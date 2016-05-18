/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import Game.AbstractFabric;
import IModel.CollisionManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author tranhieu
 */
public class Dish {
    
    AbstractFabric fabric;
    private CollisionManager collisionManager;
    
    private int width,height;
    
    private ArrayList<DishObject> objects = new ArrayList<>();
    
    public Dish(int w, int h, AbstractFabric f){
        width = w;
        height = h;
        fabric = f;
        collisionManager = fabric.createCollisionManager();
    }
    
    public void update(long l){
        for(DishObject obj : objects){
            obj.update(l);
        }
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public void createBactery(){
        DishObject obj = fabric.createBactery();
        addObject(obj,new Point(50,50));
        obj.setSpeed(0.1, 0.1);
    }
    
    public void addObject(DishObject obj, Point pos){
        obj.setPosition(pos);
        objects.add(obj);
        fireObjectCreated(obj);
    }
    
    private ArrayList<ActionListener> listeners = new ArrayList<>();
    
    public void addListener(ActionListener l){
        listeners.add(l);
    }
    
    private void fireObjectCreated(DishObject obj){
        ActionEvent event = new ActionEvent(obj,1,"object created");
        for(ActionListener l : listeners){
            l.actionPerformed(event);
        }
    }
}
