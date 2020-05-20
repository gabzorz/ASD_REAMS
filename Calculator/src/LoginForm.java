
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm extends Application {
    public static void main(String [] args) { launch(args); }
    
    private Label usernameLbl;
    private TextField usernameTf;
    private Label passwordLbl;
    private PasswordField passwordPf;
    private Button loginBtn;
    private Text resultTxt;

    @Override
    public void start(Stage stage) throws Exception {
        usernameLbl = new Label("Username:");
        usernameTf = new TextField();
        passwordLbl = new Label("Password:");
        passwordPf = new PasswordField();
        loginBtn = new Button("Login");
        resultTxt = new Text();
        
        GridPane grid = new GridPane();
        
        grid.add(usernameLbl, 0, 0);
        grid.add(usernameTf, 1, 0);
        grid.add(passwordLbl, 0 , 1);
        grid.add(passwordPf, 1, 1);
        grid.add(loginBtn, 1, 2);
        grid.add(resultTxt, 2, 2);
        
        stage.setScene(new Scene(grid));
        stage.setTitle("Login");
        stage.show();
    }
    
    
}