# 🪙 Conversor de Monedas - Challenge Oracle ONE

¡Bienvenido! Este proyecto es una aplicación de consola en Java que permite realizar conversiones de divisas en tiempo real. Fue desarrollado como parte del programa **Oracle NEXT Education** en colaboración con Alura.

---

## 🚀 Características

* **Tipos de Cambio en Vivo:** Utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener datos actualizados.
* **Interfaz Interactiva:** Menú de usuario sencillo para navegar por las opciones.
* **Gestión de Errores:**
    * Si ingresas un código de moneda inexistente, el programa te notificará para que lo verifiques.
    * Valida que la cantidad de dinero sea un número (entero o decimal); de lo contrario, solicita el dato nuevamente.
* **Consulta de Códigos:** Opción dedicada para listar las monedas disponibles.

---

## 🛠️ Tecnologías y Herramientas

* **Lenguaje:** Java 17
* **Librería externa:** [Gson](https://github.com/google/gson) (para la deserialización de objetos JSON).
* **Consumo de API:** `HttpClient` para peticiones asíncronas.

---

## 📋 Requisitos de Configuración

Para ejecutar este programa, necesitarás tu propia **API Key** para conectarte al servicio de tasas de cambio.

1. Regístrate de forma gratuita en [ExchangeRate-API](https://www.exchangerate-api.com/).
2. Una vez tengas tu llave (Key), abre el archivo `Main.java`.
3. Busca la siguiente línea y reemplaza el valor de la variable:

```java
// Sustituye el texto entre comillas por tu llave personal
String apiKey = "TU_API_KEY_AQUÍ";
```
## 🕹️ Guía de Uso y Funcionamiento

El programa funciona como una máquina de estados simple dentro de un ciclo `while`. A continuación, te explico cómo usarlo y qué sucede detrás de escena:

### Cómo usar el programa:
1. **Ejecución:** Al iniciar, verás un mensaje de bienvenida y el menú principal.
2. **Consultar Monedas (Opción 1):** Si no conoces el código de una moneda (ej. Peso Argentino = `ARS`), elige esta opción para ver la lista de códigos soportados.
3. **Convertir (Opción 2):**
   - El sistema te pedirá el **código de la moneda base** (la que ya tienes).
   - Luego, el **código de la moneda objetivo** (a la que quieres cambiar).
   - Finalmente, ingresa la **cantidad**. El programa acepta decimales (usa el formato de tu localidad, usualmente punto `.` o coma `,`).
4. **Salir (Opción 9):** Finaliza la ejecución de forma segura.

---

### ⚙️ ¿Cómo funciona internamente?

El proyecto sigue un flujo de procesamiento de datos lineal para garantizar que la información sea precisa:

1. **Captura de Datos:** Se utiliza la clase `Scanner` para recibir las entradas del usuario. En este punto, el código valida que la cantidad sea un número válido antes de continuar.
2. **Consulta Externa:** La clase `ApiComunicador` construye una URL dinámica usando tu `apiKey` y los códigos de moneda ingresados. Se realiza una petición HTTP para obtener los tipos de cambio actuales.
3. **Procesamiento de Datos (JSON):** - La respuesta de la API llega en formato JSON.
   - La clase `GsonManipulador` utiliza la librería **GSON** para convertir ese texto en un objeto Java (POJO/Record).
4. **Lógica de Negocio:** La clase `Calculadora` toma el valor de conversión (`conversion_rate`) del objeto creado y lo multiplica por la cantidad que ingresaste.
5. **Salida Formateada:** El programa utiliza `System.out.printf` para mostrarte un resultado limpio y con formato de moneda (dos decimales).
