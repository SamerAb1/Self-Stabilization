package gui;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class ThirdAlgorithm_Controller implements Initializable {
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
	boolean changeDisplay = true;
	boolean autobtn_Pause = false;
	SharedData sharedData;
	ActionEvent tempevent;
	private ScheduledExecutorService executorService;

	@FXML
	private Label y_Func;

	@FXML
	private Polyline Larrow_1;

	@FXML
	private Polyline Larrow_2;

	@FXML
	private Polyline Larrow_3;

	@FXML
	private Polyline Larrow_4;

	@FXML
	private Polyline Larrow_5;

	@FXML
	private Polyline Larrow_6;

	@FXML
	private Polyline Larrow_7;

	@FXML
	private Polyline Larrow_8;

	@FXML
	private Polyline Larrow_9;

	@FXML
	private Polyline Rarrow_1;

	@FXML
	private Polyline Rarrow_2;

	@FXML
	private Polyline Rarrow_3;

	@FXML
	private Polyline Rarrow_4;

	@FXML
	private Polyline Rarrow_5;

	@FXML
	private Polyline Rarrow_6;

	@FXML
	private Polyline Rarrow_7;

	@FXML
	private Polyline Rarrow_8;

	@FXML
	private Polyline Rarrow_9;

	@FXML
	private ToggleButton Change_Display;

	@FXML
	private Button Exit_button;

	@FXML
	private Label N_value_label;

	@FXML
	private Button NextStep_button;

	@FXML
	private Label P10_N;

	@FXML
	private Label P10_N_String;

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
	private Label P1_N;

	@FXML
	private Label P1_N_String;

	@FXML
	private Label P20_N;

	@FXML
	private Label P2_N;

	@FXML
	private Label P2_N_String;

	@FXML
	private Label P3_N;

	@FXML
	private Label P3_N_String;

	@FXML
	private Label P4_N;

	@FXML
	private Label P4_N_String;

	@FXML
	private Label P5_N;

	@FXML
	private Label P5_N_String;

	@FXML
	private Label P6_N;

	@FXML
	private Label P6_N_String;

	@FXML
	private Label P7_N;

	@FXML
	private Label P7_N_String;

	@FXML
	private Label P8_N;

	@FXML
	private Label P8_N_String;

	@FXML
	private Label P9_N;

	@FXML
	private Label P9_N_String;

	@FXML
	private Label Plabel1;

	@FXML
	private Label Plabel10;

	@FXML
	private Label Plabel10_String;

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
	private Label Plabel1_String;

	@FXML
	private Label Plabel2;

	@FXML
	private Label Plabel20;

	@FXML
	private Label Plabel2_String;

	@FXML
	private Label Plabel3;

	@FXML
	private Label Plabel3_String;

	@FXML
	private Label Plabel4;

	@FXML
	private Label Plabel4_String;

	@FXML
	private Label Plabel5;

	@FXML
	private Label Plabel5_String;

	@FXML
	private Label Plabel6;

	@FXML
	private Label Plabel6_String;

	@FXML
	private Label Plabel7;

	@FXML
	private Label Plabel7_String;

	@FXML
	private Label Plabel8;

	@FXML
	private Label Plabel8_String;

	@FXML
	private Label Plabel9;

	@FXML
	private Label Plabel9_String;

	@FXML
	private Circle Processor10_Ring;

	@FXML
	private Circle Processor10_String;

	@FXML
	private Circle Processor11_Ring;

	@FXML
	private Circle Processor12_Ring;

	@FXML
	private Circle Processor13_Ring;

	@FXML
	private Circle Processor14_Ring;

	@FXML
	private Circle Processor15_Ring;

	@FXML
	private Circle Processor16_Ring;

	@FXML
	private Circle Processor17_Ring;

	@FXML
	private Circle Processor18_Ring;

	@FXML
	private Circle Processor19_Ring;

	@FXML
	private Circle Processor1_Ring;

	@FXML
	private Circle Processor1_String;

	@FXML
	private Circle Processor20_Ring;

	@FXML
	private Circle Processor2_Ring;

	@FXML
	private Circle Processor2_String;

	@FXML
	private Circle Processor3_Ring;

	@FXML
	private Circle Processor3_String;

	@FXML
	private Circle Processor4_Ring;

	@FXML
	private Circle Processor4_String;

	@FXML
	private Circle Processor5_Ring;

	@FXML
	private Circle Processor5_String;

	@FXML
	private Circle Processor6_Ring;

	@FXML
	private Circle Processor6_String;

	@FXML
	private Circle Processor7_Ring;

	@FXML
	private Circle Processor7_String;

	@FXML
	private Circle Processor8_Ring;

	@FXML
	private Circle Processor8_String;

	@FXML
	private Circle Processor9_Ring;

	@FXML
	private Circle Processor9_String;

	@FXML
	private ToggleButton automatic_button;

	@FXML
	void Exit_button(ActionEvent event) throws IOException {
		System.out.println("Exit");
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
		Pane root = loader.load(getClass().getResource("/gui/ThirdAlgorithmValues.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("First Algorithm Values");
		primaryStage.setScene(scene);
		primaryStage.show();
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
					setColor(getProcC(Proc2, true), Yellow);
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
					setColor(getProcC(Proc2, false), Yellow);
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
	void Processor3_click(MouseEvent event) {
		int n = Integer.parseInt(P3_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor5_click(MouseEvent event) {
		int n = Integer.parseInt(P5_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor7_click(MouseEvent event) {
		int n = Integer.parseInt(P7_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor9_click(MouseEvent event) {
		int n = Integer.parseInt(P9_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor11_click(MouseEvent event) {
		int n = Integer.parseInt(P11_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor13_click(MouseEvent event) {
		int n = Integer.parseInt(P13_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor15_click(MouseEvent event) {
		int n = Integer.parseInt(P15_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor17_click(MouseEvent event) {
		int n = Integer.parseInt(P17_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor19_click(MouseEvent event) {
		int n = Integer.parseInt(P19_N.getText());
		changetoGreen(n - 1);
	}

	@FXML
	void Processor1_click_String(MouseEvent event) {
		int n = Integer.parseInt(P1_N_String.getText());
		changetoGreen_String(n - 1);
	}

	@FXML
	void Processor2_click_String(MouseEvent event) {
		int n = Integer.parseInt(P2_N_String.getText());
		changetoGreen_String(n - 1);
	}

	@FXML
	void Processor3_click_String(MouseEvent event) {
		int n = Integer.parseInt(P3_N_String.getText());
		changetoGreen_String(n - 1);
	}

	@FXML
	void Processor4_click_String(MouseEvent event) {
		int n = Integer.parseInt(P4_N_String.getText());
		changetoGreen_String(n - 1);
	}

	@FXML
	void Processor5_click_String(MouseEvent event) {
		int n = Integer.parseInt(P5_N_String.getText());
		changetoGreen_String(n - 1);
	}

	@FXML
	void Processor6_click_String(MouseEvent event) {
		int n = Integer.parseInt(P6_N_String.getText());
		changetoGreen_String(n - 1);
	}

	@FXML
	void Processor7_click_String(MouseEvent event) {
		int n = Integer.parseInt(P7_N_String.getText());
		changetoGreen_String(n - 1);
	}

	@FXML
	void Processor8_click_String(MouseEvent event) {
		int n = Integer.parseInt(P8_N_String.getText());
		changetoGreen_String(n - 1);
	}

	@FXML
	void Processor9_click_String(MouseEvent event) {
		int n = Integer.parseInt(P9_N_String.getText());
		changetoGreen_String(n - 1);
	}

	@FXML
	void Processor10_click_String(MouseEvent event) {
		int n = Integer.parseInt(P10_N_String.getText());
		changetoGreen_String(n - 1);
	}

	private void runProcessors() {
		for (int i = 0; i < 10; i++) {
			if (PrivilegeArray[i] == 2) {
				if (i == 0) {
					ProcessorsArray[i] = (ProcessorsArray[i] + 2) % 3;
					setProcsbuttons(N);
					pickProcessorExe();
					break;
				}
				if (i == (N - 1)) {
					ProcessorsArray[i] = (ProcessorsArray[0] + 1) % 3;
					setProcsbuttons(N);
					pickProcessorExe();
				} else {
					ProcessorsArray[i] = (ProcessorsArray[i] + 1) % 3;
					setProcsbuttons(N);
					pickProcessorExe();
					break;
				}
			}
		}
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

	@FXML
	void NextStep_button(ActionEvent event) {
		runProcessors();
	}

	@FXML
	void Change_Display(ActionEvent event) {
		changeDisplay = !changeDisplay;
		if (changeDisplay) {
			Change_Display.setText("RING");
			setfirstscreen();
		} else {
			Change_Display.setText("STRING");
			setfirstscreen();
		}

	}

	void setprocessor1(boolean value, int i) {
		Processor1_Ring.setVisible(value);
		Plabel1.setVisible(value);
		P1_N.setVisible(value);
		Plabel1.setText(Integer.toString(ProcessorsArray[i]));
		if ((ProcessorsArray[0] + 1) % 3 == ProcessorsArray[1]) {
			setColor(Processor1_Ring, Yellow);
			PrivilegeArray[0] = 1;
		} else {
			setColor(Processor1_Ring, Black);
			PrivilegeArray[0] = 0;
		}
	}

	private void setprocessor1_String(boolean value, int i) {
		Processor1_String.setVisible(value);
		Plabel1_String.setVisible(value);
		P1_N_String.setVisible(value);
		Plabel1_String.setText(Integer.toString(ProcessorsArray[i]));
		if ((ProcessorsArray[0] + 1) % 3 == ProcessorsArray[1]) {
			setColor(Processor1_String, Yellow);
			PrivilegeArray[0] = 1;
		} else {
			setColor(Processor1_String, Black);
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
		if ((i + 1) != N) {
			if (check_Privilege_proc(i)) {
				setColor(Processor, Yellow);
				PrivilegeArray[i] = 1;
			} else {
				setColor(Processor, Black);
				PrivilegeArray[i] = 0;
			}
		}
		if ((i + 1) == N) {
			if (check_Privilege_LastProc(i)) {
				setColor(Processor, Yellow);
				PrivilegeArray[i] = 1;
			} else {
				setColor(Processor, Black);
				PrivilegeArray[i] = 0;
			}
		}

	}

	void setColor(Circle Processor, int[] Color1) {
		Processor.setStrokeWidth(5);
		Processor.setStroke(Color.rgb(Color1[0], Color1[1], Color1[2]));
	}

	void pickProcessorExe() {
		int n, k = 0;
		int counter;
		boolean stopper = false;
		Random rand = new Random();

		do {
			n = rand.nextInt((N) - 0) + 0;
			counter = n + 1;
			for (int i = 0; i < 20; i++) {
				if (GreenArray[i] == 1) {
					--counter;
				}
				if (counter == 0) {
					k = i;
					i = 20;
				}
			}
			if (PrivilegeArray[n] == 1) {
				setGreen(k);
				PrivilegeArray[n] = 2;
				stopper = true;
			}

		} while (!stopper);
	}

	private void setfirstscreen() {
		setprocessor1(false, 0);
		// setprocessor(Processor2_Ring, P2_N, Plabel2, false, 1);
		setprocessor(Processor3_Ring, P3_N, Plabel3, false, 2);
		// setprocessor(Processor4_Ring, P4_N, Plabel4, false, 3);
		setprocessor(Processor5_Ring, P5_N, Plabel5, false, 4);
		// setprocessor(Processor6_Ring, P6_N, Plabel6, false, 5);
		setprocessor(Processor7_Ring, P7_N, Plabel7, false, 6);
		// setprocessor(Processor8_Ring, P8_N, Plabel8, false, 7);
		setprocessor(Processor9_Ring, P9_N, Plabel9, false, 8);
		// setprocessor(Processor10_Ring, P10_N, Plabel10, false, 9);
		setprocessor(Processor11_Ring, P11_N, Plabel11, false, 10);
		// setprocessor(Processor12_Ring, P12_N, Plabel12, false, 11);
		setprocessor(Processor13_Ring, P13_N, Plabel13, false, 12);
		// setprocessor(Processor14_Ring, P14_N, Plabel14, false, 13);
		setprocessor(Processor15_Ring, P15_N, Plabel15, false, 14);
		// setprocessor(Processor16_Ring, P16_N, Plabel16, false, 15);
		setprocessor(Processor17_Ring, P17_N, Plabel17, false, 16);
		// setprocessor(Processor18_Ring, P18_N, Plabel18, false, 17);
		setprocessor(Processor19_Ring, P19_N, Plabel19, false, 18);
		// setprocessor(Processor20_Ring, P20_N, Plabel20, false, 19);
		setprocessor1_String(false, 0);
		setprocessor(Processor2_String, P2_N_String, Plabel2_String, false, 1);
		setprocessor(Processor3_String, P3_N_String, Plabel3_String, false, 2);
		setprocessor(Processor4_String, P4_N_String, Plabel4_String, false, 3);
		setprocessor(Processor5_String, P5_N_String, Plabel5_String, false, 4);
		setprocessor(Processor6_String, P6_N_String, Plabel6_String, false, 5);
		setprocessor(Processor7_String, P7_N_String, Plabel7_String, false, 6);
		setprocessor(Processor8_String, P8_N_String, Plabel8_String, false, 7);
		setprocessor(Processor9_String, P9_N_String, Plabel9_String, false, 8);
		setprocessor(Processor10_String, P10_N_String, Plabel10_String, false, 9);
		getarrowLabel(1, true).setVisible(false);
		getarrowLabel(1, false).setVisible(false);
		getarrowLabel(2, true).setVisible(false);
		getarrowLabel(2, false).setVisible(false);
		getarrowLabel(3, true).setVisible(false);
		getarrowLabel(3, false).setVisible(false);
		getarrowLabel(4, true).setVisible(false);
		getarrowLabel(4, false).setVisible(false);
		getarrowLabel(5, true).setVisible(false);
		getarrowLabel(5, false).setVisible(false);
		getarrowLabel(6, true).setVisible(false);
		getarrowLabel(6, false).setVisible(false);
		getarrowLabel(7, true).setVisible(false);
		getarrowLabel(7, false).setVisible(false);
		getarrowLabel(8, true).setVisible(false);
		getarrowLabel(8, false).setVisible(false);
		getarrowLabel(9, true).setVisible(false);
		getarrowLabel(9, false).setVisible(false);

		for (int i = 0; i < 20; i++) {
			PrivilegeArray[i] = -1;
			ProcArray[i] = -1;
			GreenArray[i] = -1;
		}
		if (changeDisplay) {
			Change_Display.setText("RING");
		} else {
			Change_Display.setText("STRING");
		}
		setProcsbuttons(N);
		pickProcessorExe();

//		System.out.println("Privilege array test:");
//		for (int i = 0; i < 20; i++) {
//			System.out.print("," + PrivilegeArray[i]);
//		}
//		System.out.println();
//
//
//
//		for (int i = 0; i < N; i++) {
//			ProcArray[i] = ProcessorsArray[i];
//		}
//		System.out.println("Privilege array test:");
//		for (int i = 0; i < 20; i++) {
//			System.out.print("," + PrivilegeArray[i]);
//		}
//		System.out.println();
//		for (int i = 0; i < 20; i++) {
//			System.out.print(ProcArray[i] + ",");
//		}
//		System.out.print("\n");
//
//		System.out.println("Green array test:");
//		for (int i = 0; i < 20; i++) {
//			System.out.print("," + GreenArray[i]);
//		}
//		System.out.println();
	}

	void setGreen(int i) {
		if (changeDisplay) {
			switch (i + 1) {
			case 1:
				setColor(Processor1_Ring, Green);
				break;
			case 2:
				setColor(Processor2_Ring, Green);
				break;
			case 3:
				setColor(Processor3_Ring, Green);
				break;
			case 4:
				setColor(Processor4_Ring, Green);
				break;
			case 5:
				setColor(Processor5_Ring, Green);
				break;
			case 6:
				setColor(Processor6_Ring, Green);
				break;
			case 7:
				setColor(Processor7_Ring, Green);
				break;
			case 8:
				setColor(Processor8_Ring, Green);
				break;
			case 9:
				setColor(Processor9_Ring, Green);
				break;
			case 10:
				setColor(Processor10_Ring, Green);
				break;
			case 11:
				setColor(Processor11_Ring, Green);
				break;
			case 12:
				setColor(Processor12_Ring, Green);
				break;
			case 13:
				setColor(Processor13_Ring, Green);
				break;
			case 14:
				setColor(Processor14_Ring, Green);
				break;
			case 15:
				setColor(Processor15_Ring, Green);
				break;
			case 16:
				setColor(Processor16_Ring, Green);
				break;
			case 17:
				setColor(Processor17_Ring, Green);
				break;
			case 18:
				setColor(Processor18_Ring, Green);
				break;
			case 19:
				setColor(Processor19_Ring, Green);
				break;
			case 20:
				setColor(Processor20_Ring, Green);
				break;
			}
		} else {
			switch (i + 1) {
			case 1:
				setColor(Processor1_String, Green);
				break;
			case 2:
				setColor(Processor2_String, Green);
				break;
			case 3:
				setColor(Processor3_String, Green);
				break;
			case 4:
				setColor(Processor4_String, Green);
				break;
			case 5:
				setColor(Processor5_String, Green);
				break;
			case 6:
				setColor(Processor6_String, Green);
				break;
			case 7:
				setColor(Processor7_String, Green);
				break;
			case 8:
				setColor(Processor8_String, Green);
				break;
			case 9:
				setColor(Processor9_String, Green);
				break;
			case 10:
				setColor(Processor10_String, Green);
				break;
			}
		}
	}

	Circle getProcC(int i, boolean b) {
		switch (i + 1) {
		case 1:
			if (b) {
				return Processor1_Ring;
			} else {
				return Processor1_String;
			}
		case 2:
			if (b) {
				return Processor2_Ring;
			} else {
				return Processor2_String;
			}
		case 3:
			if (b) {
				return Processor3_Ring;
			} else {
				return Processor3_String;
			}
		case 4:
			if (b) {
				return Processor4_Ring;
			} else {
				return Processor4_String;
			}
		case 5:
			if (b) {
				return Processor5_Ring;
			} else {
				return Processor5_String;
			}
		case 6:
			if (b) {
				return Processor6_Ring;
			} else {
				return Processor6_String;
			}
		case 7:
			if (b) {
				return Processor7_Ring;
			} else {
				return Processor7_String;
			}
		case 8:
			if (b) {
				return Processor8_Ring;
			} else {
				return Processor8_String;
			}
		case 9:
			if (b) {
				return Processor9_Ring;
			} else {
				return Processor9_String;
			}
		case 10:
			if (b) {
				return Processor10_Ring;
			} else {
				return Processor10_String;
			}
		case 11:
			return Processor11_Ring;
		case 12:
			return Processor12_Ring;
		case 13:
			return Processor13_Ring;
		case 14:
			return Processor14_Ring;
		case 15:
			return Processor15_Ring;
		case 16:
			return Processor16_Ring;
		case 17:
			return Processor17_Ring;
		case 18:
			return Processor18_Ring;
		case 19:
			return Processor19_Ring;
		case 20:
			return Processor20_Ring;
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
		ProcessorsArray = sharedData.getN_vals_array();
		N = Integer.parseInt(N_value);
		K = Integer.parseInt(K_value);
		changeDisplay = sharedData.isTSM_ring();
		setfirstscreen();

	}

	private void setValues() {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sharedData = SharedData.getInstance();
		getValues();

	}

	private void setProcsbuttons(int N) {
		if (changeDisplay) {
			switch (N) {
			case 2:
				setprocessor1(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor2_Ring, P2_N, Plabel2, true, 1);
				GreenArray[1] = 1;
				Processor2_Ring.setFill(Color.rgb(126, 132, 140));
				break;
			case 3:
				setprocessor1(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor5_Ring, P5_N, Plabel5, true, 1);
				GreenArray[4] = 1;
				setprocessor(Processor17_Ring, P17_N, Plabel17, true, 2);
				GreenArray[16] = 1;
				Processor17_Ring.setFill(Color.rgb(126, 132, 140));
				break;
			case 4:
				setprocessor1(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor5_Ring, P5_N, Plabel5, true, 1);
				GreenArray[4] = 1;
				setprocessor(Processor11_Ring, P11_N, Plabel11, true, 2);
				GreenArray[10] = 1;
				setprocessor(Processor17_Ring, P17_N, Plabel17, true, 3);
				GreenArray[16] = 1;
				Processor17_Ring.setFill(Color.rgb(126, 132, 140));
				break;
			case 5:
				setprocessor1(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor5_Ring, P5_N, Plabel5, true, 1);
				GreenArray[4] = 1;
				setprocessor(Processor7_Ring, P7_N, Plabel7, true, 2);
				GreenArray[6] = 1;
				setprocessor(Processor15_Ring, P15_N, Plabel15, true, 3);
				GreenArray[14] = 1;
				setprocessor(Processor17_Ring, P17_N, Plabel17, true, 4);
				GreenArray[16] = 1;
				Processor17_Ring.setFill(Color.rgb(126, 132, 140));
				break;
			case 6:
				setprocessor1(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor5_Ring, P5_N, Plabel5, true, 1);
				GreenArray[4] = 1;
				setprocessor(Processor7_Ring, P7_N, Plabel7, true, 2);
				GreenArray[6] = 1;
				setprocessor(Processor11_Ring, P11_N, Plabel11, true, 3);
				GreenArray[10] = 1;
				setprocessor(Processor15_Ring, P15_N, Plabel15, true, 4);
				GreenArray[14] = 1;
				setprocessor(Processor17_Ring, P17_N, Plabel17, true, 5);
				GreenArray[16] = 1;
				Processor19_Ring.setFill(Color.rgb(126, 132, 140));
				break;
			case 7:
				setprocessor1(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor3_Ring, P3_N, Plabel3, true, 1);
				GreenArray[2] = 1;
				setprocessor(Processor5_Ring, P5_N, Plabel5, true, 2);
				GreenArray[4] = 1;
				setprocessor(Processor7_Ring, P7_N, Plabel7, true, 3);
				GreenArray[6] = 1;
				setprocessor(Processor15_Ring, P15_N, Plabel15, true, 4);
				GreenArray[14] = 1;
				setprocessor(Processor17_Ring, P17_N, Plabel17, true, 5);
				GreenArray[16] = 1;
				setprocessor(Processor19_Ring, P19_N, Plabel19, true, 6);
				GreenArray[18] = 1;
				Processor19_Ring.setFill(Color.rgb(126, 132, 140));
				break;
			case 8:
				setprocessor1(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor3_Ring, P3_N, Plabel3, true, 1);
				GreenArray[2] = 1;
				setprocessor(Processor5_Ring, P5_N, Plabel5, true, 2);
				GreenArray[4] = 1;
				setprocessor(Processor7_Ring, P7_N, Plabel7, true, 3);
				GreenArray[6] = 1;
				setprocessor(Processor11_Ring, P11_N, Plabel11, true, 4);
				GreenArray[10] = 1;
				setprocessor(Processor15_Ring, P15_N, Plabel15, true, 5);
				GreenArray[14] = 1;
				setprocessor(Processor17_Ring, P17_N, Plabel17, true, 6);
				GreenArray[16] = 1;
				setprocessor(Processor19_Ring, P19_N, Plabel19, true, 7);
				GreenArray[18] = 1;
				Processor19_Ring.setFill(Color.rgb(126, 132, 140));
				break;
			case 9:
				setprocessor1(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor3_Ring, P3_N, Plabel3, true, 1);
				GreenArray[2] = 1;
				setprocessor(Processor5_Ring, P5_N, Plabel5, true, 2);
				GreenArray[4] = 1;
				setprocessor(Processor7_Ring, P7_N, Plabel7, true, 3);
				GreenArray[6] = 1;
				setprocessor(Processor9_Ring, P9_N, Plabel9, true, 4);
				GreenArray[8] = 1;
				setprocessor(Processor13_Ring, P13_N, Plabel13, true, 5);
				GreenArray[12] = 1;
				setprocessor(Processor15_Ring, P15_N, Plabel15, true, 6);
				GreenArray[14] = 1;
				setprocessor(Processor17_Ring, P17_N, Plabel17, true, 7);
				GreenArray[16] = 1;
				setprocessor(Processor19_Ring, P19_N, Plabel19, true, 8);
				GreenArray[18] = 1;
				Processor19_Ring.setFill(Color.rgb(126, 132, 140));
				break;
			case 10:
				setprocessor1(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor3_Ring, P3_N, Plabel3, true, 1);
				GreenArray[2] = 1;
				setprocessor(Processor5_Ring, P5_N, Plabel5, true, 2);
				GreenArray[4] = 1;
				setprocessor(Processor7_Ring, P7_N, Plabel7, true, 3);
				GreenArray[6] = 1;
				setprocessor(Processor9_Ring, P9_N, Plabel9, true, 4);
				GreenArray[8] = 1;
				setprocessor(Processor11_Ring, P11_N, Plabel11, true, 5);
				GreenArray[10] = 1;
				setprocessor(Processor13_Ring, P13_N, Plabel13, true, 6);
				GreenArray[12] = 1;
				setprocessor(Processor15_Ring, P15_N, Plabel15, true, 7);
				GreenArray[14] = 1;
				setprocessor(Processor17_Ring, P17_N, Plabel17, true, 8);
				GreenArray[16] = 1;
				setprocessor(Processor19_Ring, P19_N, Plabel19, true, 9);
				GreenArray[18] = 1;
				Processor19_Ring.setFill(Color.rgb(126, 132, 140));
				break;
			}
		} else {
			switch (N) {
			case 2:
				setprocessor1_String(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor2_String, P2_N_String, Plabel2_String, true, 1);
				GreenArray[1] = 1;
				Processor2_String.setFill(Color.rgb(126, 132, 140));
				setArrows(2);
				break;
			case 3:
				setprocessor1_String(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor2_String, P2_N_String, Plabel2_String, true, 1);
				GreenArray[1] = 1;
				setprocessor(Processor3_String, P3_N_String, Plabel3_String, true, 2);
				GreenArray[2] = 1;
				Processor3_String.setFill(Color.rgb(126, 132, 140));
				setArrows(3);
				break;
			case 4:
				setprocessor1_String(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor2_String, P2_N_String, Plabel2_String, true, 1);
				GreenArray[1] = 1;
				setprocessor(Processor3_String, P3_N_String, Plabel3_String, true, 2);
				GreenArray[2] = 1;
				setprocessor(Processor4_String, P4_N_String, Plabel4_String, true, 3);
				GreenArray[3] = 1;
				Processor4_String.setFill(Color.rgb(126, 132, 140));
				setArrows(4);
				break;
			case 5:
				setprocessor1_String(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor2_String, P2_N_String, Plabel2_String, true, 1);
				GreenArray[1] = 1;
				setprocessor(Processor3_String, P3_N_String, Plabel3_String, true, 2);
				GreenArray[2] = 1;
				setprocessor(Processor4_String, P4_N_String, Plabel4_String, true, 3);
				GreenArray[3] = 1;
				setprocessor(Processor5_String, P5_N_String, Plabel5_String, true, 4);
				GreenArray[4] = 1;
				Processor4_String.setFill(Color.rgb(126, 132, 140));
				setArrows(5);
				break;
			case 6:
				setprocessor1_String(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor2_String, P2_N_String, Plabel2_String, true, 1);
				GreenArray[1] = 1;
				setprocessor(Processor3_String, P3_N_String, Plabel3_String, true, 2);
				GreenArray[2] = 1;
				setprocessor(Processor4_String, P4_N_String, Plabel4_String, true, 3);
				GreenArray[3] = 1;
				setprocessor(Processor5_String, P5_N_String, Plabel5_String, true, 4);
				GreenArray[4] = 1;
				setprocessor(Processor6_String, P6_N_String, Plabel6_String, true, 5);
				GreenArray[5] = 1;
				Processor6_String.setFill(Color.rgb(126, 132, 140));
				setArrows(6);
				break;
			case 7:
				setprocessor1_String(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor2_String, P2_N_String, Plabel2_String, true, 1);
				GreenArray[1] = 1;
				setprocessor(Processor3_String, P3_N_String, Plabel3_String, true, 2);
				GreenArray[2] = 1;
				setprocessor(Processor4_String, P4_N_String, Plabel4_String, true, 3);
				GreenArray[3] = 1;
				setprocessor(Processor5_String, P5_N_String, Plabel5_String, true, 4);
				GreenArray[4] = 1;
				setprocessor(Processor6_String, P6_N_String, Plabel6_String, true, 5);
				GreenArray[5] = 1;
				setprocessor(Processor7_String, P7_N_String, Plabel7_String, true, 6);
				GreenArray[6] = 1;
				Processor7_String.setFill(Color.rgb(126, 132, 140));
				setArrows(7);
				break;
			case 8:
				setprocessor1_String(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor2_String, P2_N_String, Plabel2_String, true, 1);
				GreenArray[1] = 1;
				setprocessor(Processor3_String, P3_N_String, Plabel3_String, true, 2);
				GreenArray[2] = 1;
				setprocessor(Processor4_String, P4_N_String, Plabel4_String, true, 3);
				GreenArray[3] = 1;
				setprocessor(Processor5_String, P5_N_String, Plabel5_String, true, 4);
				GreenArray[4] = 1;
				setprocessor(Processor6_String, P6_N_String, Plabel6_String, true, 5);
				GreenArray[5] = 1;
				setprocessor(Processor7_String, P7_N_String, Plabel7_String, true, 6);
				GreenArray[6] = 1;
				setprocessor(Processor8_String, P8_N_String, Plabel8_String, true, 7);
				GreenArray[7] = 1;
				Processor8_String.setFill(Color.rgb(126, 132, 140));
				setArrows(8);
				break;
			case 9:
				setprocessor1_String(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor2_String, P2_N_String, Plabel2_String, true, 1);
				GreenArray[1] = 1;
				setprocessor(Processor3_String, P3_N_String, Plabel3_String, true, 2);
				GreenArray[2] = 1;
				setprocessor(Processor4_String, P4_N_String, Plabel4_String, true, 3);
				GreenArray[3] = 1;
				setprocessor(Processor5_String, P5_N_String, Plabel5_String, true, 4);
				GreenArray[4] = 1;
				setprocessor(Processor6_String, P6_N_String, Plabel6_String, true, 5);
				GreenArray[5] = 1;
				setprocessor(Processor7_String, P7_N_String, Plabel7_String, true, 6);
				GreenArray[6] = 1;
				setprocessor(Processor8_String, P8_N_String, Plabel8_String, true, 7);
				GreenArray[7] = 1;
				setprocessor(Processor9_String, P9_N_String, Plabel9_String, true, 8);
				GreenArray[8] = 1;
				Processor9_String.setFill(Color.rgb(126, 132, 140));
				setArrows(9);
				break;
			case 10:
				setprocessor1_String(true, 0);
				GreenArray[0] = 1;
				setprocessor(Processor2_String, P2_N_String, Plabel2_String, true, 1);
				GreenArray[1] = 1;
				setprocessor(Processor3_String, P3_N_String, Plabel3_String, true, 2);
				GreenArray[2] = 1;
				setprocessor(Processor4_String, P4_N_String, Plabel4_String, true, 3);
				GreenArray[3] = 1;
				setprocessor(Processor5_String, P5_N_String, Plabel5_String, true, 4);
				GreenArray[4] = 1;
				setprocessor(Processor6_String, P6_N_String, Plabel6_String, true, 5);
				GreenArray[5] = 1;
				setprocessor(Processor7_String, P7_N_String, Plabel7_String, true, 6);
				GreenArray[6] = 1;
				setprocessor(Processor8_String, P8_N_String, Plabel8_String, true, 7);
				GreenArray[7] = 1;
				setprocessor(Processor9_String, P9_N_String, Plabel9_String, true, 8);
				GreenArray[8] = 1;
				setprocessor(Processor10_String, P10_N_String, Plabel10_String, true, 9);
				GreenArray[9] = 1;
				Processor10_String.setFill(Color.rgb(126, 132, 140));
				setArrows(10);
				break;
			}
		}
	}

	void compareValues(int i, int j) {
		if (ProcessorsArray[i] == ((ProcessorsArray[j] + 1) % 3)) {
			getarrowLabel(i + 1, true).setVisible(true);
			getarrowLabel(i + 1, false).setVisible(false);
			return;
		}
		if (((ProcessorsArray[i] + 1) % 3) == ProcessorsArray[j]) {
			getarrowLabel(i + 1, false).setVisible(true);
			getarrowLabel(i + 1, true).setVisible(false);
			return;
		}
		if (ProcessorsArray[i] == ProcessorsArray[j]) {
			getarrowLabel(i + 1, false).setVisible(false);
			getarrowLabel(i + 1, true).setVisible(false);
		}

	}

	private void setArrows(int i) {
		switch (i) {
		case 2:
			compareValues(0, 1);
			break;
		case 3:
			compareValues(0, 1);
			compareValues(1, 2);
			break;
		case 4:
			compareValues(0, 1);
			compareValues(1, 2);
			compareValues(2, 3);
			break;
		case 5:
			compareValues(0, 1);
			compareValues(1, 2);
			compareValues(2, 3);
			compareValues(3, 4);
			break;
		case 6:
			compareValues(0, 1);
			compareValues(1, 2);
			compareValues(2, 3);
			compareValues(3, 4);
			compareValues(4, 5);
			break;
		case 7:
			compareValues(0, 1);
			compareValues(1, 2);
			compareValues(2, 3);
			compareValues(3, 4);
			compareValues(4, 5);
			compareValues(5, 6);
			break;
		case 8:
			compareValues(0, 1);
			compareValues(1, 2);
			compareValues(2, 3);
			compareValues(3, 4);
			compareValues(4, 5);
			compareValues(5, 6);
			compareValues(6, 7);
			break;
		case 9:
			compareValues(0, 1);
			compareValues(1, 2);
			compareValues(2, 3);
			compareValues(3, 4);
			compareValues(4, 5);
			compareValues(5, 6);
			compareValues(6, 7);
			compareValues(7, 8);
			break;
		case 10:
			compareValues(0, 1);
			compareValues(1, 2);
			compareValues(2, 3);
			compareValues(3, 4);
			compareValues(4, 5);
			compareValues(5, 6);
			compareValues(6, 7);
			compareValues(7, 8);
			compareValues(8, 9);
			break;

		}

	}

	boolean check_Privilege_LastProc(int i) {
		if (((ProcessorsArray[0]) == ProcessorsArray[i - 1]) && (ProcessorsArray[i] != (ProcessorsArray[0] + 1) % 3)) {
			return true;
		} else {
			return false;
		}
	}

	boolean check_Privilege_proc(int i) {
		if ((((ProcessorsArray[i] + 1) % 3) == (ProcessorsArray[i - 1]))
				|| (((ProcessorsArray[i] + 1)) % 3 == (ProcessorsArray[i + 1]))) {
			return true;
		} else {
			return false;
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
		}, 0, 2, TimeUnit.SECONDS);
	}

	private void stopUpdatingNumbers() {
		if (executorService != null) {
			executorService.shutdownNow();
		}
	}

	Polyline getarrowLabel(int i, boolean b) {

		switch (i) {
		case 1:
			if (b)
				return Rarrow_1;
			else
				return Larrow_1;
		case 2:
			if (b)
				return Rarrow_2;
			else
				return Larrow_2;
		case 3:
			if (b)
				return Rarrow_3;
			else
				return Larrow_3;
		case 4:
			if (b)
				return Rarrow_4;
			else
				return Larrow_4;
		case 5:
			if (b)
				return Rarrow_5;
			else
				return Larrow_5;
		case 6:
			if (b)
				return Rarrow_6;
			else
				return Larrow_6;
		case 7:
			if (b)
				return Rarrow_7;
			else
				return Larrow_7;
		case 8:
			if (b)
				return Rarrow_8;
			else
				return Larrow_8;
		case 9:
			if (b)
				return Rarrow_9;
			else
				return Larrow_9;

		}
		return null;
	}
}
