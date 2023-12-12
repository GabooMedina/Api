/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vichi.builder.domain;

import edu.vichi.builder.impl.Empaque;
import edu.vichi.builder.impl.IEmbalaje;
import edu.vichi.builder.impl.IItem;

/**
 *
 * @author jaevi
 */
public abstract class Hamburguesa implements IItem {

    @Override
    
    public IEmbalaje embalaje() {
        return new Empaque();
    }

    @Override
    public abstract float getPrecio();

}
