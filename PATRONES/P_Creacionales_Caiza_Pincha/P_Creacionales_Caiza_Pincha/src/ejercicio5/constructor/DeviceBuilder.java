/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercicio5.constructor;

import ejercicio5.domain.GraphicCard;
import ejercicio5.domain.MotherBoard;
import ejercicio5.domain.Type;

/**
 *
 * @author USUARIO
 */
public interface DeviceBuilder {
        DeviceBuilder type(Type type);
    DeviceBuilder processor(String processor);
    DeviceBuilder ram(int ram);
    DeviceBuilder graphicCard(GraphicCard graphicCard);
    DeviceBuilder motherBoard(MotherBoard motherBoard);
    
}
