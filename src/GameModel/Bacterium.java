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
        grow();
        super.changeIsGrowd();
        return true;
    }

    @Override
    public String getType() {
        return spec.getType();
    }
    
    protected void grow(){
        super.setSize(super.getSize() + 1);
        if (super.getSize() >= super.nextUpgrade){
            upgrade();
            super.setNextUpgrade(super.nextUpgrade + 10);
        }
    }
    protected void upgrade(){
        //spec = GameModel.getInstance().getEvolutionaryTree().getUpgradeLevels(spec).get(0);
        spec = GameModel.getInstance().getEvolutionaryTree().getRandomSpec();
        System.out.println("Upgraded to " + spec.toString());
    }
}
