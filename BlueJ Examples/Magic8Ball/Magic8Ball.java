

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;
/**
 * Write a description of JavaFX class Magic8Ball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Magic8Ball extends Application
{
    // We keep track of the count, and label displaying the count:
    Text fortune = new Text("");

    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        // Create a Button or any control item
        VBox box = new VBox();
        box.setPadding(new Insets(20));
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        
        Text title = new Text("Magic 8 Ball");
        title.setFont(Font.font("SanSerif", 36));
        box.getChildren().add(title);
        
        fortune.setFont(Font.font("SanSerif", 20));
        box.getChildren().add(fortune);
        
        Button button = new Button("Flip the 8 Ball");
        button.setOnAction(this::buttonClick);
        box.getChildren().add(button);
        
        
        Scene scene = new Scene(box, 500, 200);
        stage.setScene(scene);
        stage.setTitle("Magic 8 Ball");
        stage.show();
    }

    /**
     * This will be executed when the button is clicked
     * 
     */
    private void buttonClick(ActionEvent event)
    {
        Random randNum = new Random();
        int randInt = randNum.nextInt(5);
        //System.out.println("Testing button click - now change the fortune");
        String fortuneText = "";
        switch (randInt) {
            case 0:
                fortuneText = "You are going to have a wonderful Day!";
                break;
            case 1:
                fortuneText = "It's going to rain today, bring an umbrella";
                break;
            case 2:
                fortuneText = "Fortune 3";
                break;
            case 3:
                fortuneText = "Fortune 4";
                break;
            case 4:
                fortuneText = "Fortune 5";
                break;
            
        }
            
        fortune.setText(fortuneText);
    }
}
