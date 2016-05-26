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
public class SimpleBactery extends Specialization{

    public SimpleBactery(){
        addRation(new Ration(Ration.HIGH_EFFICIENCY, "CO2").addRule("Agar")
                .addRule("Water")
                .addRule("Light"))
                .addRation(new Ration(Ration.HIGH_EFFICIENCY, "CO2").addRule("SimpleBactery"));
    }
    
}
