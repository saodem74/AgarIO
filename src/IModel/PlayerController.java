/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IModel;

import GameModel.Bacterium;
import GameModel.Controller;
import GameModel.specializations.Specialization;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tranhieu
 */
public abstract class PlayerController extends Controller {
    
    public PlayerController(Bacterium b) {
        super(b);
    }
    
    @Override
    protected Specialization chooseSpec(){
        ArrayList<Specialization> upgradeLevels = bact.getSpecialization().getUpgrades();
        if(upgradeLevels == null)
            return null;
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Не эволюционировать");
        for(Specialization s : upgradeLevels){
            strings.add(getSpecName(s));
        }
        Object s = JOptionPane.showInputDialog(null, "", "Вы можете эволюционировать",
                JOptionPane.QUESTION_MESSAGE, null, strings.toArray(), strings.get(0));
        if(s==null || s.equals("Не эволюционировать"))
            return null;
        return upgradeLevels.get(strings.indexOf(s)-1);
    }
    
    private String getSpecName(Specialization s){
        String name = "";
        switch(s.getType()){
            case "BacteriumBuffalo":
                name = "Бактерия-буйвол";
                break;
            case "BacteriumMoss":
                name = "Бактерия-мох";
                break;
            case "BacteriumTiger":
                name = "Бактерия-тигр";
                break;
            case "OmnivoreAnimal":
                name = "Всеядное животное";
                break;
            case "ParasitePlant":
                name = "Растение-паразит";
                break;
            case "PhytophagousAnimal":
                name = "Растениеядное животное";
                break;
            case "PredatorAnimal":
                name = "Хищное животное";
                break;
            case "PredatorPlant":
                name = "Растение-хищник";
                break;
            case "PrimitiveAnimal":
                name = "Простейшее животное";
                break;
            case "PrimitivePlant":
                name = "Простейшее растение";
                break;
            case "SimpleBactery":
                name = "Первичная бактерия";
                break;
        }
        return name;
    }
}
