/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import IModel.IDishObjectSprite;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author tranhieu
 */
public abstract class DishObject {

    private boolean isGrowd;
    protected int size;
    protected int nextUpgrade;
    private final double SPEED_COEFFICIENT = 20/3;
    protected static final int UPGRADE_COEFICIENT = 20;
    private IDishObjectSprite sprite;
    
    protected Dish dish;
    
    public DishObject (Dish d, int size){
        dish = d;
        isGrowd = false;
        this.size = size;
        this.setNextUpgrade(size + UPGRADE_COEFICIENT);
    }
    
    public void setSprite(IDishObjectSprite s){
        sprite = s;
        sprite.setDishObject(this);
    }
    
    public void update(long l){
        sprite.update(l);
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
    
    private void setSpeed(double dx, double dy){
        sprite.setSpeed(dx, dy);
    }
    
    protected void setNextUpgrade(int nextU){
        this.nextUpgrade = nextU;
    }
    public void setPosition(Point pos){
        sprite.setPosition(pos);
    }
    
    public Point getPosition(){
        return sprite.getPosition();
    }
    
    private ArrayList<ActionListener> listeners = new ArrayList<>();
    
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
    }
    
    public boolean getIsGrowd(){
        return this.isGrowd;
    }
    
    public void changeIsGrowd(){
        this.isGrowd = !(this.isGrowd);
    }
    
    public abstract String getType();
    
    public abstract boolean collideWith(DishObject o);
}
