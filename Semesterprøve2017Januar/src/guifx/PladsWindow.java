package guifx;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import application.controller.Controller;
import application.model.Område;
import application.model.Kamp;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PladsWindow extends Stage {

    public PladsWindow(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

  

    // -------------------------------------------------------------------------

    private TextField txfName, txfKonsol;
    private Label lblError;
 

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Nummer");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 1, 0);
        txfName.setPrefWidth(200);

        Label lblKonsol = new Label("Konsol type");
        pane.add(lblKonsol, 0, 5);

        txfKonsol = new TextField();
        pane.add(txfKonsol, 1, 5);
        txfKonsol.setOpacity(0);
        txfKonsol.setEditable(false);;
        
        CheckBox KonsolButton = new CheckBox("Med Spillekonsol");
		pane.add(KonsolButton, 1, 3);
	    ChangeListener<Boolean> listener =
	    (ov, oldValue, newValue) -> selectedCompanyChanged(newValue);
	    KonsolButton.selectedProperty().addListener(listener);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 6);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 1, 6);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 5);
        lblError.setStyle("-fx-text-fill: red");
        
        
       
    }

    
    

    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        int nr = Integer.parseInt(txfName.getText().trim());
        String konsolnavn = txfKonsol.getText().trim();

        if (nr < 0) {
            lblError.setText("nr kan ikke være negativ");
            return;
        }
        
        if (!konsolnavn.isEmpty()) {
        	Controller.createKonsolplads(nr, konsolnavn).setOmråde(Område.STANDARD);
        }
        else {
            Controller.createPlads(nr).setOmråde(Område.STANDARD);;
        }

        this.hide();
    }

    
    private void selectedCompanyChanged(boolean checked) {
    	if (checked) {
    	 txfKonsol.setOpacity(100);
         txfKonsol.setEditable(true);;
    	}
    	
    	else {
    		 txfKonsol.setOpacity(0);
             txfKonsol.setEditable(false);;
    	}
    }

}

