package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CristinaFidelino
 */
public class PeopleController extends Controller<Building>{
    @FXML private Button closeBtn;
    @FXML private TableView<Person> peopleTv;
    @FXML private TableColumn<Person, String> LevelClm;
    //@FXML
    
    public final Building getPerson() { return model; }
    
    
    @FXML private void initialize() {
        peopleTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //LevelClm.setCellValueFactory(cellData ->
        //cellData.getValue().levelProperty().asString().concat("Level"));
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}
