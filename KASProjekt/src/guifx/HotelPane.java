package guifx;

import application.controller.Controller;

import application.model.Hotel;
import application.model.Tilmelding;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Mads, Ramsn og Simon
 */
public class HotelPane extends GridPane {
	private TextField txfName, txfAdresse, txfBadpris, txfMadpris, txfWifipris, txfPrisPrDag, txfPrisPrDobbeltSeng, txfKonference;
	private ListView<Hotel> lvwhotel;
	private ListView<Tilmelding> lvwTilmeldinger;

	public HotelPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Hoteller");
		this.add(lblComp, 0, 0);

		lvwhotel = new ListView<>();
		this.add(lvwhotel, 0, 1, 1, 6);
		lvwhotel.setPrefWidth(180);
		lvwhotel.setPrefHeight(180);
		lvwhotel.getItems().setAll(Controller.getHoteller());

		ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
		lvwhotel.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Navn:");
		this.add(lblName, 1, 1);
		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setEditable(false);

		Label lblAdresse = new Label("Adresse:");
		this.add(lblAdresse, 1, 2);
		txfAdresse = new TextField();
		this.add(txfAdresse, 2, 2);
		txfAdresse.setEditable(false);

		
		Label lblPrisPrDag = new Label("Pris.Pr.Dag:");
		this.add(lblPrisPrDag, 1, 3);
		txfPrisPrDag = new TextField();
		this.add(txfPrisPrDag, 2, 3);
		txfPrisPrDag.setEditable(false);
		
		Label lblPrisPrDobbeltSeng = new Label("Pris.Pr.DobbeltSeng:");
		this.add(lblPrisPrDobbeltSeng, 1, 4);
		txfPrisPrDobbeltSeng = new TextField();
		this.add(txfPrisPrDobbeltSeng, 2, 4);
		txfPrisPrDobbeltSeng.setEditable(false);
		
		Label lblWifi = new Label("Wifi:");
		this.add(lblWifi, 1, 5);
		txfWifipris = new TextField();
		this.add(txfWifipris, 2, 5);
		txfWifipris.setEditable(false);
		
		Label lblMad = new Label("Mad:");
		this.add(lblMad, 1, 6);
		txfMadpris = new TextField();
		this.add(txfMadpris, 2, 6);
		txfMadpris.setEditable(false);

		Label lblBad = new Label("Bad:");
		this.add(lblBad, 1, 7);
		txfBadpris = new TextField();
		this.add(txfBadpris, 2, 7);
		txfBadpris.setEditable(false);

		Label lblkonference = new Label("Konference");
		this.add(lblkonference, 1, 8);
		txfKonference = new TextField();
		this.add(txfKonference, 2, 8);
		txfKonference.setPrefWidth(200);
		
		Label lblTilm = new Label("Tilmeldinger");
		this.add(lblTilm, 0, 7);

		lvwTilmeldinger = new ListView<>();
		this.add(lvwTilmeldinger, 0, 8, 1, 5);
		lvwTilmeldinger.setPrefWidth(180);
		lvwTilmeldinger.setPrefHeight(50);

		HBox hbxButtons = new HBox(10);
		this.add(hbxButtons, 0, 13, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_LEFT);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Update");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		if (lvwhotel.getItems().size() > 0) {
			lvwhotel.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		HotelWindow dia = new HotelWindow("Opret Hotel");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwhotel.getItems().setAll(Controller.getHoteller());
		int index = lvwhotel.getItems().size() - 1;
		lvwhotel.getSelectionModel().select(index);
	}

	private void updateAction() {
		Hotel hotel = lvwhotel.getSelectionModel().getSelectedItem();
		if (hotel == null) {
			return;
		}

		HotelWindow hw = new HotelWindow("Opdatere Hotel", hotel);
		hw.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwhotel.getSelectionModel().getSelectedIndex();
		lvwhotel.getItems().setAll(Controller.getHoteller());
		lvwhotel.getSelectionModel().select(selectIndex);
	}

	private void deleteAction() {
		Hotel hotel = lvwhotel.getSelectionModel().getSelectedItem();
		if (hotel != null) {
			Controller.deleteHotel(hotel);
			txfName.clear();
			lvwhotel.getItems().setAll(Controller.getHoteller());
			this.updateHotel();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedHotelChanged() {
		this.updateHotel();
	}

	public void updateHotel() {
		Hotel hotel = lvwhotel.getSelectionModel().getSelectedItem();
		if (hotel != null) {
			String badpris = String.valueOf(hotel.getBadPris());
			String madpris = String.valueOf(hotel.getMadPris());
			String wifipris = String.valueOf(hotel.getWifiPris());
			String prisprdag = String.valueOf(hotel.getPrisprdag());
			String dobbeltseng = String.valueOf(hotel.getDobbeltseng());
			
			StringBuilder sb = new StringBuilder();
			for (Tilmelding t : hotel.getTilmeldinger()) {
				sb.append(t + "\n");
			}
			lvwTilmeldinger.getItems().setAll(hotel.getTilmeldinger());
			
			txfName.setText(hotel.getNavn());
			txfAdresse.setText(hotel.getAdresse());
			txfBadpris.setText(badpris);
			txfMadpris.setText(madpris);
			txfWifipris.setText(wifipris);
			txfPrisPrDag.setText(prisprdag);
			txfPrisPrDobbeltSeng.setText(dobbeltseng);
			txfKonference.setText(hotel.getKonference().getBeskrivelse());
			

		} else {
			txfName.clear();
			txfAdresse.clear();
			txfBadpris.clear();
			txfMadpris.clear();
			txfWifipris.clear();
			txfPrisPrDobbeltSeng.clear();
			txfPrisPrDag.clear();
			txfKonference.clear();

		}

	}

}
