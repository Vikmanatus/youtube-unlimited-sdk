import * as React from 'react';

import { Dimensions, StyleSheet, View } from 'react-native';
import {
  // YoutubeUnlimitedSdkView,
  YoutubePlayer,
} from 'react-native-youtube-unlimited-sdk';

export default function App() {
  return (
    <View style={styles.container}>
      {/* <YoutubeUnlimitedSdkView color="#32a852" style={styles.box} /> */}
      <YoutubePlayer height={250} width={Dimensions.get('window').width} />
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
