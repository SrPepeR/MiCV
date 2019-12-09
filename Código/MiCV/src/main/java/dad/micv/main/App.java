package dad.micv.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	
	MainController mainController;
	
	Stage raizStage = new Stage();
	Scene raizScene;
	
	public void start(Stage primaryStage) throws Exception {
		
		mainController = new MainController();
		
		raizScene = new Scene(mainController.getRoot());
		raizStage = new Stage();
		raizStage.setTitle("MainView.fxml");
		raizStage.setScene(raizScene);
		raizStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
