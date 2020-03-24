package guifx;

import java.util.Optional;
import application.controller.Controller;
import application.model.Udflugt;
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

/**
 * Mads, Ramsn og Simon
 */
public class UdflugtPane extends GridPane {
	private TextField txfUdflugt, txfAdresse, txfStartTid, txfKonf, txfPris;
	private ListView<Udflugt> lvwUdflugter;

	public UdflugtPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblUdfl = new Label("Udflugter");
		this.add(lblUdfl, 0, 0);

		lvwUdflugter = new ListView<>();
		this.add(lvwUdflugter, 0, 1, 1, 5);
		lvwUdflugter.setPrefWidth(200);
		lvwUdflugter.setPrefHeight(200);
		lvwUdflugter.getItems().setAll(Controller.getUdflugter());

		ChangeListener<Udflugt> listener = (ov, oldUdfl, newUdfl) -> this.selectedUdflugtChanged();
		lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblUdflugt = new Label("Udflugt:");
		this.add(lblUdflugt, 1, 1);

		txfUdflugt = new TextField();
		this.add(txfUdflugt, 2, 1);
		txfUdflugt.setEditable(false);

		Label lblAdresse = new Label("Adresse:");
		this.add(lblAdresse, 1, 2);

		txfAdresse = new TextField();
		this.add(txfAdresse, 2, 2);
		txfAdresse.setEditable(false);

		Label lblStartTid = new Label("Start Tid:");
		this.add(lblStartTid, 1, 3);

		txfStartTid = new TextField();
		this.add(txfStartTid, 2, 3);
		txfStartTid.setEditable(false);

		Label lblPris = new Label("Pris:");
		this.add(lblPris, 1, 4);

		txfPris = new TextField();
		this.add(txfPris, 2, 4);
		txfPris.setEditable(false);

		Label lblKonf = new Label("Konference:");
		this.add(lblKonf, 1, 5);

		txfKonf = new TextField();
		this.add(txfKonf, 2, 5);
		txfKonf.setEditable(false);

		HBox hbxButtons = new HBox(22);
		this.add(hbxButtons, 0, 6, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.CENTER_LEFT);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Update");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		if (lvwUdflugter.getItems().size() > 0) {
			lvwUdflugter.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		UdflugtWindow dia = new UdflugtWindow("Opret Udflugt");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwUdflugter.getItems().setAll(Controller.getUdflugter());
		int index = lvwUdflugter.getItems().size() - 1;
		lvwUdflugter.getSelectionModel().select(index);
	}

	private void updateAction() {
		Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
		if (udflugt == null) {
			return;
		}

		UdflugtWindow uw = new UdflugtWindow("Opdater Udflugt", udflugt);
		uw.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwUdflugter.getSelectionModel().getSelectedIndex();
		lvwUdflugter.getItems().setAll(Controller.getUdflugter());
		lvwUdflugter.getSelectionModel().select(selectIndex);
	}

	private void deleteAction() {
		Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
		if (udflugt == null) {
			return;
		}

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Slet Konference");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Er du sikker?");
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Controller.deleteUdflugt(udflugt);
			lvwUdflugter.getItems().setAll(Controller.getUdflugter());
			this.updateControls();

		}
	}

	// -------------------------------------------------------------------------

	private void selectedUdflugtChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
		if (udflugt != null) {
			txfUdflugt.setText(udflugt.getBeskrivelse());
			txfAdresse.setText(udflugt.getAdresse());
			txfStartTid.setText("" + udflugt.getFraDato());
			txfPris.setText("" + udflugt.getPris());
			txfKonf.setText("" + udflugt.getKonference());

		}
	}
}
