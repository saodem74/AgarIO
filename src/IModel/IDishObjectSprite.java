/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IModel;

import java.awt.Point;

/**
 *
 * @author tranhieu
 */
public interface IDishObjectSprite {
    
    public Point getPosition();
    
    public void setPosition(Point p);
    
    public void move();
    
    public void setSpeedX(double dx);
    
    public void setSpeedY(double dy);
    
    public double getSpeedX();
    
    public double getSpeedY();
}
