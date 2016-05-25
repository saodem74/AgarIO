/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IModel;

import GameModel.Bacterium;
import GameModel.Controller;

/**
 *
 * @author tranhieu
 */
public abstract class PlayerController extends Controller {
    
    public PlayerController(Bacterium b) {
        super(b);
    }
}
