
package edu.acaiza.adapter;

/**
 *
 * @author USUARIO
 */
public class MediaAdapter  implements IMediaPlayer{

   
       IAdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String typeAudio) {
        if (typeAudio.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer = new VlcPlayer();
        } else if (typeAudio.equalsIgnoreCase("mp4")) {
            advanceMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String typeAudio, String fileName) {
        if(typeAudio.equalsIgnoreCase("vlc")){
            advanceMediaPlayer.playVlc(fileName);
        }else if(typeAudio.equalsIgnoreCase("mp4")){
            advanceMediaPlayer.playMp4(fileName);
        }
    }
   
    
}
