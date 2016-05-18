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
    
    protected Dish dish;
    
    AbstractFabric fabric;
    
    public DishView(Dish d, AbstractFabric f) {
        dish = d;
        dish.addListener(this);
        fabric = f;
    }
    
    public void render(Graphics2D g){
        for(DishObjectView obj : views){
            obj.render(g);
        }
    }
    
    public abstract void setBackground(String picture);
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("object created")){
            views.add(fabric.getDishObjectView((DishObject)e.getSource()));
        }
    }
}
