/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.adapter.figura;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author USUARIO
 */
public class CuadradoTextoAdapter implements IForma {

    JTextPane text;
    JFrame ventana;

    public CuadradoTextoAdapter() {
        ventana = new JFrame("JTextFrame");
        text = new JTextPane();
    }

    @Override
    public void dibujar() {

        
        try {
            SimpleAttributeSet attrs = new SimpleAttributeSet();
            StyleConstants.setBold(attrs, true);
            //cursiva
            StyleConstants.setItalic(attrs, true);

            StyleConstants.setUnderline(attrs, true);

            StyleConstants.setFontSize(attrs, 20);

            text.getStyledDocument().insertString(text.getStyledDocument().getLength(), "hola mundo", attrs);
        } catch (BadLocationException ex) {
            Logger.getLogger(CuadradoTextoAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        ventana.add(text);
        ventana.pack();
        ventana.setVisible(true);
            
        }
    }


