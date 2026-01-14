package com.example.demo14;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardDealer extends Application {

    private List<String> deck = new ArrayList<>();
    private Set<String> drawnCards = new HashSet<>(); // To track drawn cards
    private ImageView cardImageView;
    private Label cardLabel;

    @Override
    public void start(Stage primaryStage) {
        initializeDeck();

        cardImageView = new ImageView();
        cardImageView.setFitWidth(150);
        cardImageView.setPreserveRatio(true);
        cardImageView.setOpacity(0); // Start hidden

        cardLabel = new Label("Click 'Draw Card' to start!");

        Button drawButton = new Button("Draw Card");
        drawButton.setOnAction(e -> drawCard());

        VBox root = new VBox(10, cardImageView, cardLabel, drawButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.setTitle("Card Selector");
        primaryStage.show();
    }

    private void initializeDeck() {
        String[] suits = {"spades", "hearts", "diamonds", "clubs"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + "of" + suit + ".png");
            }
        }
        Collections.shuffle(deck);
    }

    private void drawCard() {
        if (deck.isEmpty()) {
            cardLabel.setText("No more cards left!");
            cardImageView.setImage(null);
            return;
        }

        String drawnCard;
        do {
            drawnCard = deck.remove(0);
        } while (drawnCards.contains(drawnCard) && !deck.isEmpty()); // Ensure unique draw

        drawnCards.add(drawnCard); // Mark card as drawn

        String imagePath = "/images/" + drawnCard;
        Image image = new Image(getClass().getResourceAsStream(imagePath));

        if (image.isError()) {
            System.out.println("Image not found: " + imagePath);
            cardLabel.setText("Image not found!");
        } else {
            cardImageView.setImage(image);
            cardLabel.setText(formatCardName(drawnCard));

            // Fade-in animation
            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), cardImageView);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();
        }
    }

    private String formatCardName(String fileName) {
        fileName = fileName.replace(".png", "");
        fileName = fileName.replace("of", " of ");
        fileName = Character.toUpperCase(fileName.charAt(0)) + fileName.substring(1);
        return fileName;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
