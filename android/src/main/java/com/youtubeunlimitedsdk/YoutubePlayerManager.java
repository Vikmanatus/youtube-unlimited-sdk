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

    // Get device width
    DisplayMetrics displayMetrics = new DisplayMetrics();
    reactContext.getCurrentActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int deviceWidth = displayMetrics.widthPixels;

    // Set width to device width and height to 250px
    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(deviceWidth, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250, reactContext.getResources().getDisplayMetrics()));
    videoPlayer.setLayoutParams(params);

    return videoPlayer;
  }
}
