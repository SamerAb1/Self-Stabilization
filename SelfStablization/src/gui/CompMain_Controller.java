package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class CompMain_Controller implements Initializable{
	
	Comp_SharedData Comp_sharedData;
	
	@FXML
	private Button Backbtn_CMain;

	@FXML
	private Button Kstatebtn_Cmain;

	@FXML
	private Button Threestateval_Cmain;
	

	@FXML
	void Backbtn_CMain(ActionEvent event) throws Exception {
		System.out.println("Back");
		Stage stage = (Stage) Backbtn_CMain.getScene().getWindow();
		// do what you have to do
		stage.close();
		main_Controller aFrame = new main_Controller(); // create main
		Stage primaryStage = new Stage();
		aFrame.start(primaryStage);
	}

	@FXML
	void Kstatebtn_Cmain(ActionEvent event) throws IOException {
		Comp_sharedData.setAlgorithm(true);
		System.out.println("Open Complexity numbers of processors K-state");
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
		Pane root = loader.load(getClass().getResource("/gui/CompNumbersOfProcessors.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Complex Numbers Of Processors Page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void Threestateval_Cmain(ActionEvent event) throws IOException {
		Comp_sharedData.setAlgorithm(false);
		System.out.println("Open Complexity numbers of processors Three-state");
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		((Node) event.getSource()).getScene().getWindow().hide();// do this 3 lines for all the roles no matter what
		Pane root = loader.load(getClass().getResource("/gui/CompNumbersOfProcessors.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Numbers Of Processors Page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Comp_sharedData = Comp_SharedData.getInstance();
		
	}

}
