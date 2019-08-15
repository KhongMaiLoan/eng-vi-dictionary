/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandline_ver1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ngao
 */
public class DictionaryManagement extends Dictionary{
   
    protected int wordNum;
    //this methods enter the number, the words & the meanings from keyboard
    public void insertFromCommandline()
    {
        System.out.println("Enter number of words:");
        Scanner sc = new Scanner(System.in);
        wordNum = sc.nextInt();

        for(int i = 0; i < wordNum; i++)
        {
            Scanner enter = new Scanner(System.in);
            System.out.println("Enter word:");
            String engWord = enter.nextLine();

            Scanner enter1 = new Scanner(System.in);
            System.out.println("Enter meaning:");
            String vnWord = enter1.nextLine();

            //these codes create an obj and add the obj to array "Word"
            Word w = new Word();
            w.setWord_target(engWord);
            w.setWord_explain(vnWord);
            listOfWord.add(w);
        }
    }
    
    
    
    
    
    public String dictionaryLookup()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập từ muốn tra");
        String en = scanner.nextLine();
        for(Word w : listOfWord)
        {
            if(w.getWord_target().equals(en))
            {
                System.out.println(w.getWord_explain());
                return w.getWord_explain();
            }
        }
        System.out.println("Can not find word");
        return "Can not find word";
    }
    
    
}
