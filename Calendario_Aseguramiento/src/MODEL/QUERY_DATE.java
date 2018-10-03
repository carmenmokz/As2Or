package MODEL;

/**
 * 
 */
public abstract class QUERY_DATE {

    protected static DATE date; 
    
    /**
     * Default constructor
     */
    public QUERY_DATE() {}

    /**
     * 
     */
   

    /**
     * @return
     */
    public abstract Object exec();
    
    public static void setDate(DATE _date){
        date = _date;
    }

}