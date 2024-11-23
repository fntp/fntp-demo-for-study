package org.github.stickpoint.fxdemo.typewriterdemoforstudy;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;

/**
 * typewriter-demo-for-study
 * @author Fntp
 * @e-mail fntp66@gmail.com
 * @date 2024/11/23
 * Help_address: https://www.reddit.com/r/JavaFX/comments/1gx9jqs/creating_delay_with_javafx/
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox root = fxmlLoader.load();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        Button selectFileButton = (Button) fxmlLoader.getNamespace().get("selectFileButton");
        TextArea textArea = (TextArea) fxmlLoader.getNamespace().get("textArea");

        selectFileButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select a text file");
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                try {
                    typeWriterEffect(textArea, file);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void typeWriterEffect(TextArea textArea, File file) throws Exception {
        Timeline timeline = new Timeline();
        // typeSpeed: milliseconds, If you want to adjust the speed, just change this value directly
        int typeSpeed = 100;
        String content = new String(file.toURI().toURL().openStream().readAllBytes());

        for (int i = 0; i < content.length(); i++) {
            int finalI = i;
            KeyFrame keyFrame = new KeyFrame(Duration.millis(typeSpeed * i), event -> {
                textArea.appendText(content.charAt(finalI) + "");
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.play();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}