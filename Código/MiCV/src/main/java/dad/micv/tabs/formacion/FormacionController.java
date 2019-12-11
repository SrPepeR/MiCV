package dad.micv.tabs.formacion;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import dad.micv.clases.datosTitulo.Titulo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormacionController {
	
	@FXML
	HBox root;
		@FXML
		TableView<Titulo> formacionTable;
		@FXML
		Button addButton;
		@FXML
		Button removeButton;

	Alert addAlert = new Alert(AlertType.CONFIRMATION);
	
	public FormacionController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FormacionView.fxml"));
			loader.setController(this);
			loader.load();
			
			//Titulos
			TableColumn<Titulo, LocalDate> colDesde = new TableColumn<>("Desde");
			formacionTable.getColumns().add(colDesde);
			colDesde.setCellValueFactory(new PropertyValueFactory<>("desde"));
			colDesde.setPrefWidth(150);
			TableColumn<Titulo, LocalDate> colHasta = new TableColumn<>("Hasta");
			formacionTable.getColumns().add(colHasta);
			colHasta.setCellValueFactory(new PropertyValueFactory<>("hasta"));
			colHasta.setPrefWidth(150);
			TableColumn<Titulo, String> colDenominacion = new TableColumn<>("Denominación");
			formacionTable.getColumns().add(colDenominacion);
			colDenominacion.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
			colDenominacion.setPrefWidth(150);
			TableColumn<Titulo, String> colOrganizador = new TableColumn<>("Organizador");
			formacionTable.getColumns().add(colOrganizador);
			colOrganizador.setCellValueFactory(new PropertyValueFactory<>("organizador"));
			colOrganizador.setPrefWidth(150);
			
			//ACTIONS
			addButton.setOnAction(e -> addFormacion());
			removeButton.setOnAction(e -> removeFormacion());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void addFormacion() {
		Label denominacionLabel = new Label("Denominación");
		denominacionLabel.setPrefSize(100, 30);
		TextField denominacionField = new TextField();

		Label organizadorLabel = new Label("Organizador");
		organizadorLabel.setPrefSize(100, 30);
		TextField organizadorField = new TextField();

		Label desdeLabel = new Label("Desde");
		desdeLabel.setPrefSize(100, 30);
		DatePicker desdePicker = new DatePicker();
		desdePicker.setValue(LocalDate.now());

		Label hastaLabel = new Label("Hasta");
		hastaLabel.setPrefSize(100, 30);
		DatePicker hastaPicker = new DatePicker();
		hastaPicker.setValue(LocalDate.now());
		
		addAlert.setTitle("Nuevo título");
		addAlert.setGraphic(null);
		addAlert.setHeaderText("");
		addAlert.getDialogPane().setContent(new VBox(new HBox(denominacionLabel, denominacionField)
				, new HBox(organizadorLabel, organizadorField)
				, new HBox(desdeLabel, desdePicker)
				, new HBox(hastaLabel, hastaPicker)));
		
		if (addAlert.showAndWait().get().equals(ButtonType.OK)) {
			if (!denominacionField.getText().isEmpty() && !organizadorField.getText().isEmpty()) {
				Titulo nuevoTitulo = new Titulo();
				nuevoTitulo.setDenominacion(denominacionField.getText());
				nuevoTitulo.setOrganizador(organizadorField.getText());
				nuevoTitulo.setDesde(desdePicker.getValue());
				nuevoTitulo.setHasta(hastaPicker.getValue());
				formacionTable.getItems().add(nuevoTitulo);
			}else {
				errorAñadir();
			}
		}
		
	}

	private void removeFormacion() {
		if (formacionTable.getSelectionModel().getSelectedItem() != null) {
			int posSeleccionado = formacionTable.getSelectionModel().getSelectedIndex();
			String seleccionado = formacionTable.getSelectionModel().getSelectedItem().getDenominacion() 
					+ " impartido por " + formacionTable.getSelectionModel().getSelectedItem().getOrganizador() 
					+ " desde el " + formacionTable.getSelectionModel().getSelectedItem().getDesde() 
					+ " hasta el " + formacionTable.getSelectionModel().getSelectedItem().getHasta();
			Alert eliminarMailAlert = new Alert(AlertType.CONFIRMATION);
			eliminarMailAlert.setHeaderText("");
			eliminarMailAlert.setContentText("Va a eliminar el título de " + seleccionado + " en la posición " + (posSeleccionado + 1));
			Optional<ButtonType> result = eliminarMailAlert.showAndWait();
			if (result.get() == ButtonType.OK){
				formacionTable.getItems().remove(posSeleccionado);
			}
		}
	}

	private void errorAñadir() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("Warning");
		alert.setContentText("Los datos introduciodos no son correctos.");
		alert.show();
	}

	public HBox getRoot() {
		return this.root;
	}
	
}
