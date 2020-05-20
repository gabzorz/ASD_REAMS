package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import model.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.beans.value.*;
import javafx.scene.text.Text;
/**
 * The controller for building.fxml.
 */
public class BuildingController extends Controller<Building> {
    @FXML private Slider delaySl;
    @FXML private TableColumn levelColumn;
    @FXML private Text Timetxt;
    @FXML private TableView<Lift> liftsTv;
    //@FXML private ListView<Person> peopleLv;
    @FXML private Button callBtn;
    @FXML private Button viewBtn;
    @FXML private Button peopleBtn;
    @FXML private Button exitBtn;

    public final Building getBuilding() { return model; }
    
    private Lift getSelectedLift() { return liftsTv.getSelectionModel().getSelectedItem(); }
    
    //private Person getPeople() { return peopleLv.getSelectionModel().getSelectedItem(); }
    
    

    @FXML private void initialize() {
        liftsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // Start up the building. Don't forget to also shutdown the building
        // when the user clicks the "Exit" button.
        getBuilding().startup();
        liftsTv.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldLift, newLift) -> viewBtn.setDisable(newLift == null)
        );
        levelColumn.getStyleClass().add("Monospaced");


        
    }
    
    @FXML private void handleCallLift(ActionEvent event) throws Exception {
        ViewLoader.showStage(getBuilding(), "/view/call_lift.fxml", "Call lift", new Stage());
    }
    
    @FXML private void handleViewLift(ActionEvent event) throws Exception {
        
        ViewLoader.showStage(getSelectedLift(), "/view/lift.fxml", "Lift", new Stage());
    }
    
    @FXML private void handlePerson(ActionEvent event) throws Exception {
        ViewLoader.showStage(getBuilding(), "/view/people.fxml", "People", new Stage());
    }
    
    @FXML private void handleExit(ActionEvent event) throws Exception {
        stage.close();
        getBuilding().shutdown();
    }

    /**
     * This accessor method returns the selected number on the delay slider.
     *
     * @return the the selected delay
     */
    
    private int getDelay() {
        return (int)delaySl.getValue();
    }
}
