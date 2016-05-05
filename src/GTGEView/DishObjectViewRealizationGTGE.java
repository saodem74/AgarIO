/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEView;

import GTGEModel.DishObjectSpriteGTGE;
import IView.IDishObjectViewRealization;

/**
 *
 * @author tranhieu
 */
public class DishObjectViewRealizationGTGE implements IDishObjectViewRealization {
    
    private DishObjectSpriteGTGE sprite;
    
    public DishObjectViewRealizationGTGE(DishObjectSpriteGTGE s){
        sprite = s;
    }
    
}
