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
public class PredatorPlant extends Specialization {
    
    public PredatorPlant(EvolutionaryTree et){
        super(et);
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "O2").addRule("CO2")
                .addRule("Light")
                .addRule("Water"))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("PrimitiveAnimal", 1, 0.5))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("PhytophagousAnimal", 1, 0.5))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("BacteriumBuffalo", 1, 0.5))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("PredatorAnimal", 1, 0.5))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("PhytophagousAnimal", 1, 0.5))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("OmnivoreAnimal", 1, 0.5));
    }
    
}
