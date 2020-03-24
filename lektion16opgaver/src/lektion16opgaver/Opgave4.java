package lektion16opgaver;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Opgave4 extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {	
		stage.setTitle("Boys and girls");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private ListView<String> lvwNames;
	private ArrayList<String> names;
	private ArrayList<String> boys;
	private ToggleGroup group;
	private RadioButton rb1;
	private RadioButton rb2;

	private void initContent(GridPane pane) {
		initNames();
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 7);

		// add a label to the pane (at col=0, row=1)
		Label lblNames = new Label("Names:");
		pane.add(lblNames, 0, 1);
		
		//Har byttet rundt på girl og boy så det stod i den rigtige rækkefølge i programmet, ikke særlig pænt.
		HBox box = new HBox();
		group = new ToggleGroup();
		String boy = "Girl";
		String girl = "Boy";
			rb1 = new RadioButton();
			rb1.setToggleGroup(group);
			rb1.setText(boy);
			rb1.setUserData(boy);
			box.getChildren().add(rb1);
			
			rb2 = new RadioButton();
			rb2.setToggleGroup(group);
			rb2.setText(girl);
			rb2.setUserData(girl);
			box.getChildren().add(rb2);
		
			
		pane.add(box, 0, 0, 4, 1);
		group.getToggles().get(0).setSelected(true);

		group.selectedToggleProperty().addListener(event -> toggleRadioButton());

		// add a text field to the pane (at col=1, row=0, spanning 2 columns and
		// 1 row)
		txfName = new TextField();
		pane.add(txfName, 1, 7, 1, 1);

		// add a listView to the pane(at col=1, row=0)
		lvwNames = new ListView<String>();
		pane.add(lvwNames, 1, 1, 1, 5);
		lvwNames.setPrefWidth(200);
		lvwNames.setPrefHeight(200);
		lvwNames.getItems().setAll(names);
		

		ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
		lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

		lvwNames.getSelectionModel().clearSelection();

		// add a button to the pane (at col=6, row=0)
		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 5, 7);

		// connect a method to the button
		btnAdd.setOnAction(event -> this.addAction());


	}

	// -------------------------------------------------------------------------
	// Button actions

	private void addAction() {
		String name = txfName.getText().trim();
		if (name.length() > 0 && rb1.isSelected()) {
			names.add(name);
			lvwNames.getItems().setAll(names);
		}
		else if (name.length() > 0 && rb2.isSelected()) {
			boys.add(name);
			lvwNames.getItems().setAll(boys);
			
		}
	}
	
	private void toggleRadioButton() {
		if (rb1.isSelected()) {;
				group.getSelectedToggle().getUserData();
				lvwNames.getItems().setAll(names);
				

			}
			else if (rb2.isSelected()) {
				lvwNames.getItems().setAll(boys);
				 group.getSelectedToggle().getUserData();
			}
	}



	private void initNames() {
		names = new ArrayList<String>();
		names.add("Jane");
		names.add("Eva");
		names.add("Lene");
		names.add("Mette");
		names.add("Tine");
		names.add("Line");
		names.add("Lone");
		names.add("Alberte");
		names.add("Pia");
	
		boys = new ArrayList<String>();
		boys.add("Ole");
		boys.add("Yan");
		boys.add("mand");
		boys.add("spand");
		boys.add("tttt");
		boys.add("fack");
		boys.add("Lone");
		boys.add("Alberte");
		boys.add("Pia");
	}

	// -------------------------------------------------------------------------
	// Selectionchange actions

	private void selectionChanged() {
		String newString = lvwNames.getSelectionModel().getSelectedItem();
		if (newString != null) {
			txfName.setText(newString);
		} else {
			txfName.clear();
		}
	}

}
