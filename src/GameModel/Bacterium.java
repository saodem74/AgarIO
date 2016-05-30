/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameModel.primitives.PrimitiveObject;
import GameModel.specializations.Ration;
import GameModel.specializations.Specialization;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author tranhieu
 */
public class Bacterium extends DishObject {
    
    private Specialization spec;
    
    private int nextLevel;
    
    private final int MINIMAL_SIZE_TO_SHOOT_BOLID = 60;
        
    private final int LEVEL_JUMP = 50;
    
    private ArrayList<DishObject> resources = new ArrayList<>();
    
    public Bacterium(Dish d, int size, Specialization s) {
        super(d, size);
        spec = s;
        nextLevel = size+LEVEL_JUMP;
    }
    
    @Override
    public boolean collideWith(DishObject o) {
        if (spec.canEat(o, (DishObject)this)) {
            dish.removeObject(o);
            eat(o);
            return true;
        }
        return false;
    }
    
    private void eat(DishObject food){
        food.destroy();
        resources.add(food);
        grow(digest());
    }
    
    private void grow(int change){
        if(change==0)
            return;
        setSize(getSize()+change);
        if(size>=nextLevel){
            fireReachedNextLevel();
            nextLevel+=LEVEL_JUMP;
        }
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
    
    public void shootBolid(double dx, double dy){
        if(size < MINIMAL_SIZE_TO_SHOOT_BOLID)
            return;
        Bolid b = dish.createBolid(this);
        Point p = new Point(getPosition().x,getPosition().y);
        if(dx>0){
            p.x += size;
        } else {
            p.x -= size;
        }
        if(dy>0){
            p.y += size;
        } else {
            p.y -= size;
        }
        dish.addObject(b, p);
        b.setDirection(dx, dy);
        setSize(size*2/3);
    }
    
    public void setSpecialization(Specialization s){
        spec = s;
        fireSpecializationChanged();
    }
    
    public Specialization getSpecialization(){
        return spec;
    }

    @Override
    public String getType() {
        return spec.getType();
    }
    
    private void fireReachedNextLevel(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,2,"reached next level"));
        }
    }
    
    private void fireSpecializationChanged(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,3,"specialization changed"));
        }
    }

    @Override
    public void destroy() {
        resources.clear();
        fireDied();
    }
    
    private void fireDied(){
        for(ActionListener l : listeners){
            l.actionPerformed(new ActionEvent(this,4,"died"));
        }
    }
}
