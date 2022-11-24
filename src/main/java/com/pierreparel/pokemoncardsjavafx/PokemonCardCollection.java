package com.pierreparel.pokemoncardsjavafx;// PokemonCardCollection.java

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PokemonCardCollection extends Application {
    static PokemonCards pokemonDeck = new PokemonCards(); // Card collection object

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(PokemonCardCollection.class.getResource("main-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Pokemon Card Collection");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static PokemonCards getPokemonDeck(){
        return pokemonDeck;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
