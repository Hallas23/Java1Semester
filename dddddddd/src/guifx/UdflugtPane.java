package guifx;
import java.awt.TextArea;
import java.util.Optional;

import application.controller.Controller;
import application.model.Udflugt;
import application.model.Tilmelding;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class UdflugtPane extends GridPane {
	private TextField txfUdflugt, txfAdresse, txfStartTid, txfKonf;
	private TextArea txaUdfl;
	private ListView<Udflugt> lvwUdflugter;
	private ListView<Tilmelding> lvwTilmeldinger;
	
		public UdflugtPane() {
			this.setPadding(new Insets(20));
			this.setHgap(20);
			this.setVgap(10);
			this.setGridLinesVisible(false);

			Label lblUdfl = new Label("Udflugter");
			this.add(lblUdfl, 0, 0);

			lvwUdflugter = new ListView<>();
			this.add(lvwUdflugter, 0, 1, 1, 3);
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
			
			Label lblKonf = new Label("Konference:");
			this.add(lblKonf, 1, 4);

			txfKonf = new TextField();
			this.add(txfKonf, 2, 4);
			txfKonf.setEditable(false);

			HBox hbxButtons = new HBox(40);
			this.add(hbxButtons, 0, 9, 3, 1);
			hbxButtons.setPadding(new Insets(10, 0, 0, 0));
			hbxButtons.setAlignment(Pos.BASELINE_CENTER);

			Button btnCreate = new Button("Create");
			hbxButtons.getChildren().add(btnCreate);
			btnCreate.setOnAction(event -> this.createAction());

//			Button btnUpdate = new Button("Update");
//			hbxButtons.getChildren().add(btnUpdate);
//			btnUpdate.setOnAction(event -> this.updateAction());

			Button btnDelete = new Button("Delete");
			hbxButtons.getChildren().add(btnDelete);
			btnDelete.setOnAction(event -> this.deleteAction());

			if (lvwUdflugter.getItems().size() > 0) {
				lvwUdflugter.getSelectionModel().select(0);
			}
		}

		// -------------------------------------------------------------------------

		private void createAction() {
			UdflugtWindow dia = new UdflugtWindow("Create Udflugt");
			dia.showAndWait();

			// Wait for the modal dialog to close

			lvwUdflugter.getItems().setAll(Controller.getUdflugter());
			int index = lvwUdflugter.getItems().size() - 1;
			lvwUdflugter.getSelectionModel().select(index);
		}

//		private void updateAction() {
//			Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
//			if (konference == null) {
//				return;
//			}
//
//			CompanyWindow dia = new CompanyWindow("Update Company", company);
//			dia.showAndWait();
//
//			// Wait for the modal dialog to close
//
//			int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
//			lvwCompanies.getItems().setAll(Controller.getCompanies());
//			lvwCompanies.getSelectionModel().select(selectIndex);
//		}

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
				txfStartTid.setText("" + udflugt.getFraTid());
				txfKonf.setText("" + udflugt.getKonference());
				
		}
}
}
