package guifx;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Mads, Ramsn og Simon
 */

import application.controller.Controller;
import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tilmelding;
import application.model.Udflugt;
import application.model.HotelTillæg;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TilmeldingWindow extends Stage {
	private Tilmelding tilmelding;

	public TilmeldingWindow(String title, Tilmelding tilmelding) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.tilmelding = tilmelding;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public TilmeldingWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfName, txfLedsager, txfAfrejsedato, txfAnkomstdato;
	private Label lblError;
	private CheckBox chbForedragsholder;
	private ComboBox<Konference> cbbKonference;
	private ComboBox<Deltager> cbbDeltager;
	private ComboBox<Hotel> cbbHotel;
	private CheckBox chbSeng, chbBad, chbWifi,chbMad;
	private ComboBox<Udflugt> cbbUdflugt;
	

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

		Label lblLedsager = new Label("Ledsager");
		pane.add(lblLedsager, 0, 1);
		txfLedsager = new TextField();
		pane.add(txfLedsager, 1, 1);
		txfLedsager.setPrefWidth(200);

		chbForedragsholder = new CheckBox("Foredragsholder");
		chbForedragsholder.setText("Foredragsholder");
		pane.add(chbForedragsholder, 0, 6);

		chbSeng = new CheckBox("Seng");
		chbSeng.setText("Seng");
		pane.add(chbSeng, 0, 7);

		Label lblankomstdato = new Label("Ankomstdato");
		pane.add(lblankomstdato, 0, 2);
		txfAnkomstdato = new TextField();
		pane.add(txfAnkomstdato, 1, 2);
		txfAnkomstdato.setPrefWidth(200);

		Label lblafrejsedato = new Label("Afrejsedato");
		pane.add(lblafrejsedato, 0, 3);
		txfAfrejsedato = new TextField();
		pane.add(txfAfrejsedato, 1, 3);
		txfAfrejsedato.setPrefWidth(200);

		Label lblKonference = new Label("Konference:");
		pane.add(lblKonference, 1, 7);
		cbbKonference = new ComboBox<>();
		pane.add(cbbKonference, 1, 8);
		cbbKonference.getItems().addAll(Controller.getKonference());
		
		Label lblUdflugt = new Label("Udflugt:");
		pane.add(lblUdflugt, 2, 9);
		cbbUdflugt = new ComboBox<>();
		pane.add(cbbUdflugt, 2, 10);
		cbbUdflugt.getItems().addAll(Controller.getUdflugter());

		Label lblHotel = new Label("Hotel:");
		pane.add(lblHotel, 1, 9);
		cbbHotel = new ComboBox<>();
		pane.add(cbbHotel, 1, 10);
		cbbHotel.getItems().addAll(Controller.getHoteller());

		Label lblDeltager = new Label("Deltager:");
		pane.add(lblDeltager, 2, 7);
		cbbDeltager = new ComboBox<>();
		pane.add(cbbDeltager, 2, 8);
		cbbDeltager.getItems().addAll(Controller.getDeltager());
		
		chbMad = new CheckBox();
		chbMad.setText("Mad");
		pane.add(chbMad, 0, 8);
		
		chbBad = new CheckBox();
		chbBad.setText("Bad");
		pane.add(chbBad, 0, 9);

		chbWifi = new CheckBox();
		chbWifi.setText("Wifi");
		pane.add(chbWifi, 0, 10);

		// ----------------------------

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 1, 11);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 2, 11);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 1, 12);
		lblError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	private void initControls() {
		if (tilmelding != null) {
			txfName.setText(tilmelding.getNavn());
			txfLedsager.setText(tilmelding.getLedsagernavn());
			chbForedragsholder.setSelected(tilmelding.isForedragsholder());
			chbSeng.setSelected(tilmelding.isSeng());
			txfAnkomstdato.setText("" + tilmelding.getAnkomstdato());
			txfAfrejsedato.setText("" + tilmelding.getAfrejsedato());
			if (tilmelding.getHoteltillæg() != null) {
			chbMad.setSelected(tilmelding.getHoteltillæg().isMad());
			chbBad.setSelected(tilmelding.getHoteltillæg().isBad());
			chbWifi.setSelected(tilmelding.getHoteltillæg().isWifi());
		}
			

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

		String ledsagernavn = txfLedsager.getText().trim();

		if (ledsagernavn.length() == 0) {
			lblError.setText("Name is empty");
			return;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ankomstdato = LocalDate.parse(txfAnkomstdato.getText(), formatter);
		LocalDate afrejsedato = LocalDate.parse(txfAfrejsedato.getText(), formatter);
		boolean foredragsholder = chbForedragsholder.isSelected();
		boolean seng = chbSeng.isSelected();
		boolean mad = chbMad.isSelected();
		boolean bad = chbBad.isSelected();
		boolean wifi = chbWifi.isSelected();
		Konference konference = cbbKonference.getSelectionModel().getSelectedItem();
		Deltager deltager = cbbDeltager.getSelectionModel().getSelectedItem();
		Hotel hotel = cbbHotel.getSelectionModel().getSelectedItem();
		Udflugt udflugt = cbbUdflugt.getSelectionModel().getSelectedItem();
		HotelTillæg hoteltillæg =	Controller.createHotelTillæg(bad, mad, wifi);
		
		// Call controller methods
		if (tilmelding != null) {
			Controller.updateTilmelding(tilmelding, navn, ledsagernavn, foredragsholder, seng, deltager, konference,
					ankomstdato, afrejsedato);
		if (hoteltillæg != null) {
			Controller.setHotelTillæg(tilmelding, hoteltillæg);
		}
		if (hotel != null) {
			Controller.setHotel(tilmelding, hotel);
		}
		if (udflugt != null) {
			Controller.addUdflugt(tilmelding, udflugt);
		}
		} else {
			Tilmelding t1 = Controller.createTilmelding(navn, ledsagernavn, foredragsholder, seng, deltager, konference, ankomstdato,
					afrejsedato);
			if (hoteltillæg != null) {
			Controller.setHotelTillæg(t1, hoteltillæg);
			}
			if (hotel != null) {
			Controller.setHotel(t1, hotel);
			}
			if (udflugt != null) {
			Controller.addUdflugt(t1, udflugt);
			}
		}
			this.hide();

		}

	}
