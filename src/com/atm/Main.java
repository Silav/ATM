package com.atm;

import com.atm.HomeMenu.HomeMenu;

import java.io.IOException;

public class Main {
    public static void main (String[]args){
        HomeMenu homeMenu = new HomeMenu();
        try {
            homeMenu.displayHomeMenu();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
