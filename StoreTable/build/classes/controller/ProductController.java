package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class ProductController extends Controller<Product> {
	@FXML private TextField amountTf;
        @FXML private Button sellBtn;
        
        @FXML private void initialize() {
        amountTf.textProperty().addListener((o, oldTxt, newTxt) ->
                sellBtn.setDisable(!newTxt.matches("[0-9]+")));
    }

	public final Product getProduct() { return model; }
	private final int getAmount() { return Integer.parseInt(amountTf.getText()); }
	private final void setAmount(int amount) { amountTf.setText(""+amount); }

	@FXML private void handleSell(ActionEvent event) {
		int amount = getAmount();
		if (getProduct().has(amount)) {
			getProduct().sell(amount);
			setAmount(0);
		}
	}
}
