package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Macchinetta extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		
		Distributore d1 = new Distributore();
		 
		
		d1.addConto(new ContoMacchinetta("1234", 10));
		d1.addConto(new ContoMacchinetta("1235", 10));
		
		 
		
		
		
		//creating label email 
	      Text text1 = new Text("Inserisci codice");
	      
	      //Creating Text Filed for email        
	      TextField textField1 = new TextField();  
	      
	      Button btn1=new Button("Submit");
	      
	      Button btnC=new Button("Caffè");
	      
	      Button btnT=new Button("The");
	      
	      Button btnA=new Button("Acqua");
	      
	      //Creating a Grid Pane 
	      GridPane gridPane = new GridPane();    
	      
	      //Setting size for the pane 
	      gridPane.setMinSize(400, 400); 
	      
	      //Setting the padding  
	      gridPane.setPadding(new Insets(30, 30, 30, 30));
	      
	      gridPane.setVgap(5); 
	      gridPane.setHgap(10);
	      
	      btnC.setVisible(false);
	      btnA.setVisible(false);
	      btnT.setVisible(false);
	      
	      
	      gridPane.add(text1, 0, 0);
	      gridPane.add(textField1, 1, 0);
	      gridPane.add(btn1, 0, 1);
	      gridPane.add(btnC, 0, 3);
	      gridPane.add(btnT, 0, 5);
	      gridPane.add(btnA, 0, 7);
	      
	      //Creating a scene object 
	      Scene scene = new Scene(gridPane); 
	       
	      //Setting title to the Stage 
	      stage.setTitle("Macchinetta");
	      
	      
	      // Registrare un gestore di eventi sul pulsante
	        btn1.setOnAction(e -> {
	            // Leggere l'input dai campi di testo
	        	 String campo  = textField1.getText();
	        	 
	        	if  (d1.check(campo)== true) {
	        		
	        		btnC.setVisible(true);
	      	      btnA.setVisible(true);
	      	      btnT.setVisible(true);
	        		
	        		 // Creare e mostrare un popup con l'input
		            Alert alert = new Alert(AlertType.INFORMATION);
		            alert.setTitle("Macchinetta");
		            alert.setHeaderText("Chiavetta riconosciuta");
		           
		            alert.showAndWait();
	        		
	        	}
	        	else {
	        		 // Creare e mostrare un popup con l'input
		            Alert alert = new Alert(AlertType.INFORMATION);
		            alert.setTitle("Macchinetta");
		            alert.setHeaderText("Chiavetta Non rinosciuta");
		           
		            alert.showAndWait();
	        	}
	            
	            
	           
	           
	        });
	        
	        
	        btnC.setOnAction(e -> {
	            // Leggere l'input dai campi di testo
	        	 String campo  = textField1.getText();
	        	 
	        	if  (d1.check(campo)== true ) {
	        		
	        		
	        		int credito = d1.getCredito(campo);
	        		
	        		if (credito > 0 ) {
	        			
	        			
		        		d1.erogaCoffe(campo);
		        		credito = d1.getCredito(campo);
	        			
	        		 // Creare e mostrare un popup con l'input
		            Alert alert = new Alert(AlertType.INFORMATION);
		            alert.setTitle("Macchinetta");
		            alert.setHeaderText("Caffè in erogazione");
		            alert.setContentText("credito residuo: " + credito  );
		            alert.showAndWait();}
	        		
	        		else if (credito == 0) {
		        		 // Creare e mostrare un popup con l'input
			            Alert alert = new Alert(AlertType.INFORMATION);
			            alert.setTitle("Macchinetta");
			            alert.setHeaderText("Credito esaurito");
			           
			            alert.showAndWait();}
	        		else   {
		        		 // Creare e mostrare un popup con l'input
			            Alert alert = new Alert(AlertType.INFORMATION);
			            alert.setTitle("Macchinetta");
			            alert.setHeaderText("Credito insufficiente");
			           
			            alert.showAndWait();}
	       		
	       		
	       		
	       	}
	        	
	            
	            
	           
	           
	        });
	        
	        
	        btnT.setOnAction(e -> {
	            // Leggere l'input dai campi di testo
	        	 String campo  = textField1.getText();
	        	 
	        	if  (d1.check(campo)== true ) {
	        		
	        		
	        		int credito = d1.getCredito(campo);
	        		
	        		if (credito >= 3 ) {
	        			
	        			
		        		d1.erogaThe(campo);
		        		credito = d1.getCredito(campo);
	        			
	        		 // Creare e mostrare un popup con l'input
		            Alert alert = new Alert(AlertType.INFORMATION);
		            alert.setTitle("Macchinetta");
		            alert.setHeaderText("The in erogazione");
		            alert.setContentText("credito residuo: " + credito  );
		            alert.showAndWait();}
	        		
	        		
	        		
	        		else if (credito == 0) {
		        		 // Creare e mostrare un popup con l'input
			            Alert alert = new Alert(AlertType.INFORMATION);
			            alert.setTitle("Macchinetta");
			            alert.setHeaderText("Credito esaurito");
			           
			            alert.showAndWait();}
	        		else   {
		        		 // Creare e mostrare un popup con l'input
			            Alert alert = new Alert(AlertType.INFORMATION);
			            alert.setTitle("Macchinetta");
			            alert.setHeaderText("Credito insufficiente");
			           
			            alert.showAndWait();}
	       		
	       		
	       		
	       	}
	        });
	        	
	        	 btnA.setOnAction(e -> {
		 	            // Leggere l'input dai campi di testo
		 	        	 String campo  = textField1.getText();
		 	        	 
		 	        	if  (d1.check(campo)== true ) {
		 	        		
		 	        		
		 	        		int credito = d1.getCredito(campo);
		 	        		
		 	        		if (credito > 0 ) {
		 	        			
		 	        			
		 		        		d1.erogaAcqua(campo);
		 		        		credito = d1.getCredito(campo);
		 	        			
		 	        		 // Creare e mostrare un popup con l'input
		 		            Alert alert = new Alert(AlertType.INFORMATION);
		 		            alert.setTitle("Macchinetta");
		 		            alert.setHeaderText("Acqua in erogazione");
		 		            alert.setContentText("credito residuo: " + credito  );
		 		            alert.showAndWait();}
		 	        		
		 	        		
		 	        		
		 	        		else if (credito == 0) {
		 		        		 // Creare e mostrare un popup con l'input
		 			            Alert alert = new Alert(AlertType.INFORMATION);
		 			            alert.setTitle("Macchinetta");
		 			            alert.setHeaderText("Credito esaurito");
		 			           
		 			            alert.showAndWait();}
		 	        	}
		        		
		        		
		        	
		        
		        	
		        	
		            
		            
		           
		           
		        });
	      
	      
	      
	      //Adding scene to the stage 
	      stage.setScene(scene);
	      
	      //Displaying the conten
		
	      stage.show(); 
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}