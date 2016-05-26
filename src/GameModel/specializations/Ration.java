/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel.specializations;

import GameModel.DishObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author tranhieu
 */
public class Ration {
    /**
     * Коэффициент роста для при высокой эффективности рациона
     */
    static double HIGH_EFFICIENCY = 1.0;
    
    /**
     * Коэффициент роста для при средней эффективности рациона
     */
    static double AVARAGE_EFFICIENCY = 0.7;
    
    /**
     * Коэффициент роста для при низкой эффективности рациона
     */
    static double LOW_EFFICIENCY = 0.4;
    
    /**
     * Размер элемента, требуемого на единицу роста
     */
    final int SIZE_PER_GROWTH = 20;
    
    /**
     * Размер элемента, требуемого на единицу продукта жизнедеятельности
     */
    final int EATEN_SIZE_PER_JUNK = 50;
    
    /**
     * Содержимое рациона, ключ - тип объекта, значение - законы съедения объектов данного типа
     */
    private Map <String, RationRule> ration;
    
    /**
     * Эффективность роста при выполнении рациона
     */
    private double efficiency;
    
    private String junk;
    
    private class RationRule {
        
        /**
         * Допустимое соотношение размеров
         */
        public double sizeRatio;
        
        /**
         * Необходимое количество объектов
         */
        public int count;
        
        public RationRule(int count, double sizeRatio) {
            this.count = count;
            this.sizeRatio = sizeRatio;
        }
        
        public RationRule(int count) {
            this(count, 1);
        }
        
        public RationRule() {
            this(1, 1);
        }
    }
    
    public Ration(double efficiency, String junk) {
        this.efficiency = efficiency;
        this.junk = junk;
        this.ration = new HashMap <String, RationRule>();
    }
    
    /**
     * Добавить правило в рацион
     * @param type тип допустимого объекта
     * @param count количество данного объекта, необходимое для выполнения рациона
     * @param sizeRatio коэффициент допустимого для съедения размера
     * @return текущий экземпляр класса для повторного добавления элементов
     */
    public Ration addRule(String type, int count, double sizeRatio) {
        ration.put(type, new RationRule(count, sizeRatio));
        return this;
    }
    
    /**
     * Добавить правило в рацион
     * @param type тип допустимого объекта
     * @param count количество данного объекта, необходимое для выполнения рациона
     * @return текущий экземпляр класса для повторного добавления элементов
     */
    public Ration addRule(String type, int count) {
        return addRule(type, count, 1);
    }
    
    /**
     * Добавить правило в рацион
     * @param type тип допустимого объекта
     * @return текущий экземпляр класса для повторного добавления элементов
     */
    public Ration addRule(String type) {
        return addRule(type, 1, 1);
    }
    
    /**
     * Проверить допустимость съедения одного объекта другим
     * @param eaten съедаемый объект
     * @param eater съедающий объект
     * @return признак допустимости съедения
     */
    public boolean canEat(DishObject eaten, DishObject eater) {
        // Если съедаемый объект включен в текущий рацион и удовлетворяет правилам съедения, то его можно съесть
        if (ration.containsKey(eaten.getType()) && 
                eaten.getSize() <= eater.getSize() * ration.get(eaten.getType()).sizeRatio) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Проверить, выполняется ли текущий рацион при заданных съеденных объектах
     * @param eaten съеденные объекты, ключ - тип объекта, значение - количество съеденных объектов данного типа
     * @return признак выполнения рациона
     */
    public boolean rationCompleted(Map <String, Integer> eaten) {
        Set <String> types = ration.keySet();
        // Проверить наличие нужного количества объектов всех необходимых типов
        for (String curType : types) {
            if (!eaten.containsKey(curType) || eaten.get(curType) < ration.get(curType).count)
                return false;
        }
        return true;
    }
    
    /**
     * Получить количество продуктов жизнедеятельности для выброса при выполнении рациона
     * @param eatenSize размер съеденных объектов по выполненному рациону
     * @return количество испускаемых продуктов жизнедеятельности
     */
    public int junkCount(int eatenSize) {
        return Math.max(eatenSize / EATEN_SIZE_PER_JUNK, 1);
    }
    
    /**
     * Получить прирост размеров для текущего рациона
     * @param eatenSize суммарный размер съеденных элементов, входящих в данный рацион
     * @return величина прироста размера
     */
    public int getSizeGrowth(int eatenSize) {
        return (int) (eatenSize * efficiency / SIZE_PER_GROWTH);
    }
    
    /**
     * Получить текущий рацион в виде тип-количество
     * @return текущий рацион в виде тип-количество
     */
    public Map <String, Integer> getRation() {
        // Составить набор пар тип - количество объектов данного типа
        Map <String, Integer> result = new HashMap <String, Integer>();
        Set <String> types = ration.keySet();
        for (String type : types) {
            result.put(type, ration.get(type).count);
        }
        
        return result;
    }
    
    /**
     * Получить класс объекта, создающегося в результате выполнения рациона
     * @return класс объекта результата жизнедеятельности
     */
    public String getJunk() {
        return junk;
    }
}
