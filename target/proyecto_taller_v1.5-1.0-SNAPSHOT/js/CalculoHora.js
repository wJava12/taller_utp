/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let inputEntrada=document.getElementById("inputEntrada");
let inputSalida=document.getElementById("inputSalida");
let myBtn=document.getElementById("myBtn");
let divBody=document.getElementById("divBody");
myBtn.addEventListener("click",function (){

    const $tiempo=document.querySelector('#inputTotal');
    console.log("hola")
    let url="horMan?tipo=calcular&he="+inputEntrada.value+"&hs="+inputSalida.value;
    const data={
        method:'GET'
    };
    fetch(url,data)
        .then(function (response){
            return response.json();
        })
        .then(function (hora){
            console.log(hora);
            $tiempo.setAttribute('value',hora.hour+"h y "+hora.minute+"min");
        });

});
