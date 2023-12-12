import { Monocycle } from "./vehicle.js";
class MonocycleCreator{
    createVehicle(){
        return new Monocycle();
    }
}
export{MonocycleCreator};