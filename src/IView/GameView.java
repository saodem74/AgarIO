/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

import Game.AbstractFabric;
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
    
    public GameView(GameModel m, AbstractFabric f){
        model = m;
        model.addListener(this);
        dish = f.createDishView();
        dish.setBackground(BACKGROUND_PATH);
        model.getDish().addListener(dish);
    }
    
    public void render(Graphics2D g){
        dish.render(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
