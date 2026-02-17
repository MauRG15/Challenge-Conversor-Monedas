
public class Calculadora {
    private double tasaConversion;
    private String monedaBase;
    private String monedaTarget;
    private double resultado;
    public double conversion(ConversorMoneda jsonObjt, double cantidad){
        tasaConversion = jsonObjt.conversion_rate();
        resultado = tasaConversion*cantidad;
        resultado = Math.round(resultado * 1000.0) / 1000.0; // Redondeado a 2 decimales
        return resultado;
    }
}
