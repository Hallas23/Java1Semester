package guifx;

import java.util.ArrayList;

import application.controller.Controller;
import application.model.Område;
import application.model.Kamp;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import storage.Storage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		Controller.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Netcafe administration");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final ListView<Kamp> lvwPladser = new ListView<>();

	private TextField txfName, txfFundetNummer;
	private ToggleGroup group;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);

		Label lblPladser = new Label("Pladser");
		pane.add(lblPladser, 0, 0);

		pane.add(lvwPladser, 0, 1);
		lvwPladser.setPrefWidth(300);
		lvwPladser.setPrefHeight(200);
		lvwPladser.getItems().setAll(Storage.getPladser());

		Label lblOmråde = new Label("Område:");
		pane.add(lblOmråde, 0, 2);

		Label lblNummer = new Label("Nummer:");
		pane.add(lblNummer, 1, 0);

		Label lblFundet = new Label("Fundet plads:");
		pane.add(lblFundet, 1, 1);

		txfFundetNummer = new TextField();
		pane.add(txfFundetNummer, 2, 1);
		txfFundetNummer.setEditable(false);

		txfName = new TextField();
		pane.add(txfName, 2, 0);
		txfName.setPrefWidth(200);

		HBox box = new HBox();
		group = new ToggleGroup();
		String[] områdenavne = { "Standard", "VIP", "Børne", "Turnering" };
		Område[] områder = { Område.STANDARD, Område.VIP, Område.BØRNE, Område.TURNERING };
		RadioButton rb;
		for (int i = 0; i < områdenavne.length; i++) {
			rb = new RadioButton();
			rb.setToggleGroup(group);
			rb.setText(områdenavne[i]);
			rb.setUserData(områder[i]);
			box.getChildren().add(rb);
		}
		pane.add(box, 1, 2, 1, 4);
		group.getToggles().get(0).setSelected(true);

		group.selectedToggleProperty().addListener(event -> toggleRadioButton());

		Button btnOpretStandard = new Button("Opret standard plads");
		pane.add(btnOpretStandard, 1, 3);
		btnOpretStandard.setOnAction(event -> this.opretBilAction());

		Button btnFindplads = new Button("Find plads");
		pane.add(btnFindplads, 2, 3);
		btnFindplads.setOnAction(event -> this.findPLads());

	}

	// -------------------------------------------------------------------------

	private Object toggleRadioButton() {
		Område område = (Område) group.getSelectedToggle().getUserData();
		return område;
	}

	private void opretBilAction() {
		PladsWindow dia = new PladsWindow("Create PLads");

		dia.showAndWait();

		lvwPladser.getItems().setAll(Storage.getPladser());

	}

	private void findPLads() {
		Område område = (Område) group.getSelectedToggle().getUserData();

		if (txfName.getText().isEmpty()) {
			txfFundetNummer.setText("Indtast tekt");
		}

		if (område != null && !txfName.getText().isEmpty()) {
			int nummer = Integer.parseInt(txfName.getText().trim());
			if (Controller.findPlads(område, nummer) == null) {
				txfFundetNummer.setText("Pladsen findes ikke");
				txfName.clear();
			} else {
				txfFundetNummer.setText("Plads " + String.valueOf(Controller.findPlads(område, nummer).getNr() + " findes"));
				txfName.clear();
			}
		}
	}

}
