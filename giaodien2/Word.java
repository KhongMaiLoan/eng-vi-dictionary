/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodien2;

/**
 *
 * @author ngao
 */
public class Word {
    private String word_target, word_explain;

    //getter and setter for word_target
    public Word()
    {
        word_target="";
        word_explain="";
    }
    public Word(String word_target, String word_explain)
    {
        this.word_explain = word_explain;
        this.word_target = word_target;
    }
    public void setWord_target(String n) {
        this.word_target = n;
    }

    public String getWord_target() {
        return word_target;
    }

    //getter and setter for word_explain
    public void setWord_explain(String n) {
        this.word_explain = n;
    }

    public String getWord_explain() {
        return word_explain;
    }
}