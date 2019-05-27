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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import lista.ListaRecurso;
import model.Comunidad;
import model.Docente;
import model.Estudiante;
import model.Inventario;
import model.Recurso;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author Isaac
 */
public class FXMLLibraryBasController implements Initializable {

    private Inventario inventario;
    private Comunidad comunidad;

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
    @FXML
    private ImageView imageViewFoto;
    @FXML
    private Button buttonRealizarPrestamo;
    @FXML
    private DatePicker datePickerFechaPrestamo;
    @FXML
    private DatePicker datePickerFechaLimite;
    @FXML
    private TextField textCodigoUsuarioPrestamo;
    @FXML
    private Button buttonAgregarFoto;
    @FXML
    private TableView<Usuario> tablaUsuarios;
    @FXML
    private Button botonBuscarPorId;
    @FXML
    private TableColumn<?, ?> columnaId;
    @FXML
    private TableColumn<?, ?> columnaNombre;
    @FXML
    private Button buttonEliminarUsuario;
    @FXML
    private Button buttonBuscarRecurso;
    @FXML
    private TableView<Recurso> TablaRecursos;
    @FXML
    private TableColumn<?, ?> columnaIdRecurso;
    @FXML
    private TableColumn<?, ?> columnaTipoRecurso;
    @FXML
    private TableColumn<?, ?> columnaNombreRecurso;
    @FXML
    private TableView<?> tablaPrestamos;
    @FXML
    private TableColumn<?, ?> columnaPrestamoUsuario;
    @FXML
    private TableColumn<?, ?> columnaPrestamoRecurso;
    @FXML
    private TableColumn<?, ?> columnaPrestamoFechaPrestamo;
    @FXML
    private TableColumn<?, ?> columnaPrestamoFechaLimite;
    @FXML
    private TableColumn<?, ?> columnaPrestamoMultado;
    @FXML
    private Button buttonRealizarBuscarPrestamos;
    @FXML
    private ComboBox comboBoxCodigoRecursoPrestamo;

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
        inventario = new Inventario();
        InicializarColumnas();
    }
    
    private void InicializarColumnas() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        columnaId.setCellValueFactory(new PropertyValueFactory<>("codigoUsuario"));
        
        columnaIdRecurso.setCellValueFactory(new PropertyValueFactory<>("codigoRecurso"));
        columnaNombreRecurso.setCellValueFactory(new PropertyValueFactory<>("nombreRecurso"));
        columnaTipoRecurso.setCellValueFactory(new PropertyValueFactory<>("tipo"));
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
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.setIconified(true);
    }

    @FXML
    private void setOnActionButtonAñadirRecurso(ActionEvent event) {
        String nombreRecurso = textNombre.getText();
        int codigoRecurso = Integer.parseInt(textId.getText());
        String tipo = comboBoxTipo.getValue();
        
        if(inventario.listaRecurso.buscarRecursoId(inventario.listaRecurso, codigoRecurso)==null) {
            inventario.listaRecurso.insertarRecurso(inventario.listaRecurso, nombreRecurso, codigoRecurso, tipo);
            //JOptionPane.showMessageDialog(null, "!Agregado con exito¡");
        } else {
            inventario.listaRecurso.actualizarRecurso(nombreRecurso, codigoRecurso, tipo);
            //JOptionPane.showMessageDialog(null, "!Actualizado con exito¡");
        }
        
        textNombre.setText("");
        textId.setText("");
        comboBoxTipo.getSelectionModel().select(0);
        
        LlenarListaRecursos();

    }

    @FXML
    private void setOnActionButtonEliminarRecurso(ActionEvent event) {
        int codigoRecurso = Integer.parseInt(textId.getText());
        inventario.listaRecurso = inventario.listaRecurso.eliminarRecurso(inventario.listaRecurso, codigoRecurso);
        LlenarListaRecursos();
        //JOptionPane.showMessageDialog(null,"El recurso se elimino exitosamente");
        textNombre.setText("");
        textId.setText("");
        comboBoxTipo.getSelectionModel().select(0);
    }

    @FXML
    private void setOnActionButtonAñadirUsuario(ActionEvent event) {
        String nombreUsuario = textNombreUsuario.getText();
        int codigoUsuario = Integer.parseInt(textIdUsuario.getText());
        String tipo = comboBoxRol.getValue();
        Image foto = imageViewFoto.getImage();
        
        if(comunidad.buscarUsuarioId(comunidad, codigoUsuario) == null) {
            comunidad.insertarUsuario(comunidad, nombreUsuario, codigoUsuario, tipo, foto);
            //JOptionPane.showMessageDialog(null, "!Agregado con exito¡");
        } else {
            comunidad.actualizarUsuario(nombreUsuario, codigoUsuario, tipo, foto);
            //JOptionPane.showMessageDialog(null, "!Actualizado con exito¡");
        }
        
        textNombreUsuario.setText("");
        textIdUsuario.setText("");
        imageViewFoto.imageProperty().set(null);
        comboBoxRol.getSelectionModel().select(0);
        
        LlenarListaUsuarios();
        
    }

    @FXML
    private void setOnActionButtonAgregarFoto(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Archivos PNG", "*.png"),
                new ExtensionFilter("Archivos JPG", "*.jpg")
        );
        fileChooser.setTitle("Abrir archivo de foto");
        File archivo = fileChooser.showOpenDialog(null);
        Image image = new Image(new FileInputStream(archivo.getPath()));
        imageViewFoto.setImage(image);
    }

    @FXML
    private void setOnActionButtonRealizarPrestamo(ActionEvent event) {
        int codigoRecurso = Integer.parseInt(comboBoxCodigoRecursoPrestamo.getSelectionModel().getSelectedItem().toString());
        Recurso recurso = inventario.listaRecurso.buscarRecursoId(inventario.listaRecurso, codigoRecurso);
        if(recurso.getPrestado()) {
            //JOptionPane.showMessageDialog(null, "El recurso solicitado está prestado");
            return;
        }
        
        int codigoUsuario = Integer.parseInt(textCodigoUsuarioPrestamo.getText());
        Usuario usuario = comunidad.buscarUsuarioId(comunidad, codigoUsuario);
        
        LocalDate localDatePrestamo = datePickerFechaPrestamo.getValue();
        Instant instantPrestamo = Instant.from(localDatePrestamo.atStartOfDay(ZoneId.systemDefault()));
        Date fechaPrestamo = Date.from(instantPrestamo);
        
        LocalDate localDateLimite = datePickerFechaLimite.getValue();
        Instant instantLimite = Instant.from(localDateLimite.atStartOfDay(ZoneId.systemDefault()));
        Date fechaLimite = Date.from(instantLimite);
        
        inventario.listaPrestamo.insertarPrestamo(inventario.listaPrestamo, recurso, usuario, fechaPrestamo, fechaLimite);
        //JOptionPane.showMessageDialog(null, "El prestamo ha sido registrado con exito");
        
    }
    
    private void LlenarListaUsuarios() {
        tablaUsuarios.getItems().clear();
        Comunidad apuntador = comunidad;
        while(apuntador.nodo != null) {
            tablaUsuarios.getItems().add(apuntador.nodo);
            apuntador = apuntador.siguiente;
        }
    }

    @FXML
    private void setOnActionButtonBuscarPorId(ActionEvent event) {
        int codigoUsuario = Integer.parseInt(textIdUsuario.getText());
        Usuario usuarioEncontrado = comunidad.buscarUsuarioId(comunidad, codigoUsuario);
        if(usuarioEncontrado == null) {
            //JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        } else {
            textNombreUsuario.setText(usuarioEncontrado.getNombreUsuario());
            textIdUsuario.setText("" + usuarioEncontrado.getCodigoUsuario());
            imageViewFoto.imageProperty().set(usuarioEncontrado.getFoto());
            if(usuarioEncontrado instanceof Estudiante) {
                comboBoxRol.getSelectionModel().select("Estudiante");
            } else {
                if(usuarioEncontrado instanceof Docente) {
                    comboBoxRol.getSelectionModel().select("Docente");
                } else {
                    comboBoxRol.getSelectionModel().select("Padre de familia");
                }
            }
        }
    }

    @FXML
    private void setOnActionButtonEliminarUsuario(ActionEvent event) {
        int codigoUsuario = Integer.parseInt(textIdUsuario.getText());
        comunidad = comunidad.eliminarUsuario(comunidad, codigoUsuario);
        LlenarListaUsuarios();
        textIdUsuario.setText("");
        textNombreUsuario.setText("");
    }

    @FXML
    private void setOnActionButtonBuscarRecurso(ActionEvent event) {
       int codigoRecurso = Integer.parseInt(textId.getText());
        Recurso recursoEncontrado = inventario.listaRecurso.buscarRecursoId(inventario.listaRecurso, codigoRecurso);
        if(recursoEncontrado == null) {
            //JOptionPane.showMessageDialog(null, "recurso no encontrado");
        } else {
            textNombre.setText(recursoEncontrado.getNombreRecurso());
            textId.setText("" + recursoEncontrado.getCodigoRecurso());
            comboBoxTipo.getSelectionModel().select(recursoEncontrado.getTipo());       
        }
    }
    
    private void LlenarListaRecursos() {
        TablaRecursos.getItems().clear();
        comboBoxCodigoRecursoPrestamo.getItems().clear();
        ListaRecurso apuntador = inventario.listaRecurso;
        while(apuntador.nodo != null) {
            TablaRecursos.getItems().add(apuntador.nodo);
            comboBoxCodigoRecursoPrestamo.getItems().add(apuntador.nodo.codigoRecurso().get());
            apuntador = apuntador.siguiente;
        }
    }

    @FXML
    private void setOnActionButtonBuscarPrestamos(ActionEvent event) {
    }
}
