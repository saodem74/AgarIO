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
public class OmnivoreAnimal extends Specialization {
    
    public OmnivoreAnimal(){
        addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                .addRule("Water")
                .addRule("PrimitivePlant", 1, 1.25))
                .addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("BacteriumMoss", 1, 1.25))
                .addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("ParasitePlant", 1, 1.25))
                .addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("PredatorPlant", 1, 1.25))
                .addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("PrimitiveAnimal", 1, 2))
                .addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("PhytophagousAnimal", 1, 2))
                .addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("BacteriumBuffalo", 1, 2))
                .addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("PredatorAnimal", 1, 2))
                .addRation(new Ration(Ration.LOW_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("BacteriumTiger", 1, 2));
    }
}
