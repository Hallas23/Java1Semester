package template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes12(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc)
    {
        // Replace the statement here with your code.
    	int x1 = 100;
    	int y1 = 200;
    	int x2 = 20;
    	int y2 = 10;
    	while (x2 <= 180) {
    	gc.strokeLine(x1, y1, x2, y2);
    	x2 = x2 + 40;
    	}
    }
    
    private void drawShapes1(GraphicsContext gc)
    {
        // Replace the statement here with your code.
    	int x1 = 100;
    	int y1 = 100;
    	int x2 = 20;
    	int y2 = 10;
    	while (x2 <= 180) {
    	gc.strokeLine(x1, y1, x2, y2);
    	x2 = x2 + 20;
    	}
    }
    
    private void drawShapes2(GraphicsContext gc)
    {
        // Replace the statement here with your code.
    	int x1 = 20;
    	int y1 = 190;
    	int x2 = 180;
    	int y2 = 10;
    	while (x1 <= 180) {
    	gc.strokeLine(x1, y1, x2, y2);	
    	x1 = x1 + 40;
    	x2 = x2 - 40;
    	}
    }
    

    private void drawShapes3(GraphicsContext gc)
    {
        // Replace the statement here with your code.
    	int p1x = 20;
    	int p1y = 10;
    	int p2x	= 20;
    	int p2y = 180;
    	while (p1x <= 180) {
    	gc.strokeLine(p1x,p1y, p2x, p2y);	
    	p1x = p1x + 40;
    	p2x = p2x + 40;
    	}
    }
    	
    	
    	private void drawShapes4(GraphicsContext gc)
        {
            // Replace the statement here with your code.
        	int p1x = 20;
        	int p1y = 10;
        	int p2x	= 180;
        	int p2y = 10;
        	while (p1y <= 180) {
        	gc.strokeLine(p1x,p1y, p2x, p2y);	
        	p1y = p1y + 40;
        	p2y = p2y + 40;
        	
        	}}
    	
        	private void drawShapes5(GraphicsContext gc)
            {
                // Replace the statement here with your code.
            	int p1x = 90;
            	int p1y = 10;
            	int p2x	= 110;
            	int p2y = 10;
            	while (p2x <= 190) {
            	gc.strokeLine(p1x,p1y, p2x, p2y);	
            	p1y = p1y + 40;
            	p2y = p2y + 40;
            	p1x = p1x + -20;
            	p2x = p2x + 20;
            }
    }
        	private void drawShapes6(GraphicsContext gc)
            {
                // Replace the statement here with your code.
            	int x = 50;
            	int y = 100;
            	int r = 40;
            	while (x <= 150) {
            	gc.strokeOval(x - r, y - r, 2 * r, 2 * r);	
            	x = x + 25;
            }
    }
        	private void drawShapes7(GraphicsContext gc)
            {
                // Replace the statement here with your code.
            	int x = 100;
            	int y = 100;
            	int r = 20;
            	while (r <= 100) {
            	gc.strokeOval(x - r, y - r, 2 * r, 2 * r);	
            	r = r + 20;
            	
            }
    }
        	
        	private void drawShapes8(GraphicsContext gc)
            {
                // Replace the statement here with your code.
            	int x = 20;
            	int y = 100;
            	int r = 10;
            	while (r <= 100) {
            	gc.strokeOval(x - r, y - r, 2 * r, 2 * r);	
            	x = x + 10;
            	r = r + 10;
            	
            }
    }
        	private void drawShapes9(GraphicsContext gc)
            {
                // Replace the statement here with your code.
            	int x = 100;
            	int y = 150;
            	int h = 75;
            	int r = 90;
            	while (r >= 20) {
            	gc.strokeOval(x - r, y - r, 2 * r, h);	
            	y = y - 10;
            	r = r - 10;
            	
            }
    }
        	private void drawShapes10(GraphicsContext gc)
            {
               String s = "Datamatiker";
               int x = 10;
               int y = 10;
               int i = s.length();
               int e = 0;
               
               while(e <= i) {
            	  gc.fillText(s.substring(0, e++), x, y);
            	  y = y + 10;
               }
            	
            }
        	private void drawShapes11(GraphicsContext gc)
            {
               gc.strokeLine(180, 180, 170, 175);
               gc.strokeLine(180, 180, 170, 185);
               gc.strokeLine(14, 160, 14, 200);
               int y1 = 175;
               int y2 = 185;
               
               for(int x = 14; x <= 160; x = x + 14) {
            	   gc.strokeLine(10, 180, 180, 180);
            	   gc.strokeLine(x, y1, x, y2);
            	   gc.strokeLine(x * 5, 160, x *5, 200);
            	   
            	   
               		}
            }
        	
        	private void drawShapes12(GraphicsContext gc)
            {
              
               
                int y1 = 50;
                int y2 = 100;
                double x = 180;
               
               while(x > 5) {
            	   gc.strokeLine(x, y1, x, y2);	
            	   x = x * 0.75;
            	   y1 = y1 + 10;
            	   y2= y2 - 10;
            
            	   
            	   
               		}
            }
}					

