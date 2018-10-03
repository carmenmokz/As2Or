package MODEL;

/**
 * 
 */
public class R4 extends QUERY_DATE {

    /**
     * Default constructor
     */
    public R4() {
    }

    /**
     * @Description 
     * Método encargado de determinar el número de días
     * transcurridos desde el primero de enero de su año 
     * (el número de días transcurridos entre el primero de 
     * enero y el primero de enero, dentro de un mismo año, es 0).
     * 
     * @return int
     */
    public Object dias_desde_primero_enero() {
        // TODO implement here
        
        if(!(boolean)METHODS_DATE.getmDate().getCheckDate().exec())
            return "Error: Fecha inválida"; 
        
        int[] diasPorMes = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334}; // ,365}; No hace falta
        int anio = date.getYear();
        int mes = date.getMonth();
        int dia = date.getDay();
        
        int diaDesPriEne = diasPorMes[mes-1] + dia;
       
        if(mes >= 3 && (boolean)METHODS_DATE.getmDate().getBisiesto().exec())
            diaDesPriEne++;
        
        if(anio == 1582)
            diaDesPriEne -= 10;
        
        return diaDesPriEne-1;
    }

    @Override
    public Object exec() {
        return dias_desde_primero_enero();
    }

}