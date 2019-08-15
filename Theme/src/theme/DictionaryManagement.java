/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theme;

import java.io.*;
import java.util.*;

/**
 *
 * @author ngao
 */
public class DictionaryManagement extends Dictionary{
   
    public void insertFromAhViet() throws FileNotFoundException {
        ArrayList<String> eng = new ArrayList<>();
        ArrayList<String> vi = new ArrayList<>();
        try {
            File f = new File("AnhViet.txt");
            if (!f.exists()) {
                System.out.println("Loi mo file");
                return;
            }
            Scanner input = new Scanner(new FileInputStream(f));

            String s = "";
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.isEmpty() == false && line != "") {
                    if (line.charAt(0) == '@') {
                        String a = line.substring(1, line.length());
                        eng.add(a);
                        if (s != "") {
                            vi.add(s);
                        }
                        s = "";
                    } else {
                        s = s.concat(line +"\n");
                    }
                }

            }
            vi.add(s);
            for (int j = 0; j < vi.size(); j++) {
                String a = vi.get(j);
                listOfWord.add(new Word(eng.get(j), a));
            }
        } catch (Exception e) {
            System.out.println("Loi");
        }
    }

        
    
    public void insertFromFile()
    {
        try {
             File f = new File("AnhViet.txt");
             if(!f.exists())
             {
                 System.out.println("Loi mo file");
                 return;
             }
             Scanner input = new Scanner(new FileInputStream(f));
             while(input.hasNextLine())
             {
                 String line = input.nextLine();
                 if(line.trim()!=""){
                     String items[] = line.split("\t");
                     if(items.length>=1){
                     String en = items[0].toString();
                     String vi = items[1].toString();
                     Word w = new Word(en,vi);
                     listOfWord.add(w);
                     }
                 }   
             }
             System.out.println(listOfWord.size());
             input.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
    
    private int binarySearch(ArrayList<Word> arr, int l, int r, String x) 
    {
        if (r>=l) 
        { 
            int mid = l + (r - l)/2; 
            String items[] = arr.get(mid).getWord_target().split(" ");
            int compare = items[0].compareTo(x);
            if (items[0].equals(x)) 
                return mid;
                
            if (compare>0) 
               return binarySearch(arr, l, mid-1, x); 
            return binarySearch(arr, mid+1, r, x); 
        } 
        return arr.size()-1;
    }
    
    public String dictionaryLookup(String en)
    {
        String items[] = en.split(" ");
        String s = listOfWord.get(binarySearch(listOfWord, 0, listOfWord.size()-1, items[0])).getWord_explain();
        return s;
    }

    
    public void addWord(String word_target, String word_explain)
    {
        listOfWord.add(new Word(word_target, word_explain));
    }
    
    public void delWord(String word_target)
    {
        listOfWord.remove(listOfWord.get(binarySearch(listOfWord, 0, listOfWord.size()-1, word_target)));
    }
    
    public void SuaTu(String eng, String  vi)
    {
      
        listOfWord.get(binarySearch(listOfWord,0, listOfWord.size()-1, eng)).setWord_explain(vi);
        
    }
    public void dictionaryExportToFile(String str)
    {
        try
        {
            File f = new File(str);
            FileWriter fw = new FileWriter(f);
            for(Word w: listOfWord)
            {
                fw.write(w.getWord_target() + "\t" + w.getWord_explain() +"\n");
                
            }
            fw.close();
        }catch(IOException ex)
        {
            System.out.println("Loi ghi file" + ex);
        }
    }
}