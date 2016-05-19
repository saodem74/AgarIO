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
    
    public PlayerControllerGTGE(Bacterium b, GTGEFabric f) {
        super(b);
        fabric = f;
    }

    @Override
    public void defineDirection() {
        int mouseX = fabric.getGameGTGEObject().getMouseX()+(int)fabric.getBackground().getX();
        int mouseY = fabric.getGameGTGEObject().getMouseY()+(int)fabric.getBackground().getY();
        double speed = 0.5;
        double dx = (mouseX-bact.getPosition().x > 0) ? 0.1 : -0.1;
        double dy = (mouseY-bact.getPosition().y > 0) ? 0.1 : -0.1;
        bact.setSpeed(dx,dy);
    }
    
}
