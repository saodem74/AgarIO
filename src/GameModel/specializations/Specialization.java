/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel.specializations;

import GameModel.DishObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tranhieu
 */
public abstract class Specialization {
    
    /**
     * Рационы, относящиеся к текущей специализации
     */
    protected ArrayList <Ration> rations = new ArrayList<>();
    
    private EvolutionaryTree evoTree;
    
    public Specialization(EvolutionaryTree et){
        evoTree = et;
    }
    
    public String getType(){
        return this.getClass().getSimpleName();
    }
    
    /**
     * Добавить рацион к текущей специализации
     * @param ration добавляемый рацион
     * @return текущий экземпляр класса для повторного добавления элементов
     */
    public Specialization addRation(Ration ration) {
        rations.add(ration);
        return this;
    }
    
    /**
     * Проверить допустимость съедения одного объекта другим
     * @param eaten съедаемый объект
     * @param eater съедающий объект
     * @return признак допустимости съедения
     */
    public boolean canEat(DishObject eaten, DishObject eater) {
        // Если объект можно съесть в каком-нибудь из доступных рационов, то его можно есть
        for (Ration ration : rations) {
            if (ration.canEat(eaten, eater)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Получить выполненный рацион
     * @param eaten массив съеденных объектов
     * @return выполненный рацион или null, если ни один не выполнен
     */
    public Ration completedRation(ArrayList <DishObject> eaten) {
        // Распределить съеденные объекты по типам и количеству по каждому типу
        Map <String, Integer> sortedEaten = new HashMap <String, Integer>();
        for (DishObject obj : eaten) {
            String type = obj.getType();
            
            // Если объекты этого типа уже были съедены - прибавить к их количеству единицу, иначе создать новую пару ключ-значениесо значением 1
            int count = 1;
            if (sortedEaten.containsKey(type)) {
                count += sortedEaten.get(type);
            }
            sortedEaten.put(type, count);
        }
        
        // Проверить выполнение какого-нибудь рациона
        for (Ration ration : rations) {
            if (ration.rationCompleted(sortedEaten)) {
                return ration;
            }
        }
        
        return null;
    }
    
    public ArrayList<Specialization> getUpgrades(){
        return evoTree.getUpgradeLevels(this);
    }
    
}
