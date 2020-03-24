package guifx;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import application.controller.Controller;

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

public class KampWindow extends Stage {

    private Kamp kamp;


	public KampWindow(String title, Kamp kamp) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);
        
        this.kamp = kamp;

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

  

    // -------------------------------------------------------------------------

    private TextField txfSpillested, txfDato ,txfTid;
    private Label lblError;
 

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblOmråde = new Label("Spilledato:");
		pane.add(lblOmråde, 0, 1);

		Label lblSpillested = new Label("Spillested:");
		pane.add(lblSpillested, 0, 0);

		Label lblFundet = new Label("Spilletid:");
		pane.add(lblFundet, 0, 2);

		txfSpillested = new TextField();
		pane.add(txfSpillested, 1, 0);

		txfDato = new TextField();
		pane.add(txfDato, 1, 1);
		
		txfTid = new TextField();
		pane.add(txfTid, 1, 2);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 3);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 1, 3);
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
    	 String sted = txfSpillested.getText().trim();
         if (sted.length() == 0) {
             lblError.setText("Name is empty");
             return;
         }
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
         LocalDate dato = LocalDate.parse(txfDato.getText().trim(), formatter);
                
         LocalTime tid = LocalTime.parse(txfTid.getText().trim());
         
         if (kamp != null) {
             Controller.updateKamp(kamp, sted, dato, tid);
         } else {
             Controller.createKamp(sted, dato, tid);
         }

        this.hide();
    }


}

