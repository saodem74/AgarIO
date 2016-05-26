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
public class BacteriumMoss extends Specialization {
    
    public BacteriumMoss(){
        addRation(new Ration(Ration.HIGH_EFFICIENCY, "O2").addRule("CO2")
                .addRule("Light")
                .addRule("Water"));
    }
    
}
