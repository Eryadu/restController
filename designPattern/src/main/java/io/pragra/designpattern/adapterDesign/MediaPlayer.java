package io.pragra.designpattern.adapterDesign;

public interface MediaPlayer {
    void mp3Play(String fileName);
}
class AdvancedMediaPlayer {
    void mp4Play(String fileName){
        System.out.println(fileName + "mp4Play Format");
    }
}
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;
    public MediaAdapter() {
        advancedMediaPlayer = new AdvancedMediaPlayer();
    }
    @Override
    public void mp3Play(String fileName) {
        advancedMediaPlayer.mp4Play(fileName);
    }

    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaAdapter();
        mediaPlayer.mp3Play("Music Playing in ");
    }
}