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
public class BacteriumTiger extends Specialization {
    
    public BacteriumTiger(EvolutionaryTree et){
        super(et);
        addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                .addRule("Water")
                .addRule("PrimitiveAnimal", 1, 2))
                .addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("PhytophagousAnimal", 1, 2))
                .addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("BacteriumBuffalo", 1, 2))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("BacteriumBuffalo", 1, 1.5));
    }
    
}
