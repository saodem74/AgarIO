/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEModel;

import GTGEGame.GTGEFabric;
import GameModel.Bacterium;
import IModel.PlayerController;
import com.golden.gamedev.Game;
import com.golden.gamedev.object.Background;

/**
 *
 * @author tranhieu
 */
public class PlayerControllerGTGE extends PlayerController {
    
    GTGEFabric fabric;
    Game game;
    Background background;
    
    public PlayerControllerGTGE(Bacterium b, GTGEFabric f) {
        super(b);
        fabric = f;
    }

    @Override
    public void defineDirection() {
        int mouseX = game.getMouseX()+(int)background.getX();
        int mouseY = game.getMouseY()+(int)background.getY();
        double dx = mouseX-bact.getPosition().x;
        double dy = mouseY-bact.getPosition().y;
        bact.setDirection(dx,dy);
    }
    
    public void setGame(Game g){
        game = g;
    }
    
    public void setBackground(Background b){
        background = b;
    }
    
}
