package org.github.stickpoint.fxdemo.typewriterdemoforstudy;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
/**
 * typewriter-demo-for-study
 * @author Fntp
 * @e-mail fntp66@gmail.com
 * @date 2024/11/23
 * Help_address: https://www.reddit.com/r/JavaFX/comments/1gx9jqs/creating_delay_with_javafx/
 */
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}