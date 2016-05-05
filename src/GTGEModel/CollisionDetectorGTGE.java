/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEModel;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

/**
 *
 * @author tranhieu
 */
public class CollisionDetectorGTGE extends BasicCollisionGroup {

    private CollisionManagerGTGE manager;
    
    public CollisionDetectorGTGE(CollisionManagerGTGE manager){
        super();
        this.manager = manager;
    }
    
    @Override
    public void collided(Sprite sprite, Sprite sprite1) {
        
    }
    
}
