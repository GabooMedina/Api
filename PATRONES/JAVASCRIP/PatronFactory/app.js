import { CarCreator } from "./CarCreator.js";
import { MonocycleCreator } from "./MonocycleCreator.js";
import { MotorcycleCreator } from "./MotorcycleCreator.js";
import { TrailerCreator } from "./TrailerCreator.js";
import { VehicleFactory } from "./VehicleFactory.js";


const factory = new VehicleFactory(new MonocycleCreator());
const monocycle = factory.createVehicle();
console.log(monocycle.description());
console.log("..............................");

 const factory1 = new VehicleFactory(new MotorcycleCreator());
const motorcycle = factory1.createVehicle();
console.log(motorcycle.description());

console.log("..............................");
const factory2 = new VehicleFactory(new  CarCreator);
const Car = factory2.createVehicle();
console.log(Car.description());

console.log("..............................");
const factory3 = new VehicleFactory(new TrailerCreator);
const Trailer = factory3.createVehicle();
console.log(Trailer.description());