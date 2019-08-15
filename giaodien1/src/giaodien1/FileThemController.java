/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodien2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FileThemController implements Initializable {

    @FXML
    private TextField eng, vi;
    @FXML
    private Button done;
    @FXML
    private AnchorPane anchor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void AddingNewWord2(ActionEvent event) throws IOException {
        Word newWord = new Word(eng.getText(), vi.getText());
       
        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        try
        {
            loader.load();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        FXMLDocumentController controller = loader.getController();
        controller.addListView(newWord);
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(p);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("textfield.css").toExternalForm());
        stage.showAndWait();*/
        
        
        /*Parent addParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLLoader loader = new FXMLLoader();
        
        Scene addScene = new Scene(addParent);
        addScene.getStylesheets().add(getClass().getResource("textfield.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addScene);
        window.show();
    }*/
        
        
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        scene.getStylesheets().add(getClass().getResource("textfield.css").toExternalForm());
        FXMLDocumentController controller = loader.getController();
        controller.addListView(newWord);
        stage.setScene(scene);
    }
}