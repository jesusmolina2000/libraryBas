/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Isaac
 */
public class FXMLLibraryBasController implements Initializable {

    @FXML
    private ImageView imageViewClose;
    @FXML
    private ImageView imageViewMinimize;
    @FXML
    private Button buttonInventario;
    @FXML
    private Button buttonUsuario;
    @FXML
    private Button buttonPrestamo;
    @FXML
    private Button buttonDevolucion;
    @FXML
    private Button buttonMulta;
    @FXML
    private TextField textId;
    @FXML
    private ComboBox<String> comboBoxTipo;
    @FXML
    private Pane paneEstado;
    @FXML
    private Label labelEstado;
    @FXML
    private GridPane gridPaneMulta;
    @FXML
    private GridPane gridPaneDevolucion;
    @FXML
    private GridPane gridPanePrestamo;
    @FXML
    private GridPane gridPaneUsuario;
    @FXML
    private TextField textNombreUsuario;
    @FXML
    private TextField textIdUsuario;
    @FXML
    private ComboBox<String> comboBoxRol;
    @FXML
    private GridPane gridPaneInventario;
    @FXML
    private Button buttonAñadirUsuario;
    @FXML
    private Button buttonInsertarRecurso;
    @FXML
    private Button buttonEliminarRecurso;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBoxTipo.getItems().addAll("CD", "Revista", "Libro");
        comboBoxRol.getItems().addAll("Estudiante", "Padre de familia",
                "Docente");
    }

    @FXML
    private void handleClick(ActionEvent event) {
        if (event.getSource() == buttonInventario) {
            labelEstado.setText("Inventario");
            gridPaneInventario.toFront();
        } else if (event.getSource() == buttonUsuario) {
            labelEstado.setText("Usuarios");
            gridPaneUsuario.toFront();
        } else if (event.getSource() == buttonPrestamo) {
            labelEstado.setText("Prestamos");
            gridPanePrestamo.toFront();
        } else if (event.getSource() == buttonDevolucion) {
            labelEstado.setText("Devoluciones");
            gridPaneDevolucion.toFront();
        } else if (event.getSource() == buttonMulta) {
            labelEstado.setText("Multas");
            gridPaneMulta.toFront();
        }
    }

    @FXML
    private void setOnMouseClickedImageViewClose(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void setOnMouseClickedImageViewMinimize(MouseEvent event) {

    }

}
