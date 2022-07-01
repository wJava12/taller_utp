/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function doSearch() {
    let tableReg=document.getElementById('datos');
    let searchText=document.getElementById('searchTerm').value.toLowerCase();
    let cellsOfRow="";
    let found=false;
    let compareWith="";

    for (let i = 1; i <tableReg.rows.length; i++) {
       cellsOfRow=tableReg.rows[i].getElementsByTagName('td');
       found=false;
        for (let j = 0;j  < cellsOfRow.length && !found; j++) {
            compareWith=cellsOfRow[j].innerHTML.toLowerCase();

            if(searchText.length==0||(compareWith.indexOf(searchText)>-1)){
                found=true;
            }
        }
        if(found){
            tableReg.rows[i].style.display='';
        }else{
            tableReg.rows[i].style.display='none';
        }

    }

}

function ventana(){

    if(!confirm('¿Desea Eliminar: ?')) return false;
}

function testFunction()
{
    val = this.document.getElementById("txtBuscar").value ;

    location.href ='informe1.jsp?tipo='+val+'&Nsiniestro='+val1+'';

}
