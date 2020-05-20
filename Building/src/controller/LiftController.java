/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.*;

/**
 *
 * @author CristinaFidelino
 */
public class LiftController extends Controller<Lift>{
    @FXML private ListView<Lift> passengersLv;
    @FXML private ListView<Lift> queueLv;
    @FXML private Button closeBtn;
    
    public final Lift getLift() { return model; }
    
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}
