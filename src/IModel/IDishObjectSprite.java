/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IModel;

import GameModel.DishObject;
import java.awt.Point;

/**
 *
 * @author tranhieu
 */
public interface IDishObjectSprite {
    
    public void setDishObject(DishObject o);
    
    public Point getPosition();
    
    public void setPosition(Point p);
    
    public void update(long l);
    
    public void setSpeed(double dx, double dy);
    
    public double getSpeedX();
    
    public double getSpeedY();
}
