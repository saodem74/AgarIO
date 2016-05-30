/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameModel.*;
import GameModel.primitives.*;
import GameModel.specializations.Specialization;
import IModel.*;
import IView.*;
import java.util.HashMap;

/**
 *
 * @author tranhieu
 */
public abstract class AbstractFabric {
    
    protected HashMap<DishObject,DishObjectView> createdDishObjects = new HashMap<>();
    
    public Bacterium createBactery(Dish d, int size, Specialization s){
        Bacterium b = new Bacterium(d,size,s);
        DishObjectView v = new BacteryView(b);
        createDishObject(b,v);
        return b;
    }
    
    public Bolid createBolid(Dish d, int size){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public PrimitiveObject createPrimitive(Dish d, String type){
        PrimitiveObject p;
        switch(type){
            case "Agar":
                p = new Agar(d);
                break;
            case "CO2":
                p = new CO2(d);
                break;
            case "Light":
                p = new Light(d);
                break;
            case "O2":
                p = new O2(d);
                break;
            default: //Water
                p = new Water(d);
                break;
        }
        DishObjectView v = new PrimitiveView(p);
        createDishObject(p,v);
        return p;
    }
    
    protected IDishObjectSprite createDishObject(DishObject o, DishObjectView v){
        IDishObjectSprite sprite = createSprite();
        o.setSprite(sprite);
        IDishObjectViewRealization viewR = createViewRealization(sprite);
        v.setRealization(viewR);
        createdDishObjects.put(o, v);
        return sprite;
    }
    
    protected abstract IDishObjectSprite createSprite();
    
    protected abstract IDishObjectViewRealization createViewRealization(IDishObjectSprite s);
    
    public DishObjectView getDishObjectView(DishObject model){
        return createdDishObjects.get(model);
    }
    
    public void removeObject(DishObject obj){
        createdDishObjects.remove(obj);
    }
    
    public abstract CollisionManager createCollisionManager();
    
    public abstract PlayerController createPlayerController(Bacterium b);
    
    public abstract GameView createGameView(GameModel model, int w, int h);
    
    public abstract DishView createDishView(Dish dish, int w, int h, String background);
    
    public abstract Application createApplication();
}
