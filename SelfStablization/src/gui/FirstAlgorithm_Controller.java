package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FirstAlgorithm_Controller implements Initializable {
	String N_value = null;
	String K_value = null;
	int[] ProcessorsArray = new int[20];
	int[] ProcArray = new int[20];
	int[] PrivilegeArray = new int[20];
	int[] GreenArray = new int[20];
	int executionflag;
	int[] Yellow = { 255, 218, 33 };
	int[] Green = { 122, 177, 93 };
	int[] Black = { 0, 0, 0 };
	int N, K;
	boolean autobtn_Pause = false;
	boolean showAlg = false;
	SharedData sharedData;
	private ScheduledExecutorService executorService;

    @FXML
    private ImageView image;

    @FXML
    private ToggleButton show_Alg;
    
	@FXML
	private Label stableNote_label;

	@FXML
	private Button Exit_button;

	@FXML
	private Label N_value_label;
	@FXML
	private Label K_value_label;

	@FXML
	private Button NextStep_button;
	@FXML
	private Label Plabel1;

	@FXML
	private Label Plabel10;

	@FXML
	private Label Plabel11;

	@FXML
	private Label Plabel12;

	@FXML
	private Label Plabel13;

	@FXML
	private Label Plabel14;

	@FXML
	private Label Plabel15;

	@FXML
	private Label Plabel16;

	@FXML
	private Label Plabel17;

	@FXML
	private Label Plabel18;

	@FXML
	private Label Plabel19;

	@FXML
	private Label Plabel2;

	@FXML
	private Label Plabel20;

	@FXML
	private Label Plabel3;

	@FXML
	private Label Plabel4;

	@FXML
	private Label Plabel5;

	@FXML
	private Label Plabel6;

	@FXML
	private Label Plabel7;

	@FXML
	private Label Plabel8;

	@FXML
	private Label Plabel9;

	@FXML
	private Rectangle Processor1;

	@FXML
	private Circle Processor10;

	@FXML
	private Circle Processor11;

	@FXML
	private Circle Processor12;

	@FXML
	private Circle Processor13;

	@FXML
	private Circle Processor14;

	@FXML
	private Circle Processor15;

	@FXML
	private Circle Processor16;

	@FXML
	private Circle Processor17;

	@FXML
	private Circle Processor18;

	@FXML
	private Circle Processor19;

	@FXML
	private Circle Processor2;

	@FXML
	private Circle Processor20;

	@FXML
	private Circle Processor3;

	@FXML
	private Circle Processor4;

	@FXML
	private Circle Processor5;

	@FXML
	private Circle Processor6;

	@FXML
	private Circle Processor7;

	@FXML
	private Circle Processor8;

	@FXML
	private Circle Processor9;

	@FXML
	private Label P1_N;

	@FXML
	private Label P2_N;

	@FXML
	private Label P3_N;

	@FXML
	private Label P4_N;

	@FXML
	private Label P5_N;

	@FXML
	private Label P6_N;

	@FXML
	private Label P7_N;

	@FXML
	private Label P8_N;

	@FXML
	private Label P9_N;

	@FXML
	private Label P10_N;

	@FXML
	private Label P11_N;

	@FXML
	private Label P12_N;

	@FXML
	private Label P13_N;

	@FXML
	private Label P14_N;

	@FXML
	private Label P15_N;

	@FXML
	private Label P16_N;

	@FXML
	private Label P17_N;

	@FXML
	private Label P18_N;

	@FXML
	private Label P19_N;

	@FXML
	private Label P20_N;

	@FXML
	private Label Stable_label;

	@FXML
	private Button automatic_button;

	@FXML
	void Exit_button(ActionEvent event) throws IOException {
		System.out.println("Exit");
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
    void show_Alg(ActionEvent event) {
    	if(!showAlg) {
    		show_Alg.setText("Hide Alg");
    		showAlg= !showAlg;
    	}else {
    		show_Alg.setText("Show Alg");
    		showAlg= !showAlg;
    	}
    }
    
	void runProcessors() {
		for (int i = 0; i < 20; i++) {
			if (PrivilegeArray[i] == 2) {
				if (i == 0) {
					ProcessorsArray[i] = (ProcessorsArray[i] + 1) % (K);
					setProcsbuttons(N);
					pickProcessorExe();
					break;
				} else {
					ProcessorsArray[i] = ProcessorsArray[i - 1];
					setProcsbuttons(N);
					pickProcessorExe();
					break;
				}
			}
		}
	}

	@FXML
	void NextStep_button(ActionEvent event) {
		runProcessors();
	}

	void changetoGreen(int n1) {
		int Proc1, Proc2 = -1;
		if (PrivilegeArray[n1] == 1) {
			for (int i = 0; i < 20; i++) {
				if (PrivilegeArray[i] == 2) {
					Proc2 = CircleProcNum(i + 1);
					Proc1 = CircleProcNum(n1 + 1);
					setGreen(Proc1);
					PrivilegeArray[n1] = 2;
					setColor(getProcC(Proc2), Yellow);
					PrivilegeArray[i] = 1;
					i = 20;

				}
			}

		} else {
			return;
		}

	}

	void changetoGreen_String(int n1) {
		int Proc1, Proc2 = -1;
		if (PrivilegeArray[n1] == 1) {
			for (int i = 0; i < 20; i++) {
				if (PrivilegeArray[i] == 2) {
					Proc2 = CircleProcNum(i + 1);
					Proc1 = CircleProcNum(n1 + 1);
					setGreen(Proc1);
					PrivilegeArray[n1] = 2;
					setColor(getProcC(Proc2), Yellow);
					PrivilegeArray[i] = 1;
					i = 20;

				}
			}

		} else {
			return;
		}

	}

	private int CircleProcNum(int n) {
		int counter = n;
		for (int i = 0; i < 20; i++) {
			if (GreenArray[i] == 1) {
				--counter;
			}
			if (counter == 0) {
				return i;
			}
		}
		return -1;
	}

	@FXML
	void Processor1_click(MouseEvent event) {
		int n = Integer.parseInt(P1_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor2_click(MouseEvent event) {
		int n = Integer.parseInt(P2_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor3_click(MouseEvent event) {
		int n = Integer.parseInt(P3_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor4_click(MouseEvent event) {
		int n = Integer.parseInt(P4_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor5_click(MouseEvent event) {
		int n = Integer.parseInt(P5_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor6_click(MouseEvent event) {
		int n = Integer.parseInt(P6_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor7_click(MouseEvent event) {
		int n = Integer.parseInt(P7_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor8_click(MouseEvent event) {
		int n = Integer.parseInt(P8_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor9_click(MouseEvent event) {
		int n = Integer.parseInt(P9_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor10_click(MouseEvent event) {
		int n = Integer.parseInt(P10_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor11_click(MouseEvent event) {
		int n = Integer.parseInt(P11_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor12_click(MouseEvent event) {
		int n = Integer.parseInt(P12_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor13_click(MouseEvent event) {
		int n = Integer.parseInt(P13_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor14_click(MouseEvent event) {
		int n = Integer.parseInt(P14_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor15_click(MouseEvent event) {
		int n = Integer.parseInt(P15_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor16_click(MouseEvent event) {
		int n = Integer.parseInt(P16_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor17_click(MouseEvent event) {
		int n = Integer.parseInt(P17_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor18_click(MouseEvent event) {
		int n = Integer.parseInt(P18_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor19_click(MouseEvent event) {
		int n = Integer.parseInt(P19_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor20_click(MouseEvent event) {
		int n = Integer.parseInt(P20_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void automatic_button(ActionEvent event) {
		autobtn_Pause = !autobtn_Pause;
		if (autobtn_Pause) {
			automatic_button.setText("PAUSE");
			startUpdatingNumbers();

		} else {
			automatic_button.setText("AUTOMATIC");
			stopUpdatingNumbers();
		}
	}

	void setprocessor1(boolean value, int i) {
		Processor1.setVisible(value);
		Plabel1.setVisible(value);
		P1_N.setVisible(value);
		Plabel1.setText(Integer.toString(ProcessorsArray[i]));
		if (ProcessorsArray[i] == ProcessorsArray[N - 1]) {
			setColor1(Processor1, Yellow);
			PrivilegeArray[0] = 1;
		} else {
			setColor1(Processor1, Black);
			PrivilegeArray[0] = 0;
		}
	}

	void setprocessor(Circle Processor, Label P_N_Label, Label Plabel, boolean value, int i) {
		Processor.setVisible(value);
		Plabel.setVisible(value);
		P_N_Label.setVisible(value);
		P_N_Label.setText(Integer.toString(i + 1));
		if (value) {
			Plabel.setText(Integer.toString(ProcessorsArray[i]));
			setProcessorColor(Processor, i);
		}
	}

	void setProcessorColor(Circle Processor, int i) {
		if (ProcessorsArray[i] != ProcessorsArray[i - 1]) {
			setColor(Processor, Yellow);
			PrivilegeArray[i] = 1;
		} else {
			setColor(Processor, Black);
			PrivilegeArray[i] = 0;
		}

	}

	void setColor(Circle Processor, int[] Color1) {
		if (Processor != null) {
			Processor.setStrokeWidth(5);
			Processor.setStroke(Color.rgb(Color1[0], Color1[1], Color1[2]));
			Processor.setFill(null);
		}
	}

	void setColorGreen(Circle Processor, int[] Color1) {
		if (Processor != null) {
			Processor.setFill(Color.rgb(Color1[0], Color1[1], Color1[2]));
		}
	}

	void pickProcessorExe() {
		int n, k = 0;
		boolean stopper = false;
		Random rand = new Random();

		do {
			n = rand.nextInt((N) - 0) + 0;

			k = CircleProcNum(n + 1);
			if (PrivilegeArray[n] == 1) {
				setGreen(k);
				PrivilegeArray[n] = 2;
				stopper = true;
			}
		} while (!stopper);
	}

	private void setfirstscreen() {
		setprocessor1(false, 0);
		setprocessor(Processor2, P2_N, Plabel2, false, 1);
		setprocessor(Processor3, P3_N, Plabel3, false, 2);
		setprocessor(Processor4, P4_N, Plabel4, false, 3);
		setprocessor(Processor5, P5_N, Plabel5, false, 4);
		setprocessor(Processor6, P6_N, Plabel6, false, 5);
		setprocessor(Processor7, P7_N, Plabel7, false, 6);
		setprocessor(Processor8, P8_N, Plabel8, false, 7);
		setprocessor(Processor9, P9_N, Plabel9, false, 8);
		setprocessor(Processor10, P10_N, Plabel10, false, 9);
		setprocessor(Processor11, P11_N, Plabel11, false, 10);
		setprocessor(Processor12, P12_N, Plabel12, false, 11);
		setprocessor(Processor13, P13_N, Plabel13, false, 12);
		setprocessor(Processor14, P14_N, Plabel14, false, 13);
		setprocessor(Processor15, P15_N, Plabel15, false, 14);
		setprocessor(Processor16, P16_N, Plabel16, false, 15);
		setprocessor(Processor17, P17_N, Plabel17, false, 16);
		setprocessor(Processor18, P18_N, Plabel18, false, 17);
		setprocessor(Processor19, P19_N, Plabel19, false, 18);
		setprocessor(Processor20, P20_N, Plabel20, false, 19);
		if (K > (N - 2)) {
			stableNote_label.setVisible(false);
		}
		setProcsbuttons(N);
		pickProcessorExe();

		for (int i = 0; i < N; i++) {
			ProcArray[i] = ProcessorsArray[i];
		}

//		printArrays();

	}

	void printArrays() {

		System.out.println("Proccessors array test:");
		for (int i = 0; i < 20; i++) {
			System.out.print(ProcessorsArray[i] + ",");
		}
		System.out.println();
		System.out.println("Proc array test:");
		for (int i = 0; i < 20; i++) {
			System.out.print(ProcArray[i] + ",");
		}
		System.out.println();
		System.out.println("Privilege array test:");
		for (int i = 0; i < 20; i++) {
			System.out.print("," + PrivilegeArray[i]);
		}
		System.out.println();
		System.out.println("Green array test:");
		for (int i = 0; i < 20; i++) {
			System.out.print("," + GreenArray[i]);
		}
		System.out.println();
	}

	void setGreen(int i) {
		switch (i + 1) {
		case 1:
			setColor1Green(Processor1, Green);
			break;
		case 2:
			setColorGreen(Processor2, Green);
			break;
		case 3:
			setColorGreen(Processor3, Green);
			break;
		case 4:
			setColorGreen(Processor4, Green);
			break;
		case 5:
			setColorGreen(Processor5, Green);
			break;
		case 6:
			setColorGreen(Processor6, Green);
			break;
		case 7:
			setColorGreen(Processor7, Green);
			break;
		case 8:
			setColorGreen(Processor8, Green);
			break;
		case 9:
			setColorGreen(Processor9, Green);
			break;
		case 10:
			setColorGreen(Processor10, Green);
			break;
		case 11:
			setColorGreen(Processor11, Green);
			break;
		case 12:
			setColorGreen(Processor12, Green);
			break;
		case 13:
			setColorGreen(Processor13, Green);
			break;
		case 14:
			setColorGreen(Processor14, Green);
			break;
		case 15:
			setColorGreen(Processor15, Green);
			break;
		case 16:
			setColorGreen(Processor16, Green);
			break;
		case 17:
			setColorGreen(Processor17, Green);
			break;
		case 18:
			setColorGreen(Processor18, Green);
			break;
		case 19:
			setColorGreen(Processor19, Green);
			break;
		case 20:
			setColorGreen(Processor20, Green);
			break;
		}
	}

	private void setColor1(Rectangle Processor, int[] Color1) {
		if (Processor != null) {
			Processor.setStrokeWidth(5);
			Processor.setStroke(Color.rgb(Color1[0], Color1[1], Color1[2]));
			Processor.setFill(null);
		}

	}

	private void setColor1Green(Rectangle Processor, int[] Color1) {
		if (Processor != null) {
			Processor.setFill(Color.rgb(Color1[0], Color1[1], Color1[2]));

		}

	}

	Circle getProcC(int i) {
		switch (i + 1) {
//		case 1:
//			return Processor1;
		case 2:
			return Processor2;
		case 3:
			return Processor3;
		case 4:
			return Processor4;
		case 5:
			return Processor5;
		case 6:
			return Processor6;
		case 7:
			return Processor7;
		case 8:
			return Processor8;
		case 9:
			return Processor9;
		case 10:
			return Processor10;
		case 11:
			return Processor11;
		case 12:
			return Processor12;
		case 13:
			return Processor13;
		case 14:
			return Processor14;
		case 15:
			return Processor15;
		case 16:
			return Processor16;
		case 17:
			return Processor17;
		case 18:
			return Processor18;
		case 19:
			return Processor19;
		case 20:
			return Processor20;
		}

		return null;
	}

	Label getProcLabel(int i) {
		switch (i + 1) {
		case 1:
			return Plabel1;
		case 2:
			return Plabel2;
		case 3:
			return Plabel3;
		case 4:
			return Plabel4;
		case 5:
			return Plabel5;
		case 6:
			return Plabel6;
		case 7:
			return Plabel7;
		case 8:
			return Plabel8;
		case 9:
			return Plabel9;
		case 10:
			return Plabel10;
		case 11:
			return Plabel11;
		case 12:
			return Plabel12;
		case 13:
			return Plabel13;
		case 14:
			return Plabel14;
		case 15:
			return Plabel15;
		case 16:
			return Plabel16;
		case 17:
			return Plabel17;
		case 18:
			return Plabel18;
		case 19:
			return Plabel19;
		case 20:
			return Plabel20;
		}
		return null;
	}

	private void getValues() {
		N_value = sharedData.getNValue();
		K_value = sharedData.getKValue();
		boolean stablilityflag = sharedData.isStabilityflag();
		ProcessorsArray = sharedData.getN_vals_array();
		N = Integer.parseInt(N_value);
		K = Integer.parseInt(K_value);
		K_value_label.setText(K_value);
		N_value_label.setText(N_value);
		setfirstscreen();

	}

	private void setValues() {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for (int i = 0; i < 20; i++) {
			PrivilegeArray[i] = -1;
			ProcArray[i] = -1;
			GreenArray[i] = -1;
		}
		sharedData = SharedData.getInstance();
		getValues();

	}

	private void setProcsbuttons(int N) {

		switch (N) {
		case 2:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor2, P2_N, Plabel2, true, 1);
			GreenArray[1] = 1;
			break;
		case 3:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor6, P6_N, Plabel6, true, 1);
			GreenArray[5] = 1;
			setprocessor(Processor16, P16_N, Plabel16, true, 2);
			GreenArray[15] = 1;
			break;
		case 4:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor6, P6_N, Plabel6, true, 1);
			GreenArray[5] = 1;
			setprocessor(Processor11, P11_N, Plabel11, true, 2);
			GreenArray[10] = 1;
			setprocessor(Processor16, P16_N, Plabel16, true, 3);
			GreenArray[15] = 1;
			break;
		case 5:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor5, P5_N, Plabel5, true, 1);
			GreenArray[4] = 1;
			setprocessor(Processor9, P9_N, Plabel9, true, 2);
			GreenArray[8] = 1;
			setprocessor(Processor13, P13_N, Plabel13, true, 3);
			GreenArray[12] = 1;
			setprocessor(Processor17, P17_N, Plabel17, true, 4);
			GreenArray[16] = 1;
			break;
		case 6:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor4, P4_N, Plabel4, true, 1);
			GreenArray[3] = 1;
			setprocessor(Processor8, P8_N, Plabel8, true, 2);
			GreenArray[7] = 1;
			setprocessor(Processor11, P11_N, Plabel11, true, 3);
			GreenArray[10] = 1;
			setprocessor(Processor14, P14_N, Plabel14, true, 4);
			GreenArray[13] = 1;
			setprocessor(Processor18, P18_N, Plabel18, true, 5);
			GreenArray[17] = 1;
			break;
		case 7:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor4, P4_N, Plabel4, true, 1);
			GreenArray[3] = 1;
			setprocessor(Processor6, P6_N, Plabel6, true, 2);
			GreenArray[5] = 1;
			setprocessor(Processor8, P8_N, Plabel8, true, 3);
			GreenArray[7] = 1;
			setprocessor(Processor14, P14_N, Plabel14, true, 4);
			GreenArray[13] = 1;
			setprocessor(Processor16, P16_N, Plabel16, true, 5);
			GreenArray[15] = 1;
			setprocessor(Processor18, P18_N, Plabel18, true, 6);
			GreenArray[17] = 1;
			break;
		case 8:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor4, P4_N, Plabel4, true, 1);
			GreenArray[3] = 1;
			setprocessor(Processor6, P6_N, Plabel6, true, 2);
			GreenArray[5] = 1;
			setprocessor(Processor8, P8_N, Plabel8, true, 3);
			GreenArray[7] = 1;
			setprocessor(Processor11, P11_N, Plabel11, true, 4);
			GreenArray[10] = 1;
			setprocessor(Processor14, P14_N, Plabel14, true, 5);
			GreenArray[13] = 1;
			setprocessor(Processor16, P16_N, Plabel16, true, 6);
			GreenArray[15] = 1;
			setprocessor(Processor18, P18_N, Plabel18, true, 7);
			GreenArray[17] = 1;
			break;
		case 9:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor3, P3_N, Plabel3, true, 1);
			GreenArray[2] = 1;
			setprocessor(Processor5, P5_N, Plabel5, true, 2);
			GreenArray[4] = 1;
			setprocessor(Processor7, P7_N, Plabel7, true, 3);
			GreenArray[6] = 1;
			setprocessor(Processor9, P9_N, Plabel9, true, 4);
			GreenArray[8] = 1;
			setprocessor(Processor13, P13_N, Plabel13, true, 5);
			GreenArray[12] = 1;
			setprocessor(Processor15, P15_N, Plabel15, true, 6);
			GreenArray[14] = 1;
			setprocessor(Processor17, P17_N, Plabel17, true, 7);
			GreenArray[16] = 1;
			setprocessor(Processor19, P19_N, Plabel19, true, 8);
			GreenArray[18] = 1;
			break;
		case 10:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor3, P3_N, Plabel3, true, 1);
			GreenArray[2] = 1;
			setprocessor(Processor5, P5_N, Plabel5, true, 2);
			GreenArray[4] = 1;
			setprocessor(Processor7, P7_N, Plabel7, true, 3);
			GreenArray[6] = 1;
			setprocessor(Processor9, P9_N, Plabel9, true, 4);
			GreenArray[8] = 1;
			setprocessor(Processor11, P11_N, Plabel11, true, 5);
			GreenArray[10] = 1;
			setprocessor(Processor13, P13_N, Plabel13, true, 6);
			GreenArray[12] = 1;
			setprocessor(Processor15, P15_N, Plabel15, true, 7);
			GreenArray[14] = 1;
			setprocessor(Processor17, P17_N, Plabel17, true, 8);
			GreenArray[16] = 1;
			setprocessor(Processor19, P19_N, Plabel19, true, 9);
			GreenArray[18] = 1;
			break;
		case 11:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor2, P2_N, Plabel2, true, 1);
			GreenArray[1] = 1;
			setprocessor(Processor4, P4_N, Plabel4, true, 2);
			GreenArray[3] = 1;
			setprocessor(Processor6, P6_N, Plabel6, true, 3);
			GreenArray[5] = 1;
			setprocessor(Processor8, P8_N, Plabel8, true, 4);
			GreenArray[7] = 1;
			setprocessor(Processor10, P10_N, Plabel10, true, 5);
			GreenArray[9] = 1;
			setprocessor(Processor12, P12_N, Plabel12, true, 6);
			GreenArray[11] = 1;
			setprocessor(Processor14, P14_N, Plabel14, true, 7);
			GreenArray[13] = 1;
			setprocessor(Processor16, P16_N, Plabel16, true, 8);
			GreenArray[15] = 1;
			setprocessor(Processor18, P18_N, Plabel18, true, 9);
			GreenArray[17] = 1;
			setprocessor(Processor20, P20_N, Plabel20, true, 10);
			GreenArray[19] = 1;
			break;
		case 12:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor2, P2_N, Plabel2, true, 1);
			GreenArray[1] = 1;
			setprocessor(Processor4, P4_N, Plabel4, true, 2);
			GreenArray[3] = 1;
			setprocessor(Processor6, P6_N, Plabel6, true, 3);
			GreenArray[5] = 1;
			setprocessor(Processor8, P8_N, Plabel8, true, 4);
			GreenArray[7] = 1;
			setprocessor(Processor10, P10_N, Plabel10, true, 5);
			GreenArray[9] = 1;
			setprocessor(Processor11, P11_N, Plabel11, true, 6);
			GreenArray[10] = 1;
			setprocessor(Processor12, P12_N, Plabel12, true, 7);
			GreenArray[11] = 1;
			setprocessor(Processor14, P14_N, Plabel14, true, 8);
			GreenArray[13] = 1;
			setprocessor(Processor16, P16_N, Plabel16, true, 9);
			GreenArray[15] = 1;
			setprocessor(Processor18, P18_N, Plabel18, true, 10);
			GreenArray[17] = 1;
			setprocessor(Processor20, P20_N, Plabel20, true, 11);
			GreenArray[19] = 1;
			break;
		case 13:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor3, P3_N, Plabel3, true, 1);
			GreenArray[2] = 1;
			setprocessor(Processor5, P5_N, Plabel5, true, 2);
			GreenArray[4] = 1;
			setprocessor(Processor6, P6_N, Plabel6, true, 3);
			GreenArray[5] = 1;
			setprocessor(Processor7, P7_N, Plabel7, true, 4);
			GreenArray[6] = 1;
			setprocessor(Processor9, P9_N, Plabel9, true, 5);
			GreenArray[8] = 1;
			setprocessor(Processor10, P10_N, Plabel10, true, 6);
			GreenArray[9] = 1;
			setprocessor(Processor12, P12_N, Plabel12, true, 7);
			GreenArray[11] = 1;
			setprocessor(Processor13, P13_N, Plabel13, true, 8);
			GreenArray[12] = 1;
			setprocessor(Processor15, P15_N, Plabel15, true, 9);
			GreenArray[14] = 1;
			setprocessor(Processor16, P16_N, Plabel16, true, 10);
			GreenArray[15] = 1;
			setprocessor(Processor17, P17_N, Plabel17, true, 11);
			GreenArray[16] = 1;
			setprocessor(Processor19, P19_N, Plabel19, true, 12);
			GreenArray[18] = 1;
			break;
		case 14:
			setprocessor1(true, 0);
			GreenArray[0] = 1;
			setprocessor(Processor3, P3_N, Plabel3, true, 1);
			GreenArray[2] = 1;
			setprocessor(Processor5, P5_N, Plabel5, true, 2);
			GreenArray[4] = 1;
			setprocessor(Processor6, P6_N, Plabel6, true, 3);
			GreenArray[5] = 1;
			setprocessor(Processor7, P7_N, Plabel7, true, 4);
			GreenArray[6] = 1;
			setprocessor(Processor9, P9_N, Plabel9, true, 5);
			GreenArray[8] = 1;
			setprocessor(Processor10, P10_N, Plabel10, true, 6);
			GreenArray[9] = 1;
			setprocessor(Processor11, P11_N, Plabel11, true, 7);
			GreenArray[10] = 1;
			setprocessor(Processor12, P12_N, Plabel12, true, 8);
			GreenArray[11] = 1;
			setprocessor(Processor13, P13_N, Plabel13, true, 9);
			GreenArray[12] = 1;
			setprocessor(Processor15, P15_N, Plabel15, true, 10);
			GreenArray[14] = 1;
			setprocessor(Processor16, P16_N, Plabel16, true, 11);
			GreenArray[15] = 1;
			setprocessor(Processor17, P17_N, Plabel17, true, 12);
			GreenArray[16] = 1;
			setprocessor(Processor19, P19_N, Plabel19, true, 13);
			GreenArray[18] = 1;
			break;
		case 15:
			setprocessor1(true, 0);
			setprocessor(Processor2, P2_N, Plabel2, true, 1);
			setprocessor(Processor4, P4_N, Plabel4, true, 2);
			setprocessor(Processor5, P5_N, Plabel5, true, 3);
			setprocessor(Processor6, P6_N, Plabel6, true, 4);
			setprocessor(Processor7, P7_N, Plabel7, true, 5);
			setprocessor(Processor8, P8_N, Plabel8, true, 6);
			setprocessor(Processor9, P9_N, Plabel9, true, 7);
			setprocessor(Processor13, P13_N, Plabel13, true, 8);
			setprocessor(Processor14, P14_N, Plabel14, true, 9);
			setprocessor(Processor15, P15_N, Plabel15, true, 10);
			setprocessor(Processor16, P16_N, Plabel16, true, 11);
			setprocessor(Processor17, P17_N, Plabel17, true, 12);
			setprocessor(Processor18, P18_N, Plabel18, true, 13);
			setprocessor(Processor19, P19_N, Plabel19, true, 14);
			for (int i = 0; i < 20; i++) {
				GreenArray[i] = 1;
			}
			GreenArray[2] = -1;
			GreenArray[9] = -1;
			GreenArray[10] = -1;
			GreenArray[11] = -1;
			GreenArray[19] = -1;
			break;
		case 16:
			setprocessor1(true, 0);
			setprocessor(Processor2, P2_N, Plabel2, true, 1);
			setprocessor(Processor4, P4_N, Plabel4, true, 2);
			setprocessor(Processor5, P5_N, Plabel5, true, 3);
			setprocessor(Processor6, P6_N, Plabel6, true, 4);
			setprocessor(Processor7, P7_N, Plabel7, true, 5);
			setprocessor(Processor8, P8_N, Plabel8, true, 6);
			setprocessor(Processor9, P9_N, Plabel9, true, 7);
			setprocessor(Processor11, P11_N, Plabel11, true, 8);
			setprocessor(Processor13, P13_N, Plabel13, true, 9);
			setprocessor(Processor14, P14_N, Plabel14, true, 10);
			setprocessor(Processor15, P15_N, Plabel15, true, 11);
			setprocessor(Processor16, P16_N, Plabel16, true, 12);
			setprocessor(Processor17, P17_N, Plabel17, true, 13);
			setprocessor(Processor18, P18_N, Plabel18, true, 14);
			setprocessor(Processor19, P19_N, Plabel19, true, 15);
			for (int i = 0; i < 20; i++) {
				GreenArray[i] = 1;
			}
			GreenArray[2] = -1;
			GreenArray[9] = -1;
			GreenArray[11] = -1;
			GreenArray[19] = -1;
			break;
		case 17:
			setprocessor1(true, 0);
			setprocessor(Processor2, P2_N, Plabel2, true, 1);
			setprocessor(Processor3, P3_N, Plabel3, true, 2);
			setprocessor(Processor4, P4_N, Plabel4, true, 3);
			setprocessor(Processor5, P5_N, Plabel5, true, 4);
			setprocessor(Processor6, P6_N, Plabel6, true, 5);
			setprocessor(Processor7, P7_N, Plabel7, true, 6);
			setprocessor(Processor8, P8_N, Plabel8, true, 7);
			setprocessor(Processor9, P9_N, Plabel9, true, 8);
			setprocessor(Processor13, P13_N, Plabel13, true, 9);
			setprocessor(Processor14, P14_N, Plabel14, true, 10);
			setprocessor(Processor15, P15_N, Plabel15, true, 11);
			setprocessor(Processor16, P16_N, Plabel16, true, 12);
			setprocessor(Processor17, P17_N, Plabel17, true, 13);
			setprocessor(Processor18, P18_N, Plabel18, true, 14);
			setprocessor(Processor19, P19_N, Plabel19, true, 15);
			setprocessor(Processor20, P20_N, Plabel20, true, 16);
			for (int i = 0; i < 20; i++) {
				GreenArray[i] = 1;
			}
			GreenArray[9] = -1;
			GreenArray[10] = -1;
			GreenArray[11] = -1;
			break;
		case 18:
			setprocessor1(true, 0);
			setprocessor(Processor2, P2_N, Plabel2, true, 1);
			setprocessor(Processor3, P3_N, Plabel3, true, 2);
			setprocessor(Processor4, P4_N, Plabel4, true, 3);
			setprocessor(Processor5, P5_N, Plabel5, true, 4);
			setprocessor(Processor6, P6_N, Plabel6, true, 5);
			setprocessor(Processor7, P7_N, Plabel7, true, 6);
			setprocessor(Processor8, P8_N, Plabel8, true, 7);
			setprocessor(Processor9, P9_N, Plabel9, true, 8);
			setprocessor(Processor11, P11_N, Plabel11, true, 9);
			setprocessor(Processor13, P13_N, Plabel13, true, 10);
			setprocessor(Processor14, P14_N, Plabel14, true, 11);
			setprocessor(Processor15, P15_N, Plabel15, true, 12);
			setprocessor(Processor16, P16_N, Plabel16, true, 13);
			setprocessor(Processor17, P17_N, Plabel17, true, 14);
			setprocessor(Processor18, P18_N, Plabel18, true, 15);
			setprocessor(Processor19, P19_N, Plabel19, true, 16);
			setprocessor(Processor20, P20_N, Plabel20, true, 17);
			for (int i = 0; i < 20; i++) {
				GreenArray[i] = 1;
			}
			GreenArray[9] = -1;
			GreenArray[11] = -1;
			break;
		case 19:
			setprocessor1(true, 0);
			setprocessor(Processor2, P2_N, Plabel2, true, 1);
			setprocessor(Processor3, P3_N, Plabel3, true, 2);
			setprocessor(Processor4, P4_N, Plabel4, true, 3);
			setprocessor(Processor5, P5_N, Plabel5, true, 4);
			setprocessor(Processor6, P6_N, Plabel6, true, 5);
			setprocessor(Processor7, P7_N, Plabel7, true, 6);
			setprocessor(Processor8, P8_N, Plabel8, true, 7);
			setprocessor(Processor9, P9_N, Plabel9, true, 8);
			setprocessor(Processor10, P10_N, Plabel10, true, 9);
			setprocessor(Processor12, P12_N, Plabel12, true, 10);
			setprocessor(Processor13, P13_N, Plabel13, true, 11);
			setprocessor(Processor14, P14_N, Plabel14, true, 12);
			setprocessor(Processor15, P15_N, Plabel15, true, 13);
			setprocessor(Processor16, P16_N, Plabel16, true, 14);
			setprocessor(Processor17, P17_N, Plabel17, true, 15);
			setprocessor(Processor18, P18_N, Plabel18, true, 16);
			setprocessor(Processor19, P19_N, Plabel19, true, 17);
			setprocessor(Processor20, P20_N, Plabel20, true, 18);
			for (int i = 0; i < 20; i++) {
				GreenArray[i] = 1;
			}
			GreenArray[10] = -1;
			break;
		case 20:
			setprocessor1(true, 0);
			setprocessor(Processor2, P2_N, Plabel2, true, 1);
			setprocessor(Processor3, P3_N, Plabel3, true, 2);
			setprocessor(Processor4, P4_N, Plabel4, true, 3);
			setprocessor(Processor5, P5_N, Plabel5, true, 4);
			setprocessor(Processor6, P6_N, Plabel6, true, 5);
			setprocessor(Processor7, P7_N, Plabel7, true, 6);
			setprocessor(Processor8, P8_N, Plabel8, true, 7);
			setprocessor(Processor9, P9_N, Plabel9, true, 8);
			setprocessor(Processor10, P10_N, Plabel10, true, 9);
			setprocessor(Processor11, P11_N, Plabel11, true, 10);
			setprocessor(Processor12, P12_N, Plabel12, true, 11);
			setprocessor(Processor13, P13_N, Plabel13, true, 12);
			setprocessor(Processor14, P14_N, Plabel14, true, 13);
			setprocessor(Processor15, P15_N, Plabel15, true, 14);
			setprocessor(Processor16, P16_N, Plabel16, true, 15);
			setprocessor(Processor17, P17_N, Plabel17, true, 16);
			setprocessor(Processor18, P18_N, Plabel18, true, 17);
			setprocessor(Processor19, P19_N, Plabel19, true, 18);
			setprocessor(Processor20, P20_N, Plabel20, true, 19);
			for (int i = 0; i < 20; i++) {
				GreenArray[i] = 1;
			}
			break;
		}

	}

	private void startUpdatingNumbers() {
		executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(() -> {
			// Perform the time-consuming task here
			// ...

			// Update the UI on the JavaFX Application Thread
			Platform.runLater(() -> {
				// Update the numberLabel with the new value
				runProcessors();
			});
		}, 0, 1500, TimeUnit.MILLISECONDS);
	}

	private void stopUpdatingNumbers() {
		if (executorService != null) {
			executorService.shutdownNow();
		}
	}

}
