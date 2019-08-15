/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandline_ver3;

/**
 *
 * @author ngao
 */
public class DictionaryCommandline extends DictionaryManagement{
    //public DictionaryManagement dicMan = new DictionaryManagement();
    public void showAllWords()
    {

        //System.out.println("No  | English       | Vietnamese");
        System.out.printf("%-25s%-25s%s\n","No" ,"| English" ,"| Vietnamese");
        int i=1;

        for(Word w : listOfWord)
        {
            System.out.printf("%-25s%-25s%s\n",Integer.toString(i) ,"| " + w.getWord_target() ,"| " + w.getWord_explain());
            i++;
        }
    }
}
