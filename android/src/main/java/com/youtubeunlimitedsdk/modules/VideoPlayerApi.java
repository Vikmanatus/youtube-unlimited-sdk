package com.youtubeunlimitedsdk.modules;


import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

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
  @ReactMethod
  public void initializePlayer(String videoUrl){
    final ReactApplicationContext reactContext = getReactApplicationContext();
    reactContext.runOnUiQueueThread(new Runnable() {
      @Override
      public void run() {
        // Create the player
        PlayerView playerView = new PlayerView(reactContext);
        playerView.setLayoutParams(new ViewGroup.LayoutParams(300, 250));

        ExoPlayer player = new ExoPlayer.Builder(reactContext).build();

        // This is the MediaSource representing the media to be played.
        MediaItem mediaItem = MediaItem.fromUri(videoUrl);

        // Prepare the player with the source.
        player.setMediaItem(mediaItem);
        player.prepare();

        playerView.setPlayer(player);

        // Autoplay the video when ready
        player.play();
      }
    });
  }
}
