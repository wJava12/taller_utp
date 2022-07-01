/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.entidades;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

/**
 *
 * @author ASUS
 */
public class Horario {
    private Integer idHorario;
    private String fechaIngreso;
    private String horarioEntrada;
    private String horaSalida;
    private String diaInicio;
    private String diaFin;
    private String horaAlmuerzo;


        public Horario(String horarioEntrada, String horaSalida) {
        this.horarioEntrada = horarioEntrada;
        this.horaSalida = horaSalida;
    }

    public Horario(String fechaIngreso, String horarioEntrada, String horaSalida, String diaInicio, String diaFin, String horaAlmuerzo) {
        this.fechaIngreso = fechaIngreso;
        this.horarioEntrada = horarioEntrada;
        this.horaSalida = horaSalida;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.horaAlmuerzo = horaAlmuerzo;
    }

    public Horario() {
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(String diaInicio) {
        this.diaInicio = diaInicio;
    }

    public String getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(String diaFin) {
        this.diaFin = diaFin;
    }

    public String getHoraAlmuerzo() {
        return horaAlmuerzo;
    }

    public void setHoraAlmuerzo(String horaAlmuerzo) {
        this.horaAlmuerzo = horaAlmuerzo;
    }


    public LocalTime getCalculoHoras(){

        LocalTime hora1= LocalTime.parse(this.horarioEntrada);
        LocalTime hora2= LocalTime.parse(this.horaSalida);
        int almuerzo=60;
        long dif= MINUTES.between(hora1,hora2)-almuerzo;
        Double h=dif/60.00;
        Long min=dif%60;
        LocalTime hf=LocalTime.of(h.intValue(),min.intValue());

        return hf;
    }
    public int diasHabiles( ) {
        int diffDays = 0;
        boolean diaHabil = false;

        List<Date> listaFechasNoLaborables=new ArrayList<>();

        Calendar fechaInicial=Calendar.getInstance();
        Calendar fechaFinal=Calendar.getInstance();
        LocalDate nFecha=LocalDate.parse(this.fechaIngreso);
        LocalTime nHora=LocalTime.parse(this.horarioEntrada);
        nFecha.atTime(nHora);
        Date date1 = Date.from(nFecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        fechaInicial.setTime(date1);

        LocalDate dia1=LocalDate.of(LocalDate.now().getYear(),12,25);
        Date diaFeriado1 = Date.from(dia1.atStartOfDay(ZoneId.systemDefault()).toInstant());

        listaFechasNoLaborables.add(diaFeriado1);
        LocalDate nFecha2=LocalDate.now();
        LocalTime nHora2=LocalTime.parse(this.horaSalida);
        nFecha2.atTime(nHora2);
        Date date2 = Date.from(nFecha2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        fechaFinal.setTime(date2);

        //mientras la fecha inicial sea menor o igual que la fecha final se cuentan los dias
        while (fechaInicial.before(fechaFinal) || fechaInicial.equals(fechaFinal)) {

            if (!listaFechasNoLaborables.isEmpty()) {
                for (Date date : listaFechasNoLaborables) {
                    Date fechaNoLaborablecalendar = fechaInicial.getTime();
                    //si el dia de la semana de la fecha minima es diferente de sabado o domingo
                    if (fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && !fechaNoLaborablecalendar.equals(date)) {
                        //se aumentan los dias de diferencia entre min y max
                        diaHabil = true;
                    } else {
                        diaHabil = false;
                        break;
                    }
                }
            } else {
                if (fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                    //se aumentan los dias de diferencia entre min y max
                    diffDays++;
                }
            }
            if (diaHabil == true) {
                diffDays++;
            }
            //se suma 1 dia para hacer la validacion del siguiente dia.
            fechaInicial.add(Calendar.DATE, 1);
        }
        return diffDays;
    }
    @Override
    public String toString() {
        return "Horario{" +
                "idHorario=" + idHorario +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", horarioEntrada='" + horarioEntrada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", diaInicio='" + diaInicio + '\'' +
                ", diaFin='" + diaFin + '\'' +
                ", horaAlmuerzo='" + horaAlmuerzo + '\'' +
                '}';
    }
}
