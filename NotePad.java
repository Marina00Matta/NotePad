/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Marc
 */
public class NotePad extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new Note(stage);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Notepad");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
