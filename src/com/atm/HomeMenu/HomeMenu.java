package com.atm.HomeMenu;

import com.atm.AccountMenu.Account;
import com.atm.AccountMenu.AccountMenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HomeMenu
{
    public void displayHomeMenu() throws IOException, InterruptedException
    {
        Scanner sc = new Scanner(System.in);
        String FilePath = "./";
        boolean b = true;

        while (b)
        {
            System.out.println("\n=====> WELCOME TO OUR ATM <=====");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Exit");
            System.out.print("Enter Choice : ");
            int choice = 3;
            if (sc.hasNextInt())
            {
                choice = sc.nextInt();
            }
            breack:
            {
                if (choice == 1)
                {
                    System.out.println("Enter Name : ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.println("Enter Username : ");
                    String username = sc.nextLine();

                    File file = new File(FilePath + username + ".txt");
                    if (file.exists())
                    {
                        System.out.println("Username Already Taken !");
                        System.out.println("\nPress enter to continue");
                        try
                        {
                            System.in.read();
                        }
                        catch (Exception e)
                        {
                        }
                        break breack;
                    }
                    System.out.println("Enter Password : ");
                    String password = sc.nextLine();

                    Account reg = new Account(name, username, password, "TRANSACTION:0", FilePath);
                    reg.message();

                    try
                    {
                        System.in.read();
                    }
                    catch (Exception e)
                    {
                    }
                }
                else if (choice == 2)
                {
                    System.out.println();
                    System.out.println("Enter Username : ");
                    sc.nextLine();
                    String username = sc.nextLine();
                    System.out.println("Enter Password : ");
                    String password = sc.nextLine();
                    boolean bool = true;

                    File file = new File(FilePath + username + ".txt");
                    if (file.exists())
                    {
                        try
                        {
                            Scanner dataReader = new Scanner(file);
                            String money = dataReader.nextLine();
                            int login_money = Integer.parseInt(money);
                            String login_name = dataReader.nextLine();
                            String login_username = dataReader.nextLine();
                            String login_password = dataReader.nextLine();
                            String login_transaction = dataReader.nextLine();
                            if (username.equals(login_username) && password.equals(login_password))
                            {
                                dataReader.close();
                                AccountMenu accountMenu = new AccountMenu();
                                accountMenu.displayAccountMenu(login_name, username, login_money, login_transaction, login_username, login_password);
                                bool = false;
                                break breack;
                            }
                        }
                        catch (FileNotFoundException e)
                        {
                            System.out.println("File not found !");
                            e.printStackTrace();
                            System.out.println("\nPress enter to continue");
                            try
                            {
                                System.in.read();
                            }
                            catch (Exception f)
                            {
                            }
                        }
                    }
                    else
                    {
                        System.out.println("User not registered!");
                        System.out.println("\nPress enter to continue");
                        bool = false;
                        try
                        {
                            System.in.read();
                        }
                        catch (Exception e)
                        {
                        }
                    }
                    if (bool)
                    {
                        System.out.println("Username or Password Incorrect !\nPlease Try Again");
                        System.out.println("\nPress enter to continue");
                        try
                        {
                            System.in.read();
                        }
                        catch (Exception e)
                        {
                        }
                        break breack;
                    }
                }
                else if (choice == 3)
                {
                    System.out.println("\n***** Thank you for using ATM *****");
                    System.out.println("\nPress enter to continue");
                    try
                    {
                        System.in.read();
                    }
                    catch (Exception e)
                    {
                    }
                    sc.close();
                    b = false;
                }
                else
                {
                    System.out.println("Enter correct number input !");
                    System.out.println("\nPress enter to continue");
                    try
                    {
                        System.in.read();
                    }
                    catch (Exception e)
                    {
                    }
                }
            }
            System.out.println();
        }
    }
}