package guifx;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import application.controller.Controller;
import application.model.Forestilling;
import application.model.Kunde;
import application.model.Plads;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
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
		Controller.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Teater bestillinger");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final ListView<Kunde> lvwKunder = new ListView<>();
	private final ListView<Forestilling> lvwForetillinger = new ListView<>();
	private final ListView<Plads> lvwPladser = new ListView<>();

	private TextField txfDato, txfKnavn, txfkMobil;


	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);

		Label lblPladser = new Label("Forestillinger");
		pane.add(lblPladser, 0, 0);

		pane.add(lvwKunder, 1, 1);
		lvwKunder.setPrefWidth(300);
		lvwKunder.setPrefHeight(200);
		lvwKunder.getItems().setAll(Storage.getKunde());
		ChangeListener<Kunde> listener = (ov, oldKunde, newKunde) -> this.selectedKundeChanged();
		lvwKunder.getSelectionModel().selectedItemProperty().addListener(listener);

		pane.add(lvwForetillinger, 0, 1);
		lvwForetillinger.setPrefWidth(300);
		lvwForetillinger.setPrefHeight(200);
		lvwForetillinger.getItems().setAll(Storage.getForestilling());

		pane.add(lvwPladser, 2, 2);
		lvwPladser.setPrefWidth(300);
		lvwPladser.setPrefHeight(200);

		Label lblKunder = new Label("Kunder");
		pane.add(lblKunder, 1, 0);

		Label lblSpillested = new Label("Spillested:");
		pane.add(lblSpillested, 2, 0);
		
		Label lblNavn = new Label("Navn");
		pane.add(lblNavn, 0, 2);

		Label lblMobil = new Label("Mobil:");
		pane.add(lblMobil, 1, 2);

		txfKnavn = new TextField();
		pane.add(txfKnavn, 0, 3);

		txfkMobil = new TextField();
		pane.add(txfkMobil, 1, 3);
		
		txfDato = new TextField();
		pane.add(txfDato, 2, 1);

		Button btnOpret = new Button("Opret");
		pane.add(btnOpret, 1, 4);
		btnOpret.setOnAction(event -> this.opretKunde());

		Button btnFil = new Button("Vis bestilte pladser");
		pane.add(btnFil, 3, 1);
		btnFil.setOnAction(event -> this.Pladser());

	}

	// -------------------------------------------------------------------------

	private void Pladser() {
		Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate dato = LocalDate.parse(txfDato.getText().trim(), formatter);
		if (kunde != null) {
			for (int i = 0; i < kunde.getBestillinger().size(); i++) {
				if (dato.equals(kunde.getBestillinger().get(i).getDato())) {
					lvwPladser.getItems().setAll(kunde.getBestillinger().get(i).getPladser());
				}
			}
		}

	}

	private void opretKunde() {
		String navn = txfKnavn.getText().trim();
		String mobil = txfkMobil.getText().trim();
		
		if (navn != null && mobil != null) {
       Controller.createKunde(navn, mobil);
       txfKnavn.clear();
       txfkMobil.clear();
		}
		lvwKunder.getItems().setAll(Storage.getKunde());

	}

	private void selectedKundeChanged() {
		this.updateControls();
	}

	public void updateControls() {
		
	}
}
