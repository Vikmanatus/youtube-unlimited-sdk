package com.youtubeunlimitedsdk;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.youtubeunlimitedsdk.player.VideoPlayer;

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
    return new VideoPlayer(reactContext);
  }
  @ReactProp(name = "width")
  public void setWidth(VideoPlayer view, int width) {
    view.setWidth(width);
  }
  @ReactProp(name = "videoUri")
  public void setWidth(VideoPlayer view, String videoUri) {
    view.setVideoUri(videoUri);
  }
  @ReactProp(name = "height")
  public void setHeight(VideoPlayer view, int height) {
    view.setHeight(height);
  }
}
