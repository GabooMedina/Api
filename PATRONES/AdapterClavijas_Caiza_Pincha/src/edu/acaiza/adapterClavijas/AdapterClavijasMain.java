/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.adapterClavijas;

/**
 *
 * @author USUARIO
 */
public class AdapterClavijasMain {

    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(8.0);
        RoundPeg rp = new RoundPeg(8.0);
        RoundPeg rp2 = new RoundPeg(5.0);
        SquarePeg sp = new SquarePeg(2.0);
        SquarePegAdapter spa = new SquarePegAdapter(sp);
        //*****************************************************************//

        System.out.println();
        System.out.println("-----------RoundHole---------------");
        if (roundHole.fits(rp.getRadius())) {
            System.out.println("Compatible con " + rp.getRadius());
        } else {
            System.out.println("Incompatible con " + rp.getRadius());
        }
        System.out.println("-----------RoundPeg---------------");

        if (roundHole.fits(rp2.getRadius())) {
            System.out.println("Compatible con " + rp2.getRadius());
        } else {
            System.out.println("Incompatible con " + rp2.getRadius());
        }
        System.out.println("-----------SquarePeg---------------");

        if (roundHole.fits(spa.getRadius())) {
            System.out.println("Compatible con " + spa.getRadius());
        } else {
            System.out.println("Incompatible con " + spa.getRadius());
        }

    }

}
