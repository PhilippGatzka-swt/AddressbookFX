package com.sowatec.tasksfx;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import org.json.simple.JSONArray;

public class DataManager {

  private static DataManager instance;

  private DataManager() {
    File activeTasks = new File("active-tasks.json");
    if (!activeTasks.exists()) {
      try {
        activeTasks.createNewFile();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static DataManager getInstance() {
    return instance == null ? instance = new DataManager() : instance;
  }

  public List<Task> readTasks(String filename) {

    try (Reader reader = Files.newBufferedReader(Paths.get(filename))) {
      List<Task> tasks = new Gson().fromJson(reader, new TypeToken<List<Task>>() {

      }.getType());
      reader.close();
      if (tasks == null) {
        return new ArrayList<>();
      }

      return tasks;

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  private void saveTasks(List<Task> list) {
    Gson gson = new Gson();
    String jsonString = gson.toJson(list);

    try (FileOutputStream fos = new FileOutputStream("active-tasks.json")) {
      fos.write(jsonString.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void saveTask(Task task) {
    List<Task> activeTasks = readTasks("active-tasks.json");
    activeTasks.removeIf(t -> t.getId() == task.getId());
    activeTasks.add(task);
    saveTasks(activeTasks);
  }


  public void deleteTask(Task task) {
    List<Task> activeTasks = readTasks("active-tasks.json");
    activeTasks.removeIf(t -> t.getId() == task.getId());
    saveTasks(activeTasks);
  }

  private boolean isIdFree(long id) {
    for (Task task : readTasks("active-tasks.json")) {
      if (task.getId() == id) {
        return false;
      }
    }
    return true;
  }

  public static long generateId() {
    long id = 0;
    boolean idFound = false;
    while (!idFound) {
      if (!getInstance().isIdFree(id)) {
        id++;
      } else {
        idFound = true;
      }
    }
    return id;
  }

}
