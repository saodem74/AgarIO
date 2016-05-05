/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEGame;

import com.golden.gamedev.Game;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author tranhieu
 */
public class GameGTGE extends Game {

    GameManagerGTGE manager;

    public GameGTGE(GameManagerGTGE m){
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

}
