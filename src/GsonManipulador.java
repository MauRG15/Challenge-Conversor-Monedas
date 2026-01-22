import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonManipulador {
    //Pasar de Json a OBJETO
    public ConversorMoneda deserializarGSON(String json){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Definir el tipo de objeto a convertir
        ConversorMoneda moneda = gson.fromJson(json, ConversorMoneda.class);
        return moneda;
    }
}
