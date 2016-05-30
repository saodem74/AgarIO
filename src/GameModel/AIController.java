/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameModel.specializations.Specialization;

/**
 *
 * @author tranhieu
 */
public class AIController extends Controller {

    public AIController(Bacterium b) {
        super(b);
    }

    @Override
    public void defineDirection() {
        
    }

    @Override
    protected Specialization chooseSpec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
