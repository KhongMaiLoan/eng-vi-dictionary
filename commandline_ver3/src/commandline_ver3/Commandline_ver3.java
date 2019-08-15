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
public class Commandline_ver3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DictionaryCommandLine exe = new DictionaryCommandLine();
        
        exe.dictionaryAdvanced();
        exe.addWord();
        exe.showAllWords();
        exe.SuaTu();
        exe.showAllWords();
        exe.delWord();
        exe.showAllWords();
        exe.WorddictionarySearcher();
        exe.dictionaryExportToFile("output.txt");
    }
    
}
