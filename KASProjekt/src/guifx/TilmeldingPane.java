package guifx;

import application.controller.Controller;
/**
 * Mads, Ramsn og Simon
 */
import application.model.Tilmelding;
import application.model.Udflugt;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TilmeldingPane extends GridPane {
	private TextField txfName, txfLedsager, txfKonference, txfHotel,txfAnkomstdato, txfAfrejsedato, txfForedrag, txfDobbeltseng,
			txfMad, txfWifi, txfBad;
	private ListView<Tilmelding> lvwtilmeldinger;
	private ListView<Udflugt> lvwUdflugter;


	public TilmeldingPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Tilmeldinger");
		this.add(lblComp, 0, 0);

		lvwtilmeldinger = new ListView<>();
		this.add(lvwtilmeldinger, 0, 1, 1, 13);
		lvwtilmeldinger.setPrefWidth(180);
		lvwtilmeldinger.setPrefHeight(180);
		lvwtilmeldinger.getItems().setAll(Controller.getTilmeldinger());

		ChangeListener<Tilmelding> listener = (ov, oldTilmelding, newTilmelding) -> this.selectedTilmeldingChanged();
		lvwtilmeldinger.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Navn:");
		this.add(lblName, 1, 1);
		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setEditable(false);

		Label lblledsager = new Label("Ledsager:");
		this.add(lblledsager, 1, 2);
		txfLedsager = new TextField();
		this.add(txfLedsager, 2, 2);
		txfLedsager.setEditable(false);

		Label lblforedrag = new Label("Foredragsholder");
		this.add(lblforedrag, 1, 3);
		txfForedrag = new TextField();
		this.add(txfForedrag, 2, 3);
		txfForedrag.setEditable(false);

		Label lblseng = new Label("Dobbeltseng");
		this.add(lblseng, 1, 4);
		txfDobbeltseng = new TextField();
		this.add(txfDobbeltseng, 2, 4);
		txfDobbeltseng.setEditable(false);

		Label lblankomstdato = new Label("Ankomstdato");
		this.add(lblankomstdato, 1, 6);
		txfAnkomstdato = new TextField();
		this.add(txfAnkomstdato, 2, 6);
		txfAnkomstdato.setPrefWidth(200);

		Label lblafrejsedato = new Label("Afrejsedato");
		this.add(lblafrejsedato, 1, 7);
		txfAfrejsedato = new TextField();
		this.add(txfAfrejsedato, 2, 7);
		txfAfrejsedato.setPrefWidth(200);

		Label lblkonference = new Label("Konference");
		this.add(lblkonference, 1, 8);
		txfKonference = new TextField();
		this.add(txfKonference, 2, 8);
		txfKonference.setPrefWidth(200);
		
		Label lblHotel = new Label("Hotel");
		this.add(lblHotel, 1, 9);
		txfHotel = new TextField();
		this.add(txfHotel, 2, 9);
		txfHotel.setPrefWidth(200);

		Label lblMad = new Label("Mad");
		this.add(lblMad, 1, 10);
		txfMad = new TextField();
		this.add(txfMad, 2, 10);
		txfMad.setEditable(false);

		Label lblBad = new Label("Bad");
		this.add(lblBad, 1, 11);
		txfBad = new TextField();
		this.add(txfBad, 2, 11);
		txfBad.setEditable(false);

		Label lblWifi = new Label("Wifi");
		this.add(lblWifi, 1, 12);
		txfWifi = new TextField();
		this.add(txfWifi, 2, 12);
		txfWifi.setEditable(false);
		
		Label lblUdfl = new Label("Udflugter:");
		this.add(lblUdfl, 1, 14);

		lvwUdflugter = new ListView<>();
		this.add(lvwUdflugter, 2, 14, 1, 5);
		lvwUdflugter.setPrefWidth(200);
		lvwUdflugter.setPrefHeight(50);

		HBox hbxButtons = new HBox(10);
		this.add(hbxButtons, 0, 14, 3, 1);
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

		if (lvwtilmeldinger.getItems().size() > 0) {
			lvwtilmeldinger.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		TilmeldingWindow dia = new TilmeldingWindow("Opret tilmelding");
		dia.showAndWait();


		lvwtilmeldinger.getItems().setAll(Controller.getTilmeldinger());
		int index = lvwtilmeldinger.getItems().size() - 1;
		lvwtilmeldinger.getSelectionModel().select(index);
	}

	private void updateAction() {
		Tilmelding tilmelding = lvwtilmeldinger.getSelectionModel().getSelectedItem();
		if (tilmelding == null) {
			return;
		}

		TilmeldingWindow hw = new TilmeldingWindow("Opdatere tilmelding", tilmelding);
		hw.showAndWait();


		int selectIndex = lvwtilmeldinger.getSelectionModel().getSelectedIndex();
		lvwtilmeldinger.getItems().setAll(Controller.getTilmeldinger());
		lvwtilmeldinger.getSelectionModel().select(selectIndex);
	}

	private void deleteAction() {
		Tilmelding tilmelding = lvwtilmeldinger.getSelectionModel().getSelectedItem();
		if (tilmelding != null) {
			Controller.deleteTilmelding(tilmelding);
			txfName.clear();
			lvwtilmeldinger.getItems().setAll(Controller.getTilmeldinger());
			this.updateTilmelding();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedTilmeldingChanged() {
		this.updateTilmelding();
	}

	public void updateTilmelding() {
		Tilmelding tilmelding = lvwtilmeldinger.getSelectionModel().getSelectedItem();
		if (tilmelding != null) {
			txfName.setText(tilmelding.getNavn());
			txfLedsager.setText(tilmelding.getLedsagernavn());
			txfKonference.setText(tilmelding.getKonference().getBeskrivelse());
			txfAnkomstdato.setText("" + tilmelding.getAnkomstdato());
			txfAfrejsedato.setText("" + tilmelding.getAfrejsedato());
			txfHotel.setText("" + tilmelding.getHotel());
			
			lvwUdflugter.getItems().setAll(tilmelding.getUdflugter());

			if (tilmelding.isForedragsholder()) {
				txfForedrag.setText("Ja");
			} else {
				txfForedrag.setText("Nej");
			}

			if (tilmelding.isSeng()) {
				txfDobbeltseng.setText("Ja");
			} else {
				txfDobbeltseng.setText("Nej");
			}
			if (tilmelding.getHoteltillæg() != null) {
				if (tilmelding.getHoteltillæg().isBad()) {
					txfBad.setText("Ja");
				} else {
					txfBad.setText("Nej");
				}
				if (tilmelding.getHoteltillæg().isMad()) {
					txfMad.setText("Ja");
				} else {
					txfMad.setText("Nej");
				}
				if (tilmelding.getHoteltillæg().isWifi()) {
					txfWifi.setText("Ja");
				} else {
					txfWifi.setText("Nej");
				}

			}
			else {
				txfHotel.clear();
			}

		}

	}
}
