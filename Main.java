package application;
 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
 
 
public class Main extends Application {
	@Override
	public void start(Stage fr) {
 
		/*
		 * Creare una finestra con javafx che rappresenta un bancomat. 
		 * 
		 * La finestra inizialmente ha un textfield per inserire il pin e un bottone. 
		 * 
		 * In questa classe dobbiamo creare un oggetto Bancomat e aggiungerli due o tre conti correnti. 
 
		 * Se il pin viene verificato, compaiono un altro text field per scrivere l’importo e due bottoni, 
		 * uno per prelevare e uno per versare. 
		 * Ogni pressione dei pulsanti deve far partire un alert che indichi (se il pin è giusto, e se le operazioni bancarie sono andate a buon fine e il saldo
		 * aggiornato)
		 */
 
 
		Bancomat b1 = new Bancomat();
 
		b1.aggiungiConto(new ContoCorrente(1234,1000));
		b1.aggiungiConto(new ContoCorrente(4321,1000));
 
		fr.setTitle("bancomat");
 
		// Creating a Grid Pane
		GridPane gridPane = new GridPane();
		gridPane.setMinSize(400, 400);
		gridPane.setPadding(new Insets(30, 30, 30, 30));
		gridPane.setVgap(5);
		gridPane.setHgap(10);
 
		Scene sc = new Scene(gridPane);
		fr.setScene(sc);
 
 
		TextField tfPin = new TextField();
		tfPin.setMinSize(400, 20);
		gridPane.add(tfPin, 0, 0, 2, 1); 
 
		TextField tfOp = new TextField();
		tfOp.setMinSize(400, 20);
		tfOp.setVisible(false);
		gridPane.add(tfOp, 0, 6, 2, 1); 
 
 
		Button btnPin = new Button("Inserisci PIN");
		btnPin.setPrefSize(90, 20);
		gridPane.add(btnPin, 0, 3);
 
		Button btnPreleva = new Button("Preleva");
		btnPreleva.setPrefSize(90, 20);
		gridPane.add(btnPreleva, 0, 9);
		btnPreleva.setVisible(false);
 
		Button btnVersa = new Button("Versa");
		btnVersa.setPrefSize(90, 20);
		gridPane.add(btnVersa, 1, 9);
		btnVersa.setVisible(false);
		
		Button btnSaldo = new Button("Saldo");
		btnSaldo.setPrefSize(90, 20);
		gridPane.add(btnSaldo, 2, 9);
		btnSaldo.setVisible(false);
		
 
		btnPin.setOnAction(e -> {
            // Leggere l'input dai campi di testo
        	 int pin  = Integer.parseInt(tfPin.getText());
 
        	if  (b1.check(pin)== true) {	
        		btnPreleva.setVisible(true);
      	      	btnVersa.setVisible(true);
      	      	tfOp.setVisible(true);
      	        btnPin.setDisable(true);
      	        tfPin.setDisable(true);
      	        btnSaldo.setVisible(true);
 
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Macchinetta");
	            alert.setHeaderText("Pin Corretto!");
 
	            alert.showAndWait();
        	}
        	else {
 
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Macchinetta");
	            alert.setHeaderText("Riprovare, Pin non corretto");
 
	            alert.showAndWait();
        	}
        });
		btnVersa.setOnAction(e -> {
            // Leggere l'input dai campi di testo
        	 double Op  = Double.parseDouble(tfOp.getText());
        	 int pin = Integer.parseInt(tfPin.getText());
        	 b1.versa(pin, Op);
         	 
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Versamento");
	            alert.setHeaderText("Versamento effettuato!");
 
	            alert.showAndWait();
        	
        	
        	}
        );
		btnPreleva.setOnAction(e -> {
            // Leggere l'input dai campi di testo
        	 double Op  = Double.parseDouble(tfOp.getText());
        	 int pin = Integer.parseInt(tfPin.getText());
        	 if (b1.preleva(pin, Op)) {
        		 
        	     	 
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Prelievo");
	            alert.setHeaderText("Prelievo effettuato!");
 
	            
	            alert.showAndWait();
        	 }
        	 else {
        		 
        		Alert alert = new Alert(AlertType.INFORMATION);
 	            alert.setTitle("Prelievo");
 	            alert.setHeaderText("Sei povero!!!");
  
 	            
 	            alert.showAndWait();
        	 }
        	}
		
        );
		btnSaldo.setOnAction(e -> {
            // Leggere l'input dai campi di testo
        	 
        	 int pin = Integer.parseInt(tfPin.getText());
        	 
        	 	Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Residuo");
	            alert.setHeaderText("Il tuo saldo è: " + b1.saldo(pin));

	            
	            alert.showAndWait();
		});
 
		fr.close();
		fr.show();
	}
 
	public static void main(String[] args) {
		launch(args);
	}
}
 