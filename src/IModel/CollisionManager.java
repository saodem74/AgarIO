/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IModel;

import GameModel.*;
import java.util.ArrayList;

/**
 *
 * @author tranhieu
 */
public abstract class CollisionManager {
    
    protected ArrayList<DishObject> collisionGroup = new ArrayList<>();
    
    public void collided(DishObject first, DishObject second){
        
    }
    
    public void addObject(DishObject obj){
        collisionGroup.add(obj);
    }
    
    public void removeObject(DishObject obj){
        
    }
}
