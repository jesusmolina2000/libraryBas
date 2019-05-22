/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.swing.JOptionPane;
import lista.ListaRecurso;
import model.Comunidad;

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
    @FXML
    private TextField textIdUsuarioDevolucion;
    @FXML
    private Button buttonDevolver;
    @FXML
    private Button buttonMultar;
    @FXML
    private Button buttonPagarMulta;
    @FXML
    private TextField textIdUsuarioMulta;
    @FXML
    private TextField textNombre;

    private ListaRecurso listaRecurso;
    private Comunidad comunidad;
    @FXML
    private Button botonAgregarFoto;
    @FXML
    private ImageView imageViewFoto;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBoxTipo.getItems().addAll("Seleccione tipo", "CD", "Revista", "Libro");
        comboBoxRol.getItems().addAll("Seleccione rol", "Estudiante", "Docente",
                "Padre de familia");
        comunidad = new Comunidad();
        listaRecurso = new ListaRecurso();
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

    @FXML
    private void setOnMouseClickedbuttonAñadirUsuario(MouseEvent event) {
        String nombreUsuario = textNombreUsuario.getText();
        int codigoUsuario = Integer.parseInt(textIdUsuario.getText());
        String tipo = comboBoxRol.getValue();
        Image foto = imageViewFoto.getImage();
        comunidad.insertarUsuario(comunidad, nombreUsuario, codigoUsuario, tipo, foto);
        JOptionPane.showMessageDialog(null, "!Agregado con exito¡");

        textNombreUsuario.setText("");
        textIdUsuario.setText("");
        imageViewFoto.imageProperty().set(null);
        comboBoxRol.getSelectionModel().select(0);
    }

    @FXML
    private void agregarFoto(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Archivos JPG", "*.jpg"), new ExtensionFilter("Archivos PNG", "*.png"));
        fileChooser.setTitle("Abrir archivo de foto");
        File archivo = fileChooser.showOpenDialog(null);

        Image image = new Image(new FileInputStream(archivo.getPath()));
        imageViewFoto.setImage(image);
    }

    @FXML
    private void setOnMouseClickedbuttonAñadirRecurso(ActionEvent event) {
        String nombreRecurso = textNombre.getText();
        int codigoRecurso = Integer.parseInt(textId.getText());
        String tipo = comboBoxTipo.getValue();
        listaRecurso.insertarRecurso(listaRecurso, nombreRecurso, codigoRecurso, tipo);

    }

    @FXML
    private void setOnMouseClickedbuttonEliminarRecurso(ActionEvent event) {
        int codigoRecurso = Integer.parseInt(textId.getText());
        listaRecurso.eliminarRecurso(listaRecurso, codigoRecurso);
    }

}
