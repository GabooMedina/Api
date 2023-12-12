
package edu.acaiza.adapter;

/**
 *
 * @author USUARIO
 */
public class AudioPlayer implements IMediaPlayer {
    
 MediaAdapter mediaAdapter;

    @Override
    public void play(String typeAudio, String fileName) {
        if (typeAudio.equalsIgnoreCase("mp3")) {
            System.out.println("Reproduccion de archivo MP3. Nombre = "+fileName);
        } else if (typeAudio.equalsIgnoreCase("vlc")||typeAudio.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(typeAudio);
            mediaAdapter.play(typeAudio, fileName);
        }else{
            System.out.println("Multimedia no valido. "+ typeAudio + ", formato no soportado.");
        }
    }
    
}
