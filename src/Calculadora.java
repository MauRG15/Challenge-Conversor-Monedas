
public class Calculadora {
    private double tasaConversion;
    private String monedaBase;
    private String monedaTarget;
    private double resultado;
    public double conversion(ConversorMoneda jsonObjt, double cantidad){
        tasaConversion = jsonObjt.conversion_rate();
        resultado = tasaConversion*cantidad;
        return resultado;
    }
}
