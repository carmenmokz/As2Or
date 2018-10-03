package MODEL;

/**
 * 
 */
public class DATE {

    private int day;
    private int month;
    private int year;
    private QUERY_DATE queryDate;
    
    /**
     * Default constructor
     * @param _day
     * @param _month
     * @param _year
     */
    public DATE(int _day, int _month,  int _year) {
        day = _day;
        month = _month;
        year = _year;
    }
    
    /**
     * @param _queryDate
     */
    public void setQueryDate(QUERY_DATE _queryDate) {
        queryDate = _queryDate;
    }

     /**
     * @return
     */
    public int[] getDate() {
        int date[] = {day, month, year};
        return date;
    }

    /*GETTERS AND SETTERS*/    
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public QUERY_DATE getQueryDate(){
        return queryDate;
    }

    @Override
    public String toString() {
        return "DATE( " + year + "/" + month + "/" + day +" )";
    }

    
    
}