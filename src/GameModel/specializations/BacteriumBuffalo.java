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
public class BacteriumBuffalo extends Specialization {
    
    public BacteriumBuffalo(EvolutionaryTree et){
        super(et);
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
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("BacteriumMoss", 1, 1.5));
    }
    
}
