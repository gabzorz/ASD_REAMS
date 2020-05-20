
import java.text.DecimalFormat;
import java.util.LinkedList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty stock = new SimpleIntegerProperty();
    private DoubleProperty price = new SimpleDoubleProperty();
    private IntegerProperty sold = new SimpleIntegerProperty();
    private DoubleProperty cash = new SimpleDoubleProperty();
    private IntegerProperty left = new SimpleIntegerProperty();

    public Product(String name, int stock, double price) {
        this.name.set(name);
        this.stock.set(stock);
        this.price.set(price);
        
        
        //left.bind(sold.subtract(stock).multiply(-1));
    }
    
    public final String getName() { return name.get(); }
    private final void setName(String name) { this.name.set(name);}
    public StringProperty nameProperty() {return name; }
    
    public final int getStock() { return stock.get(); }
    private final void setStock(int stock) { this.stock.set(stock);}
    public ReadOnlyIntegerProperty stockProperty() { return stock; }

    public final double getPrice() { return price.get(); }
    private final void setPrice(int price) { this.stock.set(price);}
    public ReadOnlyDoubleProperty priceProperty() { return price; }
    
    public final int getSold() { return sold.get(); }
    public ReadOnlyIntegerProperty soldProperty() { return sold; }
    
    /**public final double getCash() { return cash.get(); }
    public final void setCash(double money) { this.cash.set(money); }
    public ReadOnlyDoubleProperty cashProperty() { return cash; }**/

    public void sell(int n) {
        stock.set(stock.get() - n);
        double money = n * price.get();
        for (ProductObserver observer : observers)
            observer.handleSale(money);
            //cash.bind(stock.multiply(price));

    }

    public void restock(int n) {
        stock.set(stock.get() + n);
    }

    public boolean has(int n) {
        return n <= stock.get();
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
    
        private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }

}