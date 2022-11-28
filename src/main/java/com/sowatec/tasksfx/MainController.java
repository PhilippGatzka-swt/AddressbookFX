package com.sowatec.tasksfx;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

  @FXML
  public ListView<Task> listView;
  public DatePicker targetDateField;
  public TextField nameField;
  public TextArea descriptionField;
  public Button buttonSave;
  public Button buttonArchive;
  public Button buttonDelete;
  public Button buttonCreate;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    System.out.println("Initialize");
    updateListView();
    listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue != null) {
        buildForm(newValue);
      }
    });
  }

  private void updateListView() {
    listView.getItems().clear();
    listView.getItems().addAll(DataManager.getInstance().readTasks("active-tasks.json"));
  }

  private void buildForm(Task task) {
    targetDateField.setVisible(true);
    nameField.setVisible(true);
    descriptionField.setVisible(true);
    targetDateField.setValue(convertToLocalDateViaInstant(task.getTargetDate()));
    nameField.setText(task.getName());
    descriptionField.setText(task.getDescription());
  }

  public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate();
  }

  public void actionSave(ActionEvent actionEvent) {
    Task task = listView.getSelectionModel().getSelectedItem();
    task.setTargetDate(Date.from(targetDateField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    task.setName(nameField.getText());
    task.setDescription(descriptionField.getText());
    DataManager.getInstance().saveTask(task);
    updateListView();
  }

  public void actionDelete(ActionEvent actionEvent) {
    Task task = listView.getSelectionModel().getSelectedItem();
    DataManager.getInstance().deleteTask(task);
    updateListView();
  }

  public void actionCreate(ActionEvent actionEvent) {
    Task task = new Task("New Task", new Date(), "Description");
    DataManager.getInstance().saveTask(task);
    updateListView();
    listView.getSelectionModel().select(task);
  }
}
