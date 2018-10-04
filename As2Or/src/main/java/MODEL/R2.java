package MODEL;

/**
 * 
 */
public class R2 extends QUERY_DATE {

    /**
     * Default constructor
     */
    public R2() {}

    /**
     * @Description
     * Método encargado de determinar si una fecha es válida
     * Una fecha es válida si pertenece a un rango permitido
     *  1) Fecha >= 15/10/1582
     *  2) Si el año es bisiesto febrero puede tener 29 dias
     *  3) Según el mes tiene desde 1 hasta 30, 31, 28 dias
     *  4) Meses entre [1,12]
     * @return boolean
     */
    public boolean fecha_es_valida() {
        // TODO implement here
        int anio = date.getYear();
        int mes = date.getMonth();
        int dia = date.getDay();
        if(anio > 1582){
            if(mesValido(mes)){
                return diaValido(dia, mes);
            }
        }else if(anio == 1582){
            if(mesValido(mes) && mes >= 10){
                if(diaValido(dia, mes)){
                    if(mes == 10){
                        return dia >= 15;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int ultimoDiaDelMes(int mes){
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ultimoDia;
        ultimoDia = diasPorMes[(mes-1)];
        if((boolean)METHODS_DATE.getmDate().getBisiesto().exec() && mes == 2)
            ultimoDia++;
        return ultimoDia;
    }
    
    public boolean diaValido(int dia, int mes){
        return dia >= 1 && dia <= ultimoDiaDelMes(mes);
    }
    
    public boolean mesValido(int mes){
        return mes >= 1 && mes <= 12;
    }
    
    @Override
    public Object exec() {
        return fecha_es_valida();
    }

}