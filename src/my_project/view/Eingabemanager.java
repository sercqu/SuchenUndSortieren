package my_project.view;

import KAGO_framework.control.Interactable;
import my_project.control.ProgramController;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Dient zur Verwaltung der Eingaben des Nutzers
 */
public class Eingabemanager implements Interactable {

    private ProgramController control;

    public Eingabemanager(ProgramController control){
        this.control = control;
    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    /**
     * Wird einmalig aufgerufen, wenn eine Taste losgelassen wird.
     * @param key Enthält den Zahlencode für die Taste. Kann direkt aus der Klasse KeyEvent geladen werden, z.B. KeyEvent_VK_3
     */
    public void keyReleased(int key) {
        if ( key == KeyEvent.VK_1){
            control.randomizeTokenArray();
        }
        if ( key == KeyEvent.VK_2){
            control.restoreTokenArray();
        }
        if ( key == KeyEvent.VK_B){
            control.bubbleSort();
        }
        if ( key == KeyEvent.VK_S){
            control.selectionSort();
        }
        if ( key == KeyEvent.VK_I){
            control.insertionSort();
        }
        if ( key == KeyEvent.VK_Q){
            control.quickSort();
        }
        if ( key == KeyEvent.VK_H){
            control.hashSort();
        }
        if ( key == KeyEvent.VK_L){
            control.linSearch();
        }
        if ( key == KeyEvent.VK_N){
            control.binSearch();
        }
        if ( key == KeyEvent.VK_PLUS){
            control.increaseTokenCount();
        }
        if ( key == KeyEvent.VK_MINUS){
            control.decreaseTokenCount();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

}
