package com.kodilla;

//import javafx.application.Application;

import javafx.application.Application;

public abstract class Blackjack extends Application {

    /*

    // Original code
    // private Image imageback = new Image("file:resources/cards_table.png");
    // private Image imageback = new Image("file:resources/Namietna_Sabrina.png");


    private SimpleObjectProperty<Image> imageback
    = new SimpleObjectProperty<>(this, "imageback", new Image("file: resources/Namietna_Sabrina.png"));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback.get(), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setBackground(background);

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


     */
}

