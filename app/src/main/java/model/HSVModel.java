package model;

import android.graphics.Color;
import com.algonquincollege.ayes0002.hsvcolorpicker.MainActivity;
import java.util.Observable;
import java.lang.Float;

/**
 * Created by hjalmarayestas on 2016-10-17.
 */

public class HSVModel extends Observable {
    // Class variable
    public static final float MAX_H = 359f;
    public static final float MIN_H = 0f;
    public static final float MIN_SV = 0f;
    public static final float MAX_SV = 1f;

    // INSTANCE VARIABLES
    private float hue;
    private float saturation;
    private float value;

    /**
     * No argument constructor.
     *
     * Instantiate a new instance of this class, and
     * initialize hue, saturation, value to max values.
     */
    public HSVModel() {
        this( MIN_H, MIN_SV, MIN_SV );
    }

    /**
     * Convenience constructor.
     *
     * @param hue - starting hue value
     * @param saturation - starting saturation value
     * @param value - starting value value
     */
    public HSVModel( float hue, float saturation, float value) {
        super();

        this.hue = hue;
        this.saturation  = saturation;
        this.value = value;
    }

    public void asBlack()   { this.setHSV( MIN_H, MIN_SV, MIN_SV ); }
    public void asRed()    { this.setHSV( MIN_H, MAX_SV, MAX_SV ); }
    public void asLime()    { this.setHSV( ((MAX_H+1)/3), MAX_SV, MAX_SV ); }
    public void asBlue()   { this.setHSV( (2*((MAX_H+1)/3)), MAX_SV, MAX_SV ); }
    public void asYellow() { this.setHSV( ((MAX_H+1)/6), MAX_SV, MAX_SV ); }
    public void asCyan()     { this.setHSV( ((MAX_H+1)/2), MAX_SV, MAX_SV ); }
    public void asMagenta()   { this.setHSV( (5*((MAX_H+1)/6)), MAX_SV, MAX_SV ); }
    public void asSilver()  { this.setHSV( MIN_H, MIN_SV, (3*(MAX_SV/4)) ); }
    public void asGray()   { this.setHSV( MIN_H, MIN_SV, (MAX_SV/2) ); }
    public void asMaroon()   { this.setHSV( MIN_H, MAX_SV, (MAX_SV/2) ); }
    public void asOlive()   { this.setHSV( ((MAX_H+1)/6), MAX_SV, (MAX_SV/2) ); }
    public void asGreen()   { this.setHSV( ((MAX_H+1)/3), MAX_SV, (MAX_SV/2) ); }
    public void asPurple()   { this.setHSV( (5*((MAX_H+1))/6), MAX_SV, (MAX_SV/2) ); }
    public void asTeal()   { this.setHSV( ((MAX_H+1)/2), MAX_SV, (MAX_SV/2) ); }
    public void asNavy()   { this.setHSV( (2*((MAX_H+1)/3)), MAX_SV, (MAX_SV/2) ); }

    // GETTERS
    public Float getHue() { return hue; }
    public Float getSaturation()  { return saturation; }
    //public float getColor() { return Color.HSVToColor( new float[]{ hue, saturation, value } ); }
    public Float getValue() { return value; }

    // SETTERS
    public void setHue( float hue ) {
        this.hue = hue;

        this.updateObservers();
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation/100f;

        this.updateObservers();
    }

    public void setValue(float value) {
        this.value = value/100f;

        this.updateObservers();
    }

    // Convenient setter: set H, S, V
    public void setHSV( float hue, float saturation, float value ) {
        this.hue   = hue;
        this.saturation = saturation;
        this.value  = value;

        this.updateObservers();
    }

    // the model has changed!
    // broadcast the update method to all registered observers
    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public String toString() {
        return "HSV [h=" + (int)hue + "\u00B0 s=" + (int)(saturation*100) + "% v=" + (int)(value*100) + "%]";
    }

    // Proof that my model is independent of any view.
    public static void main( String[] args ) {
        HSVModel model = new HSVModel( 127f, 100f, 100f );

        System.out.println( model );
    }
}
