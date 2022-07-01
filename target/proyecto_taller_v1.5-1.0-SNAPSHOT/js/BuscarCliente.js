/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let myBtn=document.getElementById("myBtn");
let clientDni=document.getElementById("clientDni")
let divBody=document.getElementById("divBody");
let divBody2=document.getElementById("divBody2");
myBtn.addEventListener("click",function () {

        let url="tecnicoMan?tipo=buscar_cliente&idcod="+clientDni.value;
        const data={
            method:'GET'
        };
        fetch(url,data)
            .then(function (response){
                return response.json();
            })

            .then(function (client){
                console.log(client);
                let row="";

                row+="<label class='col-sm-2 col-form-label'>Nombre</label>"+
                    "<div class='col-sm-4'>"+
                    "<input readonly type='text' class='form-control'  value='"+client.nombre+"'>"+
                    "</div>"+
                    "<label class='col-sm-2 col-form-label'>Apellido</label>"+
                    "<div class='col-sm-4'>"+
                    "<input readonly type='text' class='form-control' value='"+client.apelldos+"'>"+
                    "</div>";
                let row2="";

                row2+="<label class='col-sm-2 col-form-label'>Dnie</label>"+
                    "<div class='col-sm-4'>"+
                    "<input readonly type='text' class='form-control'name='txtDni' value='"+client.dni+"'>"+
                    "</div>"+
                    "<label class='col-sm-2 col-form-label'>Correo</label>"+
                    "<div class='col-sm-4'>"+
                    "<input readonly type='text' class='form-control'value='"+client.correo+"'>"+
                    "</div>";
                divBody.innerHTML=row;
                divBody2.innerHTML=row2;
            });



}
);

