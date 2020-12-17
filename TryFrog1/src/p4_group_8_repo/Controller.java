package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Controller{
	@FXML
	VBox root;
	@FXML
	Pane gameSpace;
	@FXML
	Pane startPane;
	@FXML
	Pane roadPane1;
	@FXML
	Pane roadPane2;
	@FXML
	Pane roadPane3;
	@FXML
	Pane safePane;
	@FXML
	Pane waterPane1;
	@FXML
	Pane waterPane2;
	@FXML
	Pane waterPane3;
	@FXML
	Pane end;
	@FXML
	Pane liveContainer;
	@FXML
	Pane timeContainer;
	@FXML
	Pane scoreContainer;
	@FXML
	Pane levelContainer;
	
	@FXML
    public void initialize() {
		Actor frogger = new Animal("file:src/p4_group_8_repo/froggerUp.png", 32.0, 184, 16);
		startPane.getChildren().add((ImageView) frogger);
    }
 
	public void removeLife(){
		
	}
}
