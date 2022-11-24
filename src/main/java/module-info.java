module com.pierreparel.pokemoncardsjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.pierreparel.pokemoncardsjavafx to javafx.fxml;
    exports com.pierreparel.pokemoncardsjavafx;
}