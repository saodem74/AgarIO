/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEGame;

import Game.AbstractFabric;
import Game.GameManager;
import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 *
 * @author tranhieu
 */
public class GameManagerGTGE extends GameManager{
    
    private GameLoader game;
    
    public GameManagerGTGE(AbstractFabric fabric) {
        super(fabric);
        game = new GameLoader();
        game.setup(new GameGTGE(this), new Dimension(GAME_WIDTH, GAME_HEIGHT), false);
        game.start();
    }
    
}
