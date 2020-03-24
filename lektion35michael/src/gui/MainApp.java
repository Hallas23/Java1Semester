package gui;

import application.controller.Controller;
import application.model.Bil;
import application.model.Parkeringshus;
import application.model.Parkeringsplads;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		Controller.createSomeObjects();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Parkeringshuse og pladser");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final ListView<Parkeringshus> lvwParkeringshuse = new ListView<>();
	private final ListView<String> lvwOptagnepladser = new ListView<>();
	private final TextField txfRegNr = new TextField();

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);

		Label lblKollegier = new Label("Parkeringshuse");
		pane.add(lblKollegier, 0, 0);

		pane.add(lvwParkeringshuse, 0, 1);
		lvwParkeringshuse.setPrefWidth(300);
		lvwParkeringshuse.setPrefHeight(200);
		lvwParkeringshuse.getItems().setAll(Storage.getParkeringshuse());

		lvwParkeringshuse.getSelectionModel().selectedItemProperty()
				.addListener((p, ov, nv) -> this.selectedParkeringshusChanged());

		Label lblOpretBil = new Label("Opret bil med nummer:");
		pane.add(lblOpretBil, 0, 2);

		Label lblOptagePladser = new Label("Optagne pladser");
		pane.add(lblOptagePladser, 1, 0);

		pane.add(lvwOptagnepladser, 1, 1);
		lvwOptagnepladser.setPrefWidth(300);
		lvwOptagnepladser.setPrefHeight(200);

		pane.add(txfRegNr, 1, 2);

		Button btnOpretBil = new Button("Opret Bil");
		pane.add(btnOpretBil, 1, 3);
		GridPane.setHalignment(btnOpretBil, HPos.CENTER);
		btnOpretBil.setOnAction(event -> this.opretBilAction());
	}

	// -------------------------------------------------------------------------

	private void selectedParkeringshusChanged() {
		Parkeringshus selected = lvwParkeringshuse.getSelectionModel().getSelectedItem();
		if (selected == null)
			return;

		lvwOptagnepladser.getItems().setAll(selected.optagnePladser());
	}

	private void opretBilAction() {
		Parkeringshus selected = lvwParkeringshuse.getSelectionModel().getSelectedItem();
		if (selected == null)
			return;

		if (selected.antalLedigePladser() == 0)
			return;

		Parkeringsplads ledigPlads = selected.findLedigPlads();
		String regNr = txfRegNr.getText().trim();
		Bil bil = Controller.createBil(regNr);
		ledigPlads.setBil(bil);
		lvwOptagnepladser.getItems().setAll(selected.optagnePladser());

		// Test
		System.out.println("Test af 'Opret Bil'");
		System.out.println("Plads med den bil: " + selected.findPladsMedBil(regNr));
	}
}
