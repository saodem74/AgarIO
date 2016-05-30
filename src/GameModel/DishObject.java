/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import IModel.IDishObjectSprite;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Объект в чашке
 */
public abstract class DishObject {

    protected int size;
    private final double SPEED_COEFFICIENT = 10; //ускорение
    private IDishObjectSprite sprite;
    
    protected Dish dish;
    
    /**
     * конструктор
     * @param d - чашка
     * @param size - размер
     */
    public DishObject (Dish d, int size){
        dish = d;
        this.size = size;
    }
    
    /**
     * задать реализацию
     * @param s - спрайт
     */
    public void setSprite(IDishObjectSprite s){
        sprite = s;
        sprite.setDishObject(this);
    }
    
    /**
     * обновление
     * @param l - время с предыдущего обновления
     */
    public void update(long l){
        sprite.update(l); //двигаем спрайт
        //проверяем выход за границы чашки
        if(getPosition().x > dish.getWidth()-size/2){
            setPosition(new Point(dish.getWidth()-size/2,getPosition().y));
            setSpeed(0, getSpeedY());
        } else if(getPosition().x < size/2) {
            setPosition(new Point(size/2,getPosition().y));
            setSpeed(0, getSpeedY());
        }
        if(getPosition().y > dish.getHeight()-size/2){
            setPosition(new Point(getPosition().x,dish.getHeight()-size/2));
            setSpeed(getSpeedX(), 0);
        } else if (getPosition().y-size/2 < 0) {
            setPosition(new Point(getPosition().x,size/2));
            setSpeed(getSpeedX(), 0);
        }
    }
    
    /**
     * задать направление движения
     * @param x - горизонтальное направление
     * @param y - вертикальное направление
     */
    public void setDirection(double x, double y){
        //рассчитываем скорость
        double dx,dy;
        double max = Math.max(Math.abs(x), Math.abs(y));
        if(max>0){
            dx = x/max*SPEED_COEFFICIENT;
            dy = y/max*SPEED_COEFFICIENT;
        }
        else {
            dx = dy = 0;
        }
        setSpeed(dx/size,dy/size); //корректируем скорость по размеру бактерии
    }
    
    /**
     * Задать скорость
     * @param dx - гор. скорость
     * @param dy - верт. скорость
     */
    protected void setSpeed(double dx, double dy){
        sprite.setSpeed(dx, dy);
    }
    
    /**
     * узнать горизонтальную скорость
     * @return гор.скорость
     */
    public double getSpeedX(){
        return sprite.getSpeedX();
    }
    
    /**
     * узнать вертикальную скорость
     * @return верт. скорость
     */
    public double getSpeedY(){
        return sprite.getSpeedY();
    }
    
    /**
     * Задать позицию
     * @param pos - позиция
     */
    public void setPosition(Point pos){
        sprite.setPosition(pos);
    }
    
    /**
     * узнать позицию
     * @return позиция
     */
    public Point getPosition(){
        return sprite.getPosition();
    }
    
    protected ArrayList<ActionListener> listeners = new ArrayList<>();
    
    public void addListener(ActionListener l){
        listeners.add(l);
    }
    
    public Dish getDish(){
        return dish;
    }
    
    public int getSize(){
        return size;
    }
    
    /**
     * изменить размер
     * @param size - новый размер
     */
    public void setSize(int size){
        this.size = size;
        fireResize();
    }
    
    /**
     * размер изменился
     */
    private void fireResize(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,1,"resize"));
        }
    }
    
    /**
     * узнать вид объекта
     * @return вид объекта
     */
    public abstract String getType();
    
    /**
     * столкнуться с другим объектом
     * @param o - объект
     * @return удалось ли съесть
     */
    public abstract boolean collideWith(DishObject o);
    
    /**
     * уничтожить
     */
    public abstract void destroy();
}
