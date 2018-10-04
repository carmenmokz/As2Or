package MODEL;

/**
 * 
 */
public class R1 extends QUERY_DATE {

    /**
     * Default constructor
     */
    public R1() {
    }

    /**
     * @Description 
     * Método encargado de determinar si un año es bisiesto
     * Un año es bisiesto si:
     *      1) El año es divisible entre 4 y no es divisible entre 100
     *      ó
     *      2) El año es divisible entre 400
     * 
     * @return boolean
     */
    
    public Object bisiesto() {
        int year = date.getYear();
        if(year < 1582)
            return "Error: Fecha inválida";
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
       
    }

    @Override
    public Object exec() {
        return bisiesto();
    }

}