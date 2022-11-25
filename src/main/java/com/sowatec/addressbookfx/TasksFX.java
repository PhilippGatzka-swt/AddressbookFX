package com.sowatec.addressbookfx;

import java.io.IOException;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TasksFX extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(TasksFX.class.getResource("main.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("TasksFX");
    stage.setScene(scene);
    stage.show();
  }
}
