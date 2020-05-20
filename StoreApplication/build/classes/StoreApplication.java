
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoreApplication extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store.fxml"));
        Parent root = loader.load();
		stage.setTitle("Store Application");
		stage.setScene(new Scene(root));
		stage.sizeToScene();
		stage.show();
        // Add code here to load the root node from the FXML file
        // and show it
    }

    
}