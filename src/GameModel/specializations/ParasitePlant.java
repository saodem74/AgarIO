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
public class ParasitePlant extends Specialization {
    
    public ParasitePlant(){
        addRation(new Ration(Ration.LOW_EFFICIENCY, "O2").addRule("CO2")
                .addRule("Light")
                .addRule("Water"))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("PrimitivePlant", 1, 1.5))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("BacteriumMoss", 1, 1.5))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("ParasitePlant", 1, 1.5))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("PredatorPlant", 1, 1.5));
    }
    
}
