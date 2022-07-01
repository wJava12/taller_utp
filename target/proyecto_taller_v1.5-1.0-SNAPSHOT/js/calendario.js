let cal=document.getElementById('calendario');
let meses=document.getElementById('mesEntrada');
let tecnico=document.getElementById('tecnicoId');

let enlace=document.getElementById('idTecnico2');
let valor=0;
enlace.addEventListener("click",function (){

});

let tiempo=document.getElementById('horarioTecnico').value.split(":");
let diaInicio=document.getElementById('diaInicio').value;
let diaFin=document.getElementById('diaFin').value;

let fechaHoy=new Date(2022,6,29,tiempo[0],tiempo[1],tiempo[2])
let hora=fechaHoy.getHours();

function muestravalor(x){
    valor=x;
    $("#enviarIdTecnico").val(valor);
    $('#exampleModalCenter').modal('show');
}


meses.addEventListener("click",function () {

    hora=fechaHoy.getHours();
   console.log(meses.value);
    const diasTotales=calendar.map(({daysOfMonth,monthName})=>{

        let total=daysOfMonth;
        let x=1;
        let td="";
        const days=[...Array(daysOfMonth).keys()];
        const renderedDays=days.map((day,index)=>
            "<th>"+(day+1)+"</th>"
        ).join('');
        const tr="<tr>" +
            renderedDays+
            "</tr></thead>";
        let fila="<tr>";
        //let title="<h1>"+monthName+" "+actualYear+"</h1>";
        let mes=meses.value;
        let title="";
        if (mes===monthName.valueOf()){
            title+="<h1>"+mes+" "+actualYear+"</h1>";
            for (let i = 0; i < total; i++) {
                if ((x)%7!==0){
                    td+="<td>"+dia(x) +"</td>";
                    x++;
                }
                if ((i+1)%7===0){
                    td+="<td>"+dia(x) +"</td>";
                    x=1;
                }
                // console.log(td);
            }
            for (let i = 0; i <11; i++) {
                fila+="<tr>";
                for (let i = 0; i < total; i++) {
                    fila+="<td>"+
                        "<input type='submit'  class='btn btn-success' style='font-size: 10px' id='horita"+i+"' onclick='(Hora("+i+","+hora+","+fechaHoy.getMinutes()+"))' value='"+hora+':'+fechaHoy.getMinutes()+"'>"+
                        "</td>";
                    // console.log(td);
                }
                fila+="</tr>";
                hora+=1;
            }
            const table="<table class='table table-responsive table-light table-sm text-xsmall' style='width: 400px;height: 500px'>"+
                "<thead className='thead-dark'>";;

            return title+table+tr+"<tbody><tr>"+ td+"</tr>"+fila+"</tbody>" +
                "<input type='hidden' id='valueHora' name='valueHora'>" +
                "<input type='hidden' id='valueDia' name='valueDia'>"
                "</table>";
        }

    });

    cal.innerHTML=diasTotales;
});

function Hora(total,x,y){
    let valor=x+":"+y;
    let dia=total+1;
    $("#valueHora").val(valor);
    $("#valueDia").val(dia);

    alert($("#valueHora").val());
    alert($("#valueDia").val());
}
const actualYear=2022;
const locale='es-ES';

const weekdays=[...Array(7).keys()];
const intlWeekDay=new Intl.DateTimeFormat(locale,{weekday:'long'});

const weekDaysNames=weekdays.map(weekDayIndex=>{
    const date=new Date(2021,10,weekDayIndex+1);
    const weekDayName=intlWeekDay.format(date);
    return weekDayName
})


const months=[...Array(12).keys()];

const intl=new Intl.DateTimeFormat(locale,{month:'long'});

const calendar=months.map(monthkeys=>{
    const monthName=intl.format(new Date(actualYear,monthkeys));

    const nextMonthIndex= monthkeys +1;
    const daysOfMonth=new Date(actualYear,nextMonthIndex,0).getDate();

    const starsOn= new Date(actualYear,monthkeys ,1).getDay();

    return {
        monthName,
        daysOfMonth,
        starsOn
    };
});
const renderedWeekDays=weekDaysNames.map(weekDayName=>
        "<td class='day-name'>"+weekDayName+"</td>"
).join('');


//cal.innerHTML=html;
function mouseOver(btn){btn.style.background="yellow";};
function mouseOut(btn){btn.style.background="white";};


function dia(x){
    let nombreDia="";
    switch (x) {
       case 1:nombreDia="Lunes";break;
        case 2:nombreDia="Martes";break;
        case 3:nombreDia="Miercoles";break;
        case 4:nombreDia="Jueves";break;
        case 5:nombreDia="Viernes";break;
        case 6:nombreDia="Sabado";break;
        case 7:nombreDia="Domingo";break;
    }
    
    return nombreDia;
}


console.log(calendar);
console.log(weekDaysNames);


