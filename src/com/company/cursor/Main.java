package com.company.cursor;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String login = "login";
        String password = "pass";
        String confirmPassword = "pas";
        try {
            check(login,password,confirmPassword);
        }
        catch (WrongLoginException e){
            e.printStackTrace();
        }catch (WrongPasswordException e){
            e.printStackTrace();
        }finally {
            System.out.println("End try-catch block");
        }
    }
    public static void check(String login,String password,String confirmPassword) throws WrongPasswordException, WrongLoginException {
        if(login.length()>20){
            throw new WrongLoginException("To much symbols in login");
        }
        if(password.length()>20 || confirmPassword.length()>20){
            throw new WrongPasswordException("To much symbols in password");
        }
        String an = "Andrii_Tysiak66";
        final String regexLogin = "^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_]).*$";
        if(login.matches(regexLogin)) {
            System.out.println("hello");
        }
        String[] validSymbols = new String[63];
        String[] loginMas = login.split("");
        String[] passwordMas = password.split("");

        validSymbols[0] = String.valueOf((char) 95);
        for (int i = 0;i<10;i++){
            validSymbols[i+1] = String.valueOf((char) (48+i));
        }
        for (int i = 0;i < 52;i++){
            if(i<26) {
                validSymbols[i + 11] = String.valueOf((char) (65 + i));
            }
            else{
                validSymbols[i+11] = String.valueOf((char) (71+i));
            }
        }
        boolean valid1 = true;
        boolean valid2 = true;
        for(int i = 0; i< login.length();i++){

            for(int j=0;j< validSymbols.length;j++){
                if(loginMas[i].contains(validSymbols[j])){
                   valid1 = true;
                   break;
                }
                else{
                    valid1 = false;
                }
            }
        }
        if (valid1 == false){
            throw new WrongLoginException("Wrong login symbols");
        }

        for(int i = 0; i<password.length();i++){
            for(int j=0;j< validSymbols.length;j++){
                if(passwordMas[i].contains(validSymbols[j])){
                    valid2 = true;
                    break;
                }
                else{
                    valid2 = false;
                }
            }
        }
        if(valid2 == false){
            throw new WrongPasswordException("Wrong password symbols");
        }
        if(!(password == confirmPassword)){
            throw new WrongPasswordException("Passwords didn`t match");
        }


    }


}
