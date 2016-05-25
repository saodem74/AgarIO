/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

import Game.AbstractFabric;
import GameModel.Dish;
import GameModel.DishObject;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author tranhieu
 */
public abstract class DishView implements ActionListener {
    
    private ArrayList<DishObjectView> views = new ArrayList<>();
    
    protected DishObject mainPlayer;
    
    protected Dish dish;
    
    private AbstractFabric fabric;
    
    protected int width;
    
    protected int height;
    
    public DishView(Dish d, AbstractFabric f, int w, int h) {
        dish = d;
        dish.addListener(this);
        fabric = f;
        width = w;
        height = h;
    }
    
    public void render(Graphics2D g){
        centerBackground();
        for(DishObjectView obj : views){
            obj.render(g);
        }
    }
    
    public abstract void setBackground(String picture);
    
    protected abstract void centerBackground();
    
    public void setMainPlayer(DishObject mp){
        mainPlayer = mp;
    }
    
    protected void addView(DishObjectView v){
        v.setDish(this);
        views.add(v);
    }
    
    protected void removeView(DishObjectView v){
        views.remove(v);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("object created")){
            addView(fabric.getDishObjectView((DishObject)e.getSource()));
        }
        else if(e.getActionCommand().equals("object removed")){
            removeView(fabric.getDishObjectView((DishObject)e.getSource()));
        }
    }
}
