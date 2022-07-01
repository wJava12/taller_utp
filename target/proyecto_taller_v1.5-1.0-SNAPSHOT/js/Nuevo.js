
document.getElementById('marcarTodo').addEventListener('click', function(e) {
    //e.preventDefault();
    //seleccionarTodo();
    checkAll();

});

document.getElementById('desmarcarTodo').addEventListener('click', function(e) {
    //e.preventDefault();
    //seleccionarTodo();
    uncheckAll();

});

function enviarId(){
    document.getElementById('tecnico').valu
}

function checkAll() {
    document.querySelectorAll('#enviar input[type=checkbox]')
        .forEach(function(checkElement) {
            checkElement.checked = true;
        });
}

function uncheckAll() {
    document.querySelectorAll('#enviar input[type=checkbox]')
        .forEach(function(checkElement) {
            checkElement.checked = false;
        });
}


let fecha = new Date();
console.log(fecha)
let anio = fecha.getFullYear();
let dia = fecha.getDate();
let _mes = fecha.getMonth(); //viene con valores de 0 al 11
_mes = _mes + 1; //ahora lo tienes de 1 al 12
if (_mes < 10) //ahora le agregas un 0 para el formato date
{
    var mes = "0" + _mes;
} else {
    var mes = _mes.toString;
}
document.getElementById("inputFecha").min = anio + '-' + mes + '-' + dia;
