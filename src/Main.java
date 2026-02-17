import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String respuestaSWAPI;
        ConversorMoneda jsonAObjeto;
        double cantidad;
        String monedaActual;
        String monedaTarget;
        double resultadoConversion;

        //Recibir datos de usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la moneda base: ");
        monedaActual = scanner.nextLine();
        System.out.println("Ingresa la moneda objetivo: ");
        monedaTarget = scanner.nextLine();
        System.out.println("Ingresa la cantidad de dinero a convertir");
        cantidad = scanner.nextDouble();

        //Consumir API
        String direccion = "https://v6.exchangerate-api.com/v6/09a76998f04a261837f2087d/pair/"+monedaActual+"/"+monedaTarget+"/"+cantidad;
        ApiComunicador apiComunicador = new ApiComunicador();
        respuestaSWAPI= apiComunicador.comunicarConAPI(direccion);
        System.out.println(respuestaSWAPI);

        GsonManipulador gsonManipulador = new GsonManipulador();
        jsonAObjeto = gsonManipulador.deserializarGSON(respuestaSWAPI);
        System.out.println(jsonAObjeto);

        Calculadora calculadora = new Calculadora();
        resultadoConversion = calculadora.conversion(jsonAObjeto,cantidad);
        System.out.println(resultadoConversion);
    }
}
