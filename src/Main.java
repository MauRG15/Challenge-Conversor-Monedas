import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        boolean ciclo = true;
        String respuestaAPI;
        ConversorMoneda jsonAObjeto;
        double cantidad=0;
        String monedaActual;
        String monedaTarget;
        double resultadoConversion;
        String eleccionUsuario;
        String apiKey = "09a76998f04a261837f2087d";
        Scanner scanner = new Scanner(System.in);

        //Mostrar Monedas
        MenuUsuario menu = new MenuUsuario();
        menu.mostrarCurrencies();

        while (ciclo) {
            menu.mostrarMenu();
            eleccionUsuario = scanner.nextLine();
            switch (eleccionUsuario) {
                case "1":
                    menu.mostrarCurrencies();
                    break;
                case "2":
                    //Recibir datos de usuario
                    System.out.println("Ingresa el código de la moneda base (p.ej. EUR, MXN, etc): ");
                    monedaActual = scanner.nextLine();
                    System.out.println("Ingresa el código de la moneda objetivo: (p.ej. EUR, MXN, etc)");
                    monedaTarget = scanner.nextLine();
                    System.out.println("Ingresa la cantidad de dinero a convertir: ");
                    if (scanner.hasNextDouble()){
                        cantidad = scanner.nextDouble();

                    }
                    else{
                        System.out.println("Cantidad no valida, ingresa un numero decimal o entero.");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    //Consumir API
                    String direccion = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/" + monedaActual + "/" + monedaTarget;
                    ApiComunicador apiComunicador = new ApiComunicador();
                    respuestaAPI = apiComunicador.comunicarConAPI(direccion);
                    //System.out.println(respuestaAPI);//Verificar conexion con API

                    //Convertir Json a Objeto
                    GsonManipulador gsonManipulador = new GsonManipulador();
                    jsonAObjeto = gsonManipulador.deserializarGSON(respuestaAPI);
                    if (jsonAObjeto.result().equals("success")) {
                        //System.out.println(jsonAObjeto);//Estado del objeto JSON
                        Calculadora calculadora = new Calculadora();
                        resultadoConversion = calculadora.conversion(jsonAObjeto, cantidad);
                        System.out.printf("$%,.3f%n",resultadoConversion);
                    }
                    else{
                        System.out.println("No se pudo encontrar el codigo de alguna de las monedas, por favor verifica que las escribiste correctamente e intentalo de nuevo.");
                    }
                    break;
                case "9":
                    System.out.println("Nos vemos, gracias por usar mi conversor :)");
                    ciclo = false;
                    break;
                default:
                    System.out.println("Elije una opción valida del menú, por favor.");
                    break;
            }
        }
    }
}
