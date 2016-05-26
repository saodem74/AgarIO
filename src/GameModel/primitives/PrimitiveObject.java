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
public abstract class PrimitiveObject extends DishObject {
    
    public PrimitiveObject(Dish d, IDishObjectSprite s) {
        super(d, s, 15); //basic size
    }
    
}
