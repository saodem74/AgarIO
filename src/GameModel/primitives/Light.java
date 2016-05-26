/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel.primitives;

import GameModel.Dish;
import GameModel.DishObject;
import IModel.IDishObjectSprite;

/**
 *
 * @author tranhieu
 */
public class Light extends PrimitiveObject {

    public Light(Dish d, IDishObjectSprite s) {
        super(d, s);
    }

    @Override
    public boolean collideWith(DishObject o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
