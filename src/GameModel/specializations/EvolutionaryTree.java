/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel.specializations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author tranhieu
 */
public class EvolutionaryTree {
    
    private Specialization root;
    
    private HashMap<Specialization,ArrayList<Specialization>> tree = new HashMap<>();
    
    public EvolutionaryTree(){
        Specialization bt = new BacteriumTiger();
        tree.put(bt, null);
        Specialization bb = new BacteriumBuffalo();
        tree.put(bb, null);
        Specialization predAn = new PredatorAnimal();
        ArrayList<Specialization> v = new ArrayList<>();
        v.add(bt);
        tree.put(predAn, v);
        Specialization phAn = new PhytophagousAnimal();
        v = new ArrayList<>();
        v.add(bb);
        tree.put(phAn, v);
        Specialization omn = new OmnivoreAnimal();
        tree.put(omn, null);
        Specialization priAn = new PrimitiveAnimal();
        v = new ArrayList<>();
        v.add(phAn);
        v.add(predAn);
        v.add(omn);
        tree.put(priAn,v);
        Specialization bm = new BacteriumMoss();
        tree.put(bm, null);
        Specialization parPl = new ParasitePlant();
        tree.put(parPl, null);
        Specialization predPl = new PredatorPlant();
        tree.put(predPl, null);
        Specialization priPl = new PrimitivePlant();
        v = new ArrayList<>();
        v.add(bm);
        v.add(parPl);
        v.add(predPl);
        tree.put(priPl, v);
        Specialization s = new SimpleBactery();
        v = new ArrayList<>();
        v.add(priAn);
        v.add(priPl);
        tree.put(s, v);
        root = s;
    }
    
    public Specialization getBaseSpec(){
        return root;
    }
    
    public Specialization getRandomSpec(){
        Set<Specialization> specs = tree.keySet();
        int rand = (new Random()).nextInt(specs.size());
        Iterator<Specialization> iterator = specs.iterator();
        Specialization result = root;
        for(int i=0;i<rand;i++){
            result = iterator.next();
        }
        return result; //change later for unequal chances
    }
    
    public Specialization getSpec(String s){
        if(s.isEmpty())
            return null;
        for(Specialization spec : tree.keySet()){
            if(spec.getType().equals(s)){
                return spec;
            }
        }
        return root;
    }
    
    public ArrayList<Specialization> getUpgradeLevels(Specialization spec){
        return tree.get(spec);
    }
    
    public boolean isParent(Specialization parent, Specialization child){
        boolean result = false;
        Specialization spec = child;
        while(!result && spec != root){
            for(Specialization key : tree.keySet()){
                if(tree.get(key).contains(spec))
                    spec = key;
            }
            result = spec==parent;
        }
        return result;
    }
    
}
