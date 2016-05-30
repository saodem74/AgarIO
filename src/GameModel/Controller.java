/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameModel.specializations.Specialization;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tranhieu
 */
public abstract class Controller implements ActionListener {
    
    protected Bacterium bact;
    
    public Controller(Bacterium b){
        bact = b;
        bact.addListener(this);
    }
    
    public void update(){
        defineDirection();
    }
    
    public abstract void defineDirection();
    
    protected abstract Specialization chooseSpec();

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getID()==2){ //reached next level
            Specialization newSpec = chooseSpec();
            if(newSpec != null){
                bact.setSpecialization(newSpec);
            }
        }
    }
    
}
