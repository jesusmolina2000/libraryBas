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
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn.CellDataFeatures;
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
import javafx.util.Callback;
import javax.swing.JOptionPane;
import model.ListaPrestamo;
import model.ListaRecurso;
import model.Comunidad;
import model.Docente;
import model.Estudiante;
import model.Inventario;
import model.Prestamo;
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
    private TextField textId;
    @FXML
    private ComboBox<String> comboBoxTipo;
    @FXML
    private Pane paneEstado;
    @FXML
    private Label labelEstado;
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
    private Button buttonPagarMulta;
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
    private TableView<Prestamo> tablaPrestamos;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoUsuario;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoRecurso;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoFechaPrestamo;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoFechaLimite;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoMultado;
    @FXML
    private Button buttonRealizarBuscarPrestamos;
    @FXML
    private ComboBox comboBoxCodigoRecursoPrestamo;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoFechaDevolucion;
    @FXML
    private TableColumn<?, ?> columnaTipoUsuario;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoId;
    @FXML
    private TableView<Prestamo> tablaPrestamosDevolucionesMultas;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoFechaDevolucion1;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoIdDevoluciones;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoUsuarioDevoluciones;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoRecursoDevoluciones;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoFechaPrestamoDevoluciones;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoFechaLimiteDevoluciones;
    @FXML
    private TableColumn<Prestamo, String> columnaPrestamoMultadoDevoluciones;
    @FXML
    private Button buttonBuscarPrestamosDevoluciones;
    @FXML
    private DatePicker datePickerFechaDevolucion;
    @FXML
    private TableColumn<Recurso, String> columnaRecursoPrestado;
    @FXML
    private Button buttonMultarPrestamo;
    @FXML
    private TextField textValorMulta;

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
        CargarDataDePrueba(); // Quitar
    }

    
    //data de prueba para facilitar explicacion
    private void CargarDataDePrueba() {
        comunidad.insertarUsuario(comunidad, "Jesus Molina", 123, "Estudiante", null);
        comunidad.insertarUsuario(comunidad, "Freddy Rada", 321, "Docente", null);
        comunidad.insertarUsuario(comunidad, "Alberto Molina", 777, "Padre de familia", null);
        comunidad.insertarUsuario(comunidad, "Yolanda Heredia", 888, "Padre de familia", null);

        inventario.listaRecurso.insertarRecurso(inventario.listaRecurso, "Cien años de soledad", 1, "Libro");
        inventario.listaRecurso.insertarRecurso(inventario.listaRecurso, "Enciclopedia Encarta", 2, "CD");
        inventario.listaRecurso.insertarRecurso(inventario.listaRecurso, "Revista Semana Mayo 2019", 3, "Revista");

        LlenarListaRecursos();
        LlenarListaUsuarios();
    }

    private void InicializarColumnas() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        columnaId.setCellValueFactory(new PropertyValueFactory<>("codigoUsuario"));
        columnaTipoUsuario.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        columnaIdRecurso.setCellValueFactory(new PropertyValueFactory<>("codigoRecurso"));
        columnaNombreRecurso.setCellValueFactory(new PropertyValueFactory<>("nombreRecurso"));
        columnaTipoRecurso.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnaRecursoPrestado.setCellValueFactory((CellDataFeatures<Recurso, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().getPrestado() ? "Si" : "No")
        );

        columnaPrestamoRecurso.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper("" + p.getValue().getRecurso().getCodigoRecurso())
        );
        columnaPrestamoUsuario.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper("" + p.getValue().getUsuario().getCodigoUsuario())
        );
        columnaPrestamoFechaPrestamo.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().getFechaPrestamo().toString())
        );
        columnaPrestamoFechaLimite.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().getFechaLimite().toString())
        );
        columnaPrestamoFechaDevolucion.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().getFechaDevolucionString())
        );
        columnaPrestamoMultado.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().estaMultado() ? "Si" : "No")
        );
        columnaPrestamoId.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper("" + p.getValue().getId())
        );

        columnaPrestamoRecursoDevoluciones.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper("" + p.getValue().getRecurso().getCodigoRecurso())
        );
        columnaPrestamoUsuarioDevoluciones.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper("" + p.getValue().getUsuario().getCodigoUsuario())
        );
        columnaPrestamoFechaPrestamoDevoluciones.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().getFechaPrestamo().toString())
        );
        columnaPrestamoFechaLimiteDevoluciones.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().getFechaLimite().toString())
        );
        columnaPrestamoFechaDevolucion1.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().getFechaDevolucionString())
        );
        columnaPrestamoMultadoDevoluciones.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().estaMultado() ? "Si" : "No")
        );
        columnaPrestamoIdDevoluciones.setCellValueFactory((CellDataFeatures<Prestamo, String> p)
                -> new ReadOnlyObjectWrapper("" + p.getValue().getId())
        );
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

        if (inventario.listaRecurso.buscarRecursoId(inventario.listaRecurso, codigoRecurso) == null) {
            inventario.listaRecurso.insertarRecurso(inventario.listaRecurso, nombreRecurso, codigoRecurso, tipo);
            mostrarNotificacion("!Agregado con exito¡");
        } else {
            inventario.listaRecurso.actualizarRecurso(nombreRecurso, codigoRecurso, tipo);
            mostrarNotificacion("!Actualizado con exito¡");
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
        mostrarNotificacion("El recurso se elimino exitosamente");
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

        if (comunidad.buscarUsuarioId(comunidad, codigoUsuario) == null) {
            comunidad.insertarUsuario(comunidad, nombreUsuario, codigoUsuario, tipo, foto);
            mostrarNotificacion("!Agregado con exito¡");
        } else {
            comunidad.actualizarUsuario(nombreUsuario, codigoUsuario, tipo, foto);
            mostrarNotificacion("!Actualizado con exito¡");
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
        if (recurso.getPrestado()) {
            mostrarNotificacion("El recurso solicitado está prestado");
            return;
        }

        int codigoUsuario = Integer.parseInt(textCodigoUsuarioPrestamo.getText());
        Usuario usuario = comunidad.buscarUsuarioId(comunidad, codigoUsuario);
        if (usuario == null) {
            mostrarNotificacion("El usuario no existe");
            return;
        }
        // Validación de prestamos
        if ("Estudiante".equals(usuario.getTipo()) && inventario.cuantosPrestamosPorUsuario(codigoUsuario) == 2) {
            mostrarNotificacion("Este estudiante ya tiene dos prestamos y no puede tener más");
            return;
        }
        if ("Padre de familia".equals(usuario.getTipo()) && inventario.cuantosPrestamosPorUsuario(codigoUsuario) == 1) {
            mostrarNotificacion("Este padre de familia ya tiene un prestamo y no puede tener más");
            return;
        }
        if ("Docente".equals(usuario.getTipo()) && inventario.cuantosPrestamosPorUsuario(codigoUsuario) >= 4) {
            mostrarNotificacion("Este docente ya tiene cuatro prestamos y no puede tener más");
            return;
        }

        LocalDate localDatePrestamo = datePickerFechaPrestamo.getValue();
        Instant instantPrestamo = Instant.from(localDatePrestamo.atStartOfDay(ZoneId.systemDefault()));
        Date fechaPrestamo = Date.from(instantPrestamo);

        LocalDate localDateLimite = datePickerFechaLimite.getValue();
        Instant instantLimite = Instant.from(localDateLimite.atStartOfDay(ZoneId.systemDefault()));
        Date fechaLimite = Date.from(instantLimite);

        inventario.listaPrestamo.insertarPrestamo(inventario.listaPrestamo, recurso, usuario, fechaPrestamo, fechaLimite);

        comboBoxCodigoRecursoPrestamo.getSelectionModel().clearSelection();
        datePickerFechaPrestamo.getEditor().clear();
        datePickerFechaLimite.getEditor().clear();
        mostrarNotificacion("El prestamo ha sido registrado con exito");
        LlenarListaPrestamos(codigoUsuario);
        LlenarListaRecursos();
    }

    @FXML
    private void setOnActionButtonBuscarPorId(ActionEvent event) {
        int codigoUsuario = Integer.parseInt(textIdUsuario.getText());
        Usuario usuarioEncontrado = comunidad.buscarUsuarioId(comunidad, codigoUsuario);
        if (usuarioEncontrado == null) {
            mostrarNotificacion("Usuario no encontrado");
        } else {
            textNombreUsuario.setText(usuarioEncontrado.getNombreUsuario());
            textIdUsuario.setText("" + usuarioEncontrado.getCodigoUsuario());
            imageViewFoto.imageProperty().set(usuarioEncontrado.getFoto());
            comboBoxRol.getSelectionModel().select(usuarioEncontrado.getTipo());
        }
    }

    @FXML
    private void setOnActionButtonEliminarUsuario(ActionEvent event) {
        int codigoUsuario = Integer.parseInt(textIdUsuario.getText());
        comunidad = comunidad.eliminarUsuario(comunidad, codigoUsuario);
        mostrarNotificacion("Eliminado");
        LlenarListaUsuarios();
        textIdUsuario.setText("");
        textNombreUsuario.setText("");
    }

    @FXML
    private void setOnActionButtonBuscarRecurso(ActionEvent event) {
        int codigoRecurso = Integer.parseInt(textId.getText());
        Recurso recursoEncontrado = inventario.listaRecurso.buscarRecursoId(inventario.listaRecurso, codigoRecurso);
        if (recursoEncontrado == null) {
            mostrarNotificacion("recurso no encontrado");
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
        while (apuntador.nodo != null) {
            TablaRecursos.getItems().add(apuntador.nodo);
            comboBoxCodigoRecursoPrestamo.getItems().add(apuntador.nodo.codigoRecurso().get());
            apuntador = apuntador.siguiente;
        }
    }

    private void LlenarListaUsuarios() {
        tablaUsuarios.getItems().clear();
        Comunidad apuntador = comunidad;
        while (apuntador.nodo != null) {
            tablaUsuarios.getItems().add(apuntador.nodo);
            apuntador = apuntador.siguiente;
        }
    }

    private void LlenarListaPrestamos(int codigoUsuario) {
        tablaPrestamos.getItems().clear();
        tablaPrestamosDevolucionesMultas.getItems().clear();
        ListaPrestamo apuntador = inventario.listaPrestamo;
        while (apuntador.nodo != null) {
            if (apuntador.nodo.getUsuario().getCodigoUsuario() == codigoUsuario) {
                tablaPrestamos.getItems().add(apuntador.nodo);
                tablaPrestamosDevolucionesMultas.getItems().add(apuntador.nodo);
            }
            apuntador = apuntador.siguiente;
        }
    }

    @FXML
    private void setOnActionButtonBuscarPrestamos(ActionEvent event) {
        int codigoUsuario = Integer.parseInt(textCodigoUsuarioPrestamo.getText());
        Usuario usuarioEncontrado = comunidad.buscarUsuarioId(comunidad, codigoUsuario);
        if (usuarioEncontrado == null) {
            mostrarNotificacion("El usuario no fue encontrado.");
        }
        LlenarListaPrestamos(codigoUsuario);
    }

    private void mostrarNotificacion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @FXML
    private void setOnActionButtonBuscarPorIdsetOnActionButtonDevolverRecurso(ActionEvent event) {
        Prestamo prestamoSeleccionado = tablaPrestamosDevolucionesMultas.getSelectionModel().getSelectedItem();

        if (prestamoSeleccionado.estaMultado()) {
            mostrarNotificacion("El recurso está multado, así que no se puede devolver hasta pagar la multa.");
            return;
        }

        LocalDate localDateLimite = datePickerFechaDevolucion.getValue();
        Instant instantLimite = Instant.from(localDateLimite.atStartOfDay(ZoneId.systemDefault()));
        Date fechaDevolucion = Date.from(instantLimite);

        inventario.listaPrestamo.devolverRecurso(prestamoSeleccionado.getId(), fechaDevolucion);
        LlenarListaPrestamos(prestamoSeleccionado.getUsuario().getCodigoUsuario());
        LlenarListaRecursos();
    }

    @FXML
    private void setOnActionButtonBuscarPorIdsetOnActionButtonPagarMulta(ActionEvent event) {
        Prestamo prestamoSeleccionado = tablaPrestamosDevolucionesMultas.getSelectionModel().getSelectedItem();
        if (!prestamoSeleccionado.estaMultado()) {
            mostrarNotificacion("El prestamo no tiene multa, así que no hay nada que pagar.");
        } else {
            inventario.listaPrestamo.pagarMultaPrestamo(prestamoSeleccionado.getId());
            mostrarNotificacion("La multa del prestamo ha sido pagada");
        }
        LlenarListaPrestamos(prestamoSeleccionado.getUsuario().getCodigoUsuario());
        LlenarListaRecursos();
    }

    @FXML
    private void setOnActionButtonBuscarPorIdsetOnActionButtonBuscarPrestamosDevoluciones(ActionEvent event) {
        int codigoUsuario = Integer.parseInt(textIdUsuarioDevolucion.getText());
        if (comunidad.buscarUsuarioId(comunidad, codigoUsuario) == null) {
            mostrarNotificacion("El usuario no existe.");
        } else {
            LlenarListaPrestamos(codigoUsuario);
        }
    }

    @FXML
    private void setOnActionButtonMultarPrestamo(ActionEvent event) {
        Prestamo prestamoSeleccionado = tablaPrestamos.getSelectionModel().getSelectedItem();
        int valorMulta = Integer.parseInt(textValorMulta.getText());
        inventario.listaPrestamo.multarPrestamo(prestamoSeleccionado.getId(), valorMulta);
        mostrarNotificacion("multado");
        LlenarListaPrestamos(prestamoSeleccionado.getUsuario().getCodigoUsuario());
    }
}
