/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel.primitives;

import GameModel.Dish;
import GameModel.DishObject;

/**
 *
 * @author tranhieu
 */
public abstract class PrimitiveObject extends DishObject {
    
    public PrimitiveObject(Dish d) {
        super(d, 15); //basic size
    }
    
    @Override
    public String getType(){
        return this.getClass().getSimpleName();
    }
    
}
