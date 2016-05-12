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
public class Bacterium extends AliveObject {

    public Bacterium(IDishObjectSprite s) {
        super(s);
        size = 30;
    }
    
}
