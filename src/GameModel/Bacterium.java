/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

/**
 *
 * @author tranhieu
 */
public class Bacterium extends DishObject {

    public Bacterium(Dish d, int size) {
        super(d, size);
    }
    
    @Override
    public boolean collideWith(DishObject o) {
        dish.removeObject(o);
        return true;
    }
    
}
