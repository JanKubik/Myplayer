package application;

import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;

public class MediaBar extends HBox {
	
	Slider time;
	Slider vol;
	
	MediaPlayer player;
	
	public MediaBar(MediaPlayer play) {
		player = play;
		
		vol = new Slider();
		time = new Slider();
		
		getChildren().add(time);
		getChildren().add(vol);
		
		vol.prefWidth(70);
		vol.setMinWidth(30);
		vol.setValue(100);
		
		player.currentTimeProperty().addListener((o) ->{
			time.setValue(player.getCurrentTime().toMillis() /player.getTotalDuration().toMillis() * 100);
		});
		
		time.valueProperty().addListener((o) ->{
			player.seek(player.getMedia().getDuration().multiply(time.getValue()/100));
		});
		
		vol.valueProperty().addListener((o) ->{
			player.setVolume(vol.getValue()/100);
			
		});
		
	}

}
