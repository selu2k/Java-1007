import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.paint.Color;  
import javafx.scene.shape.*;
import javafx.event.EventHandler;  
import javafx.scene.control.Button;  
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Draw extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Draw");
        Menu ms = new Menu("Shapes");
        Menu mc = new Menu("Colors");
        MenuBar menuBar = new MenuBar();
        
        MenuItem m1 = new MenuItem("Circle");
        MenuItem m2 = new MenuItem("Rectanle");
        MenuItem m3 = new MenuItem("Ellipse");
        MenuItem m4 = new MenuItem("Red");
        MenuItem m5 = new MenuItem("Green");
        MenuItem m6 = new MenuItem("Cyan");
        
        ms.getItems().addAll(m1,m2,m3);
        mc.getItems().addAll(m4,m5,m6);
        menuBar.getMenus().addAll(ms,mc);
        VBox root = new VBox(menuBar);
        Rectangle rec = new Rectangle(240, 240);
        Circle cir = new Circle(50.0f, Color.RED);
        Ellipse elipse = new Ellipse();  
        elipse.setCenterX(100);  
        elipse.setCenterY(100);  
        elipse.setRadiusX(50);  
        elipse.setRadiusY(80);  

        EventHandler<MouseEvent> circi = new EventHandler<MouseEvent>() {
            
        public void handle(MouseEvent e)
        { 
            Circle cir = new Circle(50.0f, Color.RED);
            cir.setFill(Color.color(1,1,1));
            cir.setStroke(Color.color(0,0,0));
            cir.setStrokeWidth(1);root.getChildren().clear();
            root.getChildren().add(cir);
            }

        };

        EventHandler<MouseEvent> elip = new EventHandler<MouseEvent>() {
            
        public void handle(MouseEvent e)
        { 
            Ellipse elipse = new Ellipse();  
            elipse.setCenterX(100);  
            elipse.setCenterY(100);  
            elipse.setRadiusX(50);  
            elipse.setRadiusY(80);root.getChildren().clear();
            root.getChildren().add(elipse);
            }

        };

        EventHandler<MouseEvent> rect = new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent e)
            {
            Rectangle rec1 = new Rectangle(240, 240);
            rec1.setFill(Color.color(1,1,1));
            rec1.setStroke(Color.color(0,0,0));
            rec1.setStrokeWidth(1); root.getChildren().clear();
            root.getChildren().add(rec1);
           
        }
    };  

    EventHandler<MouseEvent> redd = new EventHandler<MouseEvent>() {
            
        public void handle(MouseEvent e)
        {
            root.getChildren().setFill(Color.RED);
        }
    };    
    EventHandler<MouseEvent> greenn = new EventHandler<MouseEvent>() {
            
        public void handle(MouseEvent e)
        {
            root.getChildren().setFill(Color.GREEN);
        }
    };    
    EventHandler<MouseEvent> cyaan = new EventHandler<MouseEvent>() {
            
        public void handle(MouseEvent e)
        {
            root.getChildren().setFill(Color.CYAN);
        }
    };    

        m1.addEventHandler(MouseEvent.MOUSE_PRESSED, circi);
        m2.addEventHandler(MouseEvent.MOUSE_PRESSED, rect);
        m3.addEventHandler(MouseEvent.MOUSE_PRESSED, elip);
        m4.addEventHandler(MouseEvent.MOUSE_PRESSED, redd);
        m5.addEventHandler(MouseEvent.MOUSE_PRESSED, greenn);
        m6.addEventHandler(MouseEvent.MOUSE_PRESSED, cyaan);


        Scene scene = new Scene(root, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}