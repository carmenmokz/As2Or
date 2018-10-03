package VIEW;
import java.util.Scanner; 
import CONTROLLER.CONTROLADOR;

/**
 * 
 */
public class APL_MAIN {

    private static final DTO_DATE dFecha = new DTO_DATE();
    private static final Scanner scan = new Scanner(System.in);
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int year, mes, dia;
        int opc;
        
        boolean onlyYear;
        
        printSaludo();
        
        while(true){
            onlyYear = false;
            showMenu();
            opc = getInt(">> ");
            dFecha.setQuery(opc);

            if(opc == 1 || opc == 5 || opc == 6)
                    onlyYear = true;
            else if(opc == 7){      
                    showHelp();
                    continue;
            }        
            else if(opc == 8)
                    return;          
            else if(opc < 1 || opc > 8){
                System.out.println("Opcion inválida");
                continue;
            }

            year = getInt("Año: ");
            dFecha.setYear(year);
            
            if(!onlyYear){
                mes = getInt("Mes: ");
                dFecha.setMonth(mes);
                dia = getInt("Día: ");
                dFecha.setDay(dia);
            }

            // Creamos el objeto DATE en el controller utilizando el DTO
            CONTROLADOR.getControl().createDate(dFecha);

            // Ejecutamos la funcionalidad segun la opcion elegida por el usuario
            // dicha opcion se encuentra en el DTO.
            Object obj = CONTROLADOR.getControl().execQuery();
            System.out.println("\n"+obj.toString());
        }
    }

    private static void showMenu() {
        String menu = "";
        menu += "\n    \t\tMenú\n";
        menu += "1) Determinar si un año es bisiesto. \n";
        menu += "2) Determinar si una fecha es válida\n";
        menu += "3) Determinar el dia siguiente a una fecha\n";
        menu += "4) Obtener total de dias desde el primero de enero de un año\n";
        menu += "5) Obtener el día que corresponde al primero de enero de un año\n";
        menu += "6) Imprimir el calendario de un año\n";
        menu += "7) Ayuda\n";
        menu += "8) Salir\n";
        menu += "Seleccione una opción: \n";
        System.out.println(menu);
    }
    
    private static void showHelp(){
        String helpStr = "\n------AYUDA------\n";
        helpStr += "Formato válido para fechas: \nAño: yyyy \nMes: MM \nDía: dd\n";
        helpStr += "Ejemplos:\n";
        helpStr += "1)>> 2016 \n  >> True\n";
        helpStr += "2)>> \n  Año: 2018\n  Mes: 12\n  Día: 31\n  >> True\n";
        helpStr += "3)>> \n  Año: 2018\n  Mes: 12\n  Día: 31\n  >> 2019/01/01\n";
        helpStr += "4)>> \n  Año: 2018\n  Mes: 2\n  Día: 1\n  >> 31\n";
        helpStr += "5)>> Codificación: "
                + "0 = domingo, 1 = lunes, 2 = martes, 3 = miércoles, 4 = jueves, 5 = viernes, 6 = sábado\n"
                + "  Año: 2018\n  >> 1\n";
        helpStr += "6)>> 2018 \n  >> [Calendario 2018]\n";
        System.out.println(helpStr);
    }

    private static int getInt(String data) {
        String numberStr;
        int number;
        while(true){
            System.out.print(data);
            numberStr = scan.next();
            try{
                number = Integer.parseInt(numberStr);
                if(number <= 0)
                    throw new NumberFormatException(); //To change body of generated methods, choose Tools | Templates.
                return number;
            }catch (NumberFormatException ex){
                System.out.println("ERROR! Ingrese únicamente valores enteros positivos");
            }
        }
    }

    private static void printSaludo() {
        
        System.out.print("  ____ _____ ______ _   ___      ________ _   _ _____ _____   ____  \n" +
" |  _ |_   _|  ____| \\ | \\ \\    / |  ____| \\ | |_   _|  __ \\ / __ \\ \n" +
" | |_) || | | |__  |  \\| |\\ \\  / /| |__  |  \\| | | | | |  | | |  | |\n" +
" |  _ < | | |  __| | . ` | \\ \\/ / |  __| | . ` | | | | |  | | |  | |\n" +
" | |_) _| |_| |____| |\\  |  \\  /  | |____| |\\  |_| |_| |__| | |__| |\n" +
" |____|_____|______|_| \\_|   \\/   |______|_| \\_|_____|_____/ \\____/ \n" +
"                                                                    \n" +
"                                                                    ");
    
    }
}