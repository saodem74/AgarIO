/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameModel.primitives.PrimitiveObject;
import GameModel.specializations.Ration;
import GameModel.specializations.Specialization;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Skorikov
 */
public abstract class AliveObject extends DishObject{
    
    protected Specialization spec;
    
    protected ArrayList<DishObject> resources = new ArrayList<>();
    
    public AliveObject(Dish d, int size) {
        super(d, size);
    }
    
    protected void eat(DishObject food){
        food.destroy();
        resources.add(food);
        grow(digest());
    }
    
    protected void consumeBolid(Bolid b){
        b.destroy();
        setSize(getSize()+b.getSize());
    }
    
    protected void grow(int change){
        if(change==0)
            return;
        setSize(getSize()+change);
    }
    
    private int digest(){
        Ration completedRation = spec.completedRation(resources);
        if(completedRation == null)
            return 0;
        int eatenSize = 0;
        Map<String,Integer> objects = completedRation.getRation();
        for(String type : objects.keySet()){
            for(int i=0;objects.get(type)>0 && i<resources.size();++i){
                if(resources.get(i).getType().equals(type)){
                    eatenSize += resources.get(i).getSize();
                    resources.remove(i--);
                    objects.put(type,objects.get(type)-1);
                }
            }
        }
        producePrimitives(completedRation.getJunk(),completedRation.junkCount(eatenSize));
        return completedRation.getSizeGrowth(eatenSize);
    }
    
    private void producePrimitives(String type, int count){
        PrimitiveObject primitive;
        for(int i=0;i<count;++i){
            primitive = dish.createPrimitive(type);
            dish.addObject(primitive, getPosition());
            primitive.setDirection(Math.random()-0.5, Math.random()-0.5);
        }
    }
    
    public void setSpecialization(Specialization s){
        spec = s;
        fireSpecializationChanged();
    }
    
    public Specialization getSpecialization(){
        return spec;
    }
    
    private void fireSpecializationChanged(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,3,"specialization changed"));
        }
    }
    
    @Override
    public void destroy() {
        resources.clear();
    }
}
