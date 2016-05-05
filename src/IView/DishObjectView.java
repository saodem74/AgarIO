/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

/**
 *
 * @author tranhieu
 */
public abstract class DishObjectView {
    
    private IDishObjectViewRealization realization;
    
    public void render(){
    
    }
    
    public abstract void chooseColor();
    
    public abstract void choosePicture();
}
