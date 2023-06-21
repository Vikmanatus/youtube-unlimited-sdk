import * as React from 'react';

import {
  Dimensions,
  PixelRatio,
  StyleSheet,
  UIManager,
  View,
  findNodeHandle,
  UIManager as OriginalUIManager,
} from 'react-native';
// Define the command interface for YoutubePlayer
interface YoutubePlayerCommands {
  create: number;
  // add any other commands here
}

// Define the shape of the YoutubePlayer view manager
interface YoutubePlayerManager {
  Commands: YoutubePlayerCommands;
}
interface UIManagerStatic extends OriginalUIManager {
  YoutubePlayer: YoutubePlayerManager;
}
import { YoutubeUnlimitedVideoPlayer } from 'react-native-youtube-unlimited-sdk';

const createFragment = (viewId: number) => {
  const UIMangerExtended = UIManager as UIManagerStatic;
  UIMangerExtended.dispatchViewManagerCommand(
    viewId,
    // we are calling the 'create' command
    UIMangerExtended.YoutubePlayer.Commands.create.toString(),
    [viewId]
  );
};

export default function App() {
  const ref = React.useRef(null);

  React.useEffect(() => {
    const viewId = findNodeHandle(ref.current);
    if (viewId) {
      createFragment(viewId);
    }
  }, []);
  return (
    <View style={styles.container}>
      {/* <YoutubeUnlimitedSdkView color="#32a852" style={styles.box} /> */}
      <YoutubeUnlimitedVideoPlayer
        ref={ref}
        style={{
          height: PixelRatio.getPixelSizeForLayoutSize(200),
          // converts dpi to px, provide desired width
          width: PixelRatio.getPixelSizeForLayoutSize(200),
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  box: {
    width: Dimensions.get('window').width,
    height: 400,
  },
});
