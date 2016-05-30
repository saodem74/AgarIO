/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameModel.specializations.Specialization;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        if(ae.getActionCommand().equals("reached next level")){ 
            Specialization newSpec = chooseSpec();
            if(newSpec != null){
                bact.setSpecialization(newSpec);
            }
        }
        else if(ae.getActionCommand().equals("died")){
            fireDead();
        }
    }
    
    private ArrayList<ActionListener> listeners = new ArrayList<>();
    
    public void addListener(ActionListener l){
        listeners.add(l);
    }
    
    private void fireDead(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,1,"player died"));
        }
    }
}
