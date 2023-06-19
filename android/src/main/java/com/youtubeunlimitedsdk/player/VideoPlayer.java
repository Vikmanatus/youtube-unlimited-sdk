package com.youtubeunlimitedsdk.player;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactPropGroup;

public class VideoPlayer extends FrameLayout {
  private ExoPlayer player;
  private String videoUri;
  public VideoPlayer(ThemedReactContext context){
    super(context);
    PlayerView playerView = new PlayerView(context);
    // Setting up player
    player = new ExoPlayer.Builder(context).build();
    playerView.setPlayer(player);
    addView(playerView);
  }
  public void setWidth(int width) {
    this.setLayoutParams(new ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT));
  }
  public void setVideoUri(String videoUri) {
    this.videoUri = videoUri;
    MediaItem mediaItem = MediaItem.fromUri(videoUri);
    player.setMediaItem(mediaItem);
    // Prepare the player.
    player.prepare();
    // Start the playback.
    player.play();
  }

  public void setHeight(int height) {
    this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, height));
  }

}
