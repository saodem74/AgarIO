/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import IModel.IDishObjectSprite;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author tranhieu
 */
public abstract class DishObject {

    protected int size;
    private final double SPEED_COEFFICIENT = 20/3;
    protected static final int UPGRADE_COEFICIENT = 20;
    private IDishObjectSprite sprite;
    
    protected Dish dish;
    
    public DishObject (Dish d, int size){
        dish = d;
        this.size = size;
    }
    
    public void setSprite(IDishObjectSprite s){
        sprite = s;
        sprite.setDishObject(this);
    }
    
    public void update(long l){
        sprite.update(l);
        if(getPosition().x > dish.getWidth()-size/2){
            setPosition(new Point(dish.getWidth()-size/2,getPosition().y));
            setSpeed(0, getSpeedY());
        } else if(getPosition().x < size/2) {
            setPosition(new Point(size/2,getPosition().y));
            setSpeed(0, getSpeedY());
        }
        if(getPosition().y > dish.getHeight()-size/2){
            setPosition(new Point(getPosition().x,dish.getHeight()-size/2));
            setSpeed(getSpeedX(), 0);
        } else if (getPosition().y-size/2 < 0) {
            setPosition(new Point(getPosition().x,size/2));
            setSpeed(getSpeedX(), 0);
        }
    }
    
    public void setDirection(double x, double y){
        double dx,dy;
        double max = Math.max(Math.abs(x), Math.abs(y));
        if(max>0){
            dx = x/max*SPEED_COEFFICIENT;
            dy = y/max*SPEED_COEFFICIENT;
        }
        else {
            dx = dy = 0;
        }
        setSpeed(dx/size,dy/size);
    }
    
    protected void setSpeed(double dx, double dy){
        sprite.setSpeed(dx, dy);
    }
    
    public double getSpeedX(){
        return sprite.getSpeedX();
    }
    
    public double getSpeedY(){
        return sprite.getSpeedY();
    }
    
    public void setPosition(Point pos){
        sprite.setPosition(pos);
    }
    
    public Point getPosition(){
        return sprite.getPosition();
    }
    
    protected ArrayList<ActionListener> listeners = new ArrayList<>();
    
    public void addListener(ActionListener l){
        listeners.add(l);
    }
    
    public Dish getDish(){
        return dish;
    }
    
    public int getSize(){
        return size;
    }
    
    public void setSize(int size){
        this.size = size;
        fireResize();
    }
    
    private void fireResize(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,1,"resize"));
        }
    }
    
    public abstract String getType();
    
    public abstract boolean collideWith(DishObject o);
    
    public abstract void destroy();
}
