package guifx;
/**
 * Mads, Ramsn og Simon
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import application.controller.Controller;
import application.model.*;
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

public class UdflugtWindow extends Stage {
    private Udflugt udflugt;

    public UdflugtWindow(String title, Udflugt udflugt) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.udflugt = udflugt;

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public UdflugtWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private TextField txfUdflugt, txfAdresse, txfStartTid, txfPris;
    private ComboBox<Konference> cbbKonf;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblUdflugt = new Label("Udflugt");
        pane.add(lblUdflugt, 0, 0);

        txfUdflugt = new TextField();
        pane.add(txfUdflugt, 0, 1);
        txfUdflugt.setPrefWidth(200);

        Label lblAdresse = new Label("Adresse");
        pane.add(lblAdresse, 0, 2);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 0, 3);
        
        Label lblStartTid = new Label("StartTid");
        pane.add(lblStartTid, 0, 4);

        txfStartTid = new TextField();
        pane.add(txfStartTid, 0, 5);
        
        Label lblPris = new Label("Pris");
        pane.add(lblPris, 0, 6);

        txfPris = new TextField();
        pane.add(txfPris, 0, 7);

        cbbKonf = new ComboBox<>();
        pane.add(cbbKonf, 0, 8);
        cbbKonf.getItems().addAll(Controller.getKonference());
        cbbKonf.setDisable(false);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 9);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 1, 9);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> okAction());

        lblError = new Label();
        pane.add(lblError, 0, 10);
        lblError.setStyle("-fx-text-fill: red");

        initControls();
    }

    private void initControls() {
        if (udflugt != null) {
            txfUdflugt.setText(udflugt.getBeskrivelse());
            txfAdresse.setText("" + udflugt.getAdresse());
            if (udflugt.getKonference() != null) {
                cbbKonf.getSelectionModel().select(udflugt.getKonference());
            }
            else {
                cbbKonf.getSelectionModel().select(0);
            }
        }
        else {
            txfUdflugt.clear();
            txfAdresse.clear();
            cbbKonf.getSelectionModel().select(0);
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        hide();
    }

    private void okAction() {
         
    	String beskrivelse = txfUdflugt.getText().trim();
       if (beskrivelse.length() == 0) {
            lblError.setText("Udflugt er tomt");
            return;
        }

       String adresse = txfAdresse.getText().trim();
       if (adresse.length() == 0) {
            lblError.setText("Udflugt er tomt");
            return;
        }
       
       DateTimeFormatter localDate1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       LocalDate startTid = LocalDate.parse(txfStartTid.getText(), localDate1);
       if (txfStartTid.getLength() == 0) {
       	lblError.setText("Start tid er tomt");
           return;
       }
       
       int pris = Integer.parseInt(txfPris.getText().trim());
       if(pris < 0) {
    	   lblError.setText("Pris er tomt");
           return;
       }
       
       Konference konference = cbbKonf.getSelectionModel().getSelectedItem();

       if (udflugt != null) {
           Controller.updateUdflugt(udflugt, beskrivelse, adresse, startTid, pris, konference);
       } else {
           Controller.CreateUdflugt(beskrivelse, adresse, startTid, pris, konference);
       }

       this.hide();
   }
}
