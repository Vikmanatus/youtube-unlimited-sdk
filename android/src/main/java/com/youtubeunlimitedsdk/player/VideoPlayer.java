package com.youtubeunlimitedsdk.player;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
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
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.exoplayer_view, this, true);
    // Find the PlayerView
    PlayerView playerView = view.findViewById(R.id.expoplayer_view);
//    PlayerView playerView = new PlayerView(context);
//    playerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//    playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);
    // Setting up player
    player = new ExoPlayer.Builder(context).build();
//    player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT);
    playerView.setPlayer(player);
    // addView(playerView);
    String videoUri = "https://rr5---sn-n4g-jqbek.googlevideo.com/videoplayback?expire=1687271039&ei=H2KRZMTYCYzBsALYnL9A&ip=3.250.6.50&id=o-AFKzZ8tmObGcyTskgjmwdMRNk9ruAplsdt93x-XSSPDQ&itag=22&source=youtube&requiressl=yes&bui=AZ6lgGGPx1-6xS_mDBCusMWcn_XGRYJJJtJhhfNNli8AU8_GF19iuGFUNQMCa5cy-XbR1mXAMlIAXghNpkhcPU6csOwHoNiC&spc=qEK7Bw8A1VimKjUvoXrEq3WQirKEwQg&vprv=1&svpuc=1&mime=video%2Fmp4&cnr=14&ratebypass=yes&dur=1360.410&lmt=1635748936258780&fexp=24007246,24350018,24362686&beids=24350018&c=ANDROID&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cbui%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAPPSgRAL5YU1PAaLEjYqmobIWvSGHV5XJmNf-3bvperyAiAFfVjWkArDJmG9BrzapsCWsnDrow4nGTE6ijLl6q54Gw%3D%3D&redirect_counter=1&rm=sn-q0cel7l&req_id=993f85c8e308a3ee&cms_redirect=yes&ipbypass=yes&mh=DP&mip=2a02:8428:a9e0:4301:e989:8d66:da2b:4918&mm=31&mn=sn-n4g-jqbek&ms=au&mt=1687249048&mv=m&mvi=5&pl=40&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIgQZk9Mg24huhSzaKAWpOEVnhaGRbvZ8DrS3mHWFyOYS8CIQD9hPsAkO5KZXfv1AdPbSIXzdcJ7A4OXMjCO1ZgKoUgGA%3D%3D";
    MediaItem mediaItem = MediaItem.fromUri(videoUri);
    player.setMediaItem(mediaItem);
    // Prepare the player.
    player.prepare();
    // Start the playback.
    player.play();
  }
}
