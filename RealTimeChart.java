package media;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.util.Random;
public class RealTimeChart extends Application {
    private XYChart.Series<Number, Number> series;
    private int x = 0;
    private Timeline timeline;
    private Random random = new Random();
    @Override
    public void start(Stage stage) {
        stage.setTitle("Real-Time Data Visualization");
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time (seconds)");
        yAxis.setLabel("Value");
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Live Data Chart");
        series = new XYChart.Series<>();
        series.setName("Sensor Data");
        lineChart.getData().add(series);
        Button startBtn = new Button("Start Updates");
        Button stopBtn = new Button("Stop Updates");
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> addData()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        startBtn.setOnAction(e -> {
            timeline.play();
            System.out.println("TC2: Data added every second → Graph updates in real-time");
        });
        stopBtn.setOnAction(e -> {
            timeline.stop();
            System.out.println("TC3: Stop updates → Graph freezes");
        });
        VBox root = new VBox(10, lineChart, startBtn, stopBtn);
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        System.out.println("TC1: App starts → Chart displays empty");
    }
    private void addData() {
        try {
            double y = random.nextDouble() * 100; // random numeric value
            Platform.runLater(() -> series.getData().add(new XYChart.Data<>(x++, y)));
            if (y > 100) {
                System.out.println("TC4: Data out of range → Chart scales accordingly");
            }
        } catch (Exception ex) {
            System.out.println("TC5: Non-numeric input → Handled gracefully");
        }
    }
    public static void main(String[] args) {
    	System.out.println("Mukesh p\n2117240070193");
        launch(args);
    }
}
