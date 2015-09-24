package com.kiluet.jguitar.desktop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MeasureCloseTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20, 20, 20, 20));

        HBox hbox = new HBox();
        int stringCount = 6;
        hbox.getChildren().add(createStartMeasurePane(stringCount));
        // hbox.getChildren().add(createMeasurePane(stringCount));
        pane.setCenter(hbox);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(100);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public GridPane createMeasurePane(int stringCount) {

        GridPane gridPane = new GridPane();

        for (int i = 0; i < stringCount; i++) {

            StackPane stackPane = new StackPane();
            // -fx-border-color: red;
            stackPane.setMinHeight(18);
            stackPane.setMaxHeight(18);
            stackPane.setStyle("-fx-padding: 0;");

            Line line = new Line(0, i + 1 * 10, 40, i + 1 * 10);
            line.setStroke(Color.LIGHTGRAY);

            stackPane.getChildren().addAll(line);

            gridPane.add(stackPane, 0, i + 1);

        }

        return gridPane;
    }

    public GridPane createStartMeasurePane(int stringCount) {
        GridPane gridPane = new GridPane();

        for (int i = 0; i < stringCount; i++) {

            StackPane stackPane = new StackPane();
            // -fx-border-color: red;
            stackPane.setMinHeight(18);
            stackPane.setMaxHeight(18);
            stackPane.setStyle("-fx-padding: 0;");

            Line line = new Line(0, i + 1 * 10, 15, i + 1 * 10);
            line.setStroke(Color.LIGHTGRAY);

            stackPane.getChildren().addAll(line);

            gridPane.add(stackPane, 3, i + 1);

        }

        Line a = new Line(0, 0, 0, (stringCount - 1) * 18 - 3);
        a.setStrokeWidth(4);
        gridPane.add(a, 0, 0, 1, 7);

        Line b = new Line(5, 0, 5, (stringCount - 1) * 18);
        b.setStrokeWidth(1);
        gridPane.add(b, 1, 0, 3, 7);
        GridPane.setMargin(b, new Insets(0, 0, 0, 2));

        GridPane circleGrid = new GridPane();
        circleGrid.setAlignment(Pos.CENTER);
        //circleGrid.setStyle("-fx-border-color: red;");

        Circle firstCircle = new Circle(0, 0, 3);
        circleGrid.add(firstCircle, 0, 0);
        GridPane.setVgrow(firstCircle, Priority.ALWAYS);
        GridPane.setValignment(firstCircle, VPos.CENTER);

        Circle secondCircle = new Circle(0, 0, 3);
        circleGrid.add(secondCircle, 0, 1);
        GridPane.setVgrow(secondCircle, Priority.ALWAYS);
        GridPane.setValignment(secondCircle, VPos.CENTER);
        
        gridPane.add(circleGrid, 2, 0, 3, 7);
        GridPane.setMargin(circleGrid, new Insets(0, 0, 0, 3));

        return gridPane;
    }

    public static void main(String[] args) {
        MeasureCloseTest.launch(MeasureCloseTest.class, args);
    }
}
