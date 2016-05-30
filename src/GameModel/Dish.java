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
    
    private Point getRandomPosition(){
        return new Point((int)(Math.random()*width),(int)(Math.random()*height));
    }
    
    public Bacterium createBactery(int size, Specialization spec){
        Bacterium b = fabric.createBactery(this,size,spec);
        addObject(b);
        return b;
    }
    
    public Bacterium createBactery(int size, Specialization spec, Point pos){
        Bacterium b = fabric.createBactery(this,size,spec);
        addObject(b,pos);
        return b;
    }
    
    public void createBasicPrimitives(int count){
        createPrimitives((int) (Math.random() * count),"Agar");
        createPrimitives((int) (Math.random() * count),"Light");
        createPrimitives((int) (Math.random() * count), "Water");
    }
    
    public void createPrimitives(int count, String type){
        DishObject p;
        for(int i=0; i<count; i++){
            p = fabric.createPrimitive(this, type);
            addObject(p);
        }
    }
    
    public PrimitiveObject createPrimitive(String type){
        return fabric.createPrimitive(this, type);
    }
    
    public void addObject(DishObject obj, Point pos){
        obj.setPosition(pos);
        objects.add(obj);
        collisionManager.addObject(obj);
        fireObjectCreated(obj);
    }
    
    public void addObject(DishObject obj){
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
