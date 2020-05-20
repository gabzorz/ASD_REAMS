
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Calculator extends Application {
    public static void main(String[] args) { launch(args); }

    private Label firstNumberLbl;
    private TextField firstNumberTf;
    private Label secondNumberLbl;
    private TextField secondNumberTf;
    private Label resultLbl;
    private TextField resultTf;
    private Label operationLbl;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;

    @Override
    public void start(Stage stage) throws Exception {
        // 1. create the leaf nodes
        firstNumberLbl = new Label("First number:");
        firstNumberTf = new TextField();
        secondNumberLbl = new Label("Second number:");
        secondNumberTf = new TextField();
        operationLbl = new Label("Operation:");
        resultLbl = new Label("Result:");
        resultTf = new TextField();
        addBtn = new Button("+");
        addBtn.setOnAction(new AddHandler());
        subBtn = new Button("-");
        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle (ActionEvent event) {
                setResult(getFirstNumber() - getSecondNumber());
            }
        });
        mulBtn = new Button("*");
        mulBtn.setOnAction(event -> setResult(getFirstNumber() * getSecondNumber()));
        divBtn = new Button("/");
        divBtn.setOnAction(event -> setResult(getFirstNumber() / getSecondNumber()));
        
        // 2. create the branch nodes
        
        VBox box = new VBox(10, firstNumberLbl, firstNumberTf, secondNumberLbl, secondNumberTf, operationLbl, addBtn, subBtn,mulBtn, divBtn, resultLbl, resultTf);
        //box.setAlignment(Pos.CENTER);
        
        //action handlers
        
        GridPane grid = new GridPane();
        HBox hbox = new HBox(10, addBtn,subBtn, mulBtn, divBtn);
        
        grid.add(firstNumberLbl, 0, 0);
        grid.add(firstNumberTf, 1, 0);
        grid.add(secondNumberLbl, 0, 1);
        grid.add(secondNumberTf, 1, 1);
        grid.add(operationLbl, 0, 2);
        //grid.add(addBtn, 2, 1);
        //grid.add(subBtn, 2, 2);
        //grid.add(mulBtn, 2,3);
        grid.add(hbox, 1, 2);
        grid.add(resultLbl, 0, 3);
        grid.add(resultTf, 1, 3);

        // 3. set the scene, show the stage
        stage.setScene(new Scene(grid));
        stage.setTitle("Calculator");
        stage.show();
    }
    
    
    
    public int getFirstNumber() {
        return Integer.parseInt(firstNumberTf.getText());
    }
    public int getSecondNumber() {
        return Integer.parseInt(secondNumberTf.getText());
    }
    public void setResult(int value) {
        resultTf.setText("" + value);
    }
    
    
    private class AddHandler implements EventHandler<ActionEvent> {
            @Override public void handle(ActionEvent event) {
            setResult(getFirstNumber() + getSecondNumber());
        }
}
    
}