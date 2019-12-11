package dad.micv.tabs.conocimientos;

import java.io.IOException;
import java.util.Optional;

import dad.micv.clases.datosConocimiento.Conocimiento;
import dad.micv.clases.datosConocimiento.Nivel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConocimientosController {
	
	@FXML
	HBox root;
		@FXML
		TableView<Conocimiento> conocimientosTable;
		@FXML
		Button addConocimientoButton;
		@FXML
		Button addIdiomaButton;
		@FXML
		Button removeButton;

	Alert addAlert = new Alert(AlertType.CONFIRMATION);
	
	public ConocimientosController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ConocimientosView.fxml"));
			loader.setController(this);
			loader.load();
			
			//Titulos
			TableColumn<Conocimiento, String> colDenominacion = new TableColumn<>("Denominación");
			conocimientosTable.getColumns().add(colDenominacion);
			colDenominacion.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
			colDenominacion.setPrefWidth(150);
			TableColumn<Conocimiento, String> colOrganizador = new TableColumn<>("Nivel");
			conocimientosTable.getColumns().add(colOrganizador);
			colOrganizador.setCellValueFactory(new PropertyValueFactory<>("nivelStr"));
			colOrganizador.setPrefWidth(150);
			
			//ACTIONS
			addConocimientoButton.setOnAction(e -> add(false));
			addIdiomaButton.setOnAction(e -> add(true));
			removeButton.setOnAction(e -> remove());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void add(boolean idioma) {
		Label denominacionLabel = new Label("Denominación");
		denominacionLabel.setPrefSize(100, 30);
		TextField denominacionField = new TextField();
		denominacionField.setPrefSize(150, 30);
		
		Label nivelLabel = new Label("Nivel:");
		nivelLabel.setPrefSize(100, 30);
		ComboBox<String> niveles = new ComboBox<String>();
		niveles.getItems().addAll(Nivel.BASICO.getText(), Nivel.MEDIO.getText(), Nivel.AVANZADO.getText());
		niveles.setPromptText("Seleccione un nivel");
		niveles.setPrefSize(150, 30);
		
		Label certificacionLabel = new Label("Certificación");
		certificacionLabel.setPrefSize(100, 30);
		TextField certificacionField = new TextField();
		certificacionField.setPrefSize(150, 30);
		
		addAlert.setTitle("Nuevo conocimiento");
		addAlert.setGraphic(null);
		addAlert.setHeaderText("");
		if (idioma) {
			addAlert.getDialogPane().setContent(new VBox(new HBox(denominacionLabel, denominacionField)
					, new HBox(nivelLabel, niveles)
					, new HBox(certificacionLabel, certificacionField)));
		}else {
			addAlert.getDialogPane().setContent(new VBox(new HBox(denominacionLabel, denominacionField)
					, new HBox(nivelLabel, niveles)));
		}
		
		if (addAlert.showAndWait().get().equals(ButtonType.OK)) {
			if (!denominacionField.getText().isEmpty() && niveles.getSelectionModel().getSelectedItem() != null) {
				if (idioma && certificacionField.getText().isEmpty()) {
					return;
				}else {
					Conocimiento nuevaExperiencia = new Conocimiento();
					if (idioma) {
						nuevaExperiencia.setCertificacion(certificacionField.getText());
					}
					nuevaExperiencia.setDenominacion(denominacionField.getText());
					switch (niveles.getSelectionModel().getSelectedItem()) {
					case "Básico":
						nuevaExperiencia.setNivel(Nivel.BASICO);
						break;
					case "Medio":
						nuevaExperiencia.setNivel(Nivel.MEDIO);
						break;
					case "Avanzado":
						nuevaExperiencia.setNivel(Nivel.AVANZADO);
						break;
					}
					conocimientosTable.getItems().add(nuevaExperiencia);
				}
			}else {
				errorAñadir();
			}
		}
		
	}

	private void remove() {
		if (conocimientosTable.getSelectionModel().getSelectedItem() != null) {
			int posSeleccionado = conocimientosTable.getSelectionModel().getSelectedIndex();
			String seleccionado = conocimientosTable.getSelectionModel().getSelectedItem().getDenominacion()
					+ " de nivel " + conocimientosTable.getSelectionModel().getSelectedItem().getNivelStr();
			Alert eliminarMailAlert = new Alert(AlertType.CONFIRMATION);
			eliminarMailAlert.setHeaderText("");
			eliminarMailAlert.setContentText("Va a eliminar el conocimiento en " + seleccionado + " en la posición " + (posSeleccionado + 1));
			Optional<ButtonType> result = eliminarMailAlert.showAndWait();
			if (result.get() == ButtonType.OK){
				conocimientosTable.getItems().remove(posSeleccionado);
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
