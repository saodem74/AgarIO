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
 * Абстрактный класс фабрики игровых объектов
 */
public abstract class AbstractFabric {
    
    //склад созданных объектов
    protected HashMap<DishObject,DishObjectView> createdDishObjects = new HashMap<>();
    
    /**
     * Создать бактерию
     * @param d - чашка
     * @param size - размер бактерии
     * @param s - специализация
     * @return созданная бактерия
     */
    public Bacterium createBactery(Dish d, int size, Specialization s){
        Bacterium b = new Bacterium(d,size,s);
        DishObjectView v = new BacteryView(b);
        createDishObject(b,v); //создаем реализации и связываем модель и представление
        return b;
    }
    
    /**
     * Содать болид
     * @param d - чашка
     * @param b - бактерия, которая выстреливает болид
     * @return созданный болид
     */
    public Bolid createBolid(Dish d, Bacterium b){
        Bolid bolid = new Bolid(d,b);
        DishObjectView v = new BolidView(bolid);
        createDishObject(bolid,v); //создаем реализации и связываем модель и представление
        return bolid;
    }
    
    /**
     * Создать примитивный объект
     * @param d - чашка
     * @param type - тип примитивного объекта
     * @return созданный примитивный объект
     */
    public PrimitiveObject createPrimitive(Dish d, String type){
        PrimitiveObject p;
        //создаем объект заданного типа
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
        createDishObject(p,v); //создаем реализации и связываем модель и представление
        return p;
    }
    
    /**
     * Создать реализации, связать модель и представление
     * @param o - объект модели
     * @param v - объект представления
     * @return созданный спрайт
     */
    protected IDishObjectSprite createDishObject(DishObject o, DishObjectView v){
        //создаем спрайт для модели
        IDishObjectSprite sprite = createSprite();
        o.setSprite(sprite);
        //создаем реализацию для представления по спрайту
        IDishObjectViewRealization viewR = createViewRealization(sprite);
        v.setRealization(viewR);
        createdDishObjects.put(o, v); //запоминаем созданные объекты
        return sprite;
    }
    
    /**
     * Создать спрайт
     * @return спрайт
     */
    protected abstract IDishObjectSprite createSprite();
    
    /**
     * Создать реализацию представления
     * @param s - спрайт из модели
     * @return реализация для представления
     */
    protected abstract IDishObjectViewRealization createViewRealization(IDishObjectSprite s);
    
    /**
     * Получить объект представления, связанный с объектом модели
     * @param model - объект модели
     * @return объект представления
     */
    public DishObjectView getDishObjectView(DishObject model){
        return createdDishObjects.get(model);
    }
    
    /**
     * Удаление объекта
     * @param obj - объект
     */
    public void removeObject(DishObject obj){
        createdDishObjects.remove(obj);
    }
    
    /**
     * Создание менеджера коллизий
     * @return менеджер коллизий
     */
    public abstract CollisionManager createCollisionManager();
    
    /**
     * Создание контроллера для игрока
     * @param b - бактерия, которой будет управлять контроллер
     * @return контроллер
     */
    public abstract PlayerController createPlayerController(Bacterium b);
    
    /**
     * Создание главного представления для приложения
     * @param model - модель игры
     * @param w - ширина окна
     * @param h - высота окна
     * @return представление для приложения
     */
    public abstract GameView createGameView(GameModel model, int w, int h);
    
    /**
     * Создание представления для чашки
     * @param dish - модель чашки
     * @param w - ширина окна
     * @param h - высота окна
     * @param background - фон
     * @return представление чашки
     */
    public abstract DishView createDishView(Dish dish, int w, int h, String background);
    
    /**
     * Создание приложения
     * @return приложение
     */
    public abstract Application createApplication();
}
