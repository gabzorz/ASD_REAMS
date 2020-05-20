package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class StoreController extends Controller<Store> {
    @FXML private ListView<Product> productsLv;
    @FXML private Text cashTxt;
    @FXML private Button viewBtn;
    
    
    
    public final Store getStore() { return model; }
    
    private Product getProduct() { return productsLv.getSelectionModel().getSelectedItem(); }
   
    @FXML private void handleView(ActionEvent event) throws Exception {
        ViewLoader.showStage(getProduct(), "/view/product.fxml", "Product", new Stage());
    }

    @FXML private void initialize() {
        cashTxt.textProperty().bind(getStore().getCashRegister().cashProperty().asString("$%.2f"));
    }

    //@FXML private void handleOpen(ActionEvent event) throws Exception {
      //  ViewLoader.showStage(getStore(), "/view/store.fxml", "Store", stage);
    //}
}
