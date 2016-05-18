/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEModel;

import GameModel.DishObject;
import IModel.IDishObjectSprite;
import com.golden.gamedev.object.Sprite;
import java.awt.Point;

/**
 *
 * @author tranhieu
 */
public class DishObjectSpriteGTGE extends Sprite implements IDishObjectSprite {
    
    private DishObject obj;
    
    public void setDishObject(DishObject o){
        obj = o;
        getBackground().setClip(0, 0, obj.getDish().getWidth(), obj.getDish().getHeight());
    }
    
    public DishObject getDishObject(){
        return obj;
    }

    @Override
    public Point getPosition() {
        return new Point((int)getX(),(int)getY());
    }

    @Override
    public void setPosition(Point p) {
        setX(p.x);
        setY(p.y);
    }

    @Override
    public void update(long l) {
        super.update(l);
    }

    @Override
    public void setSpeed(double dx, double dy) {
        super.setSpeed(dx, dy);
    }

    @Override
    public double getSpeedX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getSpeedY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
