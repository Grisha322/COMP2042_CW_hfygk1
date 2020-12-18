package p4_group_8_repo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
	private MyStage window;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		StackPane root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		
		Pane gameScreen = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
		
		primaryStage.setTitle("Frogger");
		
	    window = new MyStage();
	    
	    root.getChildren().add(gameScreen);
	    
	    gameScreen.toBack();
	    
	    window.getChildren().add(root);
	    
	    Scene scene  = new Scene(window,600,900);
	    
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
}
