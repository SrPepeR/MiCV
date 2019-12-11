package dad.micv.tabs.experiencia;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import dad.micv.clases.datosExperiencia.Experiencia;
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

public class ExperienciaController {
	
	@FXML
	HBox root;
		@FXML
		TableView<Experiencia> experienciaTable;
		@FXML
		Button addButton;
		@FXML
		Button removeButton;

	Alert addAlert = new Alert(AlertType.CONFIRMATION);
	
	public ExperienciaController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ExperienciaView.fxml"));
			loader.setController(this);
			loader.load();
			
			//Titulos
			TableColumn<Experiencia, LocalDate> colDesde = new TableColumn<>("Desde");
			experienciaTable.getColumns().add(colDesde);
			colDesde.setCellValueFactory(new PropertyValueFactory<>("desde"));
			colDesde.setPrefWidth(150);
			TableColumn<Experiencia, LocalDate> colHasta = new TableColumn<>("Hasta");
			experienciaTable.getColumns().add(colHasta);
			colHasta.setCellValueFactory(new PropertyValueFactory<>("hasta"));
			colHasta.setPrefWidth(150);
			TableColumn<Experiencia, String> colDenominacion = new TableColumn<>("Denominación");
			experienciaTable.getColumns().add(colDenominacion);
			colDenominacion.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
			colDenominacion.setPrefWidth(150);
			TableColumn<Experiencia, String> colOrganizador = new TableColumn<>("Empleador");
			experienciaTable.getColumns().add(colOrganizador);
			colOrganizador.setCellValueFactory(new PropertyValueFactory<>("empleador"));
			colOrganizador.setPrefWidth(150);
			
			//ACTIONS
			addButton.setOnAction(e -> addExperiencia());
			removeButton.setOnAction(e -> removeExperiencia());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void addExperiencia() {
		Label denominacionLabel = new Label("Denominación");
		denominacionLabel.setPrefSize(100, 30);
		TextField denominacionField = new TextField();

		Label empleadorLabel = new Label("Empleador");
		empleadorLabel.setPrefSize(100, 30);
		TextField empleadorField = new TextField();

		Label desdeLabel = new Label("Desde");
		desdeLabel.setPrefSize(100, 30);
		DatePicker desdePicker = new DatePicker();
		desdePicker.setValue(LocalDate.now());

		Label hastaLabel = new Label("Hasta");
		hastaLabel.setPrefSize(100, 30);
		DatePicker hastaPicker = new DatePicker();
		hastaPicker.setValue(LocalDate.now());
		
		addAlert.setTitle("Nueva experiencia");
		addAlert.setGraphic(null);
		addAlert.setHeaderText("");
		addAlert.getDialogPane().setContent(new VBox(new HBox(denominacionLabel, denominacionField)
				, new HBox(empleadorLabel, empleadorField)
				, new HBox(desdeLabel, desdePicker)
				, new HBox(hastaLabel, hastaPicker)));
		
		if (addAlert.showAndWait().get().equals(ButtonType.OK)) {
			if (!denominacionField.getText().isEmpty() && !empleadorField.getText().isEmpty()) {
				Experiencia nuevaExperiencia = new Experiencia();
				nuevaExperiencia.setDenominacion(denominacionField.getText());
				nuevaExperiencia.setEmpleador(empleadorField.getText());
				nuevaExperiencia.setDesde(desdePicker.getValue());
				nuevaExperiencia.setHasta(hastaPicker.getValue());
				experienciaTable.getItems().add(nuevaExperiencia);
			}else {
				errorAñadir();
			}
		}
		
	}

	private void removeExperiencia() {
		if (experienciaTable.getSelectionModel().getSelectedItem() != null) {
			int posSeleccionado = experienciaTable.getSelectionModel().getSelectedIndex();
			String seleccionado = experienciaTable.getSelectionModel().getSelectedItem().getEmpleador() 
					+ " de " + experienciaTable.getSelectionModel().getSelectedItem().getDenominacion()
					+ " desde el " + experienciaTable.getSelectionModel().getSelectedItem().getDesde() 
					+ " hasta el " + experienciaTable.getSelectionModel().getSelectedItem().getHasta();
			Alert eliminarMailAlert = new Alert(AlertType.CONFIRMATION);
			eliminarMailAlert.setHeaderText("");
			eliminarMailAlert.setContentText("Va a eliminar la experiencia en " + seleccionado + " en la posición " + (posSeleccionado + 1));
			Optional<ButtonType> result = eliminarMailAlert.showAndWait();
			if (result.get() == ButtonType.OK){
				experienciaTable.getItems().remove(posSeleccionado);
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
