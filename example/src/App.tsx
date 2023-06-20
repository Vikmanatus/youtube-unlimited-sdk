import * as React from 'react';

import { Dimensions, StyleSheet, View } from 'react-native';
import {
  // YoutubeUnlimitedSdkView,
  YoutubePlayer,
  VideoPlayer,
} from 'react-native-youtube-unlimited-sdk';

export default function App() {
  React.useEffect(() => {
    VideoPlayer.hello();
  }, []);
  return (
    <View style={styles.container}>
      {/* <YoutubeUnlimitedSdkView color="#32a852" style={styles.box} /> */}
      <YoutubePlayer
        style={{ width: Dimensions.get('window').width, height: 250 }}
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
