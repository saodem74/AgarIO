/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GTGEGame.GTGEFabric;

/**
 * Главный класс, запускающий приложение
 */
public class ApplicationLauncher {
    public static void main(String[] args){
        //выбираем библиотеку, которую будем использовать для реализации
        AbstractFabric fabric = new GTGEFabric();
        //запускаем игру
        Application app = fabric.createApplication();
    }
}
