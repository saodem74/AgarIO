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
 * Бактерия
 */
public class Bacterium extends AliveObject {
    
    private int nextLevel; //следующее повышение
    
    private final int MINIMAL_SIZE_TO_SHOOT_BOLID = 80; //требуемый размер для выстрела болида
        
    private final int LEVEL_JUMP = 50; //переход между уровнями
    
    private final int TIME_BEFORE_SHOOT_BOLID = 1000; //пауза перед выстрелом обратного болида
    
    /**
     * Конструктор
     * @param d - чашка
     * @param size - размер
     * @param s - специализация
     */
    public Bacterium(Dish d, int size, Specialization s) {
        super(d, size);
        spec = s;
        nextLevel = size+LEVEL_JUMP;
    }
    
    /**
     * Столкновение с другим объектом
     * @param o - объект
     * @return удалось ли съесть другой объект
     */
    @Override
    public boolean collideWith(DishObject o) {
        //если наткнулись на болид
        if(o instanceof Bolid){
            Bolid b = (Bolid)o;
            //свой болид
            if(b.getParent() == this){
                dish.removeObject(b);
                consumeBolid(b);
                return true;
            } else if(b.getSize() < this.getSize()) { //чужой болид меньше нас
                if(enemyBolid != b){
                    b.collideWith(this); //разворачиваем болид
                    //запоминаем болид
                    enemyBolid = b;
                    bolidSize = b.getSize();
                    bolidSpeedX = b.getSpeedX();
                    bolidSpeedY = b.getSpeedY();
                    //готовимся к выстрелу ответным болидом
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
        //во всех других случаях, попробуем съесть
        if (spec.canEat(o, (DishObject)this)) {
            dish.removeObject(o);
            eat(o);
            return true;
        }
        return false;
    }
    
    /**
     * Вырасти
     * @param change - прирост
     */
    @Override
    protected void grow(int change){
        super.grow(change);
        //если достигли нового уровня - можно прокачаться
        if(size>=nextLevel){
            fireReachedNextLevel();
            nextLevel+=LEVEL_JUMP;
        }
    }
    
    /**
     * Запустить болид в обратную
     * @param s - размер
     * @param dx - направление по горизонтали
     * @param dy - направление по вертикали
     */
    private void shootReverseBolid(int s, double dx, double dy){
        if(size < MINIMAL_SIZE_TO_SHOOT_BOLID) //если слишком малы для выстрела
            return;
        Bolid b = dish.createBolid(this);
        b.setSize(s); //задаем размер, как у вражеского болида
        //помещаем болид на край бактерии
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
        setSize(size-s);    //теряем массу
    }
    
    /**
     * Выстрелить болид
     * @param dx - направление по горизонтали
     * @param dy - направление по вертикали
     */
    public void shootBolid(double dx, double dy){
        if(size < MINIMAL_SIZE_TO_SHOOT_BOLID) //если слишком малы для выстрела
            return;
        Bolid b = dish.createBolid(this);
        //помещаем болид на край бактерии
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
        setSize(size*2/3); //теряем массу
    }

    /**
     * Узнать вид бактерии
     * @return вид бактерии
     */
    @Override
    public String getType() {
        return spec.getType();
    }
    
    /**
     * Достигнут новый уровень
     */
    private void fireReachedNextLevel(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,2,"reached next level"));
        }
    }

    /**
     * Уничтожить бактерию
     */
    @Override
    public void destroy() {
        super.destroy();
        fireDied();
    }
    
    /**
     * Бактерия съедена
     */
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
    
    //Параметры для выстрела ответного болида
    private Bolid enemyBolid;
    private int bolidSize;
    private double bolidSpeedX;
    private double bolidSpeedY;
    private Timer timer = new Timer();
}
