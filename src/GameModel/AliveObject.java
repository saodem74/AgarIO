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
public abstract class AliveObject extends DishObject {

    public AliveObject(Dish d, IDishObjectSprite s, int size) {
        super(d, s, size);
    }

}
