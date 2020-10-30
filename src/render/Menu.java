package render;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;



public class Menu extends Application {

  static Stage window ;
  //Button button;
  

  Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7;

  /**
   * This method launches the GUI
   * @param args
   * @author - Ivona Filipovic
   */
  public static void main(String[] args) {
      launch(args);
  }

  /**
   * This method creates the stage and the scenes for the GUI and links them using layouts.
   * It adds labels and buttons and sets the spacing and text as well as the size of the windows.
   *
   * @param primaryStage - this is the stage which everything is added to
   * @throws Exception
   * @author - Ivona Filipovic
   */
  public void start(Stage primaryStage) throws Exception {
      window = primaryStage;
      window.setTitle("Game Name");
      Label nameLabel = new Label("Game Name ");
      nameLabel.setId("name");  
      Label label1 = new Label("Start the game");
      Button button1 = new Button("PLAY");
      button1.setOnAction(e -> {
      window.setScene(scene2);
      });

      VBox layout1 = new VBox(10);
      layout1.setAlignment(Pos.BOTTOM_CENTER);
      Insets layout1Padding = new Insets(200, 1, 100, 1);
      layout1.setPadding(layout1Padding);
      layout1.getChildren().addAll(nameLabel, label1, button1);
      scene1 = new Scene(layout1, 600, 500);


      Label label2 = new Label("Choose the number of players");
      Button button2 = new Button("1 PLAYER");
      button2.setOnAction(e -> {
          window.setScene(scene3);
      });
      Button button3 = new Button("2 PLAYER");
      button3.setOnAction(e -> {
          window.setScene(scene4);
      });
      Button backButton1 = new Button("BACK");
      backButton1.setOnAction(e -> {
          window.setScene(scene1);
      });

      VBox layout2 = new VBox(10);
      layout2.setAlignment(Pos.BOTTOM_CENTER);
      Insets layout2Padding = new Insets(200, 1, 100, 1);
      layout2.setPadding(layout2Padding);
      layout2.getChildren().addAll(label2, button2, button3, backButton1);
      scene2 = new Scene(layout2, 600, 500);
      scene2.getStylesheets().add("render/Stylesheet.css");



      
      Label label3 = new Label(" Instructions for 1 player mode will be displayed here");
      Button button4 = new Button("Choose difficulty level");
      button4.setOnAction(e -> {
          window.setScene(scene5);
      });
      Button backButton2 = new Button("BACK");
      backButton2.setOnAction(e -> {
          window.setScene(scene2);
      });

      VBox layout3 = new VBox(10);
      layout3.setAlignment(Pos.BOTTOM_CENTER);
      Insets layout3Padding = new Insets(1, 1, 100, 1);
      layout3.setPadding(layout3Padding);
      layout3.getChildren().addAll(label3, button4, backButton2);
      scene3 = new Scene(layout3, 600, 500);
      scene3.getStylesheets().add("render/Stylesheet.css");



      
      Label label4 = new Label("Instructions for 2 player mode will be displayed here");
      Button button5 = new Button("Choose difficulty level");
      button5.setOnAction(e -> {
          window.setScene(scene5);
      });
      Button backButton3 = new Button("BACK");
      backButton3.setOnAction(e -> {
          window.setScene(scene2);
      });

     
      VBox layout4 = new VBox(10);
      layout4.setAlignment(Pos.BOTTOM_CENTER);
      Insets layout4Padding = new Insets(1, 1, 100, 1);
      layout4.setPadding(layout4Padding);
      layout4.getChildren().addAll(label4, button5, backButton3);
      scene4 = new Scene(layout4, 600, 500);
      scene4.getStylesheets().add("render/Stylesheet.css");


      Label label5 = new Label("Choose your difficulty level:");
      Button button6 = new Button("BEGINNER");
      button6.setOnAction(e -> {
          window.setScene(scene6);
      });

      Button button7 = new Button("INTERMEDIATE");
      button7.setOnAction(e -> {
          window.setScene(scene6);
      });
      Button button8 = new Button("ADVANCED");
      button8.setOnAction(e -> {
          window.setScene(scene6);
      });


      Button backButton4 = new Button("BACK");
      backButton4.setOnAction(e -> {
          window.setScene(scene4);
      });

      
      VBox layout5 = new VBox(10);
      layout5.setAlignment(Pos.BOTTOM_CENTER);
      Insets layout5Padding = new Insets(150, 1, 100, 1);
      layout5.setPadding(layout5Padding);
      layout5.getChildren().addAll(label5, button6, button7, button8, backButton4);
      scene5 = new Scene(layout5, 600, 500);
      scene5.getStylesheets().add("render/Stylesheet.css");
      
   
      Label label6 = new Label("BEGIN GAME?");
      Button button9 = new Button("YES");
      button9.setOnAction(e -> {
          window.setScene(scene7);
      });
     
      Button backButton5 = new Button("NO/BACK");
      backButton5.setOnAction(e -> {
          window.setScene(scene5);
      }); 

      VBox layout6 = new VBox(10);
      layout6.setAlignment(Pos.BOTTOM_CENTER);
      Insets layout6Padding = new Insets(200, 1, 100, 1);
      layout6.setPadding(layout6Padding);
     layout6.getChildren().addAll(label6, button9,backButton5);
      scene6 = new Scene(layout6, 600, 500);
      scene6.getStylesheets().add("render/Stylesheet.css");
      
      
      
      
    Button nextButton = new Button("NEXT");
       nextButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent e) {
               //window.setScene(scene7);
  //             audio.start(); //For when we will add audio to the game
   //            Game game = new Game();
          }
       });

      // Button backButton5 = new Button("BACK");
   //    backButton5.setOnAction(e -> {
    //       window.setScene(scene5);
   //    });
      
      
      
      
      VBox layout7 = new VBox(10);
      layout7.setAlignment(Pos.BOTTOM_CENTER);
      Insets layout7Padding = new Insets(100, 1, 100, 1);
      layout7.setPadding(layout7Padding);
      scene7 = new Scene(layout7, 600, 500);
      scene7.getStylesheets().add("render/Stylesheet.css");
      
      

      scene1.getStylesheets().add("render/Stylesheet.css");
      window.setScene(scene1);
      window.show();
  }
  
}

