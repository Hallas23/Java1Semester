package lektion5opgaver;


	
	import javafx.application.Application;
	import javafx.geometry.Insets;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.CheckBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.GridPane;
	import javafx.stage.Stage;

	public class lektion15opgave2 extends Application {
		public static void main(String[] args) {
			Application.launch(args);
		}

		@Override
		public void start(Stage stage) {
			stage.setTitle("Kombiner navne");
			GridPane pane = new GridPane();
			this.initContent(pane);

			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.show();
			
		}
		
		private TextField txAInf;
		private TextField txAInf2;
		private TextField txAInf3;
		private Button btnKomb;
		
		private void initContent(GridPane pane) {
			
			pane.setGridLinesVisible(false);
			
			pane.setPadding(new Insets(10));
			
			pane.setHgap(10);
			
			pane.setVgap(10);
			
			txAInf = new TextField();
			txAInf.setEditable(true);
			txAInf.setPrefWidth(150);
			txAInf.setPrefHeight(10);
			pane.add(txAInf, 0, 0);
			
			txAInf2 = new TextField();
			txAInf2.setEditable(true);
			txAInf2.setPrefWidth(150);
			txAInf2.setPrefHeight(10);
			pane.add(txAInf2, 0, 1);
			
			
			btnKomb = new Button("ombyt");
			pane.add(btnKomb, 0, 3, 2, 1);
			
			btnKomb.setOnAction(event -> this.addAction());
			
			
			
		}
		
			private void addAction() {
			String s1 = txAInf.getText();
			String s2 = txAInf2.getText();
			txAInf.setText(s2);
			txAInf2.setText(s1);
			
			}
		
	}


