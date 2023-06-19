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
  public VideoPlayer(ThemedReactContext context){
    super(context);
    PlayerView playerView = new PlayerView(context);
    // Setting up player
    player = new ExoPlayer.Builder(context).build();
    playerView.setPlayer(player);
    addView(playerView);
    String uri = "https://rr2---sn-q0c7rn7d.googlevideo.com/videoplayback?expire=1687211130&ei=GXiQZNuYPMOCp-oP8qOxuAg&ip=52.211.84.183&id=o-AGemNeGU9RaeRrMvF7ZmHBZAGhqI_emSrcqtjyF2YSH2&itag=22&source=youtube&requiressl=yes&mh=DP&mm=31%2C26&mn=sn-q0c7rn7d%2Csn-5hneknek&ms=au%2Conr&mv=u&mvi=2&pl=20&spc=qEK7BxF5MLDH_tOYUWOOlJfMMniXkcY&vprv=1&svpuc=1&mime=video%2Fmp4&cnr=14&ratebypass=yes&dur=1360.410&lmt=1635748936258780&mt=1687188055&fvip=1&fexp=24007246%2C24362686&beids=24350017&c=ANDROID&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAJsmu3IZE3WYVWbgq2gNpMROgEDAsNneZspRCVhUg6FeAiAqTH7P6BjQiI0tBzx15XF75O1wCQbfnSG4QIfEacEQiw%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl&lsig=AG3C_xAwRgIhAJmD3ZpnLiryBQRm_bT1ThSu-AWU87_VES6ddjjFe0WmAiEAsArDLLYsrlkE6mEWq-_wG_qVsTMkUpBy8dC3VrIx4OE%3D";
    MediaItem mediaItem = MediaItem.fromUri(uri);
    player.setMediaItem(mediaItem);
    // Prepare the player.
    player.prepare();
    // Start the playback.
    player.play();


  }
  public void setWidth(int width) {
    this.setLayoutParams(new ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT));
  }

  public void setHeight(int height) {
    this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, height));
  }

}
