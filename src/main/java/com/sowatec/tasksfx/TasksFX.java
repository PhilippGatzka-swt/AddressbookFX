package com.sowatec.tasksfx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TasksFX extends Application {

	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(TasksFX.class.getResource("main.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("TasksFX");
		stage.setScene(scene);
		stage.show();
		stage.getIcons().add(new Image(TasksFX.class.getResourceAsStream("icon.png")));
	}
}
