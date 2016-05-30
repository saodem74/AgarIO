/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import Game.AbstractFabric;
import GameModel.primitives.PrimitiveObject;
import GameModel.specializations.Specialization;
import IModel.CollisionManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Чашка
 */
public class Dish {
    
    private AbstractFabric fabric;
    private CollisionManager collisionManager;
    
    private int width,height;
    
    private ArrayList<DishObject> objects = new ArrayList<>();
    
    /**
     * конструктор
     * @param w - ширина
     * @param h - высота
     * @param f - фабрика объектов
     */
    public Dish(int w, int h, AbstractFabric f){
        width = w;
        height = h;
        fabric = f;
        collisionManager = fabric.createCollisionManager();
    }
    
    /**
     * Обновление
     * @param l - время с предыдущего обновления
     */
    public void update(long l){
        for(DishObject obj : objects){
            obj.update(l);
        }
        collisionManager.update();
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    /**
     * Случайно выбрать позицию
     * @return случайная позиция
     */
    private Point getRandomPosition(){
        //выбираем позицию в пределах чашки
        return new Point((int)(Math.random()*width),(int)(Math.random()*height));
    }
    
    /**
     * Создать бактерию
     * @param size - размер
     * @param spec - специализация
     * @return бактерия
     */
    public Bacterium createBactery(int size, Specialization spec){
        Bacterium b = fabric.createBactery(this,size,spec);
        addObject(b);
        return b;
    }
    
    /**
     * Создать основные примитивные объекты
     * @param count - верхний предел числа новых примитивных объектов
     */
    public void createBasicPrimitives(int count){
        createPrimitives((int) (Math.random() * count),"Agar");
        createPrimitives((int) (Math.random() * count),"Light");
        createPrimitives((int) (Math.random() * count), "Water");
    }
    
    /**
     * Создать примитивы заданного типа
     * @param count - количество
     * @param type - тип
     */
    public void createPrimitives(int count, String type){
        DishObject p;
        for(int i=0; i<count; i++){
            p = fabric.createPrimitive(this, type);
            addObject(p);
        }
    }
    
    /**
     * Создать один примитив, не помещая его на поле
     * @param type - вид
     * @return примитив
     */
    public PrimitiveObject createPrimitive(String type){
        return fabric.createPrimitive(this, type);
    }
    
    /**
     * Создать болид
     * @param b - бактерия
     * @return болид
     */
    public Bolid createBolid(Bacterium b){
        return fabric.createBolid(this, b);
    }
    
    /**
     * Добавить объект в заданную позицию
     * @param obj - объект
     * @param pos - позиция
     */
    public void addObject(DishObject obj, Point pos){
        obj.setPosition(pos);
        objects.add(obj);
        collisionManager.addObject(obj);
        fireObjectCreated(obj);
    }
    
    /**
     * Добавить объект в случайную позицию
     * @param obj - объетк
     */
    public void addObject(DishObject obj){
        //выбираем позицию в пределах чашки
        Point rp = getRandomPosition();
        if(rp.x>(width-obj.getSize()/2)){
            rp.x -= obj.getSize()/2;
        } else if (rp.x<(obj.getSize()/2)){
            rp.x += obj.getSize()/2;
        }
        if(rp.y>(height-obj.getSize()/2)){
            rp.y -= obj.getSize()/2;
        } else if (rp.y<(obj.getSize()/2)){
            rp.y += obj.getSize()/2;
        }
        addObject(obj,rp);
    }
    
    /**
     * Удалить объект из чашки
     * @param obj 
     */
    public void removeObject(DishObject obj){
        //удаляем отовсюду
        objects.remove(obj);
        collisionManager.removeObject(obj);
        fireObjectRemoved(obj);
        fabric.removeObject(obj);
    }
    
    private ArrayList<ActionListener> listeners = new ArrayList<>();
    
    public void addListener(ActionListener l){
        listeners.add(l);
    }
    
    /**
     * Новый объект создан
     * @param obj - объект
     */
    private void fireObjectCreated(DishObject obj){
        ActionEvent event = new ActionEvent(obj,1,"object created");
        for(ActionListener l : listeners){
            l.actionPerformed(event);
        }
    }
    
    /**
     * объект удален
     * @param obj - объект
     */
    private void fireObjectRemoved(DishObject obj){
        ActionEvent event = new ActionEvent(obj,2,"object removed");
        for(ActionListener l : listeners){
            l.actionPerformed(event);
        }
    }
}
