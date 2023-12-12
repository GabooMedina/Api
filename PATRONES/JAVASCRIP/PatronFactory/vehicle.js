class vehicle {
   #wheeler;
   #type;

    constructor(wheeler, type) {
        this.#wheeler = wheeler;
        this.#type = type;


    }
    getWheeler (){
return this.#wheeler;
    }
    getType (){
        return this.#type;
    }
    description (){
        return `I have ${this.#wheeler} wheeles and I am of the ${this.#type} type`;
    }

}
class Monocycle extends vehicle{
    constructor (){
        super(1,"monocycle");
        
    }
}

class Motorcycle extends vehicle{
    constructor (){
        super(2,"motorcycle");
        
    }
}
class Car extends vehicle{
    constructor (){
        super(4,"Car");
        
    }
}
class Triler extends vehicle{
    constructor (){
        super(6,"Trailer");
        
    }
}
export {Monocycle,Motorcycle,Car,Triler};
