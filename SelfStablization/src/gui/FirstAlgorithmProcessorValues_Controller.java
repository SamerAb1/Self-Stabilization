package gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FirstAlgorithmProcessorValues_Controller {
	boolean StartFlag = false;
	int counternumberofprocessors = 2;
	private String N_value;
	private String K_value;
	int K = 2;
	int[] ProcessorsArray = new int[20];
	boolean Kerr = false;
	SharedData sharedData;
	
	@FXML
	private Button Backbtn_FAPV;
	
	@FXML
	private Button Startbtn_FAPV;

	@FXML
	private Label K_value_FAPV;

	@FXML
	private Label Label1;
	
	@FXML
	private Label Label2;
	
	@FXML
	private Label Label3;
	
	@FXML
	private Label Label4;
	
	@FXML
	private Label Label5;
	
	@FXML
	private Label Label6;

	@FXML
	private Label Label7;

	@FXML
	private Label Label8;

	@FXML
	private Label Label9;
	
	@FXML
	private Label Label10;

	@FXML
	private Label Label11;

	@FXML
	private Label Label12;

	@FXML
	private Label Label13;

	@FXML
	private Label Label14;

	@FXML
	private Label Label15;

	@FXML
	private Label Label16;

	@FXML
	private Label Label17;

	@FXML
	private Label Label18;

	@FXML
	private Label Label19;

	@FXML
	private Label Label20;

	@FXML
	private TextField Processor1Value_FAPV;
	
	@FXML
	private TextField Processor2Value_FAPV;
	
	@FXML
	private TextField Processor3Value_FAPV;
	
	@FXML
	private TextField Processor4Value_FAPV;
	
	@FXML
	private TextField Processor5Value_FAPV;
	
	@FXML
	private TextField Processor6Value_FAPV;

	@FXML
	private TextField Processor7Value_FAPV;
	
	@FXML
	private TextField Processor8Value_FAPV;
	
	@FXML
	private TextField Processor9Value_FAPV;
	
	@FXML
	private TextField Processor10Value_FAPV;
	
	@FXML
	private TextField Processor11Value_FAPV;
	
	@FXML
	private TextField Processor12Value_FAPV;
	
	@FXML
	private TextField Processor13Value_FAPV;
	
	@FXML
	private TextField Processor14Value_FAPV;
	
	@FXML
	private TextField Processor15Value_FAPV;
	
	@FXML
	private TextField Processor16Value_FAPV;

	@FXML
	private TextField Processor17Value_FAPV;
	
	@FXML
	private TextField Processor18Value_FAPV;
	
	@FXML
	private TextField Processor19Value_FAPV;

	@FXML
	private TextField Processor20Value_FAPV;

	@FXML
	void Backbtn_FAPV(ActionEvent event) throws Exception {
		System.out.println("back");
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
		Pane root = loader.load(getClass().getResource("/gui/FirstAlgorithmValues.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("First Algorithm Values");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void Startbtn_FAPV(ActionEvent event) throws IOException {
		getValues();
		if (CheckValues(counternumberofprocessors)) {
			if (StartFlag) {
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
	}

	public void initialize() {
		sharedData = SharedData.getInstance();
		getValues();
		setProcsbuttons(counternumberofprocessors);
		K_value_FAPV.setText("0 ≤ X ≤ " + (K-1));

	}

	private boolean CheckValues(int counternumberofprocessors) {
		int i = 1;
		int val;
		int counter = 0;
		try {
			do {
				switch (i) {
				case 1:
					if (Processor1Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor1Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 2:
					if (Processor2Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor2Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 3:
					if (Processor3Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor3Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 4:
					if (Processor4Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor4Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;

						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 5:
					if (Processor5Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor5Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 6:
					if (Processor6Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor6Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 7:
					if (Processor7Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor7Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 8:
					if (Processor8Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor8Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 9:
					if (Processor9Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor9Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 10:
					if (Processor10Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor10Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 11:
					if (Processor11Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor11Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 12:
					if (Processor12Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor12Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 13:
					if (Processor13Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor13Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 14:
					if (Processor14Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor14Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 15:
					if (Processor15Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor15Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 16:
					if (Processor16Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor16Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 17:
					if (Processor17Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor17Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 18:
					if (Processor18Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor18Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 19:
					if (Processor19Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor19Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
					}
					;
					break;
				case 20:
					if (Processor20Value_FAPV.getText() != null) {
						val = Integer.parseInt(Processor20Value_FAPV.getText());
						if (val < 0 || val > (K-1)) {
							Kerr = true;
							counter++;
						} else {
							ProcessorsArray[i - 1] = val;
						}
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
		if(Kerr) {
			KvalErr();
		}
		if (counter == 0)
			StartFlag = true;
		return true;
	}

	private void KvalErr() {
		StartFlag = false;
		Kerr=false;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("value missing");
		alert.setHeaderText("Invalid input: Please choose Value in the range.");
		alert.show();
	}

	private void setProcsbuttons(int counternumberofprocessors1) {// remove all buttons of processors that don't exist=
		int i = counternumberofprocessors1 + 1;
		do {
			switch (i) {
			case 3:
				Label3.setVisible(false);
				Processor3Value_FAPV.setVisible(false);
				break;
			case 4:
				Label4.setVisible(false);
				Processor4Value_FAPV.setVisible(false);
				break;
			case 5:
				Label5.setVisible(false);
				Processor5Value_FAPV.setVisible(false);

				break;
			case 6:
				Label6.setVisible(false);
				Processor6Value_FAPV.setVisible(false);
				break;
			case 7:
				Label7.setVisible(false);
				Processor7Value_FAPV.setVisible(false);
				break;
			case 8:
				Label8.setVisible(false);
				Processor8Value_FAPV.setVisible(false);
				break;
			case 9:
				Label9.setVisible(false);
				Processor9Value_FAPV.setVisible(false);
				break;
			case 10:
				Label10.setVisible(false);
				Processor10Value_FAPV.setVisible(false);
				break;
			case 11:
				Label11.setVisible(false);
				Processor11Value_FAPV.setVisible(false);
				break;
			case 12:
				Label12.setVisible(false);
				Processor12Value_FAPV.setVisible(false);
				break;
			case 13:
				Label13.setVisible(false);
				Processor13Value_FAPV.setVisible(false);
				break;
			case 14:
				Label14.setVisible(false);
				Processor14Value_FAPV.setVisible(false);
				break;
			case 15:
				Label15.setVisible(false);
				Processor15Value_FAPV.setVisible(false);
				break;
			case 16:
				Label16.setVisible(false);
				Processor16Value_FAPV.setVisible(false);
				break;
			case 17:
				Label17.setVisible(false);
				Processor17Value_FAPV.setVisible(false);
				break;
			case 18:
				Label18.setVisible(false);
				Processor18Value_FAPV.setVisible(false);
				break;
			case 19:
				Label19.setVisible(false);
				Processor19Value_FAPV.setVisible(false);
				break;
			case 20:
				Label20.setVisible(false);
				Processor20Value_FAPV.setVisible(false);
				break;
			}

		} while (i++ <= 20);

	}

	public void getValues() {

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
