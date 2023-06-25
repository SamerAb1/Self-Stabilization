package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class CompNumbersOfProcessors_Controller implements Initializable {

	Comp_SharedData Comp_sharedData;
	private int[] Nvalue = new int[5];
	int maxval = 1000000;
	private int K_value;
	private boolean algorithm;
	boolean Kerr = false;
	boolean StartFlag = false;
	private int NumofRuns;
	
	@FXML
	private Button Backbrn_Cvals;

	@FXML
	private Button Startbrn_Cvals;

	@FXML
	private TextField N1_val;

	@FXML
	private TextField N2_val;

	@FXML
	private TextField N3_val;

	@FXML
	private TextField N4_val;

	@FXML
	private TextField N5_val;

	@FXML
	private TextField K_val;

	@FXML
	private Label alg;

	@FXML
	private Label Kval;
	
    @FXML
    private TextField Num_Of_Runs;

	@FXML
	void Backbrn_Cvals(ActionEvent event) throws IOException {
		System.out.println("back");
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
		Pane root = loader.load(getClass().getResource("/gui/CompMain.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Comp main");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void Startbrn_Cvals(ActionEvent event) throws IOException {
		if (CheckValues(5)) {
			if (StartFlag) {
				setValues();
				FXMLLoader loader = new FXMLLoader();
				Stage primaryStage = new Stage();
				((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter
																			// what
				Pane root = loader.load(getClass().getResource("/gui/CompGraph.fxml").openStream());
				Scene scene = new Scene(root);
				primaryStage.setTitle("Complexity Graph");
				primaryStage.setScene(scene);
				primaryStage.show();
			}
		}

	}

	private void setValues() {
		// TODO Auto-generated method stub
		Comp_sharedData.setNValue(Nvalue);
		Comp_sharedData.setKValue(K_value);
		Comp_sharedData.setNumofRuns(NumofRuns);

	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Comp_sharedData = Comp_SharedData.getInstance();
		algorithm = Comp_sharedData.isAlgorithm();
		if (algorithm) {
			alg.setText("   K-State Machiens");
		} else {
			alg.setText("Three-State Machines");
			K_val.setVisible(false);
			Kval.setVisible(false);
		}

	}

	private boolean CheckValues(int counternumberofprocessors) {
		int i = 1;
		int val;
		int counter = 0;
		try {
			do {
				switch (i) {
				case 1:
					if (N1_val.getText() != null) {
						val = Integer.parseInt(N1_val.getText());
						if (val < 2 || val > (maxval)) {
							Kerr = true;
							counter++;
						} else {
							Nvalue[0] = val;
						}
					}
					;
					break;
				case 2:
					if (N2_val.getText() != null) {
						val = Integer.parseInt(N2_val.getText());
						if (val < 2 || val > (maxval)) {
							Kerr = true;
							counter++;
						} else {
							Nvalue[1] = val;
						}
					}
					;
					break;
				case 3:
					if (N3_val.getText() != null) {
						val = Integer.parseInt(N3_val.getText());
						if (val < 2 || val > (maxval)) {
							Kerr = true;
							counter++;
						} else {
							Nvalue[2] = val;
						}
					}
					;
					break;
				case 4:
					if (N4_val.getText() != null) {
						val = Integer.parseInt(N4_val.getText());
						if (val < 2 || val > (maxval)) {
							Kerr = true;
							counter++;
						} else {
							Nvalue[3] = val;
						}
					}
					;
					break;
				case 5:
					if (N5_val.getText() != null) {
						val = Integer.parseInt(N5_val.getText());
						if (val < 2 || val > (maxval)) {
							Kerr = true;
							counter++;
						} else {
							Nvalue[4] = val;
						}
					}
					;
					break;
				case 6:
					if (algorithm) {
						if (K_val.getText() != null) {
							val = Integer.parseInt(K_val.getText());
							if (val < 2 || val > (2000000000)) {
								Kerr = true;
								counter++;
							} else {
								K_value = val;
							}
						};
					}
					break;
				case 7:
					if (Num_Of_Runs.getText() != null) {
						val = Integer.parseInt(Num_Of_Runs.getText());
						if (val < 1 || val > (50000)) {
							Kerr = true;
							counter++;
						}else {
							NumofRuns = val;
						}
					}
					;
					break;
				}

					

			} while (++i <= counternumberofprocessors + 2);
		} catch (NumberFormatException e) {
			counter++;
			StartFlag = false;
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("value missing");
			alert.setHeaderText("Invalid input: please enter numbers only!.");
			alert.show();
		}
		if (Kerr) {
			KvalErr();
		}
		if (counter == 0)
			StartFlag = true;
		return true;
	}

	private void KvalErr() {
		StartFlag = false;
		Kerr = false;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("value missing");
		alert.setHeaderText("Invalid input: Please choose Value in the range.");
		alert.show();
	}

}
