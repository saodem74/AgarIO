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
 * Класс, управляющий компьютерными противниками
 */
public class AIController extends Controller {
    
    private final double SHOOT_BOLID_CHANCE = 0.1; //шанс запуска болида

    private final Timer timer = new Timer();
    
    private double dx,dy;
    
    /**
     * Конструктор
     * @param b - бактерия, которой будем управлять
     */
    public AIController(Bacterium b) {
        super(b);
        setRandomDirection();
        startTimer();
    }

    /**
     * Выбрать направление движения
     */
    @Override
    public void defineDirection() {
        bact.setDirection(dx, dy);
    }
    
    /**
     * Задать случайное направление
     */
    private void setRandomDirection(){
        dx = Math.random()-0.5;
        dy = Math.random()-0.5;
    }
    
    /**
     * Запустить таймер, отсчитывающий время до смены направления движения
     */
    private void startTimer(){
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                setRandomDirection();
                startTimer();
            }
        }, (int)(Math.random()*3000));
    }

    /**
     * Выбрать рандомную специализацию
     * @return специализация для прокачки
     */
    @Override
    protected Specialization chooseSpec() {
        Specialization spec = null;
        if(Math.random()>0.5){
            ArrayList<Specialization> upgradeLevels = bact.getSpecialization().getUpgrades();
            if(upgradeLevels == null){
                return null;
            }
            int random = (int)(Math.random()*upgradeLevels.size());
            spec = upgradeLevels.get(random);
        }
        return spec;
    }

    /**
     * Выстрелить болид случайно
     */
    @Override
    public void shootBolid() {
        if(Math.random()<SHOOT_BOLID_CHANCE){
            bact.shootBolid(bact.getSpeedX(), bact.getSpeedY());
        }
    }
    
}
