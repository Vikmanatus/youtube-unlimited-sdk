import type { ViewStyle } from 'react-native';
import {
  requireNativeComponent,
  UIManager,
  Platform,
  NativeModules,
} from 'react-native';

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

type YoutubePlayerProps = {
  style: ViewStyle;
};
export const YoutubePlayer =
  UIManager.getViewManagerConfig('YoutubePlayer') !== null
    ? requireNativeComponent<YoutubePlayerProps>('YoutubePlayer')
    : () => {
        throw new Error(LINKING_ERROR);
      };

const { VideoPlayerApiModule } = NativeModules;
interface VideoPlayerApiInterface {
  hello: () => void;
}

export const VideoPlayer: VideoPlayerApiInterface = VideoPlayerApiModule;
