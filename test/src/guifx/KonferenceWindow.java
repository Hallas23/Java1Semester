package guifx;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import application.controller.Controller;
import application.model.Konference;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Mads, Ramsn og Simon
 */
public class KonferenceWindow extends Stage {

	private Konference konference;

	public KonferenceWindow(String title, Konference konference) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.konference = konference;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public KonferenceWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfKonference, txfStartDato, txfSlutDato, txfadresse;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblKonference = new Label("Konference");
		pane.add(lblKonference, 0, 0);

		txfKonference = new TextField();
		pane.add(txfKonference, 0, 1);
		txfKonference.setPrefWidth(200);

		Label lbladresse = new Label("Adresse");
		pane.add(lbladresse, 0, 2);

		txfadresse = new TextField();
		pane.add(txfadresse, 0, 3);

		Label lblStartDato = new Label("Start Dato:		(yyyy-MM-dd)");
		pane.add(lblStartDato, 0, 4);

		txfStartDato = new TextField();
		pane.add(txfStartDato, 0, 5);

		Label lblSlutDato = new Label("Slut Dato:	        	(yyyy-MM-dd)");
		pane.add(lblSlutDato, 0, 6);

		txfSlutDato = new TextField();
		pane.add(txfSlutDato, 0, 7);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 9);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 9);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 8);
		lblError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	private void initControls() {
		if (konference != null) {
			txfKonference.setText(konference.getBeskrivelse());
			txfStartDato.setText("" + konference.getFraDato());
			txfSlutDato.setText("" + konference.getTilDato());
		} else {
			txfKonference.clear();
			txfStartDato.clear();
			txfSlutDato.clear();
		}
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void okAction() {

		String name = txfKonference.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Konference er tomt");
			return;
		}

		String adresse = txfadresse.getText().trim();
		if (adresse.length() == 0) {
			lblError.setText("Adresse er tomt");
			return;
		}

		DateTimeFormatter localDate1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDato = LocalDate.parse(txfStartDato.getText(), localDate1);
		if (txfStartDato.getLength() == 0) {
			lblError.setText("Start dato er tomt");
			return;
		}

		LocalDate slutDato = LocalDate.parse(txfSlutDato.getText(), localDate1);
		if (txfSlutDato.getLength() == 0) {
			lblError.setText("Slut dato er tomt");
			return;
		}

		// Call controller methods

		Controller.createKonference(startDato, slutDato, adresse, name);

		this.hide();
	}
}
