/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodien2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ngao
 */
public class Dictionary_CommandLine extends DictionaryCommandline{
    
    protected ArrayList<Word> arrSearcher = new ArrayList<Word>();
    public void dictionaryBasic()
    {
        insertFromCommandline();
        showAllWords();
    }
    
    public void dictionaryAdvanced()
    {
        this.insertFromFile();
        this.showAllWords();
        //this.dictionaryLookup();
    }
    public ArrayList  WorddictionarySearcher(String tucandich)
    {
        //ArrayList<Word> arr = new ArrayList();
        arrSearcher.clear();
        for(int i=0;i<listOfWord.size();i++)
        {
            if(listOfWord.get(i).getWord_target().length()>= tucandich.length()){
            int n = tucandich.length();
            String sub = listOfWord.get(i).getWord_target().substring(0,n);
            
            if(sub.equals(tucandich)==true)
            {
                arrSearcher.add(listOfWord.get(i));
               
            }
        }
        }
        return arrSearcher;
       
    }
}

    
    
