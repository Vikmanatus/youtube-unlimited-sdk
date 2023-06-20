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
    // const url =
    //   'https://rr2---sn-q0c7rn7d.googlevideo.com/videoplayback?expire=1687293157&ei=hbiRZIX6ApjRvdIP0-iV6Ac&ip=3.250.6.50&id=o-APflNrwNtNd_bKegtw9c5lplg0WHyy9ePKXtZJAyIa1T&itag=22&source=youtube&requiressl=yes&mh=DP&mm=31%2C26&mn=sn-q0c7rn7d%2Csn-5hne6nzk&ms=au%2Conr&mv=m&mvi=2&pl=13&initcwndbps=798750&spc=qEK7B8hCCNdCt02OIxjBf8_XYqnwL74&vprv=1&svpuc=1&mime=video%2Fmp4&cnr=14&ratebypass=yes&dur=1360.410&lmt=1635748936258780&mt=1687271360&fvip=1&fexp=24007246%2C51000022&c=ANDROID&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgLSsELpechB28DMRQH8bgUjzHrw5weKQE7cKjAjNNUP0CIEKFFF5vzzVktbTAVrKz7iI9l34jA4XOAiZquLACEfUq&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgc3sJv_SF6IZpslnaIbGFT6ubM2_rwC1BOWofMhurlKgCIQCx20MRI5D07N5fu5rWbnbahL0nfFcP8Su6fdvVpDOqEg%3D%3D';
    // VideoPlayer.initializePlayer(url);
  }, []);
  return (
    <View style={styles.container}>
      {/* <YoutubeUnlimitedSdkView color="#32a852" style={styles.box} /> */}
      <YoutubePlayer
        style={{
          width: Dimensions.get('window').width,
          height: 250,
          backgroundColor: 'red',
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
