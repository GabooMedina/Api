/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vichi.builder.domain;

import edu.vichi.builder.impl.Botella;
import edu.vichi.builder.impl.IEmbalaje;
import edu.vichi.builder.impl.IItem;

/**
 *
 * @author jaevi
 */
public abstract class BebidaFria implements IItem{


    @Override
    public IEmbalaje embalaje() {
    return new Botella();
    }

    @Override
    public abstract float getPrecio();
    
}
