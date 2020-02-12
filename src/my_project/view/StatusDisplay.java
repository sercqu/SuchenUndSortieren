package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

/**
 * Dient in diesem Programm zur Anzeige von informativen Texten
 */
public class StatusDisplay extends GraphicalObject {

    private String text = "";

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawText(10,60,text);
        drawTool.drawText(10, 10,"Anleitung: [1]neues Array - [2]wiederherstellen - [+/-]TokenCount");
        drawTool.drawText(10, 30,"[L]ineare Suche - Bi[n]äre Suche");
        drawTool.drawText(250, 30,"[B]ubbleSort - [S]electionSort - [I]nsertionSort - [Q]uickSort - [H]ashSort");
    }

    @Override
    public void update(double dt) {

    }

    public void setText(String t){
        text = t;
    }

}
