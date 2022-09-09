package com.atm.AccountMenu;

import com.atm.HomeMenu.User;
import java.io.IOException;
public class Account extends User {
    int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Account(String name, String username, String password, String transaction, String FilePath) {
        super(name, username, password);
        this.money = 0;
        try {
            AccountController controller = new AccountController();
            controller.fileWrite(name,username,password,transaction,FilePath,money);

        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }

    public void message() {
        System.out.println("USER GENERATED SUCCESSFULLY !");
    }
}
