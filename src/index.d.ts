import { UIManager as OriginalUIManager } from 'react-native';

// Define the command interface for YoutubePlayer
interface YoutubePlayerCommands {
  create: number;
  // add any other commands here
}

// Define the shape of the YoutubePlayer view manager
interface YoutubePlayerManager {
  Commands: YoutubePlayerCommands;
}

// Extend the original UIManager with YoutubePlayer
declare module 'react-native' {
  interface UIManagerStatic extends OriginalUIManager {
    YoutubePlayer: YoutubePlayerManager;
  }
}
