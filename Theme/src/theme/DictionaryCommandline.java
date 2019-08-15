/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theme;

/**
 *
 * @author ngao
 */
public class DictionaryCommandline  extends DictionaryManagement {
    public void showAllWords()
    {

        System.out.println("No  | English       | Vietnamese");
        for(int i=0;i<listOfWord.size();i++)
        {
            System.out.println(i + "     | " + listOfWord.get(i).getWord_target() + "           | " + listOfWord.get(i).getWord_explain());
          
        }
    }
   
    
}