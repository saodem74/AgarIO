/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameModel.*;
import IView.*;
import java.awt.Graphics2D;

/**
 * Класс приложения
 */
public abstract class Application {
    
    protected final int SCREEN_WIDTH = 800; //ширина окна
    protected final int SCREEN_HEIGHT = 600;    //высота окна
    
    private GameModel model;
    private GameView view;
    
    /**
     * Конструктор
     * @param fabric - фабрика игровых объектов 
     */
    public Application(AbstractFabric fabric) {
        model = new GameModel(fabric);
        view = fabric.createGameView(model,SCREEN_WIDTH,SCREEN_HEIGHT);
        model.startGame();
    }
    
    /**
     * Обновление игры
     * @param l - время, прошедшее с предыдущего обновления
     */
    public void update(long l){
        model.update(l);
    }
    
    /**
     * Отрисовка
     * @param g - графика, на которой будет рисоваться игра
     */
    public void render(Graphics2D g){
        view.render(g);
    }
}
