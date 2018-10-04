package MODEL;

/**
 * 
 */
public class R5 extends QUERY_DATE {

    /**
     * Default constructor
     */
    public R5() {
        
    }

    /**
     * @Description 
     * Método que determina el día de la semana que
     * le corresponde al primero de enero de ese año.
     * Este tiene la siguiente codificación: 
     * 0 = domingo
     * 1 = lunes
     * 2 = martes
     * 3 = miércoles
     * 4 = jueves
     * 5 = viernes
     * 6 = sábado
     * 
     * @return int
     */
    public Object dia_primero_enero() {
        date.setMonth(1);
        date.setDay(1);
        if(!(boolean)METHODS_DATE.getmDate().getCheckDate().exec())
            return "Error: Fecha inválida"; 
        
        int year = date.getYear();
        int month = 1;
        int day = 1;
        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        
        if (month < 3) year--;
        
        //Algoritmo de Zeller
        return (year + year/4 - year/100 + year/400 + t[month-1] + day) % 7;
    }

    @Override
    public Object exec() {
        return dia_primero_enero();
    }

}