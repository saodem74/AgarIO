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
 * Абстрактный класс контроллера, управляющего бактерией
 */
public abstract class Controller implements ActionListener {
    
    protected Bacterium bact;
    
    /**
     * конструктор
     * @param b - бактерия, которой будем управлять
     */
    public Controller(Bacterium b){
        bact = b;
        bact.addListener(this);
    }
    
    /**
     * Обновление
     */
    public void update(){
        defineDirection();
        shootBolid();
    }
    
    /**
     * Выбрать направление движения
     */
    public abstract void defineDirection();
    
    /**
     * Выбрать специализацию при повышении
     * @return специализация
     */
    protected abstract Specialization chooseSpec();
    
    /**
     * Выстрелить болид
     */
    public abstract void shootBolid();

    /**
     * Слушаем бактерию
     * @param ae - событие, случившиеся с бактерией
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("reached next level")){ 
            //меняем специализацию
            Specialization newSpec = chooseSpec();
            if(newSpec != null){
                bact.setSpecialization(newSpec);
            }
        }
        else if(ae.getActionCommand().equals("died")){
            //выходим из игры
            fireDead();
        }
    }
    
    private ArrayList<ActionListener> listeners = new ArrayList<>();
    
    public void addListener(ActionListener l){
        listeners.add(l);
    }
    
    /**
     * Убрать контроллер из игры
     */
    private void fireDead(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,1,"player died"));
        }
    }
}
