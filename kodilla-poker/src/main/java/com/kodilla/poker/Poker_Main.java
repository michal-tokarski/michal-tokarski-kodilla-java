package com.kodilla.poker;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Poker_Main extends Application {


    // GridPane - UpperMain :
    // ======================================================================================================
    public static GridPane gridPane_UpperMain               = new GridPane();
    public static Button button_Common_StartPlay            = new Button("Start play");
    public static Button button_Common_ExitPlay             = new Button("Exit play");
    public static Label label_Common_GameMessage            = new Label();


    // GridPane - Main :
    // ======================================================================================================
    // public static GridPane gridPane_Main = new GridPane();
    // Labels - Heading :
    public static Label label_Dealer_Heading = new Label("Dealer's cards : ");
    public static Label label_Player_Heading = new Label("Player's cards : ");
    // FlowPanes - Hand :
    public static FlowPane flowpane_Dealer_Hand_CardImages = new FlowPane(Orientation.VERTICAL, 5, 5);
    public static FlowPane flowpane_Player_Hand_CardImages = new FlowPane(Orientation.VERTICAL,5,5);


    // GridPane - Game Info :
    // ======================================================================================================
    public static GridPane gridPane_Dealer_GameInfo = new GridPane();
    public static GridPane gridPane_Player_GameInfo = new GridPane();
    // Labels - Poker Category :
    public static Label label_Dealer_PokerCategory_Caption      = new Label("Poker category.........");
    public static Label label_Player_PokerCategory_Caption      = new Label("Poker category.........");
    public static Label label_Dealer_PokerCategory_Value        = new Label();
    public static Label label_Player_PokerCategory_Value        = new Label();
    // Labels - Highest Card :
    public static Label label_Dealer_HighestCard_Caption        = new Label("Highest card.............");
    public static Label label_Player_HighestCard_Caption        = new Label("Highest card.............");
    public static Label label_Dealer_HighestCard_Value          = new Label();
    public static Label label_Player_HighestCard_Value          = new Label();
    // Labels - Initial Credits :
    public static Label label_Dealer_InitialCredits_Caption     = new Label("Initial credits.............");
    public static Label label_Player_InitialCredits_Caption     = new Label("Initial credits.............");
    public static Label label_Dealer_InitialCredits_Value       = new Label();
    public static Label label_Player_InitialCredits_Value       = new Label();
    // Labels - Credits Left :
    public static Label label_Dealer_CreditsBalance_Caption     = new Label("Credits balance........");
    public static Label label_Player_CreditsBalance_Caption     = new Label("Credits balance........");
    public static Label label_Dealer_CreditsBalance_Value       = new Label();
    public static Label label_Player_CreditsBalance_Value       = new Label();
    // Labels - Current Bet :
    public static Label label_Dealer_TotalBet_Caption           = new Label("Total bet...................");
    public static Label label_Player_TotalBet_Caption           = new Label("Total bet...................");
    public static Label label_Dealer_TotalBet_Value             = new Label();
    public static Label label_Player_TotalBet_Value             = new Label();
    // Labels - Outstanding Bet :
    public static Label label_Dealer_OutstandingBet_Caption     = new Label("Outstanding bet........");
    public static Label label_Player_OutstandingBet_Caption     = new Label("Outstanding bet........");
    public static Label label_Dealer_OutstandingBet_Value       = new Label();
    public static Label label_Player_OutstandingBet_Value       = new Label();
    // Labels - Games Won :
    public static Label label_Dealer_GamesWon_Caption           = new Label("Games won..............");
    public static Label label_Player_GamesWon_Caption           = new Label("Games won..............");
    public static Label label_Dealer_GamesWon_Value             = new Label();
    public static Label label_Player_GamesWon_Value             = new Label();
    // GridPanes - User Interface :
    public static GridPane gridPane_Dealer_UserInterface        = new GridPane();
    public static GridPane gridPane_Player_UserInterface        = new GridPane();

    
    // GridPanes - Common - Game Info :
    // ======================================================================================================
    public static GridPane gridPane_Common_GameInfo = new GridPane();
    // Pot Value :
    public static Label label_Common_PotValue_Caption           = new Label("Pot value ................");
    public static Label label_Common_PotValue_Value             = new Label();
    // Game Winner :
    public static Label label_Common_GameWinner_Caption         = new Label("Game winner ..........");
    public static Label label_Common_GameWinner_Value           = new Label();


    // User interface - Dealer / Player :
    // ======================================================================================================
    // Dealer :
    public static Button button_Dealer_NewGame          = new Button("Phase 0" + "\n" + "New Game");
    public static Button button_Dealer_EntryBet         = new Button("Phase 1" + "\n" + "Entry bet");
    public static Button button_Dealer_EntryBet_Done    = new Button("Phase 1" + "\n" + "Done");
    public static Button button_Dealer_SwapCards        = new Button("Phase 2" + "\n" + "Swap cards");
    public static Button button_Dealer_SwapCards_Done   = new Button("Phase 2" + "\n" + "Done");
    public static Button button_Dealer_RaiseBet         = new Button("Phase 3" + "\n" + "Raise bet");
    public static Button button_Dealer_Check3           = new Button("Phase 3" + "\n" + "Check (wait)");
    public static Button button_Dealer_Call             = new Button("Phase 3" + "\n" + "Call");
    public static Button button_Dealer_Fold             = new Button("Phase 3" + "\n" + "Fold (pass)");

    // Player :
    public static Button button_Player_NewGame          = new Button("Phase 0" + "\n" + "New Game");
    public static Button button_Player_EntryBet         = new Button("Phase 1" + "\n" + "Entry bet");
    public static Button button_Player_EntryBet_Done    = new Button("Phase 1" + "\n" + "Done");
    public static Button button_Player_SwapCards        = new Button("Phase 2" + "\n" + "Swap cards");
    public static Button button_Player_SwapCards_Done   = new Button("Phase 2" + "\n" + "Done");
    public static Button button_Player_RaiseBet         = new Button("Phase 3" + "\n" + "Raise bet");
    public static Button button_Player_Check3           = new Button("Phase 3" + "\n" + "Check (wait)");
    public static Button button_Player_Call             = new Button("Phase 3" + "\n" + "Call");
    public static Button button_Player_Fold             = new Button("Phase 3" + "\n" + "Fold (pass)");

    // PlaceBet_Amount :
    public static TextField textfield_Dealer_EntryBet_Amount = new TextField ("Entry amount");
    public static TextField textfield_Player_EntryBet_Amount = new TextField ("Entry amount");
    // RaiseBet_Amount :
    public static TextField textfield_Dealer_RaiseBet_Amount = new TextField ("Raise amount");
    public static TextField textfield_Player_RaiseBet_Amount = new TextField ("Raise amount");


    // Images - Background
    // ======================================================================================================
    private Image imageback = new Image("card_table.png");


    // MAIN
    // ======================================================================================================
    public static void main(String[] args) {
        // launches the stage
        launch(args);
    }

    // Start
    // ======================================================================================================
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Labels - appearance settings :
        // ======================================================================================================
        int fontSize1 = 20;

        // Labels - Game Message :
        label_Common_GameMessage.setTextFill(Color.web("#FFF"));
        label_Common_GameMessage.setFont(new Font("Arial", fontSize1));
        label_Common_GameMessage.setMinSize(50 ,20);
        label_Common_GameMessage.setAlignment(Pos.CENTER);

        // Labels - Heading :
        label_Dealer_Heading.setTextFill(Color.web("#FFF"));
        label_Dealer_Heading.setFont(new Font("Arial", fontSize1));
        label_Player_Heading.setTextFill(Color.web("#FFF"));
        label_Player_Heading.setFont(new Font("Arial", fontSize1));

        // Labels - Poker Category :
        label_Dealer_PokerCategory_Caption.setTextFill(Color.web("#FFF"));
        label_Dealer_PokerCategory_Caption.setFont(new Font("Arial", fontSize1));
        label_Player_PokerCategory_Caption.setTextFill(Color.web("#FFF"));
        label_Player_PokerCategory_Caption.setFont(new Font("Arial", fontSize1));
        label_Dealer_PokerCategory_Value.setTextFill(Color.web("#FFF"));
        label_Dealer_PokerCategory_Value.setFont(new Font("Arial", fontSize1));
        label_Player_PokerCategory_Value.setTextFill(Color.web("#FFF"));
        label_Player_PokerCategory_Value.setFont(new Font("Arial", fontSize1));

        // Labels - Highest Card :
        label_Dealer_HighestCard_Caption.setTextFill(Color.web("#FFF"));
        label_Dealer_HighestCard_Caption.setFont(new Font("Arial", fontSize1));
        label_Player_HighestCard_Caption.setTextFill(Color.web("#FFF"));
        label_Player_HighestCard_Caption.setFont(new Font("Arial", fontSize1));
        label_Dealer_HighestCard_Value.setTextFill(Color.web("#FFF"));
        label_Dealer_HighestCard_Value.setFont(new Font("Arial", fontSize1));
        label_Player_HighestCard_Value.setTextFill(Color.web("#FFF"));
        label_Player_HighestCard_Value.setFont(new Font("Arial", fontSize1));

        // Labels - Initial Credits :
        label_Dealer_InitialCredits_Caption.setTextFill(Color.web("#FFF"));
        label_Dealer_InitialCredits_Caption.setFont(new Font("Arial", fontSize1));
        label_Player_InitialCredits_Caption.setTextFill(Color.web("#FFF"));
        label_Player_InitialCredits_Caption.setFont(new Font("Arial", fontSize1));
        label_Dealer_InitialCredits_Value.setTextFill(Color.web("#FFF"));
        label_Dealer_InitialCredits_Value.setFont(new Font("Arial", fontSize1));
        label_Player_InitialCredits_Value.setTextFill(Color.web("#FFF"));
        label_Player_InitialCredits_Value.setFont(new Font("Arial", fontSize1));

        // Labels - Credits Balance :
        label_Dealer_CreditsBalance_Caption.setTextFill(Color.web("#FFF"));
        label_Dealer_CreditsBalance_Caption.setFont(new Font("Arial", fontSize1));
        label_Player_CreditsBalance_Caption.setTextFill(Color.web("#FFF"));
        label_Player_CreditsBalance_Caption.setFont(new Font("Arial", fontSize1));
        label_Dealer_CreditsBalance_Value.setTextFill(Color.web("#FFF"));
        label_Dealer_CreditsBalance_Value.setFont(new Font("Arial", fontSize1));
        label_Player_CreditsBalance_Value.setTextFill(Color.web("#FFF"));
        label_Player_CreditsBalance_Value.setFont(new Font("Arial", fontSize1));

        // Labels - Total Bet :
        label_Dealer_TotalBet_Caption.setTextFill(Color.web("#FFF"));
        label_Dealer_TotalBet_Caption.setFont(new Font("Arial", fontSize1));
        label_Player_TotalBet_Caption.setTextFill(Color.web("#FFF"));
        label_Player_TotalBet_Caption.setFont(new Font("Arial", fontSize1));
        label_Dealer_TotalBet_Value.setTextFill(Color.web("#FFF"));
        label_Dealer_TotalBet_Value.setFont(new Font("Arial", fontSize1));
        label_Player_TotalBet_Value.setTextFill(Color.web("#FFF"));
        label_Player_TotalBet_Value.setFont(new Font("Arial", fontSize1));

        // Labels - Outstanding Bet :
        label_Dealer_OutstandingBet_Caption.setTextFill(Color.web("#FFF"));
        label_Dealer_OutstandingBet_Caption.setFont(new Font("Arial", fontSize1));
        label_Player_OutstandingBet_Caption.setTextFill(Color.web("#FFF"));
        label_Player_OutstandingBet_Caption.setFont(new Font("Arial", fontSize1));
        label_Dealer_OutstandingBet_Value.setTextFill(Color.web("#FFF"));
        label_Dealer_OutstandingBet_Value.setFont(new Font("Arial", fontSize1));
        label_Player_OutstandingBet_Value.setTextFill(Color.web("#FFF"));
        label_Player_OutstandingBet_Value.setFont(new Font("Arial", fontSize1));
        
        // Labels - Games Won :
        label_Dealer_GamesWon_Caption.setTextFill(Color.web("#FFF"));
        label_Dealer_GamesWon_Caption.setFont(new Font("Arial", fontSize1));
        label_Player_GamesWon_Caption.setTextFill(Color.web("#FFF"));
        label_Player_GamesWon_Caption.setFont(new Font("Arial", fontSize1));
        label_Dealer_GamesWon_Value.setTextFill(Color.web("#FFF"));
        label_Dealer_GamesWon_Value.setFont(new Font("Arial", fontSize1));
        label_Player_GamesWon_Value.setTextFill(Color.web("#FFF"));
        label_Player_GamesWon_Value.setFont(new Font("Arial", fontSize1));

        // Labels - Pot Value :
        label_Common_PotValue_Caption.setTextFill(Color.web("#FFF"));
        label_Common_PotValue_Caption.setFont(new Font("Arial", fontSize1));
        label_Common_PotValue_Value.setTextFill(Color.web("#FFF"));
        label_Common_PotValue_Value.setFont(new Font("Arial", fontSize1));

        // Labels - Game Winner :
        label_Common_GameWinner_Caption.setTextFill(Color.web("#FFF"));
        label_Common_GameWinner_Caption.setFont(new Font("Arial", fontSize1));
        label_Common_GameWinner_Value.setTextFill(Color.web("#FFF"));
        label_Common_GameWinner_Value.setFont(new Font("Arial", fontSize1));

        // Background - appearance settings :
        BackgroundSize backgroundSize = new BackgroundSize (100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage (imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background (backgroundImage);


        // Buttons & Textfields - appearance settings :
        // ======================================================================================================
        double buttonHeight = 50;
        double buttonWidth = 120;
        double textfieldHeight = 50;
        double textfieldWidth = 120;

        button_Common_StartPlay             .setMinSize (buttonWidth, buttonHeight);
        button_Common_ExitPlay              .setMinSize (buttonWidth, buttonHeight);

        button_Dealer_NewGame               .setMinSize (buttonWidth, buttonHeight);
        button_Dealer_EntryBet              .setMinSize (buttonWidth, buttonHeight);
        textfield_Dealer_EntryBet_Amount    .setPrefSize (textfieldWidth, textfieldHeight);
        button_Dealer_EntryBet_Done         .setMinSize (buttonWidth, buttonHeight);
        button_Dealer_SwapCards             .setMinSize (buttonWidth, buttonHeight);
        button_Dealer_SwapCards_Done        .setMinSize (buttonWidth, buttonHeight);
        button_Dealer_Check3                .setMinSize (buttonWidth, buttonHeight);
        button_Dealer_RaiseBet              .setMinSize (buttonWidth, buttonHeight);
        textfield_Dealer_RaiseBet_Amount    .setPrefSize (textfieldWidth, textfieldHeight);
        button_Dealer_Call                  .setMinSize (buttonWidth, buttonHeight);
        button_Dealer_Fold                  .setMinSize (buttonWidth, buttonHeight);

        button_Player_NewGame               .setMinSize (buttonWidth, buttonHeight);
        button_Player_EntryBet              .setMinSize (buttonWidth, buttonHeight);
        textfield_Player_EntryBet_Amount    .setPrefSize (textfieldWidth, textfieldHeight);
        button_Player_EntryBet_Done         .setMinSize (buttonWidth, buttonHeight);
        button_Player_SwapCards             .setMinSize (buttonWidth, buttonHeight);
        button_Player_SwapCards_Done        .setMinSize (buttonWidth, buttonHeight);
        button_Player_Check3                .setMinSize (buttonWidth, buttonHeight);
        button_Player_RaiseBet              .setMinSize (buttonWidth, buttonHeight);
        textfield_Player_RaiseBet_Amount    .setPrefSize (textfieldWidth, textfieldHeight);
        button_Player_Call                  .setMinSize (buttonWidth, buttonHeight);
        button_Player_Fold                  .setMinSize (buttonWidth, buttonHeight);


        // Gridpanes - add elements :
        // =========================================================================================

        // Common : Upper Main - add elements :
        gridPane_UpperMain.add(button_Common_StartPlay,          0, 0);
        gridPane_UpperMain.add(button_Common_ExitPlay,           1, 0);
        gridPane_UpperMain.add(label_Common_GameMessage,         3, 0);

        // Dealer : User Interface - add elements :
        gridPane_Dealer_UserInterface.add(button_Dealer_NewGame,            0, 0);
        gridPane_Dealer_UserInterface.add(button_Dealer_EntryBet,           1, 0);
        gridPane_Dealer_UserInterface.add(textfield_Dealer_EntryBet_Amount, 1, 1);
        gridPane_Dealer_UserInterface.add(button_Dealer_EntryBet_Done,      2, 0);
        gridPane_Dealer_UserInterface.add(button_Dealer_SwapCards,          3, 0);
        gridPane_Dealer_UserInterface.add(button_Dealer_SwapCards_Done,     4, 0);
        gridPane_Dealer_UserInterface.add(button_Dealer_RaiseBet,           5, 0);
        gridPane_Dealer_UserInterface.add(textfield_Dealer_RaiseBet_Amount, 5, 1);
        //gridPane_Dealer_UserInterface.add(button_Dealer_Check3,             6, 0);
        gridPane_Dealer_UserInterface.add(button_Dealer_Call,               7, 0);
        gridPane_Dealer_UserInterface.add(button_Dealer_Fold,               8, 0);

        // Player : User Interface - add elements :
        gridPane_Player_UserInterface.add(button_Player_NewGame,            0, 0);
        gridPane_Player_UserInterface.add(button_Player_EntryBet,           1, 0);
        gridPane_Player_UserInterface.add(textfield_Player_EntryBet_Amount, 1, 1);
        gridPane_Player_UserInterface.add(button_Player_EntryBet_Done,      2, 0);
        gridPane_Player_UserInterface.add(button_Player_SwapCards,          3, 0);
        gridPane_Player_UserInterface.add(button_Player_SwapCards_Done,     4, 0);
        gridPane_Player_UserInterface.add(button_Player_RaiseBet,           5, 0);
        gridPane_Player_UserInterface.add(textfield_Player_RaiseBet_Amount, 5, 1);
        gridPane_Player_UserInterface.add(button_Player_Call,               7, 0);
        gridPane_Player_UserInterface.add(button_Player_Fold,               8, 0);
        
        // GameInfo - Dealer - add elements :
        gridPane_Dealer_GameInfo.add(label_Dealer_PokerCategory_Caption,    1,1);
        gridPane_Dealer_GameInfo.add(label_Dealer_PokerCategory_Value,      2,1);
        gridPane_Dealer_GameInfo.add(label_Dealer_HighestCard_Caption,      1,2);
        gridPane_Dealer_GameInfo.add(label_Dealer_HighestCard_Value,        2,2);
        gridPane_Dealer_GameInfo.add(label_Dealer_InitialCredits_Caption,   1,3);
        gridPane_Dealer_GameInfo.add(label_Dealer_InitialCredits_Value,     2,3);
        gridPane_Dealer_GameInfo.add(label_Dealer_CreditsBalance_Caption,   1,4);
        gridPane_Dealer_GameInfo.add(label_Dealer_CreditsBalance_Value,     2,4);
        gridPane_Dealer_GameInfo.add(label_Dealer_TotalBet_Caption,         1,5);
        gridPane_Dealer_GameInfo.add(label_Dealer_TotalBet_Value,           2,5);
        gridPane_Dealer_GameInfo.add(label_Dealer_OutstandingBet_Value,     2,6);
        gridPane_Dealer_GameInfo.add(label_Dealer_OutstandingBet_Caption,   1,6);
        gridPane_Dealer_GameInfo.add(label_Dealer_GamesWon_Caption,         1,7);
        gridPane_Dealer_GameInfo.add(label_Dealer_GamesWon_Value,           2,7);

        // GameInfo - Player - add elements :
        gridPane_Player_GameInfo.add(label_Player_PokerCategory_Caption,    1,1);
        gridPane_Player_GameInfo.add(label_Player_PokerCategory_Value,      2,1);
        gridPane_Player_GameInfo.add(label_Player_HighestCard_Caption,      1,2);
        gridPane_Player_GameInfo.add(label_Player_HighestCard_Value,        2,2);
        gridPane_Player_GameInfo.add(label_Player_InitialCredits_Caption,   1,3);
        gridPane_Player_GameInfo.add(label_Player_InitialCredits_Value,     2,3);
        gridPane_Player_GameInfo.add(label_Player_CreditsBalance_Caption,   1,4);
        gridPane_Player_GameInfo.add(label_Player_CreditsBalance_Value,     2,4);
        gridPane_Player_GameInfo.add(label_Player_TotalBet_Caption,         1,5);
        gridPane_Player_GameInfo.add(label_Player_TotalBet_Value,           2,5);
        gridPane_Player_GameInfo.add(label_Player_OutstandingBet_Caption,   1,6);
        gridPane_Player_GameInfo.add(label_Player_OutstandingBet_Value,     2,6);
        gridPane_Player_GameInfo.add(label_Player_GamesWon_Caption,         1,7);
        gridPane_Player_GameInfo.add(label_Player_GamesWon_Value,           2,7);

        // GameInfo - Common - add elements :
        gridPane_Common_GameInfo.add(label_Common_PotValue_Caption,         1,1);
        gridPane_Common_GameInfo.add(label_Common_PotValue_Value,           2,1);
        gridPane_Common_GameInfo.add(label_Common_GameWinner_Caption,       1,2);
        gridPane_Common_GameInfo.add(label_Common_GameWinner_Value,         2,2);


        // Gridpanes - appearance settings :
        // ======================================================================================================
        gridPane_UpperMain.setVgap(50);
        gridPane_UpperMain.setHgap(30);

        gridPane_Dealer_GameInfo.setVgap(10);
        gridPane_Dealer_GameInfo.setHgap(30);
        gridPane_Player_GameInfo.setVgap(10);
        gridPane_Player_GameInfo.setHgap(30);

        gridPane_Dealer_GameInfo.setVgap(10);
        gridPane_Dealer_GameInfo.setHgap(0);
        gridPane_Player_GameInfo.setVgap(10);
        gridPane_Player_GameInfo.setHgap(0);
        gridPane_Common_GameInfo.setVgap(10);
        gridPane_Common_GameInfo.setHgap(0);

        // Scene and Stage :
        // ======================================================================================================
        GridPane gridPane_Main = new GridPane();
        Scene scene = new Scene(gridPane_Main, 1600, 900);
        scene.getStylesheets().add(getClass().getResource("/card_appearance_extras.css").toExternalForm());
        primaryStage.setTitle("Poker game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

        // GridPane Main - settings :
        // ======================================================================================================
        gridPane_Main.setAlignment(Pos.CENTER);
        gridPane_Main.setPadding(new Insets(20, 10, 20, 10));
        gridPane_Main.setHgap(5);
        gridPane_Main.setVgap(5);
        gridPane_Main.setBackground(background);
        gridPane_Main.setGridLinesVisible(true);

        // GridPane_Main - add elements :
        // ======================================================================================================
        gridPane_Main.add(gridPane_UpperMain,                       0,0);
        gridPane_Main.add(label_Dealer_Heading,                     0,2);
        gridPane_Main.add(flowpane_Dealer_Hand_CardImages,          0,3, 5, 1);
        gridPane_Main.add(gridPane_Dealer_GameInfo,                 1,3);
        gridPane_Main.add(gridPane_Dealer_UserInterface,            0,4);
        gridPane_Main.add(gridPane_Common_GameInfo,                 1,5);
        gridPane_Main.add(label_Player_Heading,                     0,6);
        gridPane_Main.add(flowpane_Player_Hand_CardImages,          0,7, 5, 1);
        gridPane_Main.add(gridPane_Player_GameInfo,                 1,7);
        gridPane_Main.add(gridPane_Player_UserInterface,            0,9);

        // Buttons - actions :
        // ======================================================================================================
        Game currentGame = new Game();

        button_Common_StartPlay         .setOnAction(e -> currentGame.startPlay());
        button_Common_ExitPlay          .setOnAction(e -> currentGame.exitPlay());

        button_Dealer_NewGame           .setOnAction(e -> currentGame.newGame       ("Dealer"));
        button_Dealer_EntryBet          .setOnAction(e -> currentGame.entryBet      ("Dealer"));
        button_Dealer_EntryBet_Done     .setOnAction(e -> currentGame.entryBetDone  ("Dealer"));
        button_Dealer_SwapCards         .setOnAction(e -> currentGame.swapCards     ("Dealer"));
        button_Dealer_SwapCards_Done    .setOnAction(e -> currentGame.swapCardsDone ("Dealer"));
        button_Dealer_RaiseBet          .setOnAction(e -> currentGame.raiseBet      ("Dealer"));
        button_Dealer_Call              .setOnAction(e -> currentGame.call          ("Dealer"));
        button_Dealer_Fold              .setOnAction(e -> currentGame.fold          ("Dealer"));

        button_Player_NewGame           .setOnAction(e -> currentGame.newGame       ("Player"));
        button_Player_EntryBet          .setOnAction(e -> currentGame.entryBet      ("Player"));
        button_Player_EntryBet_Done     .setOnAction(e -> currentGame.entryBetDone  ("Player"));
        button_Player_SwapCards         .setOnAction(e -> currentGame.swapCards     ("Player"));
        button_Player_SwapCards_Done    .setOnAction(e -> currentGame.swapCardsDone ("Player"));
        button_Player_RaiseBet          .setOnAction(e -> currentGame.raiseBet      ("Player"));
        button_Player_Call              .setOnAction(e -> currentGame.call          ("Player"));
        button_Player_Fold              .setOnAction(e -> currentGame.fold          ("Player"));

    }

}
