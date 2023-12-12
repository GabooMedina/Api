import counter from "./counter.js";
const button =document.getElementById("green");
button.addEventListener("click",()=>{
    console.log("Counter total:",counter.decrement())
});