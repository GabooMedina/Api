import { Car } from "./vehicle.js";
class CarCreator{
    createVehicle(){
        return new Car();
    }
}
export{CarCreator};