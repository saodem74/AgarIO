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
public class Bacterium extends AliveObject {

    public Bacterium(Dish d, IDishObjectSprite s) {
        super(d,s);
        size = 30;
    }

    @Override
    public boolean collideWith(DishObject o) {
        dish.removeObject(o);
        return true;
    }
    
}
