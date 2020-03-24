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

public class lektion15opgave4 extends Application {
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


		btnKomb = new Button("+");
		pane.add(btnKomb, 2, 0, 2, 1);
		
		btnKomb2 = new Button("-");
		pane.add(btnKomb2, 2, 2, 2, 1);
		

		btnKomb.setOnAction(event -> this.addAction1());
		btnKomb2.setOnAction(event -> this.addAction2());

	}

	private void addAction1() {
		String s3;
		String s = txAInf.getText();
		int tal = Integer.parseInt(s);
		tal = tal + 1;
		s3 = Integer.toString(tal);
		txAInf.setText(s3);
	}
	
	private void addAction2() {
		String s2;
		String s = txAInf.getText();
		int tal = Integer.parseInt(s);
		tal = tal - 1;
		s2 = Integer.toString(tal);
		txAInf.setText(s2);
		
	}
}
