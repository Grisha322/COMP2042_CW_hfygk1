package p4_group_8_repo;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class menuController {
	@FXML
	Text musicText;
	@FXML
	Pane menu;
	@FXML
	Pane infoPage;
	Game game;
	@FXML
    public void initialize() {

		game = Game.getInstance();
		musicText.setText("ON");
    }
	
	@FXML
	public void toggleMusic() {
		if(musicText.getText().equalsIgnoreCase("ON")) {
			musicText.setText("OFF");
			game.toggleMusic(true);
		}
		else {
			musicText.setText("ON");
			game.toggleMusic(false);
		}
	}
	
	@FXML
	public void openMenu(){
		menu.toFront();
	}
	
	@FXML
	public void openInfo(){
		infoPage.toFront();
	}
}
