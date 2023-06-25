package gui;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class thrAlgVal_Controller {
	private boolean TSM_string = false;
	private boolean TSM_ring = true;
	String N_value = null;
	String K_value = "2";
	private boolean randomflag = false;
	boolean alertN = true;
	boolean stabilityflag = true;
	int[] ProcessorsArray = new int[20];
	ObservableList<String> NValue_TAV_list = FXCollections.observableArrayList( "3", "4", "5", "6", "7", "8", "9",
			"10");//,"2", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
	SharedData sharedData;

	@FXML
	private Button Backbtn_TAV;

	@FXML
	private Button Manualbtn_TAV;

	@FXML
	private ComboBox<String> NValue_TAV;

	@FXML
	private Button Randombtn_TAV;

	@FXML
	private RadioButton Ring_TAV;

	@FXML
	private RadioButton String_TAV;

	@FXML
	void Backbtn_TAV(ActionEvent event) throws Exception {
		System.out.println("Back");
		Stage stage = (Stage) Backbtn_TAV.getScene().getWindow();
		// do what you have to do
		stage.close();
		main_Controller aFrame = new main_Controller(); // create main
		Stage primaryStage = new Stage();
		aFrame.start(primaryStage);
	}

	@FXML
	void Manualbtn_TAV(ActionEvent event) throws Exception {
		randomflag = false;
		getValues();
		setValues();
		System.out.println("Add manual value to third algorithm");
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
		Pane root = loader.load(getClass().getResource("/gui/ThirdAlgorithmProcessorValues.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add Manual Values To Three State Machines Algorithm");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void Randombtn_TAV(ActionEvent event) throws IOException {
		getValues();

		if (!alertN) {
			int n = Integer.parseInt(N_value);
			int k = Integer.parseInt(K_value);
			 Random rand = new Random();
			    for (int i = 0; i < n; i++) {
			    	ProcessorsArray[i] = rand.nextInt((k+1) - 0) + 0;
			    }
			randomflag = true;    
			setValues();
			FXMLLoader loader = new FXMLLoader();
			Stage primaryStage = new Stage();
			((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
			Pane root = loader.load(getClass().getResource("/gui/third algorithm.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setTitle("Three State Machines Algorithm");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}

	@FXML
	private void initialize() {
		NValue_TAV.setValue("3");
		NValue_TAV.setItems(NValue_TAV_list);

	}

	private void setValues() {
		sharedData = SharedData.getInstance();
		sharedData.setNValue(N_value);
		sharedData.setKValue(Integer.toString(2));
		sharedData.setStabilityflag(stabilityflag);
		sharedData.setTSM_ring(TSM_ring);
		sharedData.setTSM_string(TSM_string);
		if (randomflag == true) {
			sharedData.setN_vals_array(ProcessorsArray);
		}
		System.out.println("val N : " + N_value);
	}

	private void getValues() {
		try {
			N_value = NValue_TAV.getValue();
			System.out.println("N=" + N_value + ",K=" + K_value);
			if (NValue_TAV.getValue() != null) {
				alertN = false;
				ToggleGroup toggleGroup = new ToggleGroup();
				Ring_TAV.setToggleGroup(toggleGroup);
				String_TAV.setToggleGroup(toggleGroup);
				RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
				String selectedValue = selectedRadioButton.getText();
				System.out.println("Display as: " + selectedValue);
				if (selectedValue.equals("Ring")) {
					TSM_ring = true;
					TSM_string = false;
				}
				if (selectedValue.equals("String")) {
					TSM_ring = false;
					TSM_string = true;
				}
				return;

			}
			alertN = true;
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("value missing");
			alert.setHeaderText("Please check the values of N and K to continue" + "\n" + "Note: K ≤ 1000");
			alert.show();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("value missing");
			alert.setHeaderText("Invalid input: not a valid number.");
			alert.show();
		}
	}

}
