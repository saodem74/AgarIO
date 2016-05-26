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
public class Bolid extends DishObject {
    
    Bacterium bact;

    public Bolid(Dish d, int size) {
        super(d, size);
    }
    
    @Override
    public boolean collideWith(DishObject o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getType() {
        return bact.getType();
    }
    
}
