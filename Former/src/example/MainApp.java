package example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Circle circle = new Circle(300, 300, 200);
        pane.getChildren().add(circle);
        circle.setFill(Color.BLACK);
        
        Circle circle4 = new Circle(300, 300, 150);
        pane.getChildren().add(circle4);
        circle4.setFill(Color.WHITE);
        
        Circle circle1 = new Circle(300, 300, 100);
        pane.getChildren().add(circle1);
        circle1.setFill(Color.BLACK);
        
        Circle circle2 = new Circle(300, 300, 50);
        pane.getChildren().add(circle2);
        circle2.setFill(Color.WHITE);
        
        Circle circle3 = new Circle(300, 300, 25);
        pane.getChildren().add(circle3);
        circle3.setFill(Color.BLACK);
        
        double ole = 22.22;
        double wedel = 22.22;
        System.out.println(ole * wedel);
        
    }

}
