/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEModel;

import GTGEGame.GTGEFabric;
import GameModel.DishObject;
import IModel.CollisionManager;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.SpriteGroup;

/**
 *
 * @author tranhieu
 */
public class CollisionManagerGTGE extends CollisionManager {
    
    private CollisionDetectorGTGE detector;
    
    private SpriteGroup s;
    
    private GTGEFabric fabric;
    
    public CollisionManagerGTGE(GTGEFabric f){
        super();
        fabric = f;
        s = new SpriteGroup("sprites");
        detector = new CollisionDetectorGTGE(this,s);
    }
    
    @Override
    public void addObject(DishObject obj){
        super.addObject(obj);
        s.add(fabric.getSprite(obj));
    }
    
    public void setBackground(Background b){
        s.setBackground(b);
    }

    @Override
    public void update() {
        detector.checkCollision();
    }
    
}
