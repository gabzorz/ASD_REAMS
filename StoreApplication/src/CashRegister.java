
import java.text.DecimalFormat;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class CashRegister implements ProductObserver {
    private DoubleProperty cash = new SimpleDoubleProperty();

    public CashRegister() {
        cash.set(0.0);
    }
    

    public void add(double money) {
        cash.set(getCash() + money);
    }
    
    public final double getCash() { return cash.get(); }
    public final void setCash(double money) { this.cash.set(money); }
    public ReadOnlyDoubleProperty cashProperty() { return cash; }
    
    //public ReadOnlyDoubleProperty cashProperty() { return cash; }
    
    private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }

    @Override
    public void handleSale(double amount) {
        add(amount);
    }
}