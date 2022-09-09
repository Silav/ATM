package com.atm.AccountMenu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class AccountMenu
{
    public void displayAccountMenu(String login_name, String username, int login_money, String login_transaction, String login_username, String login_password) throws IOException, InterruptedException
    {
        Scanner sc = new Scanner(System.in);
        String FilePath = "./";
        boolean bo = true;

        while (bo)
        {
            System.out.println("Welcome " + login_name + " !");
            System.out.println("\n****> OPERATIONS <****");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Transfer to other account");
            System.out.println("6. Edit Profile");
            System.out.println("7. Logout ");
            System.out.print("Enter Choice : ");
            int choice2 = sc.nextInt();
            System.out.println();
            if (choice2 == 1)
            {
                System.out.println("Enter Amount to Deposit :");

                int amount = sc.nextInt();
                while (amount < 0 || amount > 50000)
                {
                    System.out.println("Enter correct amount !");
                    amount = sc.nextInt();
                }
                try
                {
                    FileWriter f0 = new FileWriter(FilePath + username + ".txt", true);
                    String old_money = Integer.toString(login_money);
                    login_money += amount;
                    int temp = amount;
                    String to_be_deposited = Integer.toString(login_money);
                    modifyFile(FilePath + username + ".txt", old_money, to_be_deposited);

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    f0.write("(+" + temp + ") :: " + formatter.format(date) + " :: Self Deposit " + "\n");

                    login_transaction = "TRANSACTION:1";
                    modifyFile(FilePath + username + ".txt", "TRANSACTION:0", "TRANSACTION:1");

                    System.out.println( temp + "$ Deposited !");
                    System.out.println("\nPress enter to continue");
                    try
                    {
                        System.in.read();
                    }
                    catch (Exception e)
                    {
                    }

                    f0.close();
                }
                catch (IOException e)
                {
                    System.out.println("User Data not found !");
                    e.printStackTrace();
                }
            }
            else if (choice2 == 2)
            {
                System.out.println("Enter Amount to Withdraw : (Limit : 0 to " + login_money + ")");
                int amount_withdraw = sc.nextInt();

                while (amount_withdraw < 0 || amount_withdraw > login_money)
                {
                    System.out.println("Enter correct amount !");
                    amount_withdraw = sc.nextInt();
                }
                try
                {
                    FileWriter f0 = new FileWriter(FilePath + username + ".txt", true);
                    String old_money = Integer.toString(login_money);
                    login_money -= amount_withdraw;
                    int temp1 = amount_withdraw;
                    String to_be_withdrawed = Integer.toString(login_money);
                    modifyFile(FilePath + username + ".txt", old_money, to_be_withdrawed);

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    f0.write("(-" + temp1 + ") :: " + formatter.format(date) + " :: Self Withdraw" + "\n");

                    login_transaction = "TRANSACTION:1";
                    modifyFile(FilePath + username + ".txt", "TRANSACTION:0", "TRANSACTION:1");

                    System.out.println("" + temp1 + "$ Withdrawed !");
                    System.out.println("" + login_money + "$ is the Remaining Balance !");
                    System.out.println("\nPress enter to continue");
                    try
                    {
                        System.in.read();
                    }
                    catch (Exception e)
                    {
                    }
                    f0.close();
                }
                catch (IOException e)
                {
                    System.out.println("User Data not found !");
                    e.printStackTrace();
                }
            }

            else if (choice2 == 3)
            {
                System.out.println("\nDetails :");
                System.out.println("1. Name      : " + login_name);
                System.out.println("2. Username  : " + login_username);
                System.out.println("3. Balance   : " + login_money + "$");
                System.out.println("\nPress enter to continue");
                try
                {
                    System.in.read();
                }
                catch (Exception e)
                {
                }
            }

            else if (choice2 == 4)
            {
                try
                {
                    File f1 = new File(FilePath + username + ".txt");
                    Scanner dataReader = new Scanner(f1);
                    System.out.println("Transaction History : ");
                    String temp = "TRANSACTION:0";
                    if (login_transaction.equals(temp))
                    {
                        System.out.println("No Transaction History is there !");
                        System.out.println("\nPress enter to continue");
                        try
                        {
                            System.in.read();
                        }
                        catch (Exception e)
                        {
                        }
                    }
                    else
                    {
                        for (int j = 0; j < 6; j++)
                        {
                            dataReader.nextLine();
                        }
                        while (dataReader.hasNextLine())
                        {
                            String fileData = dataReader.nextLine();
                            System.out.println(fileData);
                        }
                        System.out.println("\nPress enter to continue");
                        try
                        {
                            System.in.read();
                        }
                        catch (Exception e)
                        {
                        }
                    }
                    dataReader.close();
                }
                catch (FileNotFoundException exception)
                {
                    System.out.println("Unexcpected error occurred!");
                    exception.printStackTrace();
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
            else if (choice2 == 5)
            {
                System.out.println();
                System.out.println("Enter Username of other account: ");
                sc.nextLine();
                String username_to_transfer = sc.nextLine();

                File file_to_transfer = new File(FilePath + username_to_transfer + ".txt");
                if (file_to_transfer.exists())
                {
                    Scanner dataReader2 = new Scanner(file_to_transfer);
                    String money_old = dataReader2.nextLine();
                    String name_transfer = dataReader2.nextLine();
                    int money_old_user = Integer.parseInt(money_old);
                    System.out.println("Enter Amount to Transfer : (Limit : 0 to " + login_money + ")");
                    int amount_transfer_update = sc.nextInt();

                    while (amount_transfer_update <= 0 || amount_transfer_update > login_money)
                    {
                        System.out.println("Enter correct amount !");
                        amount_transfer_update = sc.nextInt();

                    }

                        String to_upd = Integer.toString(login_money);
                        login_money -= amount_transfer_update;
                        String to_upd2 = Integer.toString(login_money);
                        modifyFile(FilePath + username + ".txt", to_upd, to_upd2);

                        String to_update = Integer.toString(money_old_user);
                        money_old_user += amount_transfer_update;
                        String to_update_2 = Integer.toString(money_old_user);
                        modifyFile(FilePath + username_to_transfer + ".txt", to_update, to_update_2);
                        modifyFile(FilePath + username_to_transfer + ".txt", "TRANSACTION:0", "TRANSACTION:1");
                        try
                        {
                            FileWriter f11 = new FileWriter(FilePath + username_to_transfer + ".txt", true);
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            Date date = new Date();
                            f11.write("(+" + amount_transfer_update + ") :: " + formatter.format(date) + " :: Transferred from " + username + " (" + login_name + ")\n");
                            f11.close();

                            FileWriter f12 = new FileWriter(FilePath + username + ".txt", true);
                            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            Date date2 = new Date();
                            f12.write("(-" + amount_transfer_update + ") :: " + formatter2.format(date2) + " :: Transferred to " + username_to_transfer + " (" + name_transfer + ")\n");
                            f12.close();

                            System.out.println("(" + amount_transfer_update + ") Transferred to " + username_to_transfer + " ( " + name_transfer + " )");
                            System.out.println("\nPress enter to continue");
                            try
                            {
                                System.in.read();
                            }
                            catch (Exception e)
                            {
                            }
                        }
                        catch (IOException e)
                        {
                            System.out.println("User Data not found !");
                            e.printStackTrace();
                        }
                    dataReader2.close();
                }
                else
                {
                    System.out.println("USER DON'T EXISTS !");
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
            else if(choice2 == 6){
                Path source = Paths.get(FilePath+username+".txt");

                try{
                    System.out.println();
                    System.out.println("Enter Username : ");
                    sc.nextLine();
                    String newUsername = sc.nextLine();
                    System.out.println("Enter Password : ");
                    String newPassword = sc.nextLine();

                    FileWriter f12 = new FileWriter(FilePath + username + ".txt", true);
                    modifyFile(FilePath + username + ".txt", login_username, newUsername);

                    modifyFile(FilePath + username + ".txt", login_password , newPassword);
                    f12.close();
                    Files.move(source, source.resolveSibling(FilePath+newUsername +".txt"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                break;
            }
        }
        sc.close();
        bo = false;
    }
    static void modifyFile(String filePath, String oldString, String newString)
    {
        String oldContent = "";
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null)
            {
                
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }
            String newContent = oldContent.replace(oldString, newString);
            new FileWriter(filePath, false).close();
            FileWriter writer = new FileWriter(filePath);
            writer.write(newContent);
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}