package com.youtubeunlimitedsdk.player;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactPropGroup;

public class VideoPlayer extends FrameLayout {
  public VideoPlayer(ThemedReactContext context){
    super(context);
    this.setBackgroundColor(Color.parseColor("#74b097"));
  }
  public void setWidth(int width) {
    this.setLayoutParams(new ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT));
  }

  public void setHeight(int height) {
    this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, height));
  }

}
