import javafx.fxml.FXML;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;

//import static javafx.application.ConditionalFeature.FXML;

public class StoreController {
    private Store store = new Store();
    
    @FXML private Text nameTxt;
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;
    
    public final Store getStore() { return store; }
    public final StringProperty getName() { return store.getProduct().nameProperty();}
    private final ReadOnlyIntegerProperty getStock() { return store.getProduct().stockProperty(); }
    private final ReadOnlyDoubleProperty getPrice() { return store.getProduct().priceProperty(); }
    private final ReadOnlyDoubleProperty getCash() { return store.getCashRegister().cashProperty(); }
    private final int getAmount() { return Integer.parseInt(amountTf.getText()); }
    private final void setAmount(int amount) { amountTf.setText(""+amount); }

    @FXML private void initialize() {
        stockTxt.textProperty().bind(store.getProduct().stockProperty().asString().concat(" items"));
        priceTxt.textProperty().bind(store.getProduct().priceProperty().asString("$%.2f"));
        cashTxt.textProperty().bind(store.getCashRegister().cashProperty().asString("$%.2f"));
    }   

    @FXML private void handleSell(ActionEvent event) {
        Product product = getStore().getProduct();
        int amount = getAmount();
        if (product.has(amount))
            product.sell(amount);
        setAmount(0);
    }
    }