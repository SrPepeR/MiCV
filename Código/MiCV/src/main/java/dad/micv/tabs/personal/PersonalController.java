package dad.micv.tabs.personal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class PersonalController {
	
	@FXML
	VBox rootPersonal;
		@FXML
		ComboBox<String> paisCombo;
		@FXML
		ListView<String> nacionalidadesList;
			@FXML
			Button addButton;
			@FXML
			Button deleteButton;
		
	//TODO
	
	public PersonalController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PersonalView.fxml"));
			loader.setController(this);
			loader.load();
			
			rellenaPaises();
			
			addButton.setOnAction(e -> onAddNacionalidad());
			deleteButton.setOnAction(e -> onDeleteNacionalidad());
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void rellenaPaises() {
		paisCombo.getItems().addAll(getPaisesCSV());
	}

	private ArrayList<String> getPaisesCSV() {
		
		String leido;
		ArrayList<String> devolver = new ArrayList<String>();
		
		String fileName = getClass().getResource("/CSV/paises.csv").getFile();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));
			
			while ((leido = reader.readLine())!= null) {
				devolver.add(leido);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return devolver;
		
	}

	public void onAddNacionalidad() {
		
		String nuevaNacionalidad = getNacionalidadNueva();
		
		if (!nuevaNacionalidad.isEmpty()) {
			for (int i = 0; i < nacionalidadesList.getItems().size(); i++) {
				if (nacionalidadesList.getItems().get(i).equals(nuevaNacionalidad)) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Warning");
					alert.setContentText("Nacionalidad ya seleccionada.");
					alert.show();
					return;
				}
			}
			nacionalidadesList.getItems().add(nuevaNacionalidad);
		}
		
	}
	
	private String getNacionalidadNueva() {
		
		ArrayList<String> nacionalidades = getNacionalidadesCSV();
		
		String seleccionado = "";
		
		ChoiceDialog<String> nacionalidadChoicer = new ChoiceDialog<String>();
		nacionalidadChoicer.setHeaderText("Añadir nacionalidad");
		nacionalidadChoicer.setContentText("Seleccione una nacionalidad");
		nacionalidadChoicer.getItems().addAll(nacionalidades);
		nacionalidadChoicer.setSelectedItem(nacionalidadChoicer.getItems().get(0));
		try {
			seleccionado = nacionalidadChoicer.showAndWait().get();
		} catch (NoSuchElementException e) {
			System.out.println("Cancelado");
		}
		
		return seleccionado;
	}

	private ArrayList<String> getNacionalidadesCSV() {
		
		String leido;
		ArrayList<String> devolver = new ArrayList<String>();
		
		String fileName = getClass().getResource("/CSV/nacionalidades.csv").getFile();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));
			
			while ((leido = reader.readLine())!= null) {
				devolver.add(leido);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return devolver;
	}
	
	private void onDeleteNacionalidad() {
		
		if (nacionalidadesList.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Warning");
			alert.setContentText("No ha seleccionado ninguna nacionalidad para eliminar.");
			alert.show();
		}else {
			nacionalidadesList.getItems().remove(nacionalidadesList.getSelectionModel().getSelectedIndex());
		}
		
	}

	public VBox getRoot() {
		return this.rootPersonal;
	}
	
}
