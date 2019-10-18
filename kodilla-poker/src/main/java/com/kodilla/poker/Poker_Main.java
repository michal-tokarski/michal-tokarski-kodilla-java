package com.kodilla.poker;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Poker_Main extends Application {


    public static FlowPane flowpane_Dealer_Hand = new FlowPane(Orientation.VERTICAL);
    public static FlowPane flowpane_Player_Hand = new FlowPane(Orientation.VERTICAL);

    private Label totalLabel = new Label();
    private Label totalLabelDealer = new Label();

    // Labels - Headings :
    private Label label_Dealer_Heading = new Label("Dealer's cards");
    private Label label_Player_Heading = new Label("Player's cards");

    // Labels - Poker categories :
    public static Label label_Dealer_PokerCategory = new Label("Dealer's poker category : ");
    public static Label label_Player_PokerCategory = new Label("Player's poker category : ");

    // Labels - Hand values :
    public static Label label_Dealer_HandValue = new Label("Dealer's hand value : ");
    public static Label label_Player_HandValue = new Label("Player's hand value : ");

    // Labels - Highest cards :
    public static Label label_Dealer_HighestCard = new Label("Dealer's highest card : ");
    public static Label label_Player_HighestCard = new Label("Player's highest card : ");

    private Label status = new Label();
    private Image imageback = new Image("cards_table.png");


    public static void main(String[] args) {
        // launches the stage
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        // ...........................
        totalLabel.setFont(new Font("Arial", 24));
        totalLabel.setTextFill(Color.web("#FFF"));

        totalLabelDealer.setFont(new Font("Arial", 24));
        totalLabelDealer.setTextFill(Color.web("#FFF"));

        status.setTextFill(Color.web("#FFF"));
        status.setFont(new Font("Arial", 24));

        // Jfx Labels - Headings :
        label_Dealer_Heading.setTextFill(Color.web("#FFF"));
        label_Dealer_Heading.setFont(new Font("Arial", 24));
        label_Player_Heading.setTextFill(Color.web("#FFF"));
        label_Player_Heading.setFont(new Font("Arial", 24));

        // Jfx Labels - Poker Categories :
        label_Dealer_PokerCategory.setTextFill(Color.web("#FFF"));
        label_Dealer_PokerCategory.setFont(new Font("Arial", 24));
        label_Player_PokerCategory.setTextFill(Color.web("#FFF"));
        label_Player_PokerCategory.setFont(new Font("Arial", 24));

        // Jfx Labels - Hand Values :
        label_Dealer_HandValue.setTextFill(Color.web("#FFF"));
        label_Dealer_HandValue.setFont(new Font("Arial", 24));
        label_Player_HandValue.setTextFill(Color.web("#FFF"));
        label_Player_HandValue.setFont(new Font("Arial", 24));

        // Jfx Labels - Highest Cards :
        label_Dealer_HighestCard.setTextFill(Color.web("#FFF"));
        label_Dealer_HighestCard.setFont(new Font("Arial", 24));
        label_Player_HighestCard.setTextFill(Color.web("#FFF"));
        label_Player_HighestCard.setFont(new Font("Arial", 24));

        // .................................
        BackgroundSize backgroundSize = new BackgroundSize
                (100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage
                (imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background
                (backgroundImage);


        // Buttons : declarations
        Button button_Common_NewGame = new Button();
        Button button_Dealer_Bet = new Button();
        Button button_Dealer_SwapCards = new Button();
        Button button_Dealer_Stand = new Button();
        Button button_Dealer_Raise = new Button();
        Button button_Dealer_Call = new Button();
        Button button_Dealer_QuitRound = new Button();
        Button button_Dealer_QuitGame = new Button();
        Button button_Player_Bet = new Button();
        Button button_Player_SwapCards = new Button();
        Button button_Player_Stand = new Button();
        Button button_Player_Raise = new Button();
        Button button_Player_Call = new Button();
        Button button_Player_QuitRound = new Button();
        Button button_Player_QuitGame = new Button();

        // Buttons : set text
        button_Common_NewGame               .setText("New game");
        button_Dealer_Bet                   .setText("Dealer : Bet");
        button_Dealer_SwapCards             .setText("Dealer : Swap cards");
        button_Dealer_Stand                 .setText("Dealer : Stand");
        button_Dealer_Raise                 .setText("Dealer : Raise");
        button_Dealer_Call                  .setText("Dealer : Call");
        button_Dealer_QuitRound             .setText("Dealer : Quit round");
        button_Dealer_QuitGame              .setText("Dealer : Quit game");
        button_Player_Bet                   .setText("Player : Bet");
        button_Player_SwapCards             .setText("Player : Swap cards");
        button_Player_Stand                 .setText("Player : Stand");
        button_Player_Raise                 .setText("Player : Raise");
        button_Player_Call                  .setText("Player : Call");
        button_Player_QuitRound             .setText("Player : Quit round");
        button_Player_QuitGame              .setText("Player : Quit game");

        // Buttons : appearance
        button_Common_NewGame               .setMinWidth(150);
        button_Dealer_Bet                   .setMinWidth(150);
        button_Dealer_SwapCards             .setMinWidth(150);
        button_Dealer_Stand                 .setMinWidth(150);
        button_Dealer_Raise                 .setMinWidth(150);
        button_Dealer_Call                  .setMinWidth(150);
        button_Dealer_QuitRound             .setMinWidth(150);
        button_Dealer_QuitGame              .setMinWidth(150);
        button_Player_Bet                   .setMinWidth(150);
        button_Player_SwapCards             .setMinWidth(150);
        button_Player_Stand                 .setMinWidth(150);
        button_Player_Raise                 .setMinWidth(150);
        button_Player_Call                  .setMinWidth(150);
        button_Player_QuitRound             .setMinWidth(150);
        button_Player_QuitGame              .setMinWidth(150);


        // .................................
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20, 10, 20, 10));
        grid.setHgap(5);
        grid.setVgap(5);

        // .................................
        grid.add(label_Dealer_Heading, 0, 0);
        grid.add(flowpane_Dealer_Hand, 0, 1, 5, 1);
        grid.add(label_Dealer_PokerCategory, 6, 0);
        grid.add(label_Dealer_HighestCard, 6, 1);

        Pane p = new Pane();
        p.setPrefSize(0, 100);
        grid.add(p, 0, 1);

        // .................................
        grid.add(label_Player_Heading, 0, 3);
        grid.add(flowpane_Player_Hand, 0, 4, 5, 1);
        grid.add(label_Player_PokerCategory, 6, 3);
        grid.add(label_Player_HighestCard, 6, 4);

        // .................................
        grid.add(button_Common_NewGame,     8, 3);
        grid.add(button_Dealer_Bet,         0, 2);
        grid.add(button_Dealer_SwapCards,   1, 2);
        grid.add(button_Dealer_Stand,       2, 2);
        grid.add(button_Dealer_Raise,       3, 2);
        grid.add(button_Dealer_Call,        4, 2);
        grid.add(button_Dealer_QuitRound,   5, 2);
        grid.add(button_Dealer_QuitGame,    6, 2);
        grid.add(button_Player_Bet,         0, 5);
        grid.add(button_Player_SwapCards,   1, 5);
        grid.add(button_Player_Stand,       2, 5);
        grid.add(button_Player_Raise,       3, 5);
        grid.add(button_Player_Call,        4, 5);
        grid.add(button_Player_QuitRound,   5, 5);
        grid.add(button_Player_QuitGame,    6, 5);


        // .................................
        grid.add(status, 0, 6, 5, 1);
        grid.setBackground(background);

        // .................................
        Scene scene = new Scene(grid, 1600, 900);

        primaryStage.setTitle("Poker game");
        primaryStage.setScene(scene);
        primaryStage.show();

        // .................................
        GameLogic currentGame = new GameLogic();
        button_Common_NewGame           .setOnAction(e -> currentGame.newGame());
        button_Dealer_Bet               .setOnAction(e -> currentGame.bet());
        button_Dealer_SwapCards         .setOnAction(e -> currentGame.swapCards());
        button_Dealer_Stand             .setOnAction(e -> currentGame.stand());
        button_Dealer_Raise             .setOnAction(e -> currentGame.raise());
        button_Dealer_Call              .setOnAction(e -> currentGame.call());
        button_Dealer_QuitRound         .setText("Dealer : Quit round");
        button_Dealer_QuitGame          .setOnAction(e -> currentGame.quitGame());
        button_Player_Bet               .setOnAction(e -> currentGame.bet());
        button_Player_SwapCards         .setOnAction(e -> currentGame.swapCards());
        button_Player_Stand             .setOnAction(e -> currentGame.stand());
        button_Player_Raise             .setOnAction(e -> currentGame.raise());
        button_Player_Call              .setOnAction(e -> currentGame.call());
        button_Player_QuitRound         .setText("Player : Quit round");
        button_Player_QuitGame          .setOnAction(e -> currentGame.quitGame());

    }

}
