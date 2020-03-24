package guifx;



/**
 * Mads, Ramsn og Simon
 */

import application.controller.Controller;
import application.model.Deltager;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class DeltagerPane extends GridPane {
	private TextField txfName, txfAdresse, txfFirmatelefonnr, txftelefonnummer, txfAlder, txfBy, txfFirma;
	private ListView<Deltager> lwdeltagere;


	public DeltagerPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Deltagere");
		this.add(lblComp, 0, 0);

		lwdeltagere = new ListView<>();
		this.add(lwdeltagere, 0, 1, 1, 6);
		lwdeltagere.setPrefWidth(180);
		lwdeltagere.setPrefHeight(180);
		lwdeltagere.getItems().setAll(Controller.getDeltager());

//		lvwhotelTillæg = new ListView<>();
//		this.add(lvwhotelTillæg, 0, 3, 1, 3);
//		lvwhotelTillæg.setPrefWidth(200);
//		lvwhotelTillæg.setPrefHeight(200);
//		lvwhotelTillæg.getItems().setAll(Controller.getHotelTillæg());

		ChangeListener<Deltager> listener = (ov, oldDeltager, newDeltager) -> this.selectedCompanyChanged();
		lwdeltagere.getSelectionModel().selectedItemProperty().addListener(listener);

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

		
		Label lblBy = new Label("By");
		this.add(lblBy, 1, 3);
		txfBy = new TextField();
		this.add(txfBy, 2, 3);
		txfBy.setEditable(false);
		
		Label lblFirma = new Label("Firma");
		this.add(lblFirma, 1, 4);
		txfFirma = new TextField();
		this.add(txfFirma, 2, 4);
		txfFirma.setEditable(false);
		
		Label lblAlder = new Label("Alder");
		this.add(lblAlder, 1, 5);
		txfAlder = new TextField();
		this.add(txfAlder, 2, 5);
		txfAlder.setEditable(false);
		
		Label lbltelefonnummer = new Label("Telefonnummer:");
		this.add(lbltelefonnummer, 1, 6);
		txftelefonnummer = new TextField();
		this.add(txftelefonnummer, 2, 6);
		txftelefonnummer.setEditable(false);

		Label lblFirmatelefonnummer = new Label("Firmatelefonnummer:");
		this.add(lblFirmatelefonnummer, 1, 7);
		txfFirmatelefonnr = new TextField();
		this.add(txfFirmatelefonnr, 2, 7);
		txfFirmatelefonnr.setEditable(false);

		HBox hbxButtons = new HBox(10);
		this.add(hbxButtons, 0, 7, 3, 1);
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

		if (lwdeltagere.getItems().size() > 0) {
			lwdeltagere.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		DeltagerWindow dia = new DeltagerWindow("Opret Deltager");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lwdeltagere.getItems().setAll(Controller.getDeltager());
		int index = lwdeltagere.getItems().size() - 1;
		lwdeltagere.getSelectionModel().select(index);
	}

	private void updateAction() {
		Deltager deltager = lwdeltagere.getSelectionModel().getSelectedItem();
		if (deltager == null) {
			return;
		}

		DeltagerWindow hw = new DeltagerWindow("Opdatere deltager", deltager);
		hw.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lwdeltagere.getSelectionModel().getSelectedIndex();
		lwdeltagere.getItems().setAll(Controller.getDeltager());
		lwdeltagere.getSelectionModel().select(selectIndex);
	}

	private void deleteAction() {
		Deltager deltager = lwdeltagere.getSelectionModel().getSelectedItem();
		if (deltager != null) {
			Controller.deleteDeltager(deltager);
			txfName.clear();
			lwdeltagere.getItems().setAll(Controller.getDeltager());
			this.updateDeltager();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedCompanyChanged() {
		this.updateDeltager();
	}

	public void updateDeltager() {
		Deltager deltager = lwdeltagere.getSelectionModel().getSelectedItem();
		if (deltager != null) {
			String firmatelefonNr = String.valueOf(deltager.getFirmatelefonNr());
			String telefonNr = String.valueOf(deltager.getTelefonNr());
			String alder = String.valueOf(deltager.getAlder());

			txfName.setText(deltager.getNavn());
			txfAdresse.setText(deltager.getAdresse());
			txfFirmatelefonnr.setText(firmatelefonNr);
			txftelefonnummer.setText(telefonNr);
			txfAlder.setText(alder);
			txfBy.setText(deltager.getBy());
			txfFirma.setText(deltager.getFirmanavn());
			

		} else {
			txfName.clear();
			txfAdresse.clear();
			txfFirmatelefonnr.clear();
			txftelefonnummer.clear();
			txfAlder.clear();
			txfFirma.clear();
			txfBy.clear();

		}

	}

}
