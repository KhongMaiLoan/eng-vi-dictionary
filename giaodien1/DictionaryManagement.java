/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodien2;

import java.io.*;
import java.util.*;

/**
 *
 * @author ngao
 */
public class DictionaryManagement extends Dictionary{
   
    protected int wordNum;
    
    public void insertFromFile()
    {
        try {
             File f = new File("hoa.txt");
             if(!f.exists())
             {
                 System.out.println("Loi mo file");
                 return;//f.createNewFile();
             }
             Scanner input = new Scanner(new FileInputStream(f));
             while(input.hasNextLine())
             {
                 String line = input.nextLine();
                 if(line.trim()!=""){
                     String items[] = line.split("\t");
                     String en = items[0].toString();
                     String vi = items[1].toString();
                     Word w = new Word(en,vi);
                     listOfWord.add(w);
                 }
                     //wordNum++;
                 //listOfWord.add(new Word(input.next(), input.next()));
                     
                 
             }
             System.out.println(listOfWord.size());
             //input.close();
         } catch (Exception e) {
             System.out.println("Loi");
         }
    }
    
    
    public String dictionaryLookup(String en)
    {
        for(Word w : listOfWord)
        {
            if(w.getWord_target().equals(en))
            {
                //System.out.println(w.getWord_explain());
                return w.getWord_explain();
            }
        }
        System.out.println("Can not find word");
        return "Can not find word";
    }
    //this methods enter the number, the words & the meanings from keyboard
    //private static Scanner scanner = new Scanner(System.in);
    public void insertFromCommandLine()
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
            Word w = new Word(engWord,vnWord);
            listOfWord.add(w);
        }
    }
    
    public void addWord(String word_target, String word_explain)
    {
        listOfWord.add(new Word(word_target, word_explain));
    }
    
    public void delWord(String word_target)
    {
        for(int i=0;i<listOfWord.size();i++)
        {
        if(listOfWord.get(i).getWord_target().equals(word_target)) listOfWord.remove(listOfWord.get(i));
            
        }
    }
    
    public void suaWord()
    {
        
    }
    public void dictionaryExportToFile(String str)
    {
        try
        {
            File f = new File(str);
            FileWriter fw = new FileWriter(f);
            for(Word w: listOfWord)
            {
                fw.write(w.getWord_target() + " " + w.getWord_explain() +"\n");
                
            }
            fw.close();
        }catch(IOException ex)
        {
            System.out.println("Loi ghi file" + ex);
        }
    }
    
    

    
    
}