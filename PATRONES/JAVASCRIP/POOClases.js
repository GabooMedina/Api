class Persona {
    constructor(nombre , edad){
    this.nombre=nombre;
    this.edad=edad;
}
bailar (){
    return `${this.nombre} puede bailar`;
}
};
let persona1 = new Persona("Juan",25);
console.log(persona1.nombre);
console.log(persona1.edad);
console.log(persona1.bailar());
console.log(persona1);

class Estudiante extends Persona {
    constructor(nombre, edad, asignatura) {
        super(nombre, edad);
        this.asignatura = asignatura;
    }
    estudiar() {
        return `Estudia la asignatura ${this.asignatura}`;

    }
};

let Estudiante1 = new Estudiante("Luis", 25, "Matematicas");
console.log(Estudiante1.nombre);
console.log(Estudiante1.edad);
console.log(Estudiante1.estudiar());
console.log(Estudiante1.bailar());
console.log(Estudiante1);

