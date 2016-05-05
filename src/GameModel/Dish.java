/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import Game.AbstractFabric;
import IModel.CollisionManager;

/**
 *
 * @author tranhieu
 */
public class Dish {
    
    AbstractFabric fabric;
    private CollisionManager collisionManager;
    
    private int width,height;
    
    public Dish(int w, int h, AbstractFabric f){
        width = w;
        height = h;
        fabric = f;
        collisionManager = fabric.createCollisionManager();
    }
    
}
