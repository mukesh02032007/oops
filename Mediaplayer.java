package media;import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
public class MP extends Application {
    private MediaPlayer mediaPlayer;
    
    private Label statusLabel = new Label("No media loaded.");
    @Override
    public void start(Stage primaryStage) {
        Button loadButton = new Button("Load Media");
        Button playButton = new Button("Play");
        Button pauseButton = new Button("Pause");
        Button stopButton = new Button("Stop");
        playButton.setDisable(true);
        pauseButton.setDisable(true);
        stopButton.setDisable(true);
        loadButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Media File");
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    if (mediaPlayer != null) {
                        mediaPlayer.dispose(); 
                    }
                    Media media = new Media(file.toURI().toString());
                    mediaPlayer = new MediaPlayer(media);
                    playButton.setDisable(false);
                    pauseButton.setDisable(false);
                    stopButton.setDisable(false);
                    statusLabel.setText("Media loaded: " + file.getName());
                    mediaPlayer.setOnPlaying(() -> statusLabel.setText("TC1: Playing"));
                    mediaPlayer.setOnPaused(() -> statusLabel.setText("TC2: Paused"));
                    mediaPlayer.setOnStopped(() -> statusLabel.setText("TC3: Stopped"));
                    mediaPlayer.setOnEndOfMedia(() -> {
                        mediaPlayer.stop();
                        statusLabel.setText("Playback finished");
                    });
                    mediaPlayer.setOnError(() -> 
                        statusLabel.setText("Error: " + mediaPlayer.getError().getMessage())
                    );
                } catch (MediaException ex) {
                    statusLabel.setText("Unsupported media format.");
                    playButton.setDisable(true);
                    pauseButton.setDisable(true);
                    stopButton.setDisable(true);
                }
            } else {
                statusLabel.setText("No file loaded.");
            }
        });
        playButton.setOnAction(e -> {
            if (mediaPlayer != null) {
                mediaPlayer.play();
            } else {
                statusLabel.setText("Error: Load a media file first. (TC4)");
            }
        });
        pauseButton.setOnAction(e -> {
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        });
        stopButton.setOnAction(e -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.seek(Duration.ZERO); // Reset to start
            }
        });
        HBox controls = new HBox(10, loadButton, playButton, pauseButton, stopButton);
        VBox root = new VBox(10, controls, statusLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 420, 140);
        primaryStage.setTitle("JavaFX Media Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
    	System.out.println("mukesh p\n2117240070913");
        launch(args);
    }
}
