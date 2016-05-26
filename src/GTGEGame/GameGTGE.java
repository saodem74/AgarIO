/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEGame;

import com.golden.gamedev.Game;
import java.awt.Graphics2D;

/**
 *
 * @author tranhieu
 */
public class GameGTGE extends Game {

    ApplicationGTGE manager;

    public GameGTGE(ApplicationGTGE m){
        super();
        manager = m;
    }

    @Override
    public void initResources() {
    }

    @Override
    public void update(long l) {
        manager.update(l);
    }

    @Override
    public void render(Graphics2D gd) {
        manager.render(gd);
    }
    
    public int getbsInputX(){
        return this.bsInput.getMouseX();
    }

    public int getbsInputY(){
        return this.bsInput.getMouseY();
    }
}
