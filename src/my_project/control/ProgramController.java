package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.Datenmanager;
import my_project.model.Token;
import my_project.view.StatusDisplay;
import my_project.view.Eingabemanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    // Attribute
    private int tokenCount = 25;
    private final int radius = 35;
    private final int maxKey = 100;
    private int currentKey, foundIndex;

    // Referenzen

    private Token[] tokens, backupTokens;
    private StatusDisplay statusDisplay;
    private Datenmanager dataManager;
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param ViewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController ViewController){
        foundIndex = -1;
        currentKey = -1;
        this.viewController = ViewController;
        toFullscreen();
    }

    /**
     * Vergrößert das Fenster, um den Bildschirm möglichst komplett zu füllen.
     */
    private void toFullscreen(){
        JFrame window = viewController.getDrawFrame();
        Config.WINDOW_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-10;
        Config.WINDOW_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-100;
        window.setLocation(10,10);
        window.setSize(Config.WINDOW_WIDTH,Config.WINDOW_HEIGHT);
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     */
    public void startProgram(){
        viewController.register(new Eingabemanager(this));
        statusDisplay = new StatusDisplay();
        viewController.draw(statusDisplay);
        dataManager = new Datenmanager();
        randomizeTokenArray();
    }

    /**
     * Erhöht die Anzahl der zu sortierenden Tokens um 100
     */
    public void increaseTokenCount(){
        tokenCount+=100;
        randomizeTokenArray();
        rearrangeTokenArray();
    }

    /**
     * Reduziert die Anzahl der zu sortierenden Tokens um 100
     */
    public void decreaseTokenCount(){
        if (tokenCount > 1){
            tokenCount -=100;
            randomizeTokenArray();
            rearrangeTokenArray();
        }
    }

    /**
     * Erzeugt ein neues, zufälliges Array von Tokens
     */
    public void randomizeTokenArray(){
        statusDisplay.setText("Neu randomisierte Zahlen.");
        if (tokens != null){
            for (Token token : tokens){
                if (token!=null) viewController.removeDrawable(token);
            }
        }
        tokens = new Token[tokenCount];
        backupTokens = new Token[tokenCount];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = new Token(0, 0, radius, maxKey);
            backupTokens[i] = tokens[i];
            viewController.draw(tokens[i]);
        }
        rearrangeTokenArray();
    }

    /**
     * Ordnet alle Tokens in einem Array wieder so an, dass sie alle sichtbar und in der aktuellen
     * Reihenfolge sind.
     */
    public void rearrangeTokenArray(){
        if (tokens != null){
            if ( tokens[0] != null){
                int countHorizontal = (int)(Config.WINDOW_WIDTH / (tokens[0].getRadius()*1.25)-1);
                int count = 0;
                for ( int zeile = 0; count < tokens.length; zeile ++){
                    for (int spalte = 0; spalte <= countHorizontal && count < tokens.length; spalte ++){
                        tokens[count].setY(50+zeile*tokens[count].getRadius()*1.25+tokens[count].getRadius()*0.5+20);
                        tokens[count].setX(spalte*tokens[count].getRadius()*1.25+tokens[count].getRadius()*0.5+10);
                        count++;
                    }
                }
            }
        }
    }

    /**
     * Stellt die ursprüngliche (unsortierte) Form eines Token-Arrays wieder her
     */
    public void restoreTokenArray(){
        for (int i = 0; i < tokens.length; i++){
            backupTokens[i].setHighlighted(false);
            tokens[i] = backupTokens[i];
        }
        rearrangeTokenArray();
    }

    /**
     * Ruft Bubble-Sort auf
     */
    public void bubbleSort(){
        dataManager.bubbleSort(tokens);
        statusDisplay.setText("BubbleSort. Vergleiche: "+ dataManager.getAnzahlVergleiche()+" Vertauschungen: "+ dataManager.getAnzahlVertauschungen()+" Zeit: "+ dataManager.getBenoetigteZeit());
        rearrangeTokenArray();
    }

    /**
     * Ruf Selection-Sort auf
     */
    public void selectionSort(){
        dataManager.selectionSort(tokens);
        statusDisplay.setText("SelectionSort. Vergleiche: "+ dataManager.getAnzahlVergleiche()+" Vertauschungen: "+ dataManager.getAnzahlVertauschungen()+" Zeit: "+ dataManager.getBenoetigteZeit());
        rearrangeTokenArray();
    }

    /**
     * Ruft Insertion-Sort auf
     */
    public void insertionSort(){
        dataManager.insertionSort(tokens);
        statusDisplay.setText("InsertionSort. Vergleiche: "+ dataManager.getAnzahlVergleiche()+" Vertauschungen: "+ dataManager.getAnzahlVertauschungen()+" Zeit: "+ dataManager.getBenoetigteZeit());
        rearrangeTokenArray();
    }

    /**
     * Ruft QuickSort auf
     */
    public void quickSort(){
        dataManager.quickSort(tokens);
        statusDisplay.setText("QuickSort. Vergleiche: "+ dataManager.getAnzahlVergleiche()+" Vertauschungen: "+ dataManager.getAnzahlVertauschungen()+" Zeit: "+ dataManager.getBenoetigteZeit());
        rearrangeTokenArray();
    }

    /**
     * Ruft HashSort auf
     */
    public void hashSort(){
        dataManager.hashSort(tokens);
        statusDisplay.setText("HashSort. Vergleiche: "+ dataManager.getAnzahlVergleiche()+" Vertauschungen: "+ dataManager.getAnzahlVertauschungen()+" Zeit: "+ dataManager.getBenoetigteZeit());
        rearrangeTokenArray();
    }

    /**
     * Ruft die lineare Suche auf, dabei wird ein zufälliger primärer Schlüssel gewählt
     */
    public void linSearch(){
        createNewRandomKey();
        foundIndex = dataManager.linSearch(currentKey);
        if (foundIndex != -1){
            tokens[foundIndex].setHighlighted(true);
        }
        statusDisplay.setText("Lineare Suche nach: "+currentKey+" Vergleiche: "+ dataManager.getAnzahlVergleiche()+" Vertauschungen: "+ dataManager.getAnzahlVertauschungen()+" Zeit: "+ dataManager.getBenoetigteZeit());
        rearrangeTokenArray();
    }

    /**
     * Ruft die binäre Suche auf, dabei wird ein zufälliger primärer Schlüssel gewählt
     */
    public void binSearch(){
        createNewRandomKey();
        foundIndex = dataManager.binSearch(currentKey);
        if (foundIndex != -1){
            tokens[foundIndex].setHighlighted(true);
        }
        statusDisplay.setText("Binäre Suche nach: "+currentKey+" Vergleiche: "+ dataManager.getAnzahlVergleiche()+" Vertauschungen: "+ dataManager.getAnzahlVertauschungen()+" Zeit: "+ dataManager.getBenoetigteZeit());
        rearrangeTokenArray();
    }

    /**
     * Ermittelt einen im Token-Array vorhandenen Schlüssel zufällig.
     * Für das Testen der Suche noch Ergebnis kann currentKey auf einen negativen Wert gesetzt werden.
     */
    private void createNewRandomKey(){
        if (foundIndex != -1) tokens[foundIndex].setHighlighted(false);
        currentKey = tokens[ (int)Math.floor(Math.random()*tokens.length)].getPrimaryKey();
    }

    /**
     * Für FORTGESCHRITTENE
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){


    }

    /**
     * Für FORTGESCHRITTENE
     * Diese Methode wird einmalig aufgerufen für jedes Mal, wenn die Maus im Fenster geklickt wird.
     * @param e Das übergebene Objekt enthält alle Informationen zum MouseEvent
     */
    public void mouseClicked(MouseEvent e){

    }

}
