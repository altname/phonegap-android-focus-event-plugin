/**
 * Phonegap FocusEvent plugin Copyright (c) Anton Taranovskyi <anton.taranovskyi@gmail.com>
 */

package com.phonegap.plugin;

import android.os.SystemClock;
import android.view.InputDevice;
import android.view.MotionEvent;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class FocusEventPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

        if ("simulateFocus".equals(action)) {

            final float x = args.getInt(0);
            final float y = args.getInt(1);

            // List of meta states found here: developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
            final int metaState = 0;

            final long timestamp = SystemClock.uptimeMillis();

            MotionEvent touchStart = MotionEvent.obtain(
                    timestamp,
                    timestamp + 50,
                    MotionEvent.ACTION_DOWN,
                    x,
                    y,
                    metaState
            );
            touchStart.setSource(InputDevice.SOURCE_TOUCHSCREEN);

            webView.dispatchTouchEvent(touchStart);

            MotionEvent touchEnd = MotionEvent.obtain(
                    timestamp+50,
                    timestamp+100,
                    MotionEvent.ACTION_UP,
                    x,
                    y,
                    metaState
            );
            touchEnd.setSource(InputDevice.SOURCE_TOUCHSCREEN);

            webView.dispatchTouchEvent(touchEnd);


            callbackContext.success(); // Thread-safe.
            return true;
        }

        return false;
    }

}
