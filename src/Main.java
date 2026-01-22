import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Main {
    public static void main(String[] args){
        String respuestaSWAPI;
        ConversorMoneda jsonAObjeto;

        String direccion = "https://v6.exchangerate-api.com/v6/09a76998f04a261837f2087d/pair/EUR/GBP/100";
        ApiComunicador apiComunicador = new ApiComunicador();
        respuestaSWAPI= apiComunicador.comunicarConAPI(direccion);
        System.out.println(respuestaSWAPI);

        GsonManipulador gsonManipulador = new GsonManipulador();
        jsonAObjeto = gsonManipulador.deserializarGSON(respuestaSWAPI);
        System.out.println(jsonAObjeto);

    }
}
