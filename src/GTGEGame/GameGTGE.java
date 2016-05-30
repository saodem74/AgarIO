/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEGame;

import com.golden.gamedev.Game;
import java.awt.Graphics2D;

/**
 * Класс игры, отлавливающий события обновления и рендера
 */
public class GameGTGE extends Game {

    ApplicationGTGE app; //ссылка на приложение

    /**
     * Конструктор
     * @param a - приложение
     */
    public GameGTGE(ApplicationGTGE a){
        super();
        app = a;
    }

    /**
     * метод, вызываемый при запуске игры
     */
    @Override
    public void initResources() {
    }

    /**
     * Обновление игры
     * @param l - время с предыдущего обновления
     */
    @Override
    public void update(long l) {
        app.update(l);
    }

    /**
     * Отрисовка игры
     * @param gd - объект графики для рисования
     */
    @Override
    public void render(Graphics2D gd) {
        app.render(gd);
    }
}
