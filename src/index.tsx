import type { MutableRefObject } from 'react';
import type { ViewStyle } from 'react-native';
import { requireNativeComponent, Platform, UIManager } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-youtube-unlimited-sdk' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

type YoutubeUnlimitedSdkProps = {
  color: string;
  style: ViewStyle;
};

const ComponentName = 'YoutubeUnlimitedSdkView';

export const YoutubeUnlimitedSdkView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<YoutubeUnlimitedSdkProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };

export type YoutubePlayerProps = {
  style: ViewStyle;
  ref: MutableRefObject<null>;
};

const PlayerComponentName = 'YoutubePlayer';

export const YoutubeUnlimitedVideoPlayer =
  UIManager.getViewManagerConfig(PlayerComponentName) != null
    ? requireNativeComponent<YoutubePlayerProps>(PlayerComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };
