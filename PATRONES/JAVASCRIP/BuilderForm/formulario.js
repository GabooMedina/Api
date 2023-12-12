class Formulario{
    constructor(){
        this.campos=[];
    }

    setCampos(campo){
        this.campos.push(campo);
    }

}
class Inputs{
    constructor(texto){
        this.texto = texto;
    }
}

class InputText extends Inputs{
    constructor(texto){
        super(texto);
        this.texto = texto;
    }
    crearElemento(){
        const InputText = document.createElement("input");
        InputText.setAttribute("type","text");
        InputText.setAttribute("placeholder", this.texto);
        return InputText;
    }
    
}
class InputEmail extends Inputs{
    constructor(texto){
        super(texto);
        this.texto = texto;
    }
    crearElemento(){
        const InputEmail = document.createElement("input");
        InputEmail.setAttribute("type","email");
        InputEmail.setAttribute("placeholder", this.texto);
        return InputEmail;
    }

}

class InputButton extends Inputs{
    constructor(texto){
        super(texto);
        this.texto = texto;
    }
    crearElemento(){
        const button = document.createElement("button");
        button.setAttribute("type","submit");
        button.textContent = this.texto;
        return button;
    }
}


//Constructores Concretos
class FormularioBuilder{
    constructor(){
        this.formulario = new Formulario();
    }
    agregarCampos(tipo, texto){
        let campo;
        switch (tipo){
            case "text":
                campo = new InputText(texto);
                break;
            case "email":
                campo = new InputEmail(texto);
                break;
            case "button":
                campo = new InputButton(texto);
                break;
            default:
                throw new Error("Tipo de campo no valido "+tipo);
                break;
        }
        this.formulario.setCampos(campo);   
    }
    obtenerFormularios(){
        let form = document.createElement("form"), 
        ancho=this.formulario.campos.length,
        campo;

        for(let i = 0; i < ancho; i++){
            campo = this.formulario.campos[i];
            form.appendChild(campo.crearElemento());
            let br = document.createElement("br");
            form.appendChild(br);
        }
        return form;
    }

}                                                                                                                                                                                                                                                                                                                                                                                                               


//Cliente
const director = new FormularioBuilder();
director.agregarCampos("text","Añade tu nombre");
director.agregarCampos("text","Añade tu apellido");
director.agregarCampos("email","Añade tu email");
director.agregarCampos("button","Enviar Formulario");
console.log(director);

//Renderizar en HTML
document.addEventListener("DOMContentLoaded", ()=>{
document.querySelector("#app").appendChild(director.obtenerFormularios());
});










