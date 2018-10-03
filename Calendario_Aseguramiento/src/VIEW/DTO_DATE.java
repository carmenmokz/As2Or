package VIEW;

/**
 * Data Transfer Object utilizado para comunicar la interfaz con el controlador 
 */

public class DTO_DATE {

    /**
     * Default constructor
     */
    public DTO_DATE() {
    }

    /**
     * 
     */
    private int day;

    /**
     * 
     */
    private int year;

    /**
     * 
     */
    private int month;

    /**
     * 
     */
    private int query;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getQuery() {
        return query;
    }

    public void setQuery(int query) {
        this.query = query;
    }



}