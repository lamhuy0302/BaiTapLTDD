package com.example.student.bai1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Skeleton of an Android Things activity.
 * <p>
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 * <p>
 * <pre>{@code
 * PeripheralManagerService service = new PeripheralManagerService();
 * mLedGpio = service.openGpio("BCM6");
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
 * mLedGpio.setValue(true);
 * }</pre>
 * <p>
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 * @see <a href="https://github.com/androidthings/contrib-drivers#readme">https://github.com/androidthings/contrib-drivers#readme</a>
 */
public class ActivityBai2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
    }
    public void FtoC(View v){
        int F = Integer.parseInt(((EditText)findViewById(R.id.etF)).getText().toString());
        int kq = (F-32)*5/9;
        ((EditText)findViewById(R.id.etC)).setText(""+kq);
    }
    public void CtoF(View v){
        int C = Integer.parseInt(((EditText)findViewById(R.id.etC)).getText().toString());
        int kq = C*9/5+32;
        ((EditText)findViewById(R.id.etF)).setText(""+kq);
    }
    public void Clear(View v){
        ((EditText)findViewById(R.id.etC)).setText("");
        ((EditText)findViewById(R.id.etF)).setText("");
    }
}
