package net.redlinesoft.plainwatchface;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
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
    
    public void setBackground(final int color) {
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
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
