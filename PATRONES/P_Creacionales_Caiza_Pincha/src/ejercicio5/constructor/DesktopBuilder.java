/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5.constructor;

import ejercicio5.domain.Desktop;
import ejercicio5.domain.GraphicCard;
import ejercicio5.domain.MotherBoard;
import ejercicio5.domain.Type;

/**
 *
 * @author USUARIO
 */
public class DesktopBuilder implements DeviceBuilder{
    private Type type;
    private String processor;
    private int ram;
    private GraphicCard graphicCard;
    private MotherBoard motherBoard;

    @Override
    public DesktopBuilder type(final Type type) {
        this.type = type;
        return this;
    }

    @Override
    public DesktopBuilder processor(final String processor) {
        this.processor = processor;
        return this;
    }

    @Override
    public DesktopBuilder ram(final int ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public DesktopBuilder graphicCard(final GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
        return this;
    }

    @Override
    public DesktopBuilder motherBoard(final MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
        return this;
    }

    public Desktop build() {
        return new Desktop(this.type, this.processor, this.ram, this.graphicCard, this.motherBoard);
    }    
}
