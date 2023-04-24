package com.management;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    public Fecha(int dia, int mes, int anio){
        this.anio = (anio>2022)? anio : 0;
        this.mes = (mes>0 && mes<=12)? mes : 0;
        this.dia = determinarFecha(mes, dia);
    }

    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAnio(){
        return anio;
    }
    public int determinarFecha(int mes, int dia){
        if(dia > 0){
            if(dia<=determinarDiasPorMes(mes)){
                return dia;
            }
        }
        return 0;
    }
    public int determinarDiasPorMes(int mes){
        if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
            return 31;
        }
        if(mes==4 || mes==6 || mes==9 || mes==11){
            return 30;
        }
        if(mes==2){
            return 28;
        }
        return 0;
    }
    public boolean compararSiOtraFechaEsMayor(Fecha nuevaFecha){
        if(anio < nuevaFecha.getAnio()){
            return true;
        }else{
            if(anio == nuevaFecha.getAnio()){
                if(mes < nuevaFecha.getMes()){
                    return true;
                }else{
                    if(mes == nuevaFecha.getMes()){
                        if(dia < nuevaFecha.getDia()){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
    @Override
    public String toString(){
        return "\n " + dia + "/" + mes + "/" + anio;
    }
}
