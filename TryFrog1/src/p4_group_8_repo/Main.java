package p4_group_8_repo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//This is a main class of the app. It launches application, by creating a window and setting the initial scene
public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		StackPane root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		
		primaryStage.setTitle("Frogger");
	    
	    Scene scene  = new Scene(root,600,900);
	    
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
}
