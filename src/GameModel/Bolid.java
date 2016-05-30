/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

/**
 * Болид
 */
public class Bolid extends AliveObject {
    
    private Bacterium bact; //родитель
    
    private final double SPEED_DECREASE = 0.995; //торможение

    /**
     * конструктор
     * @param d - чашка
     * @param b - бактерия-родитель
     */
    public Bolid(Dish d, Bacterium b) {
        super(d, b.getSize()/3);
        bact = b;
        spec = b.getSpecialization();
    }
    
    /**
     * Столкновение с другим объектом
     * @param o - объект
     * @return удалось ли съесть
     */
    @Override
    public boolean collideWith(DishObject o) {
        if(o instanceof Bolid){ //Если наткнулись на родственный болид
            Bolid b = (Bolid)o;
            if(b.getParent() == this.getParent() && this.size > b.getSize()){
                dish.removeObject(b);
                consumeBolid(b);
                return true;
            }
        }
        else if(o instanceof Bacterium){ //если наткнулись на бактерию
            Bacterium b = (Bacterium)o;
            if(b == this.getParent()) //на своего родителя
                return false;
            else if (b.getSize() > this.getSize()){ //на бактерию больше нас
                reverseDirection(); //развернуться
                return false;
            }
        }
        //в других случаях попробуем съесть объект
        if(spec.canEat(o,(DishObject)this)){
            dish.removeObject(o);
            eat(o);
            return true;
        }
        return false;
    }
    
    /**
     * Развернуться
     */
    private void reverseDirection(){
        setDirection(-getSpeedX(), -getSpeedY());
    }

    /**
     * Получить вид болида
     * @return вид болида
     */
    @Override
    public String getType() {
        return bact.getType();
    }
    
    /**
     * Получить родителя
     * @return бактерия-родитель
     */
    public Bacterium getParent(){
        return bact;
    }

    /**
     * Обновление
     * @param l - время с предыдущего обновления
     */
    @Override
    public void update(long l){
        super.update(l);
        setSpeed(getSpeedX()*SPEED_DECREASE,getSpeedY()*SPEED_DECREASE); //сбрасываем скорость
    }
    
}
