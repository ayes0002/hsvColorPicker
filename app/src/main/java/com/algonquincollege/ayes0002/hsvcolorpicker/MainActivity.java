package com.algonquincollege.ayes0002.hsvcolorpicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Observable;
import java.util.Observer;

import model.HSVModel;

/**
 *  This app consist in a color picker using HSV (Hue, Saturation, Value) style of coloring.
 *  @Hjalmar Hjalmar Ayestas (ayes0002@algonquincollege.com)
 */

public class MainActivity extends AppCompatActivity implements Observer
                                                    , SeekBar.OnSeekBarChangeListener {

    private static final String ABOUT_DIALOG_TAG = "About";

    private AboutDialogFragment mAboutDialog;
    private TextView            mColorSwatch;
    private HSVModel            mModel;
    private SeekBar             mHueSB;
    private SeekBar             mSaturationSB;
    private SeekBar             mValueSB;
    private TextView            mHueTV;
    private TextView            mSaturationTV;
    private TextView            mValueTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAboutDialog = new AboutDialogFragment();

        //Model
        mModel = new HSVModel();
        mModel.addObserver( this );


        // Reference each view
        mColorSwatch = (TextView) findViewById( R.id.colorSwatch );
        mHueSB = (SeekBar) findViewById( R.id.hueSB );
        mSaturationSB = (SeekBar) findViewById( R.id.saturationSB );
        mValueSB = (SeekBar) findViewById( R.id.valueSB);
        mHueTV = (TextView) findViewById(R.id.hue);
        mSaturationTV = (TextView) findViewById(R.id.saturation);
        mValueTV = (TextView) findViewById(R.id.value);

        // Register each eventListener to seekBars
        mHueSB.setOnSeekBarChangeListener( this );
        mSaturationSB.setOnSeekBarChangeListener( this );
        mValueSB.setOnSeekBarChangeListener( this );

        // initialize the View to the values of the Model
        this.updateView();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        mAboutDialog.show(getFragmentManager(), ABOUT_DIALOG_TAG);
        return true;
    }

    /**
     * Event handler for the <SeekBar>s: hue, saturation, value.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method
        if ( fromUser == false ) {
            return;
        }

        // Determine which <SeekBark> caused the event (switch + case)
        // GET the SeekBar's progress, and SET the model to it's new value
        switch ( seekBar.getId() ) {
            case R.id.hueSB:
                mModel.setHue( (float) mHueSB.getProgress() );
                mHueTV.setText( getResources().getString(R.string.hueProgress, progress).toUpperCase() );
                break;

            case R.id.saturationSB:
                mModel.setSaturation( (float) mSaturationSB.getProgress() );
                mSaturationTV.setText( getResources().getString(R.string.saturationProgress, progress).toUpperCase() );
                break;

            case R.id.valueSB:
                mModel.setValue( (float) mValueSB.getProgress() );
                mValueTV.setText( getResources().getString(R.string.valueProgress, progress).toUpperCase() );
                break;
        }
    }

    public boolean onButtonSelected(View item) {
        // Handle presses on the buttons
        switch (item.getId()) {

            case R.id.redButton:
                mModel.asRed();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.blueButton:
                mModel.asBlue();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.greenButton:
                mModel.asGreen();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.magentaButton:
                mModel.asMagenta();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.blackButton:
                mModel.asBlack();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.grayButton:
                mModel.asGray();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.silverButton:
                mModel.asSilver();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.maroonButton:
                mModel.asMaroon();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.limeButton:
                mModel.asLime();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.purpleButton:
                mModel.asPurple();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.tealButton:
                mModel.asTeal();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.navyButton:
                mModel.asNavy();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.cyanButton:
                mModel.asCyan();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.oliveButton:
                mModel.asOlive();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.yellowButton:
                mModel.asYellow();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return true;

            default:
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                return this.onButtonSelected(item);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (seekBar.getId()) {
            case R.id.hueSB:
                mHueTV.setText( getResources().getString(R.string.hue) );
                break;

            case R.id.saturationSB:
                mSaturationTV.setText(getResources().getString(R.string.saturation));
                break;

            case R.id.valueSB:
                mValueTV.setText(getResources().getString(R.string.value));
                break;
        }
    }

    // The Model has changed state!
    // Refresh the View to display the current values of the Model.
    @Override
    public void update(Observable observable, Object data) {
        this.updateView();
    }

    private void updateColorSwatch() {

        mColorSwatch.setBackgroundColor(Color.HSVToColor(new float[]{ mModel.getHue(),
                                                                      mModel.getSaturation(),
                                                                      mModel.getValue() }));
    }

    private void updateHueSB() {
        mHueSB.setProgress( mModel.getHue().intValue() );
        Log.d("hue " , mModel.getHue().toString());
    }

    private void updateSaturationSB() {
        mSaturationSB.setProgress( (int) (mModel.getSaturation() * 100) );
        Log.d("saturation " , mModel.getSaturation().toString());
    }

    private void updateValueSB() {
        mValueSB.setProgress( (int)(mModel.getValue() * 100) );
        Log.d("value " , mModel.getValue().toString());
    }

    // synchronize each View component with the Model
    public void updateView() {
        this.updateColorSwatch();
        this.updateHueSB();
        this.updateSaturationSB();
        this.updateValueSB();
    }
}