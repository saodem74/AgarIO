/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel.specializations;

/**
 *
 * @author Skorikov
 */
public class PrimitiveAnimal extends Specialization {
    
    public PrimitiveAnimal(){
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "CO2").addRule("O2")
                .addRule("Water")
                .addRule("SimpleBactery", 1, 1.2));
    }
    
}
