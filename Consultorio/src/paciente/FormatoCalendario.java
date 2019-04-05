package paciente;

import java.util.Date;
import java.util.GregorianCalendar;

public class FormatoCalendario {
	
	private Date date;
    private String fecha;
    
    FormatoCalendario(Date d){
        setDate(d);
        setFecha(obtenerFecha(d));
    }
	
	public String obtenerFecha(Date dat){
		
        GregorianCalendar gc = new GregorianCalendar();
        
        //Obtiene la fecha en formato Date
        gc.setTime(dat);         
        //Extrae el día, mes y año de la fecha dada
        int dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
        int mes = gc.get(GregorianCalendar.MONTH) + 1; ///Se suma el 1, porque los meses están dados del 0 al 11
        int año = gc.get(GregorianCalendar.YEAR);
        String d = "", m = "";
        if(dia < 10){
            d = "0" + dia;
        }else{ 
            d = String.valueOf(dia);
        }
        if(mes < 10){
            m = "0" + mes;
        }else{
            m = String.valueOf(mes);
        }
        return d + "/" + m + "/" + año;
    }
	
	
	
	public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
