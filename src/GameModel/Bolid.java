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
    
    private final double SPEED_DECREASE = 0.995;

    public Bolid(Dish d, Bacterium b) {
        super(d, b.getSize()/3);
        bact = b;
    }
    
    @Override
    public boolean collideWith(DishObject o) {
        return false;
    }

    @Override
    public String getType() {
        return bact.getType();
    }

    @Override
    public void update(long l){
        super.update(l);
        setSpeed(getSpeedX()*SPEED_DECREASE,getSpeedY()*SPEED_DECREASE);
    }
    
    @Override
    public void destroy() {
        
    }
    
}
