package com.drh.lesson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccountManager {
    //细水长流 待哪天不是150了你就知错
    static int linenum = 150;
    static String[] Users = new String[linenum];
    static String[] Pswds = new String[linenum];

    public static void main(String[] args) {
        try {
            FileReader bnd = new FileReader("AccountInfo.txt");
            BufferedReader ttb = new BufferedReader(bnd);
            String line;
            Account[] boy = new Account[linenum];
            int ttemp = 0;

            //ttb.reset();
            while((line = ttb.readLine()) != null){
                String [] temp = line.split(" ");
                Account what = new Account(temp[0], temp[1]);
                //boy[ttemp] = what;
                Users[ttemp] = what.Username;
                Pswds[ttemp] = what.Passwords;
                ttemp++;
                //System.out.println(ttemp);
            }

            Add("bndttb", "Ohyessir123");

            /*
            for (Account xiete : boy) {
                System.out.println("账号: " + xiete.Username + " 密码: " + xiete.Passwords);
            }
             */

        }catch (IOException e){
            System.out.println("?");
        }
    }
    public static boolean Check(String Username, String Password){
        if (Username.length() > 3 && Username.length() < 8 && Username.matches("[a-z]*") && Password.matches("([a-z]*[A-Z]*[0-9]*)*")){
            for (int i = 0; i < Users.length; i++) {
                if (Users[i] == Username){
                    System.out.println("No, sir");
                    return false;
                }
            }
            System.out.println("Yes, sir!");
            return true;
        }
            return false;
    }

    public static void Add(String Username, String Password) throws IOException {
        if (Check(Username, Password)){
            try {
                FileWriter xie = new FileWriter("AccountInfo.txt", true);
                xie.write(Username + " " + Password);
                xie.flush();
                xie.close();

                System.out.println("Yes, sir!");

            }catch (Exception e){
                System.out.println("No, sir");
            }
        }
    }


    }
