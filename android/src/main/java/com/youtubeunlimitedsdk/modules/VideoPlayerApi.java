package com.youtubeunlimitedsdk.modules;


import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class VideoPlayerApi extends ReactContextBaseJavaModule {
  public VideoPlayerApi(ReactApplicationContext context) {
    super(context);
  }
  @Override
  public String getName() {
    return "VideoPlayerApiModule";
  }
  @ReactMethod
  public void hello() {
    // Your native function
    Toast.makeText(getReactApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
  }
}
