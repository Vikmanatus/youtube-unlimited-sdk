package com.youtubeunlimitedsdk;

import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

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
    VideoPlayer videoPlayer = new VideoPlayer(reactContext);
    return videoPlayer;
  }
}
