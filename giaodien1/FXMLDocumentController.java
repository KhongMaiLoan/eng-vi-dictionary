/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodien2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        textField.setMaxWidth(500);
        exe.insertFromFile();
        list.removeAll(list);
        for (int i = 0; i < exe.listOfWord.size(); i++) {
            list.add(exe.listOfWord.get(i).getWord_target());
        }
        listView.getItems().addAll(list);
        sfromtextfield = textField.getText();

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

        list.removeAll(listView);
        list.clear();

        ArrayList<Word> arrayHaveTuDauTienS = exe.WorddictionarySearcher(sfromtextfield);
        if (arrayHaveTuDauTienS.isEmpty() != true) {
            for (int i = 0; i < arrayHaveTuDauTienS.size(); i++) {
                list.add(arrayHaveTuDauTienS.get(i).getWord_target());
            }
            list = FXCollections.observableArrayList(list);
            //list.addAll(arrayHaveTuDauTienS);
            listView.getItems().addAll(list);
        }
    }

    @FXML
    private void AddingNewWord1(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FileThem.fxml"));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        FileThemController controller = loader.getController();
        
        stage.setScene(scene);
    }
    
    public void addListView(Word newWord)
    {
        System.out.println("Done");
        list.removeAll(list);
        list.add(newWord.getWord_target());
        listView.getItems().addAll(list);
    }

    @FXML
    private void FixTheWord(ActionEvent event) throws IOException {
        //SuaTu("hello", "What's up");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FileSua.fxml"));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        FileSuaController controller = loader.getController();
        
        stage.setScene(scene);
    }

    @FXML
    private void DelTheWord(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FileXoa.fxml"));
        Parent studentViewParent = loader.load();
        Scene scene = new Scene(studentViewParent);
        FileXoaController controller = loader.getController();
        
        stage.setScene(scene);
     
    }
    
    public void XoaTu(String s)
    {
        listView.getItems().clear();

        list.removeAll(listView);
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
        for (int i = 0; i < exe.listOfWord.size(); i++) {
            if(exe.listOfWord.get(i).getWord_target().equals(eng))
            {
                exe.listOfWord.get(i).setWord_explain(vi);
            }
        }
    }
}
