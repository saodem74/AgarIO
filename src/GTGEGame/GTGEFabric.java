/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEGame;

import GameModel.primitives.*;
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
 *
 * @author tranhieu
 */
public class GTGEFabric extends AbstractFabric {
    
    private Game game;
    private DishViewGTGE dishView;
    private PlayerControllerGTGE controller;
    private CollisionManagerGTGE collisionManager;
    
    private HashMap<DishObject,DishObjectSpriteGTGE> realizations = new HashMap<>();
    
    @Override
    public void removeObject(DishObject obj){
        super.removeObject(obj);
        realizations.remove(obj);
    }

    @Override
    protected IDishObjectSprite createSprite() {
        return new DishObjectSpriteGTGE();
    }

    @Override
    protected IDishObjectViewRealization createViewRealization(IDishObjectSprite s) {
        return new DishObjectViewRealizationGTGE((DishObjectSpriteGTGE) s);
    }
    
    @Override
    protected IDishObjectSprite createDishObject(DishObject o, DishObjectView v){
        IDishObjectSprite sprite = super.createDishObject(o, v);
        realizations.put(o, (DishObjectSpriteGTGE) sprite);
        return sprite;
    }

    @Override
    public CollisionManager createCollisionManager() {
        collisionManager = new CollisionManagerGTGE(this);
        return collisionManager;
    }

    @Override
    public PlayerController createPlayerController(Bacterium b) {
        controller = new PlayerControllerGTGE(b,this);
        controller.setBackground(dishView.getBackground());
        return controller;
    }

    @Override
    public GameView createGameView(GameModel model, int w, int h) {
        return new GameViewGTGE(model,this,w,h);
    }

    @Override
    public DishView createDishView(Dish dish, int w, int h, String background) {
        dishView = new DishViewGTGE(dish,this,w,h);
        dishView.setBackground(background);
        collisionManager.setBackground(dishView.getBackground());
        return dishView;
    }

    @Override
    public Application createApplication() {
        ApplicationGTGE app = new ApplicationGTGE(this);
        return app;
    }
    
    public Game getGameGTGEObject(){
        return game;
    }
    
    public void setGameGTGEObject(Game g){
        game = g;
        if(controller != null){
            controller.setGame(g);
        }
    }
    
    public Background getBackground(){
        return dishView.getBackground();
    }
    
    public DishObjectSpriteGTGE getSprite(DishObject obj){
        return realizations.get(obj);
    }
}
