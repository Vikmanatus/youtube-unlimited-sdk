package com.youtubeunlimitedsdk.player;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.core.content.ContextCompat;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerView;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.youtubeunlimitedsdk.R;

public class VideoPlayer extends FrameLayout {
  boolean fullscreen = false;
  ImageView fullscreenButton;
  private ExoPlayer player;
  public VideoPlayer(ThemedReactContext context){
    super(context);
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.exoplayer_view, this, true);

    // Find the PlayerView
    PlayerView playerView = view.findViewById(R.id.expoplayer_view);
    playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);

    fullscreenButton = playerView.findViewById(R.id.exo_fullscreen_icon);
    fullscreenButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(fullscreen) {
          player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT);
          fullscreenButton.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_fullscreen_open));

          context.getCurrentActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);

//          if(getSupportActionBar() != null){
//            getSupportActionBar().show();
//          }

          context.getCurrentActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

          ViewGroup.LayoutParams params = playerView.getLayoutParams();
          params.width = ViewGroup.LayoutParams.MATCH_PARENT;
          params.height = (int) ( 200 * context.getResources().getDisplayMetrics().density);
          playerView.setLayoutParams(params);
          playerView.requestLayout();
          fullscreen = false;
        }else{
          player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
          fullscreenButton.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_fullscreen_close));

          context.getCurrentActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
            |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

//          if(getSupportActionBar() != null){
//            getSupportActionBar().hide();
//          }

          context.getCurrentActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

          ViewGroup.LayoutParams params = playerView.getLayoutParams();
          params.width = ViewGroup.LayoutParams.MATCH_PARENT;
          params.height = ViewGroup.LayoutParams.MATCH_PARENT;
          playerView.setLayoutParams(params);

          playerView.requestLayout();  // Force PlayerView to resize

          fullscreen = true;
        }
      }
    });
    // Setting up player
    player = new ExoPlayer.Builder(context).build();
    player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
    playerView.setPlayer(player);

    // addView(playerView);
    String videoUri = "https://rr2---sn-q0c7rn7d.googlevideo.com/videoplayback?expire=1687293157&ei=hbiRZIX6ApjRvdIP0-iV6Ac&ip=3.250.6.50&id=o-APflNrwNtNd_bKegtw9c5lplg0WHyy9ePKXtZJAyIa1T&itag=22&source=youtube&requiressl=yes&mh=DP&mm=31%2C26&mn=sn-q0c7rn7d%2Csn-5hne6nzk&ms=au%2Conr&mv=m&mvi=2&pl=13&initcwndbps=798750&spc=qEK7B8hCCNdCt02OIxjBf8_XYqnwL74&vprv=1&svpuc=1&mime=video%2Fmp4&cnr=14&ratebypass=yes&dur=1360.410&lmt=1635748936258780&mt=1687271360&fvip=1&fexp=24007246%2C51000022&c=ANDROID&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgLSsELpechB28DMRQH8bgUjzHrw5weKQE7cKjAjNNUP0CIEKFFF5vzzVktbTAVrKz7iI9l34jA4XOAiZquLACEfUq&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgc3sJv_SF6IZpslnaIbGFT6ubM2_rwC1BOWofMhurlKgCIQCx20MRI5D07N5fu5rWbnbahL0nfFcP8Su6fdvVpDOqEg%3D%3D";
    MediaItem mediaItem = MediaItem.fromUri(videoUri);
    player.setMediaItem(mediaItem);
    // Prepare the player.
    player.prepare();
    // Start the playback.
    player.play();
  }
}
