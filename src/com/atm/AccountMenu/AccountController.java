package com.atm.AccountMenu;

import java.io.FileWriter;
import java.io.IOException;

public class AccountController {

    public void fileWrite(String name, String username, String password, String transaction, String FilePath, int money) throws IOException {
        FileWriter fwrite = new FileWriter(FilePath + username + ".txt",true);
        fwrite.write(money + "\r\n" + name + "\r\n" + username + "\r\n"+ password + "\r\n"  + "\r\n"+transaction+"\r\n");
        fwrite.close();
    }
}
