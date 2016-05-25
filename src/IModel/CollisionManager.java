/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IModel;

import GameModel.*;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author tranhieu
 */
public abstract class CollisionManager {
    
    protected ArrayList<DishObject> collisionGroup = new ArrayList<>();
    
    public void collided(DishObject first, DishObject second){
        double dx = first.getPosition().getX()-second.getPosition().getX();
        double dy = first.getPosition().getY()-second.getPosition().getY();
        double dist = dx*dx + dy*dy;
        if(dist <= first.getSize()*first.getSize()/4)
            first.collideWith(second);
        else if(dist <= second.getSize()*second.getSize()/4)
            second.collideWith(first);
    }
    
    public void addObject(DishObject obj){
        collisionGroup.add(obj);
    }
    
    public void removeObject(DishObject obj){
        
    }
    
    public abstract void update();
}
