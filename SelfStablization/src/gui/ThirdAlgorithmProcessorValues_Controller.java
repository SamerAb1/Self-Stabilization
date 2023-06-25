package gui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ThirdAlgorithmProcessorValues_Controller {
	boolean StartFlag = false;
	int counternumberofprocessors = 2;
	String N_value = null;
	String K_value = null;
	int K = 2;
	int[] ProcessorsArray = new int[20];
	ObservableList<String> K_TAV_list = FXCollections.observableArrayList("0", "1", "2");
	SharedData sharedData;
	@FXML
	private Button Backbtn_TAPV;

	@FXML
	private Button Startbtn_TAPV;

	@FXML
	private ChoiceBox<String> Processor1Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor2Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor3Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor4Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor5Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor6Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor7Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor8Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor9Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor10Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor11Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor12Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor13Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor14Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor15Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor16Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor17Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor18Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor19Value_TAPV;

	@FXML
	private ChoiceBox<String> Processor20Value_TAPV;

	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	private Label label3;

	@FXML
	private Label label4;

	@FXML
	private Label label5;

	@FXML
	private Label label6;

	@FXML
	private Label label7;

	@FXML
	private Label label8;

	@FXML
	private Label label9;

	@FXML
	private Label label10;

	@FXML
	private Label label11;

	@FXML
	private Label label12;

	@FXML
	private Label label13;

	@FXML
	private Label label14;

	@FXML
	private Label label15;

	@FXML
	private Label label16;

	@FXML
	private Label label17;

	@FXML
	private Label label18;

	@FXML
	private Label label19;

	@FXML
	private Label label20;

	@FXML
	void Backbtn_TAPV(ActionEvent event) throws Exception {
		System.out.println("back");
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
		Pane root = loader.load(getClass().getResource("/gui/ThirdAlgorithmValues.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Three State Machines Algorithm Values");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void Startbtn_TAPV(ActionEvent event) throws IOException {
		if (CheckValues(counternumberofprocessors)) {
			if (StartFlag) {
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
	}

	@FXML
	private void initialize() {
		getValues();
		setProcsbuttons(counternumberofprocessors);
		Processor1Value_TAPV.setValue("0");
		Processor1Value_TAPV.setItems(K_TAV_list);
		Processor2Value_TAPV.setValue("0");
		Processor2Value_TAPV.setItems(K_TAV_list);
		setChoiceBox(counternumberofprocessors);
	}

	private void setChoiceBox(int counternumberofprocessors) {
		int i = 1;
		do {
			switch (i) {
			case 3:
				Processor3Value_TAPV.setValue("0");
				Processor3Value_TAPV.setItems(K_TAV_list);
				break;
			case 4:
				Processor4Value_TAPV.setValue("0");
				Processor4Value_TAPV.setItems(K_TAV_list);
				break;
			case 5:
				Processor5Value_TAPV.setValue("0");
				Processor5Value_TAPV.setItems(K_TAV_list);
				break;
			case 6:
				Processor6Value_TAPV.setValue("0");
				Processor6Value_TAPV.setItems(K_TAV_list);
				break;
			case 7:
				Processor7Value_TAPV.setValue("0");
				Processor7Value_TAPV.setItems(K_TAV_list);
				break;
			case 8:
				Processor8Value_TAPV.setValue("0");
				Processor8Value_TAPV.setItems(K_TAV_list);
				break;
			case 9:
				Processor9Value_TAPV.setValue("0");
				Processor9Value_TAPV.setItems(K_TAV_list);
				break;
			case 10:
				Processor10Value_TAPV.setValue("0");
				Processor10Value_TAPV.setItems(K_TAV_list);
				break;
			case 11:
				Processor11Value_TAPV.setValue("0");
				Processor11Value_TAPV.setItems(K_TAV_list);
				break;
			case 12:
				Processor12Value_TAPV.setValue("0");
				Processor12Value_TAPV.setItems(K_TAV_list);
				break;
			case 13:
				Processor13Value_TAPV.setValue("0");
				Processor13Value_TAPV.setItems(K_TAV_list);
				break;
			case 14:
				Processor14Value_TAPV.setValue("0");
				Processor14Value_TAPV.setItems(K_TAV_list);
				break;
			case 15:
				Processor15Value_TAPV.setValue("0");
				Processor15Value_TAPV.setItems(K_TAV_list);
				break;
			case 16:
				Processor16Value_TAPV.setValue("0");
				Processor16Value_TAPV.setItems(K_TAV_list);
				break;
			case 17:
				Processor17Value_TAPV.setValue("0");
				Processor17Value_TAPV.setItems(K_TAV_list);
				break;
			case 18:
				Processor18Value_TAPV.setValue("0");
				Processor18Value_TAPV.setItems(K_TAV_list);
				break;
			case 19:
				Processor19Value_TAPV.setValue("0");
				Processor19Value_TAPV.setItems(K_TAV_list);
				break;
			case 20:
				Processor20Value_TAPV.setValue("0");
				Processor20Value_TAPV.setItems(K_TAV_list);
				break;
			}

		} while (i++ <= counternumberofprocessors);

	}

	private void setProcsbuttons(int counternumberofprocessors1) {// remove all buttons of processors that don't exist=
		int i = counternumberofprocessors1 + 1;
		do {
			switch (i) {
			case 3:
				label3.setVisible(false);
				Processor3Value_TAPV.setVisible(false);
				break;
			case 4:
				label4.setVisible(false);
				Processor4Value_TAPV.setVisible(false);
				break;
			case 5:
				label5.setVisible(false);
				Processor5Value_TAPV.setVisible(false);

				break;
			case 6:
				label6.setVisible(false);
				Processor6Value_TAPV.setVisible(false);
				break;
			case 7:
				label7.setVisible(false);
				Processor7Value_TAPV.setVisible(false);
				break;
			case 8:
				label8.setVisible(false);
				Processor8Value_TAPV.setVisible(false);
				break;
			case 9:
				label9.setVisible(false);
				Processor9Value_TAPV.setVisible(false);
				break;
			case 10:
				label10.setVisible(false);
				Processor10Value_TAPV.setVisible(false);
				break;
			case 11:
				label11.setVisible(false);
				Processor11Value_TAPV.setVisible(false);
				break;
			case 12:
				label12.setVisible(false);
				Processor12Value_TAPV.setVisible(false);
				break;
			case 13:
				label13.setVisible(false);
				Processor13Value_TAPV.setVisible(false);
				break;
			case 14:
				label14.setVisible(false);
				Processor14Value_TAPV.setVisible(false);
				break;
			case 15:
				label15.setVisible(false);
				Processor15Value_TAPV.setVisible(false);
				break;
			case 16:
				label16.setVisible(false);
				Processor16Value_TAPV.setVisible(false);
				break;
			case 17:
				label17.setVisible(false);
				Processor17Value_TAPV.setVisible(false);
				break;
			case 18:
				label18.setVisible(false);
				Processor18Value_TAPV.setVisible(false);
				break;
			case 19:
				label19.setVisible(false);
				Processor19Value_TAPV.setVisible(false);
				break;
			case 20:
				label20.setVisible(false);
				Processor20Value_TAPV.setVisible(false);
				break;
			}

		} while (i++ <= 20);

	}

	private boolean CheckValues(int counternumberofprocessors) {
		int i = 1;
		String val;
		int counter = 0;
		try {
			do {
				switch (i) {
				case 1:
					val = Processor1Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 2:
					val = Processor2Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 3:
					val = Processor3Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 4:
					val = Processor4Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 5:
					val = Processor5Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 6:
					val = Processor6Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 7:
					val = Processor7Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 8:
					val = Processor8Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 9:
					val = Processor9Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 10:
					val = Processor10Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 11:
					val = Processor11Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 12:
					val = Processor12Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 13:
					val = Processor13Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 14:
					val = Processor14Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 15:
					val = Processor15Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 16:
					val = Processor16Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 17:
					val = Processor17Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 18:
					val = Processor18Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 19:
					val = Processor19Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				case 20:
					val = Processor20Value_TAPV.getValue();
					if (val != null && !val.equals("")) {

						ProcessorsArray[i - 1] = Integer.parseInt(val);

					} else {
						KvalErr();
						counter++;
					}
					;
					break;
				}

			} while (++i <= counternumberofprocessors);
		} catch (NumberFormatException e) {
			counter++;
			StartFlag = false;
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("value missing");
			alert.setHeaderText("Invalid input: please enter numbers only!.");
			alert.show();
		}
		if (counter == 0)
			StartFlag = true;
		return true;
	}

	private void KvalErr() {
		StartFlag = false;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("value missing");
		alert.setHeaderText("Invalid input: Please choose K in the range.");
		alert.show();
	}
	

	public void getValues() {
		sharedData = SharedData.getInstance();
		N_value = sharedData.getNValue();
		K_value = sharedData.getKValue();
		counternumberofprocessors = Integer.parseInt(N_value);
		K = Integer.parseInt(K_value);
	}

	private void setValues() {
		sharedData.setNValue(N_value);
		sharedData.setKValue(K_value);
		sharedData.setN_vals_array(ProcessorsArray);
	}

}
