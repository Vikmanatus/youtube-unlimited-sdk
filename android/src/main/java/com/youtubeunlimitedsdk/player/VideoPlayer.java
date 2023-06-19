package com.youtubeunlimitedsdk.player;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerView;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.youtubeunlimitedsdk.R;

public class VideoPlayer extends FrameLayout {
  private ExoPlayer player;
  public VideoPlayer(ThemedReactContext context){
    super(context);
    PlayerView playerView = new PlayerView(context);
    playerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);

    // Setting up player
    player = new ExoPlayer.Builder(context).build();
//    player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT);
    playerView.setPlayer(player);
    addView(playerView);
    String videoUri = "https://rr2---sn-q0c7rn7d.googlevideo.com/videoplayback?expire=1687211130&ei=GXiQZNuYPMOCp-oP8qOxuAg&ip=52.211.84.183&id=o-AGemNeGU9RaeRrMvF7ZmHBZAGhqI_emSrcqtjyF2YSH2&itag=22&source=youtube&requiressl=yes&mh=DP&mm=31%2C26&mn=sn-q0c7rn7d%2Csn-5hneknek&ms=au%2Conr&mv=u&mvi=2&pl=20&spc=qEK7BxF5MLDH_tOYUWOOlJfMMniXkcY&vprv=1&svpuc=1&mime=video%2Fmp4&cnr=14&ratebypass=yes&dur=1360.410&lmt=1635748936258780&mt=1687188055&fvip=1&fexp=24007246%2C24362686&beids=24350017&c=ANDROID&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAJsmu3IZE3WYVWbgq2gNpMROgEDAsNneZspRCVhUg6FeAiAqTH7P6BjQiI0tBzx15XF75O1wCQbfnSG4QIfEacEQiw%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl&lsig=AG3C_xAwRgIhAJmD3ZpnLiryBQRm_bT1ThSu-AWU87_VES6ddjjFe0WmAiEAsArDLLYsrlkE6mEWq-_wG_qVsTMkUpBy8dC3VrIx4OE%3D";
    MediaItem mediaItem = MediaItem.fromUri(videoUri);
    player.setMediaItem(mediaItem);
    // Prepare the player.
    player.prepare();
    // Start the playback.
    player.play();

  }
}
