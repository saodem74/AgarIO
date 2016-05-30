/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameModel.specializations.Specialization;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author tranhieu
 */
public class AIController extends Controller {

    private final Timer timer = new Timer();
    
    private double dx,dy;
    
    public AIController(Bacterium b) {
        super(b);
        setRandomDirection();
        startTimer();
    }

    @Override
    public void defineDirection() {
        bact.setDirection(dx, dy);
    }
    
    private void setRandomDirection(){
        dx = Math.random()-0.5;
        dy = Math.random()-0.5;
    }
    
    private void startTimer(){
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                setRandomDirection();
                startTimer();
            }
        }, (int)(Math.random()*3000));
    }

    @Override
    protected Specialization chooseSpec() {
        Specialization spec = null;
        if(Math.random()>0.5){
            ArrayList<Specialization> upgradeLevels = bact.getSpecialization().getUpgrades();
            if(upgradeLevels.isEmpty()){
                return null;
            }
            int random = (int)(Math.random()*upgradeLevels.size());
            spec = upgradeLevels.get(random);
        }
        return spec;
    }
    
}
