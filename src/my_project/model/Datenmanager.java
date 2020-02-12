package my_project.model;

/**
 * Diese Klasse dient dazu Arrays zu sortieren. Sie soll außerdem den Aufwand des  jeweils durchgeführten Verfahrens
 * messen.
 * //todo Aufwandsmessung
 */
public class Datenmanager {

    private int anzahlVergleiche;
    private int anzahlVertauschungen;
    private double benoetigteZeit;

    public Datenmanager(){
        reset();
    }

    private void reset(){
        anzahlVergleiche = 0;
        anzahlVertauschungen = 0;
        benoetigteZeit = 0;
    }

    /**
     * Sortiert ein Array aus Tokens gemäß BubbleSort-Algorithmus
     * @param t
     */
    public void bubbleSort(Token[] t){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
    }

    /**
     * Sortiert ein Array aus Tokens gemäß SelectionSort-Algorithmus
     * @param t
     */
    public void selectionSort(Token[] t){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
    }

    /**
     * Sortiert ein Array aus Tokens gemäß InsertionSort-Algorithmus
     * @param t
     */
    public void insertionSort(Token[] t){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
    }

    /**
     * Ruft die rekursive Sortiermethode für QuickSort mit den nötigen Parametern auf und
     * sortiert ein Array aus Tokens gemäß QuickSort-Algorithmus
     * @param t
     */
    public void quickSort(Token[] t){
        recursiveQuickSort(t, 0,t.length-1);
    }

    /**
     * Sortiert ein Array aus Tokens gemäß QuickSort-Algorithmus
     * @param t
     * @param left
     * @param right
     */
    private void recursiveQuickSort(Token[] t, int left, int right){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
    }

    /**
     * Sortiert ein Array aus Tokens gemäß HashSort-Algorithmus
     * @param t
     */
    public void hashSort(Token[] t){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
    }

    /**
     * Sucht in einem Token-Array mit linearer Suche nach einem Token und gibt dessen Index zurück (-1 bedeutet nicht gefunden)
     * @param key Der gesuchte Schlüssel
     */
    public int linSearch(int key){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
        return -1;
    }

    /**
     * Sucht in einem Token-Array mit binärer Suche nach einem Token und gibt dessen Index zurück (-1 bedeutet nicht gefunden)
     * @param key Der gesuchte Schlüssel
     */
    public int binSearch(int key){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
        return -1;
    }

    // Sondierende / Zuweisende Methoden

    public int getAnzahlVergleiche() {
        return anzahlVergleiche;
    }

    public int getAnzahlVertauschungen() {
        return anzahlVertauschungen;
    }

    public double getBenoetigteZeit(){
        return benoetigteZeit;
    }
}
