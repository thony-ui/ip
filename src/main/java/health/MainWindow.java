package health;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    private static final String GREETING_MESSAGE = "Hello! "
            + "I'm your friendly ChatBot assistant called MentalHealth :)\n\n"
            + "What can I do for you?";
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private MentalHealth mentalHealth;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/human_smiling.png"));
    private Image dukeImage = new Image(
            this.getClass().getResourceAsStream("/images/mental_health_robot_and_human.png")
    );
    /**
     * Initializes the main window. This method is automatically called after the FXML file has been loaded.
     * It sets up the scroll pane to auto-scroll to the bottom whenever the dialog container's height changes,
     * ensuring that the latest messages are always visible. Additionally, it displays an initial greeting message
     * from the chatbot to welcome the user as soon as the application starts.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(
                DialogBox.getDukeDialog(GREETING_MESSAGE, dukeImage)
        );
    }

    /** Injects the Duke instance */
    public void setMentalHealth(MentalHealth d) {
        mentalHealth = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = mentalHealth.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage)
        );
        userInput.clear();
    }
}

