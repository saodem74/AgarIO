/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import IModel.IDishObjectSprite;

/**
 *
 * @author tranhieu
 */
public class Water extends PrimitiveObject {

    public Water(Dish d, IDishObjectSprite s, int size) {
        super(d, s, size);
    }

    @Override
    public boolean collideWith(DishObject o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
