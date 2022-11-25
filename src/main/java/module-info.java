module com.sowatec.addressbookfx {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;

  requires org.controlsfx.controls;
  requires com.dlsc.formsfx;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.bootstrapfx.core;
  requires com.almasb.fxgl.all;
  requires com.google.gson;


  opens com.sowatec.addressbookfx to javafx.fxml, com.google.gson;
  exports com.sowatec.addressbookfx;
}