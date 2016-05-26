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
public class PredatorAnimal extends Specialization {
    
    public PredatorAnimal(){
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "CO2").addRule("O2")
                .addRule("Water")
                .addRule("PrimitiveAnimal", 1, 2))
                .addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("PhytophagousAnimal", 1, 2))
                .addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("BacteriumBuffalo", 1, 2));
    }
    
}
