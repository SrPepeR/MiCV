package dad.micv.tabs.contacto;

import java.io.IOException;
import java.util.Optional;

import dad.micv.clases.datosContacto.Email;
import dad.micv.clases.datosContacto.Telefono;
import dad.micv.clases.datosContacto.TipoTelefono;
import dad.micv.clases.datosContacto.Web;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContactoController {
	
	@FXML
	ScrollPane root;
		@FXML
		TableView<Telefono> telefonosTable;
			@FXML
			Button addTelefono;
			@FXML
			Button removeTelefono;
		@FXML
		TableView<Email> mailsTable;
			@FXML
			Button addMail;
			@FXML
			Button removeMail;
		@FXML
		TableView<Web> websTable;
			@FXML
			Button addWeb;
			@FXML
			Button removeWeb;
	
	Alert addAlert = new Alert(AlertType.CONFIRMATION);;
		
	public ContactoController() {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ContactoView.fxml"));
			loader.setController(this);
			loader.load();

			//Telefonos
			TableColumn<Telefono, String> colNumero = new TableColumn<>("Número");
			telefonosTable.getColumns().add(colNumero);
			colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
			colNumero.setPrefWidth(150);
			
			TableColumn<Telefono, String> colTipo = new TableColumn<>("Tipo");
			telefonosTable.getColumns().add(colTipo);
			colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoStr"));
			colTipo.setPrefWidth(150);
			
			//E-mails
			TableColumn<Email, String> colMail = new TableColumn<>("E-mail");
			mailsTable.getColumns().add(colMail);
			colMail.setCellValueFactory(new PropertyValueFactory<>("direccion"));
			colMail.setPrefWidth(150);
			
			//Webs
			TableColumn<Web, String> colURL = new TableColumn<>("URL");
			websTable.getColumns().add(colURL);
			colURL.setCellValueFactory(new PropertyValueFactory<>("url"));
			colURL.setPrefWidth(150);
			
			
			//ACTIONS
			addTelefono.setOnAction(e -> addTelefono());
			removeTelefono.setOnAction(e -> removeTelefono());
			
			addMail.setOnAction(e -> addMail());
			removeMail.setOnAction(e -> removeMail());

			addWeb.setOnAction(e -> addWeb());
			removeWeb.setOnAction(e -> removeWeb());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void addTelefono() {

		Label numeroLabel = new Label("Número:");
		numeroLabel.setPrefSize(75, 30);
		TextField numeroField = new TextField();
		numeroField.setPromptText("Número de télefono");
		HBox numero = new HBox(numeroLabel, numeroField);
		numero.setPrefWidth(VBox.USE_COMPUTED_SIZE);
		
		Label tipoLabel = new Label("Tipo:");
		tipoLabel.setPrefSize(75, 30);
		ComboBox<String> tipos = new ComboBox<String>();
		tipos.getItems().addAll(TipoTelefono.DOMICILIO.getText(), TipoTelefono.MOVIL.getText());
		tipos.setPromptText("Seleccione un tipo");
		HBox tipo = new HBox(tipoLabel, tipos);
		tipo.setPrefWidth(VBox.USE_COMPUTED_SIZE);
		
		addAlert.setTitle("Nuevo teléfono");
		addAlert.setHeaderText("Introduzca el nuevo número de teléfono");
		addAlert.getDialogPane().setContent(new VBox(numero, tipo));
		
		if (addAlert.showAndWait().get().equals(ButtonType.OK)) {
			if (!numeroField.getText().isEmpty() && tipos.getSelectionModel().getSelectedItem() != null) {
				try {
					Integer.parseInt(numeroField.getText());
					Telefono newTelefono = new Telefono();
					String numeroStr = numeroField.getText();
					newTelefono.setNumero(numeroStr);
					System.out.println(numeroStr);
					String tipoStr = tipos.getSelectionModel().getSelectedItem();
					if (tipoStr == "Domicilio") {
						newTelefono.setTipo(TipoTelefono.DOMICILIO);
					}else {
						newTelefono.setTipo(TipoTelefono.MOVIL);
					}
					System.out.println(tipoStr);
					telefonosTable.getItems().add(newTelefono);
				} catch (NumberFormatException e) {
					errorAñadir();
				}
			}else {
				errorAñadir();
			}
		}
	}

	private void removeTelefono() {
		if (telefonosTable.getSelectionModel().getSelectedItem() != null) {
			int posSeleccionado = telefonosTable.getSelectionModel().getSelectedIndex();
			String seleccionado = telefonosTable.getSelectionModel().getSelectedItem().getNumero() + " de tipo " + telefonosTable.getSelectionModel().getSelectedItem().getTipoStr();
			Alert eliminarTelefonoAlert = new Alert(AlertType.CONFIRMATION);
			eliminarTelefonoAlert.setHeaderText("");
			eliminarTelefonoAlert.setContentText("Va a eliminar el número " + seleccionado + " en la posición " + (posSeleccionado + 1));
			Optional<ButtonType> result = eliminarTelefonoAlert.showAndWait();
			if (result.get() == ButtonType.OK){
				telefonosTable.getItems().remove(posSeleccionado);
			}
		}
	}
	
	public void addMail() {
		
		Label mailLabel = new Label("E-mail:");
		mailLabel.setPrefSize(75, 30);
		TextField mailField = new TextField();
		mailField.setPromptText("Dirección de e-mail");
		HBox mail = new HBox(mailLabel, mailField);
		mail.setPrefWidth(VBox.USE_COMPUTED_SIZE);
		
		addAlert.setTitle("Nuevo e-mail");
		addAlert.setHeaderText("Crear una nueva dirección de correo.");
		addAlert.getDialogPane().setContent(new VBox(mail));
		
		if (addAlert.showAndWait().get().equals(ButtonType.OK)) {
			if (!mailField.getText().isEmpty()) {
				Email newMail = new Email();
				String mailStr = mailField.getText();
				newMail.setDireccion(mailStr);
				System.out.println(mailStr);
				mailsTable.getItems().add(newMail);
			}else {
				errorAñadir();
			}
		}
		
	}

	private void removeWeb() {
		if (websTable.getSelectionModel().getSelectedItem() != null) {
			int posSeleccionado = websTable.getSelectionModel().getSelectedIndex();
			String seleccionado = websTable.getSelectionModel().getSelectedItem().getUrl();
			Alert eliminarWebAlert = new Alert(AlertType.CONFIRMATION);
			eliminarWebAlert.setHeaderText("");
			eliminarWebAlert.setContentText("Va a eliminar la url " + seleccionado + " en la posición " + (posSeleccionado + 1));
			Optional<ButtonType> result = eliminarWebAlert.showAndWait();
			if (result.get() == ButtonType.OK){
				websTable.getItems().remove(posSeleccionado);
			}
		}
	}
	
	public void addWeb() {
		
		Label urlLabel = new Label("URL:");
		urlLabel.setPrefSize(75, 30);
		TextField urlField = new TextField();
		urlField.setText("http://");
		HBox url = new HBox(urlLabel, urlField);
		url.setPrefWidth(VBox.USE_COMPUTED_SIZE);
		
		addAlert.setTitle("Nueva web");
		addAlert.setHeaderText("Crear una nueva dirección web.");
		addAlert.getDialogPane().setContent(new VBox(url));
		
		if (addAlert.showAndWait().get().equals(ButtonType.OK)) {
			if (!urlField.getText().isEmpty()) {
				Web newWeb = new Web();
				String urlStr = urlField.getText();
				newWeb.setUrl(urlStr);
				System.out.println(urlStr);
				websTable.getItems().add(newWeb);
			}else {
				errorAñadir();
			}
		}
		
	}

	private void removeMail() {
		if (mailsTable.getSelectionModel().getSelectedItem() != null) {
			int posSeleccionado = mailsTable.getSelectionModel().getSelectedIndex();
			String seleccionado = mailsTable.getSelectionModel().getSelectedItem().getDireccion();
			Alert eliminarMailAlert = new Alert(AlertType.CONFIRMATION);
			eliminarMailAlert.setHeaderText("");
			eliminarMailAlert.setContentText("Va a eliminar el e-mail " + seleccionado + " en la posición " + (posSeleccionado + 1));
			Optional<ButtonType> result = eliminarMailAlert.showAndWait();
			if (result.get() == ButtonType.OK){
				mailsTable.getItems().remove(posSeleccionado);
			}
		}
	}

	private void errorAñadir() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("Warning");
		alert.setContentText("Los datos introduciodos no son correctos.");
		alert.show();
	}

	public ScrollPane getRoot() {
		return this.root;
	}
	
}
