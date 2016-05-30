/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEGame;

import GTGEModel.*;
import GTGEView.*;
import Game.*;
import GameModel.*;
import IModel.*;
import IView.*;
import com.golden.gamedev.Game;
import com.golden.gamedev.object.Background;
import java.util.HashMap;

/**
 * Фабрика, создающая объекты GTGE
 */
public class GTGEFabric extends AbstractFabric {
    
    //Храним созданные объекты
    private Game game;
    private DishViewGTGE dishView;
    private PlayerControllerGTGE controller;
    private CollisionManagerGTGE collisionManager;
    
    private HashMap<DishObject,DishObjectSpriteGTGE> realizations = new HashMap<>();
    
    /**
     * Удаление объекта
     * @param obj - объект
     */
    @Override
    public void removeObject(DishObject obj){
        super.removeObject(obj);
        realizations.remove(obj);
    }

    /**
     * Создать спрайт
     * @return спрайт
     */
    @Override
    protected IDishObjectSprite createSprite() {
        return new DishObjectSpriteGTGE();
    }

    /**
     * Создать реализацию представления
     * @param s - спрайт из модели
     * @return реализация для представления
     */
    @Override
    protected IDishObjectViewRealization createViewRealization(IDishObjectSprite s) {
        return new DishObjectViewRealizationGTGE((DishObjectSpriteGTGE) s);
    }
    
    /**
     * Создать реализации, связать модель и представление
     * @param o - объект модели
     * @param v - объект представления
     * @return созданный спрайт
     */
    @Override
    protected IDishObjectSprite createDishObject(DishObject o, DishObjectView v){
        IDishObjectSprite sprite = super.createDishObject(o, v);
        realizations.put(o, (DishObjectSpriteGTGE) sprite); //запоминаем созданный спрайт
        return sprite;
    }

    /**
     * Создание менеджера коллизий
     * @return менеджер коллизий
     */
    @Override
    public CollisionManager createCollisionManager() {
        collisionManager = new CollisionManagerGTGE(this);
        return collisionManager;
    }

    /**
     * Создание контроллера для игрока
     * @param b - бактерия, которой будет управлять контроллер
     * @return контроллер
     */
    @Override
    public PlayerController createPlayerController(Bacterium b) {
        controller = new PlayerControllerGTGE(b,this);
        controller.setBackground(dishView.getBackground());
        return controller;
    }

    /**
     * Создание главного представления для приложения
     * @param model - модель игры
     * @param w - ширина окна
     * @param h - высота окна
     * @return представление для приложения
     */
    @Override
    public GameView createGameView(GameModel model, int w, int h) {
        return new GameViewGTGE(model,this,w,h);
    }

    /**
     * Создание представления для чашки
     * @param dish - модель чашки
     * @param w - ширина окна
     * @param h - высота окна
     * @param background - фон
     * @return представление чашки
     */
    @Override
    public DishView createDishView(Dish dish, int w, int h, String background) {
        dishView = new DishViewGTGE(dish,this,w,h);
        dishView.setBackground(background);
        collisionManager.setBackground(dishView.getBackground());
        return dishView;
    }

    /**
     * Создание приложения
     * @return приложение
     */
    @Override
    public Application createApplication() {
        ApplicationGTGE app = new ApplicationGTGE(this);
        return app;
    }
    
    /**
     * Получить объект игры
     * @return объект игры
     */
    public Game getGameGTGEObject(){
        return game;
    }
    
    /**
     * Сохранить объект игры
     * @param g - объект игры
     */
    public void setGameGTGEObject(Game g){
        game = g;
        //устанавливаем игру для контроллера
        if(controller != null){
            controller.setGame(g);
        }
    }
    
    /**
     * Получить фон
     * @return фон
     */
    public Background getBackground(){
        return dishView.getBackground();
    }
    
    /**
     * Получить спрайт для объекта
     * @param obj - объект
     * @return спрайт
     */
    public DishObjectSpriteGTGE getSprite(DishObject obj){
        return realizations.get(obj);
    }
}
