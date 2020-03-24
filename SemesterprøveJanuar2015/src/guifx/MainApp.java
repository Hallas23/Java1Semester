package guifx;

import java.util.ArrayList;

import application.controller.Controller;
import application.model.Kamp;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
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
		Controller.createSomeObjects();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Administration af spiller deltagelse");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final ListView<Kamp> lvwKampe = new ListView<>();

	private TextField txfDato, txfSpillested, txfTid;
	private ToggleGroup group;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);

		Label lblPladser = new Label("Pladser");
		pane.add(lblPladser, 0, 0);

		pane.add(lvwKampe, 0, 1);
		lvwKampe.setPrefWidth(300);
		lvwKampe.setPrefHeight(200);
		lvwKampe.getItems().setAll(Storage.getKampe());
		ChangeListener<Kamp> listener = (ov, oldEmployee, newEmployee) -> this.selectedKampChanged();
		lvwKampe.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblOmråde = new Label("Spilledato:");
		pane.add(lblOmråde, 1, 1);

		Label lblSpillested = new Label("Spillested:");
		pane.add(lblSpillested, 1, 0);

		Label lblFundet = new Label("Spilletid:");
		pane.add(lblFundet, 1, 2);

		txfSpillested = new TextField();
		pane.add(txfSpillested, 2, 0);

		txfDato = new TextField();
		pane.add(txfDato, 2, 1);
		
		txfTid = new TextField();
		pane.add(txfTid, 2, 2);
		
		Button btnOpret = new Button("Opret");
		pane.add(btnOpret, 1, 3);
		btnOpret.setOnAction(event -> this.opretKamp());
		
		Button btnUpdate = new Button("Update");
		pane.add(btnUpdate, 2, 3);
		btnUpdate.setOnAction(event -> this.updateKamp());
		
		Button btnFil = new Button("Lav fil");
		pane.add(btnFil, 1, 4);
		btnFil.setOnAction(event -> this.opretFil());


	}

	// -------------------------------------------------------------------------

	

	private void opretFil() {
		Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();
		if (kamp != null) {
		kamp.spillerHonorar("C:/Users/Simon/Documents/kamp");
		}
		else {
			return;
		}
	}

	private void updateKamp() {
		Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();
		if (kamp == null) {
			return;
		}
		KampWindow dia = new KampWindow("Update Employee", kamp);
		dia.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwKampe.getSelectionModel().getSelectedIndex();
		lvwKampe.getItems().setAll(Storage.getKampe());
		lvwKampe.getSelectionModel().select(selectIndex);
	}

	private void opretKamp() {
		KampWindow dia = new KampWindow("Create PLads", null);

		dia.showAndWait();

		lvwKampe.getItems().setAll(Storage.getKampe());

	}
	
	private void selectedKampChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();
		if (kamp != null) {
			txfSpillested.setText(kamp.getSted());
			txfDato.setText(kamp.getDato().toString());
			txfTid.setText(kamp.getTid().toString());
			
		} else {
			txfSpillested.clear();
			txfDato.clear();
			txfTid.clear();
		}
	}


}
