package gui;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Yatzy;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// Shows the face values of the 5 dice.
	private TextField[] txfValues;
	
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds;
	// Shows the results previously selected .
	// For free results (results not set yet), the results
	// corresponding to the actual face values of the 5 dice are shown.
	private TextField[] txfResults;
	// Shows points in sums, bonus and total.
	private TextField txfBonus, txfSum1;
	private TextField txfTotal;
	private TextField txfSum2;
	// Shows the number of times the dice has been rolled.
	private Label lblRolled;
	private Label[] labels;
	private boolean[] Bresults = new boolean[15];


	

	private Button btnRoll;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");
		
		Font font = new Font(50);
		
		txfValues = new TextField[5];
		
		for (int i = 0; i < txfValues.length; i ++) {
			txfValues[i] = new TextField();
			txfValues[i].setPrefSize(100, 100);
			txfValues[i].setFont(font);
			dicePane.add(txfValues[i], i, 1);
			txfValues[i].setEditable(false);
		}
		
		chbHolds = new CheckBox[5];
		for (int i = 0; i < chbHolds.length; i ++) {
			chbHolds[i] = new CheckBox("Hold");
			dicePane.add(chbHolds[i], i, 2);
		}
		
		btnRoll = new Button("Roll");
		btnRoll.setPrefSize(50, 50);
		dicePane.add(btnRoll, 3, 3);
		btnRoll.setOnAction(event -> RollButton());
		
		lblRolled = new Label("Rolled: 0");
		dicePane.add(lblRolled, 4, 3);
		
		

		// initialize txfValues, chbHolds, btnRoll and lblRolled
		// TODO

		// ---------------------------------------------------------------------

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");
		int w = 50; // width of the text fields

		// Initialize labels for results, txfResults,
		// labels and text fields for sums, bonus and total.
		// TODO
		labels = new Label[15];
		labels[0] = new Label("1-s");
		labels[1] = new Label("2-s");
		labels[2] = new Label("3-s");
		labels[3] = new Label("4-s");
		labels[4] = new Label("5-s");
		labels[5] = new Label("6-s");
		labels[6] = new Label("One Par");
		labels[7] = new Label("Two Par");
		labels[8] = new Label("Three Same");
		labels[9] = new Label("Four Same");
		labels[10] = new Label("Full House");
		labels[11] = new Label("Small Straight");
		labels[12] = new Label("Large Straight");
		labels[13] = new Label("Chanche");
		labels[14] = new Label("Yatzy");
		
		for(int i = 0; i < labels.length; i++) {
			scorePane.add(labels[i], 0, i);
		}
		
		txfResults = new TextField[15];
		int[] results = dice.getResults();
		results.toString();
		for (int i = 0; i < txfResults.length; i ++) {
			txfResults[i] = new TextField();
			txfResults[i].setPrefWidth(w);
			scorePane.add(txfResults[i], 1, i);
			txfResults[i].setOnMouseClicked(event -> this.chooseFieldAction(event));
			

		}
		
		txfSum1 = new TextField();
		txfBonus = new TextField();
		Label txfsum1 = new Label("Sum:");
		Label txfbonus1 = new Label("Bonus");
		txfSum1.setPrefWidth(w);
		txfSum1.setEditable(false);
		txfBonus.setPrefWidth(w);
		txfBonus.setEditable(false);
		
		
		scorePane.add(txfsum1, 3, 5);
		scorePane.add(txfSum1, 4, 5);
		scorePane.add(txfbonus1, 5, 5);
		scorePane.add(txfBonus, 6, 5);
		
		txfSum2 = new TextField();
		txfTotal = new TextField();
		Label txfsum2 = new Label("Sum:");
		Label txfbonus2 = new Label("Total");
		txfSum2.setPrefWidth(w);
		txfTotal.setPrefWidth(w);
		txfSum2.setEditable(false);
		txfTotal.setEditable(false);
		
		scorePane.add(txfsum2, 3, 14);
		scorePane.add(txfSum2, 4, 14);
		scorePane.add(txfbonus2, 5, 14);
		scorePane.add(txfTotal, 6, 14);
		
		

	}

	// -------------------------------------------------------------------------

	private Yatzy dice = new Yatzy();

	// Create a method for btnRoll's action.
	// Hint: Create small helper methods to be used in the action method.
	// TODO
	
	private void RollButton() {
		dice.throwDice(GetHold());
		SetTxfValues();
		SetTxfResults();
		lblRolled.setText("Rolled : " + dice.getThrowCount());
		
		if(dice.getThrowCount() == 3) {
			btnRoll.setDisable(true);
		}
		
	}
	
	
	private boolean[] GetHold() {
		boolean[] hold = new boolean[5]; 
		for (int i = 0; i < hold.length; i++) {
			hold[i] = chbHolds[i].isSelected();
		}
		return hold;
	}
	
	private void SetTxfResults() {
		for (int i = 0; i < txfResults.length; i++) {
			if (!Bresults[i])
				txfResults[i].setText("" + dice.getResults()[i]);
			}
	}
	
	private void SetTxfValues() {
		for (int i = 0; i < txfValues.length; i++) {
			txfValues[i].setText("" + dice.getValues()[i]);
		}
	}
	
	private int SumOfSingles() {
		int result = 0;
		for (int i = 0; i < 6; i++) {
			if(Bresults[i])
			result = result  + Integer.parseInt(txfResults[i].getText());
		}
			if(result >= 63) {
				txfBonus.setText("50");
			}
		return result;
	}
	

	private int secondSum() {
		int result = 0;
		for (int i = 6; i < txfResults.length; i++) {
			if(Bresults[i]) {
			result = result  + Integer.parseInt(txfResults[i].getText());
			}
		}
		return result;
	}
	
	private int TotalSum() {
		int result = 0;
		for (int i = 0; i < txfResults.length; i++) {
			if(Bresults[i]) {
			result = result  + Integer.parseInt(txfResults[i].getText());
			}
		}
		
		if(SumOfSingles() > 63) {
			result = result + 50;
		}
		return result;
	}
	
	private void resetCheckBox() {
				for (int i = 0; i < chbHolds.length; i ++) {
					chbHolds[i].setSelected(false);
				}
	}
	
	private void resetValues() {
		for (int i = 0; i < txfValues.length; i ++) {
			txfValues[i].setText("");
		}
	}
	
	private void GameOver() {
		int counter = 0;
		for (int i = 0; i < Bresults.length; i++) {
			if(Bresults[i]) {
				counter++;
			}
		}
		if(counter == Bresults.length) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game over");
			alert.setHeaderText("Game is completed");
			alert.setContentText("You got a score of " + txfTotal.getText());
			alert.showAndWait();
			System.exit(0);
		}
	}
	
	// -------------------------------------------------------------------------

	// Create a method for mouse click on one of the text fields in txfResults.
	// Hint: Create small helper methods to be used in the mouse click method.
	// TODO
	public void chooseFieldAction(MouseEvent event) {
		TextField txt = (TextField) event.getSource();
		for (int i = 0; i < txfResults.length; i++) {
			if(txt == txfResults[i] && !Bresults[i]) {
				Bresults[i] = true;
				resetCheckBox();
				resetValues();
				txt.setStyle("-fx-text-inner-color: blue");
				txfSum1.setText(String.valueOf(SumOfSingles()));
				if(SumOfSingles() >= 63) {
					txfBonus.setText("50");
					
				}
				txfTotal.setText(String.valueOf(TotalSum()));
				txfSum2.setText(String.valueOf(secondSum()));
			}
			else if (!Bresults[i]) {
				txfResults[i].setText("0");
			}
			
		}
		dice.resetThrowCount();
		btnRoll.setDisable(false);
		GameOver();
	}

}
