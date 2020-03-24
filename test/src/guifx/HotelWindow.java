package guifx;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Konference;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Mads, Ramsn og Simon
 */
public class HotelWindow extends Stage {
	private Hotel hotel;

	public HotelWindow(String title, Hotel hotel) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.hotel = hotel;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public HotelWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfName, txfAdresse, txfBadpris, txfMadpris, txfWifipris, txfDobbeltseng, txfPrisprdag;
	private Label lblError;
	private ComboBox<Konference> cbbKonference;

	private void initContent(GridPane pane) {

		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
//		pane.setGridLinesVisible(true);

		Label lblName = new Label("Navn:");
		pane.add(lblName, 0, 0);
		txfName = new TextField();
		pane.add(txfName, 1, 0);
		txfName.setPrefWidth(200);

		Label lblAdresse = new Label("Adresse:");
		pane.add(lblAdresse, 0, 1);
		txfAdresse = new TextField();
		pane.add(txfAdresse, 1, 1);
		txfAdresse.setPrefWidth(200);

		Label lblBadpris = new Label("Badpris:");
		pane.add(lblBadpris, 0, 4);
		txfBadpris = new TextField();
		pane.add(txfBadpris, 1, 4);
		txfBadpris.setPrefWidth(200);

		Label lblMadpris = new Label("Madpris:");
		pane.add(lblMadpris, 0, 5);
		txfMadpris = new TextField();
		pane.add(txfMadpris, 1, 5);
		txfMadpris.setPrefWidth(200);

		Label lblWifipris = new Label("Wifipris:");
		pane.add(lblWifipris, 0, 6);
		txfWifipris = new TextField();
		pane.add(txfWifipris, 1, 6);
		txfWifipris.setPrefWidth(200);

		Label lblprisprdag = new Label("Prisprdag:");
		pane.add(lblprisprdag, 0, 2);
		txfPrisprdag = new TextField();
		pane.add(txfPrisprdag, 1, 2);
		txfPrisprdag.setPrefWidth(200);

		Label lbldobbeltseng = new Label("PrisDobbeltseng:");
		pane.add(lbldobbeltseng, 0, 3);
		txfDobbeltseng = new TextField();
		pane.add(txfDobbeltseng, 1, 3);
		txfDobbeltseng.setPrefWidth(200);

		cbbKonference = new ComboBox<>();
		pane.add(cbbKonference, 1, 7);
		cbbKonference.getItems().addAll(Controller.getKonference());

		// ----------------------------

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 8);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 1, 8);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 9);
		lblError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	private void initControls() {
		if (hotel != null) {
			txfName.setText(hotel.getNavn());
			txfAdresse.setText("" + hotel.getAdresse());
			txfPrisprdag.setText(Integer.toString(hotel.getPrisprdag()));
			txfDobbeltseng.setText(Integer.toString(hotel.getDobbeltseng()));
			txfBadpris.setText(Integer.toString(hotel.getBadPris()));
			txfMadpris.setText(Integer.toString(hotel.getMadPris()));
			txfWifipris.setText(Integer.toString(hotel.getWifiPris()));
			cbbKonference.getSelectionModel().select(hotel.getKonference());
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

		String adresse = txfAdresse.getText().trim();

		if (adresse.length() == 0) {
			lblError.setText("Name is empty");
			return;
		}

		int prisprdag = Integer.parseInt(txfPrisprdag.getText().trim());

		if (prisprdag < 0) {
			lblError.setText("Name is empty");
			return;
		}

		int dobbeltseng = Integer.parseInt(txfDobbeltseng.getText().trim());

		if (dobbeltseng < 0) {
			lblError.setText("Name is empty");
			return;
		}

		int badpris = Integer.parseInt(txfBadpris.getText().trim());

		if (badpris < 0) {
			lblError.setText("Name is empty");
			return;
		}

		int madpris = Integer.parseInt(txfMadpris.getText().trim());

		if (madpris < 0) {
			lblError.setText("Name is empty");
			return;
		}

		int wifipris = Integer.parseInt(txfWifipris.getText().trim());

		if (wifipris < 0) {
			lblError.setText("Name is empty");
			return;
		}

		Konference konference = cbbKonference.getSelectionModel().getSelectedItem();

		// Call controller methods
		if (hotel != null) {
			Controller.updateHotel(hotel, navn, adresse, prisprdag, dobbeltseng, badpris, madpris, wifipris,
					konference);
		} else {
			Controller.createHotel(navn, adresse, prisprdag, dobbeltseng, badpris, madpris, wifipris, konference);
		}

		this.hide();
	}

}
