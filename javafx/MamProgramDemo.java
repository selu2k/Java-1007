import javafx.stage.Stage; 
import javafx.application.Application;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.shape.Line; 
import javafx.scene.shape.*; 
import javafx.stage.Stage;  
import javafx.scene.paint.Color;  
import javafx.collections.*; 
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.io.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.transform.Scale;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Modality;

public class MamProgramDemo extends Application{ 
     
   public void start(Stage stage1) { 
   FlowPane root=new FlowPane();
   Button b1=new Button("b1");
   root.getChildren().addAll(b1);
    root.setVgap(10);
    root.setHgap(10);
   b1.setOnAction(new EventHandler<ActionEvent>(){
   public void handle(ActionEvent ae)
   {
    TextField tf1=new TextField("Enter ur text here");
    TextField tf2=new TextField();
    Button b2=new Button("click");
    HBox root2=new HBox(10);
    root2.getChildren().addAll(tf1,tf2,b2);
    b2.setOnAction(new EventHandler<ActionEvent>(){
    public void handle(ActionEvent ae2)
    {
      tf2.setText(tf1.getText());
      System.out.println(tf1.getText());
     }});
     Stage stage2=new Stage();
      Scene scene2 = new Scene(root2, 200, 100,Color.rgb(100,100,150,0.5)); 
      stage2.setTitle("Second Frame"); 
      stage2.initModality(Modality.APPLICATION_MODAL);  //Modality.WINDOW_MODAL
      stage2.setX(stage1.getX()+200);
      stage2.setY(stage1.getY()+150);
      stage2.initOwner(stage1);
      stage2.setScene(scene2); 
      stage2.show(); 
    
    
   }});
   
    Scene scene = new Scene(root, 600, 500,Color.rgb(100,100,150,0.5)); 
      stage1.setTitle("Sample application"); 
      stage1.setScene(scene); 
      stage1.show(); 
   }
   public static void main(String args[]){ 
      launch(args); 
   } 
}