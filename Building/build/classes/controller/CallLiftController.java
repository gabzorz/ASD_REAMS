/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import model.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.beans.value.*;
import model.*;
/**
 *
 * @author CristinaFidelino
 */
public class CallLiftController extends Controller<Building>{
    @FXML private Button cancelBtn;
    @FXML private Button callBtn;
    @FXML private ComboBox<Person> peopleCmb;
    @FXML private TextField destinationTf;
    
    public final Building getBuilding() { return model; }
    
    
    private int getDestination() { return Integer.parseInt(destinationTf.getText()); }
    
    private Person getSelectedCaller() { return peopleCmb.getSelectionModel().getSelectedItem(); }
             
    @FXML private void handleCancel(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void handleCall(ActionEvent event) throws Exception {
            try {
                getBuilding().call(getSelectedCaller(), getDestination());
                stage.close();
                }
            catch (Exception e) {
                //int destination = getDestination();
                //if (getDestination().canReach(destination))
                        //(.matches("[0-9]+"))
                //throw new Exception("Destination must be an integer");
                }
			// If an exception occurred, show an error window.
			// NOTE: the following line might *also* throw an IOException if
                        //"You must select a caller" 
                        //"No suitable lift found"
                        // /view/error.fxml is not found (location not set) or if the
			// FXML file itself contains errors. But in that case, we can't
			// show the error anyway, so we just throw IOException.
			//ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
		 
		
    }
}

