/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 201811294029
 */
public class FXMLLibraryBasController implements Initializable {

    @FXML
    private JFXButton buttonGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setOnActionButtonGuardar(ActionEvent event) {
        cargarVentana();
    }
    
    public void cargarVentana(){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLAgregar.fxml"));
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Tutulo");
            stage.showAndWait();
        } catch (Exception e) {
        }
        
    }
    
}
