package dad.micv.main;

import java.io.IOException;

import dad.micv.tabs.contacto.ContactoController;
import dad.micv.tabs.personal.PersonalController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MainController {
	
	PersonalController personalController = new PersonalController();
	ContactoController contactoController = new ContactoController();
	
	@FXML
	VBox raiz;
		@FXML
		Menu archivoMenu;
			@FXML
			MenuItem nuevoItem;
				@FXML
				ImageView nuevoImagen;
			@FXML
			MenuItem abrirItem;
				@FXML
				ImageView abrirImagen;
			@FXML
			MenuItem guardarItem;
				@FXML
				ImageView guardarImagen;
			@FXML
			MenuItem guardarComoItem;
			@FXML
			MenuItem salirItem;
		@FXML
		Menu ayudaMenu;
			@FXML
			MenuItem acercaDeItem;
		@FXML
		TabPane tabsPane;
			@FXML
			Tab personalTab;
			@FXML
			Tab contactoTab;
			@FXML
			Tab formacionTab;
			@FXML
			Tab experienciaTab;
			@FXML
			Tab conocimientosTab;
			
		public MainController() {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/MainView.fxml"));
				loader.setController(this);
				loader.load();
				
				nuevoImagen.setImage(new Image(getClass().getResource("/images/nuevo.gif").toString()));
				abrirImagen.setImage(new Image(getClass().getResource("/images/abrir.gif").toString()));
				guardarImagen.setImage(new Image(getClass().getResource("/images/guardar.gif").toString()));
				
				personalTab.setContent(personalController.getRoot());
				contactoTab.setContent(contactoController.getRoot());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		public VBox getRoot() {
			return raiz;
		}
	
}
