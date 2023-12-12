import { Motorcycle } from "./vehicle.js";
class MotorcycleCreator{
    createVehicle(){
        return new Motorcycle();
    }
}
export{MotorcycleCreator};