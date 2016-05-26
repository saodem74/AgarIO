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
public class CO2 extends PrimitiveObject {

    public CO2(Dish d) {
        super(d);
    }
    
    @Override
    public boolean collideWith(DishObject o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
