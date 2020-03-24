package guifx;

import application.controller.Controller;
import application.model.Deltager;
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
public class DeltagerWindow extends Stage {
	private Deltager deltager;

	public DeltagerWindow(String title, Deltager deltager) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.deltager = deltager;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public DeltagerWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfName, txfAlder, txfAdresse, txfBy, txfFirmanavn, txfTelefonNr, txfFirmatelefonNr;
	private Label lblError;

	private void initContent(GridPane pane) {

		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
//		pane.setGridLinesVisible(true);

		Label lblName = new Label("Navn");
		pane.add(lblName, 0, 0);
		txfName = new TextField();
		pane.add(txfName, 1, 0);
		txfName.setPrefWidth(200);

		Label lblAdresse = new Label("Adresse");
		pane.add(lblAdresse, 0, 2);
		txfAdresse = new TextField();
		pane.add(txfAdresse, 1, 2);
		txfAdresse.setPrefWidth(200);

		Label lblby = new Label("By");
		pane.add(lblby, 0, 3);
		txfBy = new TextField();
		pane.add(txfBy, 1, 3);
		txfBy.setPrefWidth(200);

		Label lblFirma = new Label("Firma");
		pane.add(lblFirma, 0, 4);
		txfFirmanavn = new TextField();
		pane.add(txfFirmanavn, 1, 4);
		txfFirmanavn.setPrefWidth(200);

		Label lblAlder = new Label("Alder");
		pane.add(lblAlder, 0, 1);
		txfAlder = new TextField();
		pane.add(txfAlder, 1, 1);
		txfAlder.setPrefWidth(200);

		Label lblTelefonNr = new Label("Telefonnummer");
		pane.add(lblTelefonNr, 0, 5);
		txfTelefonNr = new TextField();
		pane.add(txfTelefonNr, 1, 5);
		txfTelefonNr.setPrefWidth(200);

		Label lblFirmatelefonNr = new Label("FirmatelefonNr");
		pane.add(lblFirmatelefonNr, 0, 6);
		txfFirmatelefonNr = new TextField();
		pane.add(txfFirmatelefonNr, 1, 6);
		txfFirmatelefonNr.setPrefWidth(200);

		// ----------------------------

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 7);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 1, 7);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 8);
		lblError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	private void initControls() {
		if (deltager != null) {
			txfName.setText(deltager.getNavn());
			txfAdresse.setText("" + deltager.getAdresse());
			txfBy.setText("" + deltager.getBy());
			txfAlder.setText(Integer.toString(deltager.getAlder()));
			txfFirmanavn.setText("" + deltager.getFirmanavn());
			txfTelefonNr.setText(Integer.toString(deltager.getTelefonNr()));
			txfFirmatelefonNr.setText(Integer.toString(deltager.getFirmatelefonNr()));

		} else {
			txfName.clear();
			txfAdresse.clear();
		}
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void okAction() {
		String navn = txfName.getText().trim();

		if (navn.length() == 0) {
			lblError.setText("Name is empty");
			return;
		}
		
		int alder = Integer.parseInt(txfAlder.getText().trim());

		if (alder < 0) {
			lblError.setText("Name is empty");
			return;
		}
		String adresse = txfAdresse.getText().trim();
		
		if (adresse.length() == 0) {
			lblError.setText("Name is empty");
			return;
		}
		
		String by = txfBy.getText().trim();
		
		if (by.length() == 0) {
			lblError.setText("Name is empty");
			return;
		}
		
		
		String firmanavn = txfFirmanavn.getText().trim();
		
		if (adresse.length() == 0) {
			lblError.setText("Name is empty");
			return;
		}
		
		int telefonNr = Integer.parseInt(txfTelefonNr.getText().trim());

		if (telefonNr < 0) {
			lblError.setText("Name is empty");
			return;
		}
		
		int firmatelefonNr = Integer.parseInt(txfFirmatelefonNr.getText().trim());

		if (firmatelefonNr < 0) {
			lblError.setText("Name is empty");
			return;
		}

     // Call controller methods
    if (deltager != null) {
         Controller.updateDeltager(deltager, navn, alder, adresse, by, firmanavn, telefonNr, firmatelefonNr);
     } else {
         Controller.createDeltager(navn, alder, adresse, by, firmanavn, telefonNr, firmatelefonNr);
     }

     this.hide();
 }

}
