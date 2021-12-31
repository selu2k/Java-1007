import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Ellipse;

public class onSpotProject extends Application {
  // Indicate which player has a turn, initially it is the X player
  private char whoseTurn = 'X';

  public String playername1;
  public String playername2;

  // create each cell in the box
  private box[][] cell = new box[3][3];

  // Display which playre's turn it is
  private Label playerTurn = new Label(playername1 + "'s turn to play");

  public void start(Stage primaryStage) {

    // Initial game scene
    BorderPane start_layout = new BorderPane();

    // menu
    VBox menu = new VBox();
    menu.setSpacing(25);

    Button play = new Button("Start");
    play.setMaxHeight(1000);
    play.setMaxWidth(300);
    Button exit = new Button("Exit");
    exit.setMaxHeight(1000);
    exit.setMaxWidth(300);

    Label welcome = new Label("Tic Tac Toe!");
    welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 100));

    Label madeby = new Label("The game was made by Selukash and Eshan.");
    exit.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        primaryStage.close();
      }
    });
    menu.getChildren().addAll(welcome, play, exit);

    // start_layout.getChildren().addAll(menu);
    menu.setAlignment(Pos.CENTER);

    start_layout.setBottom(madeby);
    start_layout.setCenter(menu);
    Scene gameStart = new Scene(start_layout, 600, 500);

    // Player scene

    Label name1 = new Label("Player 1:");
    TextField playerName1 = new TextField();

    Label name2 = new Label("Player 2:");
    TextField playerName2 = new TextField();

    Button submit = new Button("Submit");

    HBox p1 = new HBox();
    p1.getChildren().addAll(name1, playerName1);
    HBox p2 = new HBox();
    p1.getChildren().addAll(name2, playerName2);
    p1.setAlignment(Pos.CENTER);
    p2.setAlignment(Pos.CENTER);

    VBox playerData = new VBox();
    playerData.getChildren().addAll(p1, p2, submit);
    playerData.setAlignment(Pos.CENTER);
    playerData.setSpacing(25);
    playerData.setPadding(new Insets(30, 30, 30, 30));
    Scene palyers = new Scene(playerData, 600, 500);

    // Pane to hold cell
    GridPane pane = new GridPane();
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        pane.add(cell[i][j] = new box(), j, i);

    // To see line between the cells of the box.
    pane.setGridLinesVisible(true);
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(playerTurn);

    Scene scene = new Scene(borderPane, 600, 500);
    primaryStage.setTitle("TicTacToe");
    primaryStage.setScene(gameStart);

    // second scene to take player name.
    play.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        primaryStage.setScene(palyers);
      }
    });

    // Last scene where the game is.
    submit.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        playername1 = playerName1.getText();
        playername2 = playerName2.getText();
        primaryStage.setScene(scene);
      }
    });
    primaryStage.show();
  }

  public boolean Occupied() {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (cell[i][j].getToken() == ' ')
          return false;

    return true;
  }

  // To check who won
  public boolean isWon(char val) {
    for (int i = 0; i < 3; i++)
      if (cell[i][0].getToken() == val && cell[i][1].getToken() == val && cell[i][2].getToken() == val) {
        return true;
      }

    for (int j = 0; j < 3; j++)
      if (cell[0][j].getToken() == val && cell[1][j].getToken() == val && cell[2][j].getToken() == val) {
        return true;
      }

    if (cell[0][0].getToken() == val && cell[1][1].getToken() == val && cell[2][2].getToken() == val) {
      return true;
    }

    if (cell[0][2].getToken() == val
        && cell[1][1].getToken() == val
        && cell[2][0].getToken() == val) {
      return true;
    }

    return false;
  }

  public class box extends Pane {

    private char val = ' ';

    public box() {
      this.setPrefSize(800, 800);
      this.setOnMouseClicked(e -> {
        try {
          // If cell is empty and game is not over
          if (val == ' ' && whoseTurn != ' ') {
            setToken(whoseTurn);

            // Check game status
            if (isWon(whoseTurn)) {
              playerTurn.setText(
                  whoseTurn == 'X' ? playername1 + " won! The game is over" : playername2 + " won! The game is over");
              whoseTurn = ' ';
            } else if (Occupied()) {
              playerTurn.setText("Draw! The game is over");
              whoseTurn = ' ';
            } else {
              // Change the turn
              whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';

              playerTurn.setText(whoseTurn == 'X' ? playername1 + "'s turn" : playername2 + "'s turn");
            }
          }
        } catch (Exception e1) {

          e1.printStackTrace();
        }
      });
    }

    public char getToken() {
      return val;
    }

    public void setToken(char c) throws Exception {
      val = c;

      if (val == 'X') {
        Image cir = new Image(new FileInputStream("Cross.png"));
        ImageView circle = new ImageView(cir);
        BackgroundImage myBI = new BackgroundImage(cir, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(myBI));
      } else if (val == 'O') {
        Image cir = new Image(new FileInputStream("circle.jpeg"));
        ImageView circle = new ImageView(cir);
        BackgroundImage myBI = new BackgroundImage(cir, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(myBI));
      }
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}