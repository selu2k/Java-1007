import javafx.animation.TranslateTransition;  
import javafx.application.Application;  
import javafx.event.EventHandler;  
import javafx.scene.shape.Circle;  
import javafx.stage.Stage;
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;  
import javafx.scene.input.MouseEvent;  
import javafx.scene.paint.Color;  
import javafx.scene.control.*; 
import javafx.scene.shape.Circle; 
import javafx.util.Duration;
import java.util.*; 
import java.io.*; 

public class Myfirst extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Circle c = new Circle(100,100,50);
        c.setFill(Color.GREEN);
        c.setStroke(Color.BLACK);
        BorderPane root2 = new BorderPane();
        TranslateTransition trans = new TranslateTransition();
        trans.setAutoReverse(true);
        trans.setByX(200);
        trans.setCycleCount(100);
        trans.setDuration(Duration.millis(500));
        trans.setNode(c);

        MenuBar menubar = new MenuBar();  
        Menu FileMenu = new Menu("File");  
        MenuItem filemenu1=new MenuItem("new");  
        MenuItem filemenu2=new MenuItem("Save");  
        MenuItem filemenu3=new MenuItem("Exit");  
        Menu EditMenu=new Menu("Edit");  
        MenuItem EditMenu1=new MenuItem("Cut");  
        MenuItem EditMenu2=new MenuItem("Copy");  
        MenuItem EditMenu3=new MenuItem("Paste"); 
        FileMenu.getItems().addAll(filemenu1,filemenu2,filemenu3);  
        menubar.getMenus().addAll(FileMenu,EditMenu);  
        
        EditMenu.getItems().addAll(EditMenu1,EditMenu2,EditMenu3); 
        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                trans.play();
            }
        };
        c.setOnMouseClicked(handler);
        GridPane root = new GridPane();
        root2.setTop(menubar);
        root.add(root2,0,0);
        root.add(c,3,3,6,6);
        //root.getChildren().addAll(c,root2);
        Scene scene = new Scene(root,420,300,Color.WHEAT);
        //Scene s2 = new Scene(root2,420,300,Color.WHEAT);
        stage.setScene(scene);
        stage.setTitle("My first javafx");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
