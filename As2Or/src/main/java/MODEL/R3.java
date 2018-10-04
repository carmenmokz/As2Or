package MODEL;
/**
 * 
 */
public class R3 extends QUERY_DATE {

    /**
     * Default constructor
     */
    public R3() {}

    /**
     * Description
     * Método encargado de obtener el siguiente día válido de una fecha recibida
     * @return
     */
    public Object dia_siguiente() {
        // TODO implement here
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        
        if((boolean)METHODS_DATE.getmDate().getCheckDate().exec()){
            if(day == 31 && month == 12){
                day = 1;
                month = 1;
                year += 1;
            }else if(month==2){
                if((boolean)METHODS_DATE.getmDate().getBisiesto().exec() && day == 28){
                    day = 29;
                }else if(day==29 || day==28){
                    day = 1;
                    month = 3;
                }else{
                    day++;
                }
            }else if((day == 31) || (day == 30 && (month==4 || month==6 || month==9 || month==11))){
                day = 1;
                month++;
            }else{
                day++;
            }
        }else{
            return "Error: Fecha inválida";
        }
        DATE newDate = new DATE(day, month, year); 
        //String result = String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day);
        return newDate;
    }

    @Override
    public Object exec() {
        return dia_siguiente(); //To change body of generated methods, choose Tools | Templates.
    }

}