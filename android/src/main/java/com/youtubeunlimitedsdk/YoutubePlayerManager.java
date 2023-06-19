package com.youtubeunlimitedsdk;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;

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

  @ReactPropGroup(names = {"width", "height"})
  public void setDimensions(View view, int width, int height) {
    // Setting the background color
    view.setBackgroundColor(Color.parseColor("#fcba03"));
    // Setting width and height
    view.setLayoutParams(new ViewGroup.LayoutParams(width, height));
  }
}
