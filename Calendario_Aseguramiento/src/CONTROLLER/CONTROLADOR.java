package CONTROLLER;


import MODEL.DATE;
import MODEL.METHODS_DATE;
import MODEL.QUERY_DATE;
import VIEW.DTO_DATE;

/**
 * 
 */
public class CONTROLADOR {
    
    public static CONTROLADOR control = new CONTROLADOR();    
    private DTO_DATE DTO_F;
    private DATE date;
    private QUERY_DATE qDate;
    private METHODS_DATE mDate = METHODS_DATE.getmDate();
    
    /**
     * Default constructor
     */
    private CONTROLADOR() {}
    
    /*
    */
    public void createDate(DTO_DATE dFecha) {
        setDTO_F(dFecha); // Se establece el DTO
        if(date == null)
            date = new DATE(DTO_F.getDay(), DTO_F.getMonth(), DTO_F.getYear()); // Creamos un nuevo objeto Date con los datos d,m,y
        else{ // Si el objeto ya existe, actualizamos los datos
            date.setDay(DTO_F.getDay());
            date.setMonth(DTO_F.getMonth());
            date.setYear(DTO_F.getYear());
        }
        QUERY_DATE.setDate(date); // Establecemos este DATE como un nuevo objeto para utilizarlo en los Queries
    }

    /**
     * @return
     */
    public Object execQuery() {
        //System.out.println("Query: "+ DTO_F.getQuery());
        switch (DTO_F.getQuery()){
            case 1:
                date.setQueryDate(mDate.getBisiesto());
            break;
            case 2:
                date.setQueryDate(mDate.getCheckDate());
            break;
            case 3:
                date.setQueryDate(mDate.getNextDay());
            break;
            case 4:
                date.setQueryDate(mDate.getDaysFrom1Jan());
            break;
            case 5:
                date.setQueryDate(mDate.getDayFirstJan());
            break;
            case 6:
                date.setQueryDate(mDate.getPrintCalendar());
            break;
        }
        return date.getQueryDate().exec(); // Método que encapsula la ejecución de las funcionalidades
    }
    
    /*GETTERS AND SETTERS*/
    public static CONTROLADOR getControl() {
        return control;
    }
    public static void setControl(CONTROLADOR control) {
        CONTROLADOR.control = control;
    }
    public DTO_DATE getDTO_F() {
        return DTO_F;
    }
    public void setDTO_F(DTO_DATE DTO_F) {
        this.DTO_F = DTO_F;
    }
    
    
}