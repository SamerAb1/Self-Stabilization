package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FirstAlgVal_Controller {
	String N_value = null;
	String K_value = null;
	private boolean randomflag = false;
	boolean alertK = true;
	boolean alertN = true;
	boolean stabilityflag = true;  // if the value of K is <= N-2 this flag causes an alert in the algorithm simulation page
	int[] ProcessorsArray = new int[20];
	ObservableList<String> NValue_FAV_list = FXCollections.observableArrayList("2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");
	SharedData sharedData;

	@FXML
	private Button Backbtn_FAV;

	@FXML
	private TextField KValue_FAV;

	@FXML
	private Button Manualbtn_FAV;

	@FXML
	private ComboBox<String> NValue_FAV;

	@FXML
	private Button Randombtn_FAV;

	@FXML
	void Backbtn_FAV(ActionEvent event) throws Exception {
		System.out.println("Back");
		Stage stage = (Stage) Backbtn_FAV.getScene().getWindow();
		stage.close();
		main_Controller aFrame = new main_Controller(); // create main
		Stage primaryStage = new Stage();
		aFrame.start(primaryStage);
	}

	@FXML
	void Manualbtn_FAV(ActionEvent event) throws Exception {
		System.out.println("Add manual value to first algorithm");
		randomflag = false;
		getValues();
		setValues();
		if (!alertK && !alertN) {
			FXMLLoader loader = new FXMLLoader();
			Stage primaryStage = new Stage();
			((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
			Pane root = loader.load(getClass().getResource("/gui/FirstAlgorithmProcessorValues.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setTitle("Add Manual Values To The K-State Machines Algorithm");
			primaryStage.setScene(scene);
			primaryStage.show();
		}

	}

	@FXML
	void Randombtn_FAV(ActionEvent event) throws IOException {
		getValues();
		if (!alertK && !alertN) {
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
			Pane root = loader.load(getClass().getResource("/gui/first algorithm.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setTitle("K-State Machines Algorithm");
			primaryStage.setScene(scene);
			primaryStage.show();
		}

	}
	@FXML
	private void initialize() {
		//NValue_FAV.setValue("2");
		NValue_FAV.setItems(NValue_FAV_list);

	}

	private void getValues() {
		try {
		N_value = NValue_FAV.getValue();
		K_value = KValue_FAV.getText();
		System.out.println("N=" + N_value + ",K=" + K_value);
		if (NValue_FAV.getValue() != null) {
			alertN = false;
			if (KValue_FAV.getText() != "") {
				int k = Integer.parseInt(K_value);
				if (k <= 1000 && k > 1) {
					int n = Integer.parseInt(N_value);
					if(k < n-2) {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Note!");
						alert.setHeaderText("Please note: K > N-2! the system may not stable!");
						ButtonType buttonTypeContinue = new ButtonType("Continue");
						ButtonType buttonTypeCancel = new ButtonType("Cancel");
						alert.getButtonTypes().setAll(buttonTypeContinue, buttonTypeCancel);
						Optional<ButtonType> result = alert.showAndWait();
						if (result.isPresent() && result.get() == buttonTypeContinue) {
							stabilityflag=false;
							alertK = false;
							return;
						} else {
							
							return;
						}
						
					}
					alertK = false;
					return;
				}
			}
		}
		alertN = true;
		alertK = true;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("value missing");
		alert.setHeaderText("Please check the values of N and K to continue"+"\n"+"Note: 2 ≤ K ≤ 1000");
		alert.show();
	       } catch (NumberFormatException e) {
	   		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("value missing");
			alert.setHeaderText("Invalid input: not a valid number.");
			alert.show();
	        }
	}
	
	private void setValues() {
		sharedData = SharedData.getInstance();
		sharedData.setNValue(N_value);
		sharedData.setKValue(K_value);
		sharedData.setStabilityflag(stabilityflag);
		if(randomflag == true) {
			sharedData.setN_vals_array(ProcessorsArray);
		}
	}
}
