import javafx.application.*;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class StoreApplication extends Application {
	public static void main(String[] args) { launch(args); }

	@Override
	public void start(Stage stage) throws Exception {
		ViewLoader.showStage(new Store(), "/view/store.fxml", "Store", stage);
	}
}
