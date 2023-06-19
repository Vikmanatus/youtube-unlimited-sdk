package com.youtubeunlimitedsdk;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class YoutubePlayerManager extends SimpleViewManager<View> {
  public static final String REACT_CLASS = "YoutubePlayer";

  @Override
  @NonNull
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  @NonNull
  public View createViewInstance(ThemedReactContext reactContext) {
    return new View(reactContext);
  }

  @ReactProp(name = "width")
  public void setWidth(View view, Integer width) {
    view.setBackgroundColor(Color.parseColor("#fcba03"));
    view.setLayoutParams(new ViewGroup.LayoutParams(width, 400));
  }
}
