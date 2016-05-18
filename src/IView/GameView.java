/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

import Game.AbstractFabric;
import GameModel.DishObject;
import GameModel.GameModel;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tranhieu
 */
public abstract class GameView implements ActionListener {
    
    private DishView dish;
    private GameModel model;
    private final String BACKGROUND_PATH = "resources/background.jpg";
    
    public GameView(GameModel m, AbstractFabric f, int w, int h){
        model = m;
        model.addListener(this);
        dish = f.createDishView(model.getDish(),w,h);
        dish.setBackground(BACKGROUND_PATH);
    }
    
    public void render(Graphics2D g){
        dish.render(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("main player created")){
            dish.setMainPlayer((DishObject)e.getSource());
        }
    }
}
