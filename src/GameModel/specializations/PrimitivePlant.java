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
public class PrimitivePlant extends Specialization{
    
    public PrimitivePlant(){
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "O2").addRule("CO2")
                .addRule("Light")
                .addRule("Water"))
                .addRation(new Ration(Ration.AVARAGE_EFFICIENCY, "O2").addRule("SimpleBactery"));
    }
    
}
