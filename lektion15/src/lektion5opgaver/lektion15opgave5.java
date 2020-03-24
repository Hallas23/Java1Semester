package lektion5opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class lektion15opgave5 extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Kombiner navne");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

	}

	private TextField txAInf;
	private Button btnKomb;
	private Button btnKomb2;
	private boolean c = true;


	private void initContent(GridPane pane) {

		pane.setGridLinesVisible(false);

		pane.setPadding(new Insets(10));

		pane.setHgap(10);

		pane.setVgap(10);

		txAInf = new TextField();
		txAInf.setEditable(true);
		txAInf.setPrefWidth(150);
		txAInf.setPrefHeight(10);
		pane.add(txAInf, 0, 1);


		btnKomb = new Button("C/F");
		pane.add(btnKomb, 2, 0, 2, 1);
		
		btnKomb.setOnAction(event -> this.addAction1());
		
	}

	private void addAction1() {
		if(c == true) {
		btnKomb.setOnAction(event -> this.addAction1());
		c = false;
		}
		if(c == false) {
			btnKomb.setOnAction(event -> this.addAction2());
			c = true;
		}	
		String s3;
		String s = txAInf.getText();
		double tal = Integer.parseInt(s);
		tal = tal * 1.8000 +32;
		s3 = Double.toString(tal);
		txAInf.setText(s3);

	}
	private void addAction2() {
		String s3;
		String s = txAInf.getText();
		double tal = Integer.parseInt(s);
		tal = (tal - 32) / 1.800; 
		s3 = Double.toString(tal);
		txAInf.setText(s3);
		c = true;
		addAction1();

	}
	
		
	}

