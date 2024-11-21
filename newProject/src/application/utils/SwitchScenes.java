package application.utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchScenes {
	
	public static void switchScene(String fxmlPath, String title, Stage currentStage) {
		// TODO Auto-generated method stub
		try {
            // Load the FXML of the target scene
            FXMLLoader loader = new FXMLLoader(SwitchScenes.class.getResource(fxmlPath));
            Parent root = loader.load();

            // Create a new stage for the new scene
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle(title);
            newStage.centerOnScreen();
            if(title.equalsIgnoreCase("Login")||title.equalsIgnoreCase("Forgot Password")||title.equalsIgnoreCase("Create Account")) {
            	newStage.setMaximized(false);
            }
            newStage.show();
            
            currentStage.hide();
		} catch (IOException ex) {
            ex.printStackTrace(); // Add meaningful error handling
        }
	}
}
