package guifx;

import application.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private static final Tab Konference = null;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		Controller.init();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Arcitecture Demo");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tabKonference = new Tab("Konference");
		tabPane.getTabs().add(tabKonference);

		KonferencePane konferencePane = new KonferencePane();
		tabKonference.setContent(konferencePane);
		tabKonference.setOnSelectionChanged(event -> konferencePane.updateControls());
		
		Tab tabUdflugt = new Tab("Udflugt");
		tabPane.getTabs().add(tabUdflugt);

		UdflugtPane UdflugtPane = new UdflugtPane();
		tabUdflugt.setContent(UdflugtPane);
		tabUdflugt.setOnSelectionChanged(event -> UdflugtPane.updateControls());

//		Tab tabEmployees = new Tab("Employees");
//		tabPane.getTabs().add(tabEmployees);
//
//		EmployeePane employeePane = new EmployeePane();
//		tabEmployees.setContent(employeePane);
//		tabEmployees.setOnSelectionChanged(event -> employeePane.updateControls());
	}
}