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
    
    private final double SPEED_DECREASE = 0.98;
    
    public PrimitiveObject(Dish d) {
        super(d, 15); //basic size
    }
    
    @Override
    public String getType(){
        return this.getClass().getSimpleName();
    }
    
    @Override
    public boolean collideWith(DishObject o){
        return false;
    }
    
    @Override
    public void update(long l){
        super.update(l);
        setSpeed(getSpeedX()*SPEED_DECREASE,getSpeedY()*SPEED_DECREASE);
    }
}
