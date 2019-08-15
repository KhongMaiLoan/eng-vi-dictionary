/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transparent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 *
 * @author ngao
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField textfield;
    @FXML
    private TextArea textarea;
    @FXML
    private Button button;
    
    private void handleButtonAction(ActionEvent event) {
        textarea.setText(textfield.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 Image image = new Image(getClass().getResourceAsStream("35730117.jpg"));
    label = new Label("Search");
    label.setGraphic(new ImageView(image));
    }    
    
}
