/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.adapter;

/**
 *
 * @author USUARIO
 */
public class Mp4Player implements IAdvanceMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Reprducion de archivo MP4 .Nombre" + fileName);
    }
    
}
