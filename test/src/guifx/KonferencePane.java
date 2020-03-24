package guifx;

/**
 * Mads, Ramsn og Simon
 */
import java.util.Optional;

import application.controller.Controller;
import application.model.Konference;
import application.model.Hotel;
import application.model.Udflugt;
import application.model.Tilmelding;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class KonferencePane extends GridPane {
	private TextField txfKonference, txfAdresse, txfStartDato, txfSlutDato;
	private ListView<Konference> lvwKonferencer;
	private ListView<Hotel> lvwHoteller;
	private ListView<Udflugt> lvwUdflugter;
	private ListView<Tilmelding> lvwTilmeldinger;

	public KonferencePane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblKonf = new Label("Konferencer");
		this.add(lblKonf, 0, 0);

		lvwKonferencer = new ListView<>();
		this.add(lvwKonferencer, 0, 1, 1, 20);
		lvwKonferencer.setPrefWidth(200);
		lvwKonferencer.setPrefHeight(200);
		lvwKonferencer.getItems().setAll(Controller.getKonference());

		ChangeListener<Konference> listener = (ov, oldKonf, newKonf) -> this.selectedKonferenceChanged();
		lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblKonference = new Label("Konference:");
		this.add(lblKonference, 1, 1);

		txfKonference = new TextField();
		this.add(txfKonference, 2, 1);
		txfKonference.setEditable(false);

		Label lblAdresse = new Label("Adresse:");
		this.add(lblAdresse, 1, 2);

		txfAdresse = new TextField();
		this.add(txfAdresse, 2, 2);

		Label lblStartDato = new Label("Start Dato:");
		this.add(lblStartDato, 1, 3);

		txfStartDato = new TextField();
		this.add(txfStartDato, 2, 3);
		txfStartDato.setEditable(false);

		Label lblSlutDato = new Label("Slut Dato:");
		this.add(lblSlutDato, 1, 4);

		txfSlutDato = new TextField();
		this.add(txfSlutDato, 2, 4);
		txfSlutDato.setEditable(false);

		// listview af tilmeldinger inde under konference
		Label lblTilm = new Label("Tilmeldinger:");
		this.add(lblTilm, 1, 5);

		lvwTilmeldinger = new ListView<>();
		this.add(lvwTilmeldinger, 2, 5, 1, 4);
		lvwTilmeldinger.setPrefWidth(200);
		lvwTilmeldinger.setPrefHeight(50);

		// listview af udflugter inde under konference
		Label lblUdfl = new Label("Udflugter:");
		this.add(lblUdfl, 1, 10);

		lvwUdflugter = new ListView<>();
		this.add(lvwUdflugter, 2, 9, 1, 5);
		lvwUdflugter.setPrefWidth(200);
		lvwUdflugter.setPrefHeight(50);

		// listview af hoteller inde under konference
		Label lblHotel = new Label("Hoteller:");
		this.add(lblHotel, 1, 14);

		lvwHoteller = new ListView<>();
		this.add(lvwHoteller, 2, 14, 1, 7);
		lvwHoteller.setPrefWidth(200);
		lvwHoteller.setPrefHeight(50);

		HBox hbxButtons = new HBox(100);
		this.add(hbxButtons, 0, 21, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.CENTER_LEFT);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

//			Button btnUpdate = new Button("Update");
//			hbxButtons.getChildren().add(btnUpdate);
//			btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		if (lvwKonferencer.getItems().size() > 0) {
			lvwKonferencer.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		KonferenceWindow dia = new KonferenceWindow("Create Konference");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwKonferencer.getItems().setAll(Controller.getKonference());
		int index = lvwKonferencer.getItems().size() - 1;
		lvwKonferencer.getSelectionModel().select(index);
	}

//		private void updateAction() {
//			Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
//			if (konference == null) {
//				return;
//			}
//
//			KonferenceWindow dia = new KonferenceWindow("Update Konference", konference);
//			dia.showAndWait();
//
//			// Wait for the modal dialog to close
//
//			int selectIndex = lvwKonferencer.getSelectionModel().getSelectedIndex();
//			lvwKonferencer.getItems().setAll(Controller.getKonference());
//			lvwKonferencer.getSelectionModel().select(selectIndex);
//		}

	private void deleteAction() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Slet Konference");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Er du sikker?");
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Controller.deleteKonference(konference);
			lvwKonferencer.getItems().setAll(Controller.getKonference());
			this.updateControls();
		}

	}

	// -------------------------------------------------------------------------

	private void selectedKonferenceChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			txfKonference.setText(konference.getBeskrivelse());
			txfAdresse.setText(konference.getAdresse());
			txfStartDato.setText("" + konference.getFraDato());
			txfSlutDato.setText("" + konference.getTilDato());
			StringBuilder sb = new StringBuilder();
			for (Tilmelding konf : konference.getTilmeldinger()) {
				sb.append(konf + "\n");
			}
			lvwTilmeldinger.getItems().setAll(konference.getTilmeldinger());

			for (Udflugt ud : konference.getUdflugter()) {
				sb.append(ud + "\n");
			}
			lvwUdflugter.getItems().setAll(konference.getUdflugter());

			for (Hotel ho : konference.getHoteller()) {
				sb.append(ho + "\n");
			}
			lvwHoteller.getItems().setAll(konference.getHoteller());

		} else {
			txfKonference.clear();
			txfAdresse.clear();
			txfSlutDato.clear();
			txfStartDato.clear();

		}
	}
}
