package com.youtubeunlimitedsdk.player;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

public class VideoPlayerView extends FrameLayout {
  private ExoPlayer player;
  private PlayerView playerView;

  public VideoPlayerView(@NonNull Context context) {
    super(context);
    // this.setBackgroundColor(Color.parseColor("#5FD3F3"));
    player = new ExoPlayer.Builder(context).build();
    playerView = new PlayerView(context);
    playerView.setPlayer(player);
    playerView.setUseController(true); // set to true or false to control visibility of the controller
    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    playerView.setLayoutParams(params);
    this.addView(playerView);
    String videoUri = "https://rr4---sn-4g5ednsz.googlevideo.com/videoplayback?expire=1687380830&ei=_g6TZK29JMWyxN8Pl_qk0A0&ip=54.74.63.241&id=o-AHONGTHcEcpX93wHO4GGvJ_qs9Psk3TkJ1AEQV-N5v8i&itag=22&source=youtube&requiressl=yes&spc=qEK7B5T5Qg4zwfPfHw2E5rgqxlsafL4&vprv=1&svpuc=1&mime=video%2Fmp4&cnr=14&ratebypass=yes&dur=1360.410&lmt=1635748936258780&fexp=24007246,24350018,51000022&beids=24350018&c=ANDROID&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRgIhAMUouNsFmljipqUVLLX_a4p29KWL5T1I2gBoSOQ-mfcYAiEAlNG5XuZkuAp1-_kXe9kaVFp1sWr-SzbDDZuKla97sjY%3D&redirect_counter=1&cm2rm=sn-q0cee7s&req_id=d6b024b52e87a3ee&cms_redirect=yes&mh=DP&mip=2a02:8428:a9e0:4301:7c8d:a356:2da6:ec0b&mm=34&mn=sn-4g5ednsz&ms=ltu&mt=1687359177&mv=m&mvi=4&pl=40&lsparams=mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhAIf_DP232m0HrPGPdaQqQEpRUY-1pCGL50JquofJiK3bAiAK_ELpgWrG8eAnc8C1ByvqNJtGWcAcPMvDGXVpzNt_fQ%3D%3D";
    MediaItem mediaItem = MediaItem.fromUri(Uri.parse(videoUri));
    player.setMediaItem(mediaItem);
    player.prepare();
    player.play();
  }
}
