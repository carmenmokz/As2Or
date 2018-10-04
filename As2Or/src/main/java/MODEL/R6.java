package MODEL;

/**
 * 
 */
public class R6 extends QUERY_DATE{

    // Atributos de la clase
    private final String meses[] = {"Enero", "Febrero", "Marzo",     "Abril",   "Mayo",      "Junio", 
                                    "Julio", "Agosto",  "Setiembre", "Octubre", "Noviembre", "Diciembre"};
    private final int dias [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
    private int dia;
    private String strCalendar; // String que contiene el resultado del Calendario obtenido
    
    /**
     * Default constructor
     */
    public R6() {
    }

    /**
     * Decription
     * @param year
     * @return 
     */
    public Object imprimir_4x3(int year) {
        date.setMonth(1);
        date.setDay(1);
        if(!(boolean)METHODS_DATE.getmDate().getCheckDate().exec())
            return "Error: Fecha inválida"; 
        
        // Variables locales
        String diasEncabezado = "  D    L    K    M    J    V    S  |";
        diasEncabezado = diasEncabezado + diasEncabezado + diasEncabezado;
        int calendario[][];
        int mes = 0;
        int col = 0;
        String mesEncabezado;
        
        // Métodos de preparación
        setDay(); // Obtiene el dia que cayó primero de enero ese año
        if((boolean)METHODS_DATE.getmDate().getBisiesto().exec()) dias[1]++; // Si es bisiesto => +1 a febrero

        strCalendar = centerString(108, "CALENDARIO DEL AÑO " + year + " D.C.")+"\n\n";
        
        //Llenamos un calendario de 3 meses 4 veces para imprimir el 4x3 del año
        for(int x = 0; x < 4; x++, col = 0){
            mesEncabezado = ""; // Encabezado con los meses que corresponden para cada iteracion
            calendario = new int[7][21];    
            for(int y = 0; y < 3; y++, col += 7, mes++){
                mesEncabezado += centerString(36, meses[mes]);
                calendario = fillMes(dias[mes], calendario, col);   // Llenamos la matriz con los dias del mes que corresponda
            }
            strCalendar += mesEncabezado + "\n";    // Agregamos el encabezado de los meses
            strCalendar += diasEncabezado + "\n";   // Agregamos el encabezado de dias
            printCalendar1x3(calendario);           // Imprimimos los 3 meses que correspondan
        }
        return strCalendar;
    }
    
    
    /*
        Método encargado de llenar los dias de un mes basandose en el dia que inicia el mes 
        y la cantidad de dias que este posee
    */
    public int[][] fillMes(int mes, int[][] calendario, int col){
        dia += col;
        for(int x = 0, diaCont = 1;;x++){
            for(; dia < col+7; dia++, diaCont++){
                calendario[x][dia] = diaCont;
                if(diaCont == mes){
                    dia++;
                    dia %= 7;
                    return calendario;
                }
            }
            dia = col;
        }
    }
    
    /*
        Método que imprime un calendario de 3 meses
    */
    private void printCalendar1x3(int[][] calendario) {
        for(int x2 = 0; x2 < 6; x2++){
                for(int y = 0; y < 21; y++){
                    if(y%7 == 0 && y > 0){
                        strCalendar += "|";
                    }
                    if(calendario[x2][y] > 0){
                        strCalendar += makeNumberStr(calendario[x2][y]);
                    }
                    else{
                        strCalendar += "     ";
                    }
                }
                strCalendar += "|\n";
            }
    }
    
    /*
        Método encargado de centrar un número en us String de tamaño 5
    */
    private String makeNumberStr(int x){
        String str2 = " ";
        if((int)Math.log10(x) == 0) // Log10(x) + 1 => Devuelve la cantidad de digitos de un número 
            str2 += " ";
        return str2 + x + "  ";
    }
    
    /*
        Método que centra un String recibido en un String de tamaño n
        width = n
    */
    public static String centerString (int width, String s) {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }
    
    /*
        Método que obtiene el número día que cae el primer día del año
    */
    private void setDay() {
        dia = (int)METHODS_DATE.getmDate().getDayFirstJan().exec();
    }
    
    
    // Auxiliares
    @Override
    public Object exec() {
        return imprimir_4x3(date.getYear());
    }

}