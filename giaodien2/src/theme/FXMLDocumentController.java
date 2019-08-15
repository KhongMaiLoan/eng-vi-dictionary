/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theme;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author ngao
 */
public class FXMLDocumentController implements Initializable {

    ObservableList list = FXCollections.observableArrayList();
    Dictionary_CommandLine exe = new Dictionary_CommandLine();

    private String sfromtextfield = "";
    @FXML
    private ListView<String> listView;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button soundButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        textArea.setWrapText(true);
        textField.setMaxWidth(500);
        try {
            exe.insertFromAhViet();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //list.removeAll(list);
        for (int i = 0; i < exe.listOfWord.size(); i++) {
            list.add(exe.listOfWord.get(i).getWord_target());
        }
        listView.getItems().addAll(list);
        sfromtextfield = textField.getText();
        
        exe.dictionaryExportToFile("output.txt");

    }

    @FXML
    private void displaySelected(MouseEvent event) {
        sfromtextfield = listView.getSelectionModel().getSelectedItem();
        if (sfromtextfield == null || sfromtextfield.isEmpty()) {
            textArea.setText("Looking up your word!");
        } else if (sfromtextfield.isEmpty()) {
            textArea.setText("Looking up your word!");
        } else {

            textArea.setText(exe.dictionaryLookup(sfromtextfield));
        }

    }

    @FXML
    private void disPlayInListView(KeyEvent event) {

        sfromtextfield = textField.getText();
        if (sfromtextfield.isEmpty()) {
            textArea.setText("Looking up your word!");
        }
        //listView.refresh();
        listView.getItems().clear();

        //list.removeAll(listView);
        list.clear();

        ArrayList<Word> arrayHaveTuDauTienS = exe.WorddictionarySearcher(sfromtextfield);
        if (arrayHaveTuDauTienS.isEmpty() != true) {
            for (int i = 0; i < arrayHaveTuDauTienS.size(); i++) {
                list.add(arrayHaveTuDauTienS.get(i).getWord_target());
            }
            list = FXCollections.observableArrayList(list);
            listView.getItems().addAll(list);
        }
    }

    
    @FXML
    public void AddingNewWord1(ActionEvent event) throws IOException {
        
        
        Parent addParent = FXMLLoader.load(getClass().getResource("FileThem.fxml"));
        Scene addScene = new Scene(addParent);
        addScene.getStylesheets().add(getClass().getResource("textfield.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addScene);
        window.show();
    }
    
    public void addListView(Word newWord)
    {
        //System.out.println("Done");
        exe.addWord(newWord.getWord_target(), newWord.getWord_explain());
        //list.removeAll(list);
        //exe.sort(exe.listOfWord, 0, exe.listOfWord.size()-1);
        list.add(newWord.getWord_target());
        listView.getItems().addAll(list);
        
        
    }

    @FXML
    private void FixTheWord(ActionEvent event) throws IOException {
        Parent addParent = FXMLLoader.load(getClass().getResource("FileSua.fxml"));
        Scene fixScene = new Scene(addParent);
        fixScene.getStylesheets().add(getClass().getResource("textfield.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(fixScene);
        window.show();
    }

    @FXML
    private void DelTheWord(ActionEvent event) throws IOException {
        Parent addParent = FXMLLoader.load(getClass().getResource("FileXoa.fxml"));
        Scene delScene = new Scene(addParent);
        delScene.getStylesheets().add(getClass().getResource("textfield.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(delScene);
        window.show();
     
    }
    
    public void XoaTu(String s) {
        listView.getItems().clear();

        //list.removeAll(listView);
        list.clear();

        exe.delWord(s);
        for (int i = 0; i < exe.listOfWord.size(); i++) {
            list.add(exe.listOfWord.get(i).getWord_target());
        }
        list = FXCollections.observableArrayList(list);
        listView.getItems().addAll(list);
    }
    
    public void SuaTu(String eng, String  vi)
    {
        exe.SuaTu(eng, vi);
        
    }

    @FXML
    public void playSound(ActionEvent event) {
        String items[] = listView.getSelectionModel().getSelectedItem().split(" ");
        String s = items[0].toString();
        
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin16");
        voice.allocate();
        voice.speak(s); 
    }
    
    
    
}
