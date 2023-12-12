class counter{
    #instance;
    #counter =0;

    constructor(){
        if(this.#instance){
            throw new Error("Tu puedes crecar una sola instancia");


        }
this.#instance = this;
    }

    getInstance(){
        return this.#instance;
    }
    getCount(){
        return this.#counter;
    }
    increment(){
        return ++ this.#counter;
    }
    decrement(){
        return -- this.#counter;
    }
}

const singletonCounter=Object.freeze (new counter());
export default singletonCounter;