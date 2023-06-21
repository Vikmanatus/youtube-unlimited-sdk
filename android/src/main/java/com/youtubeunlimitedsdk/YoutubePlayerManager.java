package com.youtubeunlimitedsdk;

import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.youtubeunlimitedsdk.fragments.VideoPlayerFragment;
import com.youtubeunlimitedsdk.player.VideoPlayerView;

import java.util.Map;

public class YoutubePlayerManager extends ViewGroupManager<FrameLayout> {
  public static final String REACT_CLASS = "YoutubePlayer";
  public final int COMMAND_CREATE = 1;
  private int propWidth;
  private int propHeight;

  ReactApplicationContext reactContext;

  public YoutubePlayerManager(ReactApplicationContext reactContext) {
    this.reactContext = reactContext;
  }


  @Override
  public String getName() {
    return REACT_CLASS;
  }

  /**
   * Return a FrameLayout which will later hold the Fragment
   */
  @Override
  public FrameLayout createViewInstance(ThemedReactContext reactContext) {
    return new FrameLayout(reactContext);
  }

  /**
   * Map the "create" command to an integer
   */
  @Nullable
  @Override
  public Map<String, Integer> getCommandsMap() {
    return MapBuilder.of("create", COMMAND_CREATE);
  }

  /**
   * Handle "create" command (called from JS) and call createFragment method
   */
  @Override
  public void receiveCommand(
    @NonNull FrameLayout root,
    String commandId,
    @Nullable ReadableArray args
  ) {
    super.receiveCommand(root, commandId, args);
    int reactNativeViewId = args.getInt(0);
    int commandIdInt = Integer.parseInt(commandId);

    switch (commandIdInt) {
      case COMMAND_CREATE:
        createFragment(root, reactNativeViewId);
        break;
      default: {}
    }
  }

  @ReactPropGroup(names = {"width", "height"}, customType = "Style")
  public void setStyle(FrameLayout view, int index, Integer value) {
    if (index == 0) {
      propWidth = value;
    }

    if (index == 1) {
      propHeight = value;
    }
  }

  /**
   * Replace your React Native view with a custom fragment
   */
  public void createFragment(FrameLayout root, int reactNativeViewId) {
    ViewGroup parentView = (ViewGroup) root.findViewById(reactNativeViewId);
    setupLayout(parentView);

    final VideoPlayerFragment videoPlayerFragment = new VideoPlayerFragment();
    FragmentActivity activity = (FragmentActivity) reactContext.getCurrentActivity();
    activity.getSupportFragmentManager()
      .beginTransaction()
      .replace(reactNativeViewId, videoPlayerFragment, String.valueOf(reactNativeViewId))
      .commit();
  }

  public void setupLayout(View view) {
    Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
      @Override
      public void doFrame(long frameTimeNanos) {
        manuallyLayoutChildren(view);
        view.getViewTreeObserver().dispatchOnGlobalLayout();
        Choreographer.getInstance().postFrameCallback(this);
      }
    });
  }

  private int getScreenWidth() {
    WindowManager windowManager = (WindowManager) reactContext.getSystemService(reactContext.WINDOW_SERVICE);
    DisplayMetrics displayMetrics = new DisplayMetrics();
    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    return displayMetrics.widthPixels;
  }
  /**
   * Layout all children properly
   */
  public void manuallyLayoutChildren(View view) {
    // propWidth and propHeight coming from react-native props
    int width = getScreenWidth();
    int height = convertDpToPixel(700, reactContext);

    view.measure(
      View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
      View.MeasureSpec.makeMeasureSpec(800, View.MeasureSpec.EXACTLY));

    view.layout(0, 0, width, 800);
  }

  public static int convertDpToPixel(float dp, ReactApplicationContext context){
    return (int) dp * (context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
  }
}
