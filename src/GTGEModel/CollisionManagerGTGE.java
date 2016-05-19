/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEModel;

import GameModel.DishObject;
import IModel.CollisionManager;
import com.golden.gamedev.object.SpriteGroup;

/**
 *
 * @author tranhieu
 */
public class CollisionManagerGTGE extends CollisionManager {
    
    private CollisionDetectorGTGE detector;
    
    private SpriteGroup s;
    
    public CollisionManagerGTGE(){
        super();
        s = new SpriteGroup("sprites");
        detector = new CollisionDetectorGTGE(this,s);
    }
    
    @Override
    public void addObject(DishObject obj){
        super.addObject(obj);
//        s.add(obj.);
    }
    
}
