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
	@FXML private TableView<Product> productsTv;
	@FXML private Text cashTxt;
        @FXML private Button viewBtn;

	@FXML private void initialize() {
		cashTxt.textProperty().bind(getStore().getCashRegister().cashProperty().asString("$%.2f"));
                productsTv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldProduct, newProduct) -> viewBtn.setDisable(newProduct == null)
                );
	}

	public final Store getStore() { return model; }
	private Product getProduct() { return productsTv.getSelectionModel().getSelectedItem(); }

	@FXML private void handleView() throws Exception {
		ViewLoader.showStage(getProduct(), "/view/product.fxml", "Product", new Stage());
	}
}
