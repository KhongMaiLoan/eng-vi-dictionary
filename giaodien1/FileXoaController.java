/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodien2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ngao
 */
public class FileXoaController implements Initializable {

    @FXML
    private TextField delWord;
    @FXML
    private Button done;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DelingWord(ActionEvent event) {
        //Word newWord = new Word(eng.getText(), vi.getText());
       
        FXMLLoader loader = new FXMLLoader();
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
        //controller.addListView(newWord);
        controller.XoaTu(delWord.getText());
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();
    }
    
}
