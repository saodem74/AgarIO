/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEModel;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

/**
 *
 * @author tranhieu
 */
public class CollisionDetectorGTGE extends BasicCollisionGroup {

    private CollisionManagerGTGE manager;
    
    public CollisionDetectorGTGE(CollisionManagerGTGE manager, SpriteGroup sg){
        super();
        setCollisionGroup(sg, sg);
        pixelPerfectCollision = true;
        this.manager = manager;
    }
    
    @Override
    public void collided(Sprite sprite1, Sprite sprite2) {
        DishObjectSpriteGTGE s1 = (DishObjectSpriteGTGE)sprite1;
        DishObjectSpriteGTGE s2 = (DishObjectSpriteGTGE)sprite2;
        manager.collided(s1.getDishObject(), s2.getDishObject());
    }
    
}
