package com.pierreparel.pokemoncardsjavafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class AppController {

    // END OF SLIDESHOW PAGE
    private final Image WaterBG = new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/bg/WaterBG.gif");
    private final Image DragonBG = new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/bg/DragonBG.jpg");
    private final Image ElectricBG = new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/bg/ElectricBG.jpg");
    private final Image FireBG = new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/bg/FireBG.png");
    private final Image NormalBG = new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/bg/NormalBG.png");
    private final Image PsychicBG = new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/bg/PsychicBG.jpg");
    private final Image IceBG = new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/bg/IceBG.png");
    private final Image RockBG = new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/bg/RockBG.jpg");
    public TextField pokemonNameSearch;
    // SEARCH PAGE
    @FXML
    public Text displayName;
    @FXML
    public Text displayHeight;
    @FXML
    public Text displayWeight;
    @FXML
    public Rectangle attackFill;
    @FXML
    public ImageView displayBackground;
    @FXML
    public ImageView displayPokemon;

    // END OF SEARCH PAGE
    @FXML
    public Text displayRandName;
    @FXML
    public Text displayRandHeight;

    // END OF REMOVE PAGE

    // RANDOM PAGE
    @FXML
    public Text displayRandWeight;
    @FXML
    public Rectangle attackFillRand;
    @FXML
    public ImageView displayRandBackground;
    @FXML
    public ImageView displayRandPokemon;
    @FXML
    public Rectangle defenseFillRand;
    @FXML
    public Rectangle speedFillRand;
    @FXML
    public Rectangle type1ChipRand;
    @FXML
    public Rectangle type2ChipRand;
    @FXML
    public Text type1TextRand;
    @FXML
    public Text type2TextRand;
    // SLIDESHOW PAGE
    @FXML
    public Text displaySlideName;
    @FXML
    public Text displaySlideHeight;

    // END OF RANDOM PAGE
    @FXML
    public Text displaySlideWeight;
    @FXML
    public Rectangle attackFillSlide;
    @FXML
    public ImageView displaySlideBackground;
    @FXML
    public ImageView displaySlidePokemon;
    @FXML
    public Rectangle defenseFillSlide;
    @FXML
    public Rectangle speedFillSlide;
    @FXML
    public Rectangle type1ChipSlide;
    @FXML
    public Rectangle type2ChipSlide;
    @FXML
    public Text type1TextSlide;
    @FXML
    public Text type2TextSlide;
    PokemonCards pokemonDeck = PokemonCardCollection.getPokemonDeck();
    int i;
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        showSlidePokemon(pokemonDeck.getPokemon(i));
        i++;
    }));
    private Stage stage;
    @FXML
    private Rectangle defenseFill;
    @FXML
    private Rectangle speedFill;
    @FXML
    private Rectangle type1Chip;
    @FXML
    private Rectangle type2Chip;
    @FXML
    private Text type1Text;
    @FXML
    private Text type2Text;
    // REMOVE PAGE
    @FXML
    private TextField pokemonRemoveSearch;
    @FXML
    private Label removeNotif;

    public void searchButtonClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(PokemonCardCollection.class.getResource("search-page.fxml"));
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
//        scene = new Scene(searchLoader.load());
        stage.getScene().setRoot(searchLoader.load());
    }

    public void removeButtonClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader removeLoader = new FXMLLoader(PokemonCardCollection.class.getResource("remove-page.fxml"));
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
//        scene = new Scene(searchLoader.load());
        stage.getScene().setRoot(removeLoader.load());
    }

    public void randomButtonClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader randomLoader = new FXMLLoader(PokemonCardCollection.class.getResource("random-page.fxml"));
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
//        scene = new Scene(searchLoader.load());
        stage.getScene().setRoot(randomLoader.load());

    }

    public void slideshowButtonClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader slideLoader = new FXMLLoader(PokemonCardCollection.class.getResource("slideshow-page.fxml"));
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
//        scene = new Scene(searchLoader.load());
        stage.getScene().setRoot(slideLoader.load());
    }

    public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(PokemonCardCollection.class.getResource("main-page.fxml"));
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
//        scene = new Scene(searchLoader.load());
        stage.getScene().setRoot(mainLoader.load());
        timeline.stop();
    }

    public void searchPokemon() {
        System.out.println("SEARCH THE POKEMON");
        String pokemonName = pokemonNameSearch.getText();
        System.out.println(pokemonName);

        int index = pokemonDeck.searchPokemon(pokemonName);
        if (index != -1) {
            // POKEMON FOUND
            Pokemon currentPokemon = pokemonDeck.getPokemon(index);
            showPokemon(currentPokemon);
            System.out.println("Pokemon Found!");
        } else {
            // POKEMON NOT FOUND
            System.out.println("Pokemon NOT Found!");
            resetSearchPage();
        }
    }

    private void showPokemon(Pokemon currentPokemon) {
        displayName.setText(currentPokemon.getName());
        displayHeight.setText(currentPokemon.getHeight());
        displayWeight.setText(currentPokemon.getWeight());

        // ATTACK BAR
        System.out.println("CURRENT POKEMON ATTACK: " + currentPokemon.getAttack());
        attackFill.setWidth(277 * currentPokemon.getAttack());
        attackFill.setArcHeight(10);
        attackFill.setArcWidth(10);
        attackFill.setFill(Color.LIGHTSEAGREEN);
        attackFill.setStroke(Color.BLACK);
        attackFill.setStrokeWidth(1);
        attackFill.setStrokeType(StrokeType.INSIDE);

        // DEFENSE BAR
        System.out.println("CURRENT POKEMON ATTACK: " + currentPokemon.getAttack());
        defenseFill.setWidth(277 * currentPokemon.getDefense());
        defenseFill.setArcHeight(10);
        defenseFill.setArcWidth(10);
        defenseFill.setFill(Color.LIGHTSEAGREEN);
        defenseFill.setStroke(Color.BLACK);
        defenseFill.setStrokeWidth(1);
        defenseFill.setStrokeType(StrokeType.INSIDE);

        // SPEED BAR
        System.out.println("CURRENT POKEMON ATTACK: " + currentPokemon.getAttack());
        speedFill.setWidth(277 * currentPokemon.getSpeed());
        speedFill.setArcHeight(10);
        speedFill.setArcWidth(10);
        speedFill.setFill(Color.LIGHTSEAGREEN);
        speedFill.setStroke(Color.BLACK);
        speedFill.setStrokeWidth(1);
        speedFill.setStrokeType(StrokeType.INSIDE);
        displayPokemon.setImage(new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/sprites/" + currentPokemon.getName().toLowerCase() + ".gif"));

        if (currentPokemon.getMulticlass()) {
            System.out.println("MULTITYPE!");
            showMultiTypePokemon(currentPokemon);
        } else {
            System.out.println("SINGLE TYPE!");
            showSingleTypePokemon(currentPokemon);
        }
    }

    private void showSingleTypePokemon(Pokemon currentPokemon) {
        System.out.println("Pokemon is type: " + currentPokemon.getType());
        switch (currentPokemon.getType()) {
            case "Water" -> {
                displayBackground.setImage(WaterBG);
                type1Chip.setFill(Color.DARKBLUE);
            }
            case "Dragon" -> {
                displayBackground.setImage(DragonBG);
                type1Chip.setFill(Color.MEDIUMPURPLE);
            }
            case "Electric" -> {
                displayBackground.setImage(ElectricBG);
                type1Chip.setFill(Color.LIGHTGOLDENRODYELLOW);
            }
            case "Fire" -> {
                displayBackground.setImage(FireBG);
                type1Chip.setFill(Color.INDIANRED);
            }
            case "Normal" -> {
                displayBackground.setImage(NormalBG);
                type1Chip.setFill(Color.SANDYBROWN);
            }
            case "Psychic" -> {
                displayBackground.setImage(PsychicBG);
                type1Chip.setFill(Color.DARKVIOLET);
            }
        }

        type1Chip.setVisible(true);
        type1Text.setVisible(true);
        type1Text.setText(currentPokemon.getType().toUpperCase());

        type2Text.setVisible(false);
        type2Chip.setVisible(false);
    }

    private void showMultiTypePokemon(Pokemon currentPokemon) {
        String[] types = currentPokemon.getType().split("/");

        switch (types[0]) {
            case "Water" -> {
                displayBackground.setImage(WaterBG);
                type1Chip.setFill(Color.DARKBLUE);
            }
            case "Dragon" -> {
                displayBackground.setImage(DragonBG);
                type1Chip.setFill(Color.MEDIUMPURPLE);
            }
            case "Electric" -> {
                displayBackground.setImage(ElectricBG);
                type1Chip.setFill(Color.LIGHTGOLDENRODYELLOW);
            }
            case "Fire" -> {
                displayBackground.setImage(FireBG);
                type1Chip.setFill(Color.INDIANRED);
            }
            case "Ice" -> {
                displayBackground.setImage(IceBG);
                type1Chip.setFill(Color.DEEPSKYBLUE);
            }
            case "Rock" -> {
                displayBackground.setImage(RockBG);
                type1Chip.setFill(Color.SADDLEBROWN);
            }
        }

        if (types[1].equals("Flying")) {
            type2Chip.setFill(Color.POWDERBLUE);
        } else if (types[1].equals("Water")) {
            type2Chip.setFill(Color.DARKBLUE);
        }


        type1Text.setText(types[0].toUpperCase());
        type2Text.setText(types[1].toUpperCase());
        type1Chip.setVisible(true);
        type1Text.setVisible(true);
        type2Chip.setVisible(true);
        type2Text.setVisible(true);

    }

    private void resetSearchPage() {
        displayName.setText("-");
        displayHeight.setText("-");
        displayWeight.setText("-");

        // ATTACK BAR
        attackFill.setWidth(1);
        attackFill.setArcHeight(10);
        attackFill.setArcWidth(10);
        attackFill.setFill(Color.TRANSPARENT);
        attackFill.setStroke(Color.TRANSPARENT);
        attackFill.setStrokeWidth(0);
        attackFill.setStrokeType(StrokeType.INSIDE);

        // DEFENSE BAR
        defenseFill.setWidth(1);
        defenseFill.setArcHeight(10);
        defenseFill.setArcWidth(10);
        defenseFill.setFill(Color.TRANSPARENT);
        defenseFill.setStroke(Color.TRANSPARENT);
        defenseFill.setStrokeWidth(0);
        defenseFill.setStrokeType(StrokeType.INSIDE);

        // SPEED BAR
        speedFill.setWidth(1);
        speedFill.setArcHeight(10);
        speedFill.setArcWidth(10);
        speedFill.setFill(Color.TRANSPARENT);
        speedFill.setStroke(Color.TRANSPARENT);
        speedFill.setStrokeWidth(0);
        displayPokemon.setImage(null);

        type1Chip.setVisible(false);
        type2Chip.setVisible(false);
        type1Text.setVisible(false);
        type2Text.setVisible(false);
    }

    public void removePokemon() {
        int index = pokemonDeck.searchPokemon(pokemonRemoveSearch.getText());

        if (index != -1) {
            // POKEMON FOUND
            pokemonDeck.remove(index);
            System.out.println("Pokemon Deleted!");
            removeNotif.setText(pokemonRemoveSearch.getText() + " has now been deleted from the database!");
        } else {
            // POKEMON NOT FOUND
            System.out.println("Pokemon NOT Found!");
            if (pokemonRemoveSearch.getText().trim().isEmpty() || pokemonRemoveSearch.getText() == null || pokemonRemoveSearch.getText().equals("")) {
                removeNotif.setText("Please enter a Pokemon Name in the field below.");
            }
            else{
                removeNotif.setText(pokemonRemoveSearch.getText() + " cannot be found in the database!");
            }
        }
        pokemonRemoveSearch.setText("");
    }

    private void showRandPokemon(Pokemon currentPokemon) {
        displayRandName.setText(currentPokemon.getName());
        displayRandHeight.setText(currentPokemon.getHeight());
        displayRandWeight.setText(currentPokemon.getWeight());

        // ATTACK BAR
        System.out.println("CURRENT POKEMON ATTACK: " + currentPokemon.getAttack());
        attackFillRand.setWidth(277 * currentPokemon.getAttack());
        attackFillRand.setArcHeight(10);
        attackFillRand.setArcWidth(10);
        attackFillRand.setFill(Color.LIGHTSEAGREEN);
        attackFillRand.setStroke(Color.BLACK);
        attackFillRand.setStrokeWidth(1);
        attackFillRand.setStrokeType(StrokeType.INSIDE);

        // DEFENSE BAR
        System.out.println("CURRENT POKEMON ATTACK: " + currentPokemon.getAttack());
        defenseFillRand.setWidth(277 * currentPokemon.getDefense());
        defenseFillRand.setArcHeight(10);
        defenseFillRand.setArcWidth(10);
        defenseFillRand.setFill(Color.LIGHTSEAGREEN);
        defenseFillRand.setStroke(Color.BLACK);
        defenseFillRand.setStrokeWidth(1);
        defenseFillRand.setStrokeType(StrokeType.INSIDE);

        // SPEED BAR
        System.out.println("CURRENT POKEMON ATTACK: " + currentPokemon.getAttack());
        speedFillRand.setWidth(277 * currentPokemon.getSpeed());
        speedFillRand.setArcHeight(10);
        speedFillRand.setArcWidth(10);
        speedFillRand.setFill(Color.LIGHTSEAGREEN);
        speedFillRand.setStroke(Color.BLACK);
        speedFillRand.setStrokeWidth(1);
        speedFillRand.setStrokeType(StrokeType.INSIDE);
        displayRandPokemon.setImage(new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/sprites/" + currentPokemon.getName().toLowerCase() + ".gif"));

        if (currentPokemon.getMulticlass()) {
            System.out.println("MULTITYPE!");
            showRandMultiTypePokemon(currentPokemon);
        } else {
            System.out.println("SINGLE TYPE!");
            showRandSingleTypePokemon(currentPokemon);
        }
    }

    public void generateRandomCard() {
        int rgen = (int) Math.floor(Math.random() * pokemonDeck.getSize());
        Pokemon randomPokemon = pokemonDeck.getPokemon(rgen);
        System.out.println("RANDOM POKEMON IS " + randomPokemon.getName().toUpperCase());
        showRandPokemon(pokemonDeck.getPokemon(rgen));
    }

    private void resetRandomPage() {
        displayRandName.setText("-");
        displayRandHeight.setText("-");
        displayRandWeight.setText("-");

        // ATTACK BAR
        attackFillRand.setWidth(1);
        attackFillRand.setArcHeight(10);
        attackFillRand.setArcWidth(10);
        attackFillRand.setFill(Color.TRANSPARENT);
        attackFillRand.setStroke(Color.TRANSPARENT);
        attackFillRand.setStrokeWidth(0);
        attackFillRand.setStrokeType(StrokeType.INSIDE);

        // DEFENSE BAR
        defenseFillRand.setWidth(1);
        defenseFillRand.setArcHeight(10);
        defenseFillRand.setArcWidth(10);
        defenseFillRand.setFill(Color.TRANSPARENT);
        defenseFillRand.setStroke(Color.TRANSPARENT);
        defenseFillRand.setStrokeWidth(0);
        defenseFillRand.setStrokeType(StrokeType.INSIDE);

        // SPEED BAR
        speedFillRand.setWidth(1);
        speedFillRand.setArcHeight(10);
        speedFillRand.setArcWidth(10);
        speedFillRand.setFill(Color.TRANSPARENT);
        speedFillRand.setStroke(Color.TRANSPARENT);
        speedFillRand.setStrokeWidth(0);
        displayRandPokemon.setImage(null);

        type1ChipRand.setVisible(false);
        type2ChipRand.setVisible(false);
        type1TextRand.setVisible(false);
        type2TextRand.setVisible(false);
    }

    private void showRandMultiTypePokemon(Pokemon currentPokemon) {
        String[] types = currentPokemon.getType().split("/");

        switch (types[0]) {
            case "Water" -> {
                displayBackground.setImage(WaterBG);
                type1Chip.setFill(Color.DARKBLUE);
            }
            case "Dragon" -> {
                displayRandBackground.setImage(DragonBG);
                type1ChipRand.setFill(Color.MEDIUMPURPLE);
            }
            case "Electric" -> {
                displayRandBackground.setImage(ElectricBG);
                type1ChipRand.setFill(Color.LIGHTGOLDENRODYELLOW);
            }
            case "Fire" -> {
                displayRandBackground.setImage(FireBG);
                type1ChipRand.setFill(Color.INDIANRED);
            }
            case "Ice" -> {
                displayRandBackground.setImage(IceBG);
                type1ChipRand.setFill(Color.DEEPSKYBLUE);
            }
            case "Rock" -> {
                displayRandBackground.setImage(RockBG);
                type1ChipRand.setFill(Color.SADDLEBROWN);
            }
        }

        if (types[1].equals("Flying")) {
            type2ChipRand.setFill(Color.POWDERBLUE);
        } else if (types[1].equals("Water")) {
            type2ChipRand.setFill(Color.DARKBLUE);
        }


        type1TextRand.setText(types[0].toUpperCase());
        type2TextRand.setText(types[1].toUpperCase());
        type1ChipRand.setVisible(true);
        type1TextRand.setVisible(true);
        type2ChipRand.setVisible(true);
        type2TextRand.setVisible(true);

    }

    private void showRandSingleTypePokemon(Pokemon currentPokemon) {
        System.out.println("Pokemon is type: " + currentPokemon.getType());
        switch (currentPokemon.getType()) {
            case "Water" -> {
                displayRandBackground.setImage(WaterBG);
                type1ChipRand.setFill(Color.DARKBLUE);
            }
            case "Dragon" -> {
                displayRandBackground.setImage(DragonBG);
                type1ChipRand.setFill(Color.MEDIUMPURPLE);
            }
            case "Electric" -> {
                displayRandBackground.setImage(ElectricBG);
                type1ChipRand.setFill(Color.LIGHTGOLDENRODYELLOW);
            }
            case "Fire" -> {
                displayRandBackground.setImage(FireBG);
                type1ChipRand.setFill(Color.INDIANRED);
            }
            case "Normal" -> {
                displayRandBackground.setImage(NormalBG);
                type1ChipRand.setFill(Color.SANDYBROWN);
            }
            case "Psychic" -> {
                displayRandBackground.setImage(PsychicBG);
                type1ChipRand.setFill(Color.DARKVIOLET);
            }
        }

        type1ChipRand.setVisible(true);
        type1TextRand.setVisible(true);
        type1TextRand.setText(currentPokemon.getType().toUpperCase());

        type2TextRand.setVisible(false);
        type2ChipRand.setVisible(false);
    }

    private void showSlidePokemon(Pokemon currentPokemon) {
        displaySlideName.setText(currentPokemon.getName());
        displaySlideHeight.setText(currentPokemon.getHeight());
        displaySlideWeight.setText(currentPokemon.getWeight());

        // ATTACK BAR
        System.out.println("CURRENT POKEMON ATTACK: " + currentPokemon.getAttack());
        attackFillSlide.setWidth(277 * currentPokemon.getAttack());
        attackFillSlide.setArcHeight(10);
        attackFillSlide.setArcWidth(10);
        attackFillSlide.setFill(Color.LIGHTSEAGREEN);
        attackFillSlide.setStroke(Color.BLACK);
        attackFillSlide.setStrokeWidth(1);
        attackFillSlide.setStrokeType(StrokeType.INSIDE);

        // DEFENSE BAR
        System.out.println("CURRENT POKEMON ATTACK: " + currentPokemon.getAttack());
        defenseFillSlide.setWidth(277 * currentPokemon.getDefense());
        defenseFillSlide.setArcHeight(10);
        defenseFillSlide.setArcWidth(10);
        defenseFillSlide.setFill(Color.LIGHTSEAGREEN);
        defenseFillSlide.setStroke(Color.BLACK);
        defenseFillSlide.setStrokeWidth(1);
        defenseFillSlide.setStrokeType(StrokeType.INSIDE);

        // SPEED BAR
        System.out.println("CURRENT POKEMON ATTACK: " + currentPokemon.getAttack());
        speedFillSlide.setWidth(277 * currentPokemon.getSpeed());
        speedFillSlide.setArcHeight(10);
        speedFillSlide.setArcWidth(10);
        speedFillSlide.setFill(Color.LIGHTSEAGREEN);
        speedFillSlide.setStroke(Color.BLACK);
        speedFillSlide.setStrokeWidth(1);
        speedFillSlide.setStrokeType(StrokeType.INSIDE);
        displaySlidePokemon.setImage(new Image("file:src/main/resources/com/pierreparel/pokemoncardsjavafx/sprites/" + currentPokemon.getName().toLowerCase() + ".gif"));

        if (currentPokemon.getMulticlass()) {
            System.out.println("MULTITYPE!");
            showSlideMultiTypePokemon(currentPokemon);
        } else {
            System.out.println("SINGLE TYPE!");
            showSlideSingleTypePokemon(currentPokemon);
        }
    }

    private void showSlideSingleTypePokemon(Pokemon currentPokemon) {
        System.out.println("Pokemon is type: " + currentPokemon.getType());
        switch (currentPokemon.getType()) {
            case "Water" -> {
                displaySlideBackground.setImage(WaterBG);
                type1ChipSlide.setFill(Color.DARKBLUE);
            }
            case "Dragon" -> {
                displaySlideBackground.setImage(DragonBG);
                type1ChipSlide.setFill(Color.MEDIUMPURPLE);
            }
            case "Electric" -> {
                displaySlideBackground.setImage(ElectricBG);
                type1ChipSlide.setFill(Color.LIGHTGOLDENRODYELLOW);
            }
            case "Fire" -> {
                displaySlideBackground.setImage(FireBG);
                type1ChipSlide.setFill(Color.INDIANRED);
            }
            case "Normal" -> {
                displaySlideBackground.setImage(NormalBG);
                type1ChipSlide.setFill(Color.SANDYBROWN);
            }
            case "Psychic" -> {
                displaySlideBackground.setImage(PsychicBG);
                type1ChipSlide.setFill(Color.DARKVIOLET);
            }
        }

        type1ChipSlide.setVisible(true);
        type1TextSlide.setVisible(true);
        type1TextSlide.setText(currentPokemon.getType().toUpperCase());

        type2TextSlide.setVisible(false);
        type2ChipSlide.setVisible(false);
    }

    private void showSlideMultiTypePokemon(Pokemon currentPokemon) {
        String[] types = currentPokemon.getType().split("/");

        switch (types[0]) {
            case "Water" -> {
                displaySlideBackground.setImage(WaterBG);
                type1ChipSlide.setFill(Color.DARKBLUE);
            }
            case "Dragon" -> {
                displaySlideBackground.setImage(DragonBG);
                type1ChipSlide.setFill(Color.MEDIUMPURPLE);
            }
            case "Electric" -> {
                displaySlideBackground.setImage(ElectricBG);
                type1ChipSlide.setFill(Color.LIGHTGOLDENRODYELLOW);
            }
            case "Fire" -> {
                displaySlideBackground.setImage(FireBG);
                type1ChipSlide.setFill(Color.INDIANRED);
            }
            case "Ice" -> {
                displaySlideBackground.setImage(IceBG);
                type1ChipSlide.setFill(Color.DEEPSKYBLUE);
            }
            case "Rock" -> {
                displaySlideBackground.setImage(RockBG);
                type1ChipSlide.setFill(Color.SADDLEBROWN);
            }
        }

        if (types[1].equals("Flying")) {
            type2ChipSlide.setFill(Color.POWDERBLUE);
        } else if (types[1].equals("Water")) {
            type2ChipSlide.setFill(Color.DARKBLUE);
        }


        type1TextSlide.setText(types[0].toUpperCase());
        type2TextSlide.setText(types[1].toUpperCase());
        type1ChipSlide.setVisible(true);
        type1TextSlide.setVisible(true);
        type2ChipSlide.setVisible(true);
        type2TextSlide.setVisible(true);

    }

    public void startSlideshow() {
        i = 0;
        timeline.setCycleCount(pokemonDeck.getSize());
        timeline.play();
    }

    // END OF SLIDESHOW PAGE

}

