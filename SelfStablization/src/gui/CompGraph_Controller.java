package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.Random;

public class CompGraph_Controller<X, Y> implements Initializable {

	private int[] N_values;
	private int[] Step_counter = new int[5];
	private int[] avg_Step_counter = new int[5];
	private int[] max_Step_counter = new int[5];
	private int K_value;
	private boolean algorithm;
	Comp_SharedData Comp_sharedData;
	private int[][] N_arrays;
	private int Tokens;
	private int Y;
	private int NumofRuns;
	private boolean stable = false;

	@FXML
	private Button Exit_button;

	@FXML
	private LineChart<?, ?> Complexity_Chart;
	@FXML
	private CategoryAxis numOfProcessors;

	@FXML
	private NumberAxis numOfSteps;

	@FXML
	private Label main_Label;

	@FXML
	void Exit_button(ActionEvent event) throws IOException {
		System.out.println("Exit");
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
		Pane root = loader.load(getClass().getResource("/gui/CompMain.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Comp Main");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Comp_sharedData = Comp_SharedData.getInstance();
		N_values = Comp_sharedData.getNValue();
		algorithm = Comp_sharedData.isAlgorithm();
		NumofRuns = Comp_sharedData.getNumofRuns();
		if (algorithm)
			K_value = Comp_sharedData.getKValue();
		else
			K_value = 3;
		Tokens = 0;
		stable = false;
		Y = 0;
		for (int i = 0; i < NumofRuns; i++) {
			setProcessorsValues();
		}
		for (int j = 0; j < 5; j++) {
			avg_Step_counter[j] = avg_Step_counter[j] / NumofRuns;

		}

		System.out.println("avg array : " + Arrays.toString(avg_Step_counter));
		System.out.println("max array : " + Arrays.toString(max_Step_counter));
		display();
	}

	private void setProcessorsValues() {
		// Create an array of arrays
		N_arrays = new int[N_values.length][];

		// Generate random numbers and fill the arrays
		Random random = new Random();
		for (int i = 0; i < N_values.length; i++) {
			N_arrays[i] = new int[N_values[i]];
			for (int j = 0; j < N_values[i]; j++) {
				N_arrays[i][j] = random.nextInt(K_value);
			}
		}
		runAlg();
		for (int j = 0; j < 5; j++) {
			avg_Step_counter[j] = avg_Step_counter[j] + Step_counter[j];
			if (Step_counter[j] > max_Step_counter[j])
				max_Step_counter[j] = Step_counter[j];
			Step_counter[j] = 0;
		}

	}

	private void runAlg() {
		for (int i = 0; i < N_values.length; i++) {
			Tokens = 0;
			stable = false;
			Y = 0;
			if (algorithm) {
				main_Label.setText("    K-State Machines Complex Graph");
				countTokens_FirstAlg(N_arrays[i]);
				FirstAlgorithm(N_arrays[i], i);
			} else {
				main_Label.setText("Three-State Machines Complex Graph");
				countY_ThirdAlg(N_arrays[i]);
				ThirdAlgorithm(N_arrays[i], i);
			}

		}

	}

	private void display() {

		XYChart.Series series = new XYChart.Series();
		series.setName("No of schools in an year");
		series.setName("avg");
		series.getData().add(new XYChart.Data(Integer.toString(N_arrays[0].length),
				(float) avg_Step_counter[0] / ((N_arrays[0].length) * (N_arrays[0].length))));
		series.getData().add(new XYChart.Data(Integer.toString(N_arrays[1].length),
				(float) avg_Step_counter[1] / ((N_arrays[1].length) * (N_arrays[1].length))));
		series.getData().add(new XYChart.Data(Integer.toString(N_arrays[2].length),
				(float) avg_Step_counter[2] / ((N_arrays[2].length) * (N_arrays[2].length))));
		series.getData().add(new XYChart.Data(Integer.toString(N_arrays[3].length),
				(float) avg_Step_counter[3] / ((N_arrays[3].length) * (N_arrays[3].length))));
		series.getData().add(new XYChart.Data(Integer.toString(N_arrays[4].length),
				(float) avg_Step_counter[4] / ((N_arrays[4].length) * (N_arrays[4].length))));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("max");
		series2.getData().add(new XYChart.Data(Integer.toString(N_arrays[0].length),
				(float) max_Step_counter[0] / ((N_arrays[0].length) * (N_arrays[0].length))));
		series2.getData().add(new XYChart.Data(Integer.toString(N_arrays[1].length),
				(float) max_Step_counter[1] / ((N_arrays[1].length) * (N_arrays[1].length))));
		series2.getData().add(new XYChart.Data(Integer.toString(N_arrays[2].length),
				(float) max_Step_counter[2] / ((N_arrays[2].length) * (N_arrays[2].length))));
		series2.getData().add(new XYChart.Data(Integer.toString(N_arrays[3].length),
				(float) max_Step_counter[3] / ((N_arrays[3].length) * (N_arrays[3].length))));
		series2.getData().add(new XYChart.Data(Integer.toString(N_arrays[4].length),
				(float) max_Step_counter[4] / ((N_arrays[4].length) * (N_arrays[4].length))));
		Complexity_Chart.getData().addAll(series);
		Complexity_Chart.getData().addAll(series2);
	}

	private void countY_ThirdAlg(int[] N) {
		for (int i = 0; i < (N.length - 1); i++) {
			if (((N[i] + 1) % 3) == N[i + 1]) {
				Y++;
			} else if (N[i] == ((N[i + 1] + 1) % 3)) {
				Y = Y + 2;
				;
			}
		}
	}

	private void countTokens_FirstAlg(int[] N) {
		if (N[0] == N[(N.length) - 1])
			Tokens++;
		for (int i = 1; i < N.length; i++) {
			if (N[i] != N[i - 1])
				Tokens++;
		}
	}

	private void ThirdAlgorithm(int[] N, int i) {
		Random random = new Random();
		int temp;
		while (!stable) {
			temp = random.nextInt(N.length);

			if (checkPrivilege_thirdAlg(N, temp)) {
				if (temp == 0) {
					if (((N[temp] + 1) % 3) == N[temp + 1]) {
						N[temp] = (N[temp] + 2) % 3;
						Step_counter[i]++;
						Y = Y + 1;
					}

				} else if (temp == (N.length - 1)) {
					if ((N[temp - 1] == (N[temp] + 1) % 3)) {
						N[temp] = (N[0] + 1) % 3;
						Step_counter[i]++;
						Y = Y - 1;
					}
					if (N[temp - 1] == N[temp]) {
						N[temp] = (N[0] + 1) % 3;
						Step_counter[i]++;
						Y = Y + 1;
					}
				} else {
					if ((N[temp - 1] == ((N[temp] + 1) % 3)) && (N[temp] == N[temp + 1])) {
						N[temp] = (N[temp] + 1) % 3;
						Step_counter[i]++;
					}
					if ((N[temp - 1] == N[temp]) && (((N[temp] + 1) % 3) == N[temp + 1])) {
						N[temp] = (N[temp] + 1) % 3;
						Step_counter[i]++;
					}
					if ((N[temp - 1] == ((N[temp] + 1) % 3)) && (((N[temp] + 1) % 3) == N[temp + 1])) {
						N[temp] = (N[temp] + 1) % 3;
						Step_counter[i]++;
						Y = Y - 3;
					}
					if ((N[temp - 1] == ((N[temp] + 1) % 3)) && (N[temp] == ((N[temp + 1] + 1) % 3))) {
						N[temp] = (N[temp] + 1) % 3;
						Step_counter[i]++;
						Y = Y - 3;
					}
					if ((((N[temp - 1] + 1) % 3) == N[temp]) && (((N[temp] + 1) % 3) == N[temp + 1])) {
						N[temp] = (N[temp] + 1) % 3;
						Step_counter[i]++;
					}
				}
			}

			if (Y < 3) {
				stable = checkarrows_Thirdalg(N);
			}
		}
	}

	private boolean checkarrows_Thirdalg(int[] N) {
		int temp_arrows = 0;
		for (int i = 0; i < N.length - 1; i++) {
			if (((N[i]) == (((N[i + 1]) + 1) % 3))) {
				++temp_arrows;
			}
			if (((((N[i]) + 1) % 3) == (N[i + 1]))) {
				++temp_arrows;
			}
		}

		if (temp_arrows > 1) {
			return false;
		}
		return true;

	}

	private boolean checkPrivilege_thirdAlg(int[] N, int temp) {
		if (temp == 0) {
			if (((N[temp] + 1) % 3) == N[temp + 1]) {
				return true;
			}
		} else if (temp == (N.length - 1)) {
			if ((N[temp - 1] == N[0]) && (((N[0] + 1) % 3) != N[temp])) {
				return true;
			}
		} else {
			if ((((N[temp] + 1) % 3) == (N[temp - 1])) || (((N[temp] + 1) % 3) == (N[temp + 1]))) {
				return true;
			}
		}
		return false;
	}

	private void FirstAlgorithm(int[] N, int i) {
		Random random = new Random();
		int temp;

		while (Tokens > 1) {

			temp = random.nextInt(N.length);
			if (checkPrivilege_firstAlg(N, temp)) {
				if (temp == 0) {
					if (N[0] == (N[(N.length) - 1])) {
						N[0] = ((N[0] + 1) % K_value);
						Step_counter[i]++;
						if (N[0] != N[1]) {
							Tokens--;
						}
					}
				} else {
					if (N[temp] != N[temp - 1]) {
						if (temp == ((N.length) - 1)) {
							if (N[temp] == N[0]) {
								N[temp] = N[temp - 1];
								Step_counter[i]++;
								Tokens = Tokens - 2;
							} else {
								N[temp] = N[temp - 1];
								Step_counter[i]++;
								if (N[temp] != N[0])
									Tokens = Tokens - 1;
							}

						} else {
							if (N[temp] != N[temp + 1]) {
								N[temp] = N[temp - 1];
								Step_counter[i]++;
								if (N[temp] == N[temp + 1]) {
									Tokens = Tokens - 2;
								} else {
									Tokens--;
								}
							} else {
								N[temp] = N[temp - 1];
								Step_counter[i]++;
							}
						}

					}
				}
			}
		}
	}

	private boolean checkPrivilege_firstAlg(int[] N, int temp) {
		if (temp == 0) {
			if (N[0] == N[(N.length) - 1]) {
				return true;
			}
		} else {
			if (N[temp] != N[temp - 1]) {
				return true;
			}
		}
		return false;
	}

}
