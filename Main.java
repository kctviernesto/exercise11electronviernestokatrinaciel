import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Main extends Application {
  int index = 0;

  Subject math = new Subject("Math", "math.png", 4, 1.75);
  Subject bio = new Subject("Biology", "biology.png", 3, 2.0);
  Subject chem = new Subject("Chemistry", "chemistry.png", 3, 1.5);
  Subject physics = new Subject("Physics", "physics.png", 3, 1.75);
  Subject cs = new Subject("CS", "computer science.png", 1, 1.5);

  Subject displayedSubject = math;
  
  Subject[] subjects = {math, bio, chem, physics, cs};

  ImageView image;
  Image img;
  Text name, units, grade;
  
  @Override
  public void start(Stage primaryStage) { 
    primaryStage.setTitle("i <3 pisay");
    
    FlowPane root = new FlowPane();
    Scene scene = new Scene(root, 450, 450);
    primaryStage.setScene(scene);
    
    image = new ImageView();
    img = new Image(Main.class.getResourceAsStream(displayedSubject.getImgFileName()));
    image.setImage(img);
    root.getChildren().add(image);
    
    name = new Text(" || " + displayedSubject.getName() + " |");
    name.setFill(Color.VIOLET);
    name.setFont(new Font("Arial", 20));
    root.getChildren().add(name);
    
    units = new Text("| " + Double.toString(displayedSubject.getUnits()) + " |");
    units.setFill(Color.SPRINGGREEN);
    units.setFont(new Font("Arial", 20));
    root.getChildren().add(units);
    
    grade = new Text("| " + Double.toString(displayedSubject.getGrade()) + " || ");
    grade.setFill(Color.SKYBLUE);
    grade.setFont(new Font("Arial", 20));
    root.getChildren().add(grade);
    
    Button button = new Button("Next");
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        if(index < subjects.length - 1) {
          index++;
          displayedSubject = subjects[index];
          resetDisplay(displayedSubject);
        }
        else {
          index = 0;
          displayedSubject = subjects[index];
          resetDisplay(displayedSubject);
        }
      }
    };
    button.setOnAction(event);
    root.getChildren().add(button);
    
    primaryStage.show();  
  }

  public void resetDisplay(Subject s) {
    img = new Image(Main.class.getResourceAsStream(s.getImgFileName()));
    image.setImage(img);
    name.setText(" || " + s.getName() + " |");
    units.setText("| " + Double.toString(s.getUnits()) + " |");
    grade.setText("| " + Double.toString(s.getGrade()) + " || ");
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}