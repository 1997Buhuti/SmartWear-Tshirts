/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ButoonsAnimated;

import java.awt.Color;
import static javax.swing.text.StyleConstants.getBackground;

/**
 *
 * @author dpman
 */
public class Buttons {
    private boolean rounded;
    private boolean backgrounPainted;
    private boolean linePainted;
    private boolean entered;
    private boolean pressed;
    
    private Color enteredcolor;
    private Color pressedColor;
    private Color gradientBackgroundColor;
    private Color gradientLineColor;
    private Color lineColor;

    public Buttons() {
        super();
        rounded= false;
        linePainted= true;
        entered=false;
        
    }

    public Buttons(boolean rounded, boolean backgrounPainted, boolean linePainted, boolean entered, boolean pressed, Color enteredcolor, Color pressedColor, Color gradientBackgroundColor, Color gradientLineColor, Color lineColor) {
        this.rounded = rounded;
        this.backgrounPainted = backgrounPainted;
        this.linePainted = linePainted;
        this.entered = entered;
        this.pressed = pressed;
        this.enteredcolor = enteredcolor;
        this.pressedColor = pressedColor;
        this.gradientBackgroundColor = gradientBackgroundColor;
        this.gradientLineColor = gradientLineColor;
        this.lineColor = lineColor;
    }

    public boolean isRounded() {
        return rounded;
    }

    public void setRounded(boolean rounded) {
        this.rounded = rounded;
    }

    public boolean isBackgrounPainted() {
        return backgrounPainted;
    }

    public void setBackgrounPainted(boolean backgrounPainted) {
        this.backgrounPainted = backgrounPainted;
    }

    public boolean isLinePainted() {
        return linePainted;
    }

    public void setLinePainted(boolean linePainted) {
        this.linePainted = linePainted;
    }

    public boolean isEntered() {
        return entered;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public Color getEnteredcolor() {
        return enteredcolor;
    }

    public void setEnteredcolor(Color enteredcolor) {
        this.enteredcolor = enteredcolor;
    }

    public Color getPressedColor() {
        return pressedColor;
    }

    public void setPressedColor(Color pressedColor) {
        this.pressedColor = pressedColor;
    }

    public Color getGradientBackgroundColor() {
        return gradientBackgroundColor;
    }

    public void setGradientBackgroundColor(Color gradientBackgroundColor) {
        this.gradientBackgroundColor = gradientBackgroundColor;
    }

    public Color getGradientLineColor() {
        return gradientLineColor;
    }

    public void setGradientLineColor(Color gradientLineColor) {
        this.gradientLineColor = gradientLineColor;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }
    
    
    
}
