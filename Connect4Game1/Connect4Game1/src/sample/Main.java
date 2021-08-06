package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private com.internshala.game.Controller controller;


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        controller=loader.getController();
        controller.createPlayground();
        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menuPane = (Pane)rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(0,menuBar);


        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();}
    public MenuBar createMenu() {
        Menu fileMenu = new Menu("File");
        MenuItem newMenu = new MenuItem("New Game");
        newMenu.setOnAction((actionEvent) -> {
            controller.resetGame();
        });
        MenuItem resetMenu = new MenuItem("Reset Game");
        resetMenu.setOnAction((actionEvent) -> {
            controller.resetGame();
        });
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitMenu = new MenuItem("Exit Game");
        exitMenu.setOnAction((actionEvent) -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenu, resetMenu, separatorMenuItem, exitMenu);
        Menu helpMenu = new Menu("Help");
        MenuItem aboutMenu = new MenuItem("About Connect4");
        aboutMenu.setOnAction((actionEvent) -> {
            this.aboutConnect4();
        });
        MenuItem aboutmeMenu = new MenuItem("About Me");
        aboutmeMenu.setOnAction((actionEvent) -> {
            this.aboutMe();
        });
        SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();
        helpMenu.getItems().addAll(aboutMenu, separatorMenuItem2, aboutmeMenu);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Ritu Tiwari");
        alert.setContentText("I am a B.tech Student ,I love to code,want to learn many more thingsand love to work on projects ");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
