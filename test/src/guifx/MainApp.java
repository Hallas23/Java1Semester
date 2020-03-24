package guifx;

import application.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Mads, Ramsn og Simon
 */
public class MainApp extends Application {

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

		Tab tabHoteller = new Tab("Hoteller");
		tabPane.getTabs().add(tabHoteller);

		HotelPane companyPane = new HotelPane();
		tabHoteller.setContent(companyPane);
		tabHoteller.setOnSelectionChanged(event -> companyPane.updateHotel());

		Tab tabDeltager = new Tab("Deltager");
		tabPane.getTabs().add(tabDeltager);

		DeltagerPane deltagerPane = new DeltagerPane();
		tabDeltager.setContent(deltagerPane);
		tabDeltager.setOnSelectionChanged(event -> deltagerPane.updateDeltager());

		Tab tabTilmelding = new Tab("Tilmeldinger");
		tabPane.getTabs().add(tabTilmelding);

		TilmeldingPane tilmeldingPane = new TilmeldingPane();
		tabTilmelding.setContent(tilmeldingPane);
		tabTilmelding.setOnSelectionChanged(event -> tilmeldingPane.updateTilmelding());

		Tab tabUdflugt = new Tab("Udflugter");
		tabPane.getTabs().add(tabUdflugt);

		UdflugtPane udflugtPane = new UdflugtPane();
		tabUdflugt.setContent(udflugtPane);
		tabUdflugt.setOnSelectionChanged(event -> udflugtPane.updateControls());

		Tab tabKonference = new Tab("Konferencer");
		tabPane.getTabs().add(tabKonference);

		KonferencePane konferencePane = new KonferencePane();
		tabKonference.setContent(konferencePane);
		tabKonference.setOnSelectionChanged(event -> konferencePane.updateControls());

	}

}
