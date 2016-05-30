/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameModel.specializations.Specialization;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author tranhieu
 */
public class Bacterium extends AliveObject {
    
    private int nextLevel;
    
    private final int MINIMAL_SIZE_TO_SHOOT_BOLID = 80;
        
    private final int LEVEL_JUMP = 50;
    
    private final int TIME_BEFORE_SHOOT_BOLID = 1000;
    
    public Bacterium(Dish d, int size, Specialization s) {
        super(d, size);
        spec = s;
        nextLevel = size+LEVEL_JUMP;
    }
    
    @Override
    public boolean collideWith(DishObject o) {
        if(o instanceof Bolid){
            Bolid b = (Bolid)o;
            if(b.getParent() == this){
                dish.removeObject(b);
                consumeBolid(b);
                return true;
            } else if(b.getSize() < this.getSize()) {
                if(enemyBolid != b){
                    b.collideWith(this);
                    enemyBolid = b;
                    bolidSize = b.getSize();
                    bolidSpeedX = b.getSpeedX();
                    bolidSpeedY = b.getSpeedY();
                    Timer t = new Timer();
                    t.schedule(new TimerTask(){
                        @Override
                        public void run() {
                            shootReverseBolid(bolidSize,bolidSpeedX,bolidSpeedY);
                            enemyBolid = null;
                        }
                        
                    }, TIME_BEFORE_SHOOT_BOLID);
                }
                return false;
            }
        }
        if (spec.canEat(o, (DishObject)this)) {
            dish.removeObject(o);
            eat(o);
            return true;
        }
        return false;
    }
    
    @Override
    protected void grow(int change){
        super.grow(change);
        if(size>=nextLevel){
            fireReachedNextLevel();
            nextLevel+=LEVEL_JUMP;
        }
    }
    
    private void shootReverseBolid(int s, double dx, double dy){
        if(size < MINIMAL_SIZE_TO_SHOOT_BOLID)
            return;
        Bolid b = dish.createBolid(this);
        b.setSize(s);
        Point p = new Point(getPosition().x,getPosition().y);
        if(dx>0){
            p.x += size;
        } else {
            p.x -= size;
        }
        if(dy>0){
            p.y += size;
        } else {
            p.y -= size;
        }
        dish.addObject(b, p);
        b.setDirection(dx, dy);
        setSize(size-s);
    }
    
    public void shootBolid(double dx, double dy){
        if(size < MINIMAL_SIZE_TO_SHOOT_BOLID)
            return;
        Bolid b = dish.createBolid(this);
        Point p = new Point(getPosition().x,getPosition().y);
        if(dx>0){
            p.x += size;
        } else {
            p.x -= size;
        }
        if(dy>0){
            p.y += size;
        } else {
            p.y -= size;
        }
        dish.addObject(b, p);
        b.setDirection(dx, dy);
        setSize(size*2/3);
    }

    @Override
    public String getType() {
        return spec.getType();
    }
    
    private void fireReachedNextLevel(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,2,"reached next level"));
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        fireDied();
    }
    
    private void fireDied(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,4,"died"));
        }
    }
    
//    private HashMap<Bolid,BolidInfo> enemyBolids = new HashMap<>();
//    
//    private ArrayList<Timer> timers = new ArrayList<>();
//    
//    private class BolidInfo {
//        int size;
//        double speedX;
//        double speedY;
//        
//        public BolidInfo(int s, double sx, double sy){
//            size = s;
//            speedX = sx;
//            speedY = sy;
//        }
//    }
    
    private Bolid enemyBolid;
    private int bolidSize;
    private double bolidSpeedX;
    private double bolidSpeedY;
    private Timer timer = new Timer();
}
