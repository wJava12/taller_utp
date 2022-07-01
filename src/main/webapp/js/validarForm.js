/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let myBtn=document.getElementById("myBtn");
let clientDni=document.getElementById("inputDni");
let fecha=document.getElementById("inputFecha");

let nom;


clientDni.addEventListener('input',updateValue);
//myBtn.addEventListener("click",updateValue);


function  updateValue(){

        let url="tecnicoMan?tipo=buscar_tecnico&idcod="+clientDni.value;
        alert(clientDni.value);
        const data={
            method:'GET'
        };
        fetch(url,data)
            .then(function (response){
                return response.json();
            })

            .then(function (client){
                //if(confirm("Esta seguro que se desea registrar sus datos")){
                alert(clientDni.value);
                    if(client.dni===clientDni.value ){
                        //vent.preventDefault();
                        console.log(client);
                        //alert("Dni ya existe");
                        document.getElementById('inputDni').style.backgroundColor = "#FFA4A4";
                        //clientDni.setCustomValidity(`Dni duplicado`);
                        //return 0;
                        //clientDni.setCustomValidity(`Dni duplicado`);
                        //window.history.back();

                    }else {
                        document.getElementById('inputDni').style.backgroundColor = "#d8ebf3";
                        //console.log(band);
                        //e.preventDefault();

                        //clientDni.setCustomValidity(`Dni duplicado`);
                        //window.history.back();
                        //$('#enviar').valid();
                        //document.getElementById('enviar').submit();
                        //return 1;
                    }
                //}
            });

}



