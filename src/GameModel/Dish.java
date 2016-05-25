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
    
    private AbstractFabric fabric;
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
        collisionManager.update();
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public Bacterium createBactery(){
        Bacterium b = fabric.createBactery(this);
        addObject(b,new Point(50,50));
        b.setSpeed(0.1, 0.1);
        return b;
    }
    
    public Bacterium createBactery(Point pos){
        Bacterium b = fabric.createBactery(this);
        addObject(b,pos);
        b.setSpeed(0, 0);
        return b;
    }
    
    public void addObject(DishObject obj, Point pos){
        obj.setPosition(pos);
        objects.add(obj);
        collisionManager.addObject(obj);
        fireObjectCreated(obj);
    }
    
    public void removeObject(DishObject obj){
        objects.remove(obj);
        collisionManager.removeObject(obj);
        fireObjectRemoved(obj);
        fabric.removeObject(obj);
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
    
    private void fireObjectRemoved(DishObject obj){
        ActionEvent event = new ActionEvent(obj,2,"object removed");
        for(ActionListener l : listeners){
            l.actionPerformed(event);
        }
    }
}
