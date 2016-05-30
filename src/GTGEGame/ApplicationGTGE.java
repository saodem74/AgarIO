/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEGame;

import Game.AbstractFabric;
import Game.Application;
import com.golden.gamedev.GameLoader;
import java.awt.Dimension;

/**
 * Реализация приложения на GTGE
 */
public class ApplicationGTGE extends Application{
    
    private GameGTGE gamegtge; //объект игры из библиотеки gtge
    
    /**
     * Конструктор
     * @param fabric - фабрика игровых объектов 
     */
    public ApplicationGTGE(AbstractFabric fabric) {
        super(fabric);
        //Создаем приложение gtge
        GameLoader game;
        game = new GameLoader();
        gamegtge = new GameGTGE(this); //создаем объект игры gtge
        ((GTGEFabric)fabric).setGameGTGEObject(gamegtge); //сохраняем созданную игру на фабрике
        game.setup(gamegtge, new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT), false); //устанавливаем параметры игры
        game.start(); 
    }
    
    public GameGTGE getGameGTGE(){
        return gamegtge;
    }
    
}
