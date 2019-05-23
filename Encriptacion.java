/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encriptacion;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author isaac
 */
public class Encriptacion extends Application {
    
    @Override
    public void start(Stage primaryStage) {        
        Label etiqueta = new Label("Palabra");
        etiqueta.setAlignment(Pos.CENTER);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(grid, 400, 400);
        grid.add(etiqueta, 0 , 1);
        
        TextField palabra = new TextField();
        grid.add(palabra, 1, 1);
        
        Label resultado1 = new Label();
        grid.add(resultado1, 2, 2);
        
        Label resultado2 = new Label();
        grid.add(resultado2, 2, 3);
        
        Button encriptar = new Button("Encriptar");
        grid.add(encriptar, 1, 2);
        encriptar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Base64.Encoder encoder = Base64.getEncoder();
                String b = encoder.encodeToString(palabra.getText().getBytes(StandardCharsets.UTF_8));
                resultado1.setText(b);
            }
        });
        
        Button desencriptar = new Button("Desencriptar");
        grid.add(desencriptar, 1, 3);
        desencriptar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] decodedByteArray = decoder.decode(resultado1.getText());
                String b = new String(decodedByteArray);
                resultado2.setText(b);
            }
        });
        
        primaryStage.setTitle("Factorial");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
