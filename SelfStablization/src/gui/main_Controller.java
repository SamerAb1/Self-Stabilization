package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class main_Controller {

	@FXML
	private Button Exitbtn_Main;

	@FXML
	private Button Kstatebtn_Main;
	
	@FXML
	private Button Threestatebtn_Main;

    @FXML
    private Button complicationsbtn_Main;
    
	@FXML
	void Kstatebtn_Main(ActionEvent event) throws Exception {
		System.out.println("Open First Algorithm Choose Values Page");
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
		Pane root = loader.load(getClass().getResource("/gui/FirstAlgorithmValues.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("K-state Machines Algorithm Values");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	@FXML
	void Threestatebtn_Main(ActionEvent event) throws Exception {
		System.out.println("Open Third Algorithm Choose Values Page");
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
	void Exitbtn_Main(ActionEvent event) {
		System.out.println("Main Exit");
		System.exit(0);
	}

	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/gui/main.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Self-Stabilization");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
    @FXML
    void complicationsbtn_Main(ActionEvent event) throws IOException {
		System.out.println("Open complications main");
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
		Pane root = loader.load(getClass().getResource("/gui/CompMain.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Complexity");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

}
