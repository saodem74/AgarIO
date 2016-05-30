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
public class PhytophagousAnimal extends Specialization {
    
    public PhytophagousAnimal(EvolutionaryTree et){
        super(et);
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "CO2").addRule("O2")
                .addRule("Water")
                .addRule("PrimitivePlant", 1, 1.25))
                .addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("BacteriumMoss", 1, 1.25))
                .addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("ParasitePlant", 1, 1.25))
                .addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "CO2").addRule("O2")
                        .addRule("Water")
                        .addRule("PredatorPlant", 1, 1.25));
    }
    
}
