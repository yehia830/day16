package tiy.gui;

import javafx.application.Application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.security.Key;

public class JavaPsychedelics extends Application {
    final double DEFAULT_SCENE_HEIGHT = 600;
    final double DEFAULT_SCENE_WIDTH = 800;
    double strokeSize = 10;

    @Override
    public void start(Stage primaryStage) {
        Group rootGroup = new Group();

//        Scene mainScene = new Scene(rootGroup, 800, 600, Color.BLACK);


        Canvas canvas = new Canvas(DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);
        canvas.setFocusTraversable(true);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
        graphicsContext.setLineWidth(2);



        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("key pressed was: " + event.getText());
                if(event.getCode().toString() == "A"){
                    graphicsContext.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
                }
                if(event.getCode().toString() == "C"){
//                    graphicsContext.clearRect(0,0,canvas.getHeight());
                    graphicsContext.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
                }
                if(event.getCode() == event.getCode().UP){
                  strokeSize ++;
                    System.out.println("Stroke size = " + strokeSize);
                }
                if(event.getCode() == event.getCode().DOWN){
                    strokeSize --;
                    System.out.println("Stroke size = " + strokeSize);
                }


            }
        });

        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {

//                System.out.println("x: " + e.getX() + ", y: " + e.getY());
                graphicsContext.strokeOval(e.getX(), e.getY(), strokeSize, strokeSize);

            }
        });

        rootGroup.getChildren().add(canvas);
        Scene scene = new Scene(rootGroup, DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
