/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameModel.specializations.Specialization;

/**
 *
 * @author tranhieu
 */
public class Bacterium extends DishObject {
    
    private Specialization spec;

    public Bacterium(Dish d, int size, Specialization s) {
        super(d, size);
        spec = s;
    }
    
    @Override
    public boolean collideWith(DishObject o) {
        dish.removeObject(o);
        return true;
    }

    @Override
    public String getType() {
        return spec.getType();
    }
    
}
