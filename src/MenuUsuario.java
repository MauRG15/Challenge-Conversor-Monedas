import java.util.List;

public class MenuUsuario {
    public void mostrarCurrencies(String apiKey){
        String respuestaAPI;
        Currencies jsonAObjeto;

        //Consumir API
        String direccion = "https://v6.exchangerate-api.com/v6/"+apiKey+"/codes";
        ApiComunicador apiComunicador = new ApiComunicador();
        respuestaAPI= apiComunicador.comunicarConAPI(direccion);
        //System.out.println(respuestaAPI);//Estado de respuesta de API

        //Convertir Json a Objeto
        GsonManipulador gsonManipulador = new GsonManipulador();
        jsonAObjeto = gsonManipulador.deserializarGSON_Currencies(respuestaAPI);

        System.out.println("MONEDAS DISPONIBLES PARA CONVERSION.\n");
        for (List<String> c : jsonAObjeto.supported_codes()) {
            String code = c.get(0);
            String name = c.get(1);
            System.out.println(code + " → " + name);
        }
    }
    public void mostrarMenu(){
        System.out.println("************************************************\n" +
                "BIENVENIDO A LA APP DE CONVERSION DE MONEDAS\n\n" +
                "Elija una de las siguientes opciones:\n" +
                "1. Mostrar monedas disponibles.\n" +
                "2. Realizar una conversión.\n\n" +
                "9. Salir\n\n" +
                "************************************************\n" +
                "Opción a elegir: ");
    }
}
