//Definir edad

function Persona(nombre , edad){
    this.nombre= nombre;
    this.edad = edad;

}
Persona.prototype.saludar=function(){
    console.log('Hola ,soy ' + this.nombre);
}

//Creacion de objetos persona
var persona1 = new Persona("Rocio", 12);
console.log(persona1.nombre);
console.log(persona1.edad);
console.log(persona1);


