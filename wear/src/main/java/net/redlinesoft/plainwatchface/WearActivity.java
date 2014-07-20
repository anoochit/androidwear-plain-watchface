package net.redlinesoft.plainwatchface;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextClock;

public class WearActivity extends Activity {

    TextClock textClock;
    ImageView imageView;
    WatchViewStub stub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear);

        stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        textClock = (TextClock) stub.findViewById(R.id.textClock);
        imageView = (ImageView) stub.findViewById(R.id.background);

//        Handler handler = new Handler(Looper.getMainLooper());
//
//        final DisplayManager displayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
//        displayManager.registerDisplayListener(new DisplayManager.DisplayListener() {
//            @Override
//            public void onDisplayAdded(int displayId) {
//
//            }
//
//            @Override
//            public void onDisplayRemoved(int displayId) {
//
//            }
//
//            @Override
//            public void onDisplayChanged(int displayId) {
//                try {
//                    if (displayManager.getDisplay(displayId).getState() == Display.STATE_DOZING) {
//                        //updateFaceDisplay(true);
//                        Log.d(TAG, "onDisplayChanged: dozing");
//                    } else {
//                        //updateFaceDisplay(false);
//                        Log.d(TAG, "onDisplayChanged: not dozing");
//
//                    }
//                } catch (NullPointerException exception) {
//                }
//            }
//        }, handler);
        
    }
    
    private void setBackground(final int color) {
        stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                imageView = (ImageView) stub.findViewById(R.id.background);
                imageView.setBackgroundColor(color);
            }
        });
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        setBackground(Color.DKGRAY);
    }

    @Override
    protected void onPause() {
        super.onPause();
        setBackground(Color.BLACK);
    }
    
  
}
