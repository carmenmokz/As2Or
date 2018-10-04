package MODEL;

/*
* Clase contenedor que posee una instancia únia de las funcionalidades sobre la clase DATE.
* Su función principal es ser un punto en común para acceder a las funcioalidades y evitar la creación de instancias innecesarias.
*/
public class METHODS_DATE {
    
    private static  METHODS_DATE mDate = new METHODS_DATE();
    
    /*Instancias de las funciones*/
    private R1 bisiesto = new R1();
    private R2 checkDate = new R2();
    private R3 nextDay = new R3();
    private R4 daysFrom1Jan = new R4();
    private R5 dayFirstJan = new R5();
    private R6 printCalendar = new R6();
    /*Fin declaracion de instancias*/
    
    private METHODS_DATE (){}
    
    public static METHODS_DATE getmDate() {
        return mDate;
    }

    public static void setmDate(METHODS_DATE mDate) {
        METHODS_DATE.mDate = mDate;
    }

    public R1 getBisiesto() {
        return bisiesto;
    }

    public void setBisiesto(R1 bisiesto) {
        this.bisiesto = bisiesto;
    }

    public R2 getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(R2 checkDate) {
        this.checkDate = checkDate;
    }

    public R3 getNextDay() {
        return nextDay;
    }

    public void setNextDay(R3 nextDay) {
        this.nextDay = nextDay;
    }

    public R4 getDaysFrom1Jan() {
        return daysFrom1Jan;
    }

    public void setDaysFrom1Jan(R4 daysFrom1Jan) {
        this.daysFrom1Jan = daysFrom1Jan;
    }

    public R5 getDayFirstJan() {
        return dayFirstJan;
    }

    public void setDayFirstJan(R5 dayFirstJan) {
        this.dayFirstJan = dayFirstJan;
    }

    public R6 getPrintCalendar() {
        return printCalendar;
    }

    public void setPrintCalendar(R6 printCalendar) {
        this.printCalendar = printCalendar;
    }
    
    
    
}
