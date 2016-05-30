/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameModel.primitives.PrimitiveObject;

/**
 *
 * @author tranhieu
 */
public class Bolid extends AliveObject {
    
    private Bacterium bact;
    
    private final double SPEED_DECREASE = 0.995;

    public Bolid(Dish d, Bacterium b) {
        super(d, b.getSize()/3);
        bact = b;
        spec = b.getSpecialization();
    }
    
    @Override
    public boolean collideWith(DishObject o) {
        if(o instanceof Bolid){
            Bolid b = (Bolid)o;
            if(b.getParent() == this.getParent() && this.size > b.getSize()){
                dish.removeObject(b);
                consumeBolid(b);
                return true;
            }
        }
        else if(o instanceof Bacterium){
            Bacterium b = (Bacterium)o;
            if(b == this.getParent())
                return false;
            else if (b.getSize() > this.getSize()){
                reverseDirection();
                return false;
            }
        }
        if(bact.getSpecialization().canEat(o,(DishObject)this)){
            dish.removeObject(o);
            eat(o);
            return true;
        }
        return false;
    }
    
    private void reverseDirection(){
        setDirection(-getSpeedX(), -getSpeedY());
    }

    @Override
    public String getType() {
        return bact.getType();
    }
    
    public Bacterium getParent(){
        return bact;
    }

    @Override
    public void update(long l){
        super.update(l);
        setSpeed(getSpeedX()*SPEED_DECREASE,getSpeedY()*SPEED_DECREASE);
    }
    
}
