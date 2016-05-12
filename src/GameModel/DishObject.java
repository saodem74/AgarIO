/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import IModel.IDishObjectSprite;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author tranhieu
 */
public abstract class DishObject {
    
    protected int size;
//    private Point position;
//    private double speedX;
//    private double speedY;
    
    private IDishObjectSprite sprite;
    
    public DishObject (IDishObjectSprite s){
        sprite = s;
    }
    
    public void setPosition(Point pos){
        sprite.setPosition(pos);
    }
    
    private ArrayList<ActionListener> listeners = new ArrayList<>();
    
    public void addListener(ActionListener l){
        listeners.add(l);
    }
    
    public int getSize(){
        return size;
    }
    
    public void setSize(int size){
        this.size = size;
    }
}
