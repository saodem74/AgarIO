/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import IModel.IDishObjectSprite;

/**
 *
 * @author tranhieu
 */
public abstract class PrimitiveObject extends DishObject {

    public PrimitiveObject(IDishObjectSprite s) {
        super(s);
    }
    
}