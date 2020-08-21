# RETROFIT | LIB - COMMONUTILITIES

Utilidad relacionada a los servicios web. Forma parte del proyecto [CommonUtilities](https://github.com/vanskarner/CommunUtilidades/blob/master/README.md)

## Pre-Requisitos :gear:

* `build.gradle(Module:app)` | Agregar dependencias
```gradle
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    implementation 'com.squareup.okhttp3:okhttp:3.12.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.12.0'
```
* `AndroidManifest.xml` | Agregar permiso
```xml
<uses-permission android:name="android.permission.INTERNET" />    
```
## Compatibilidad :heavy_check_mark:

* Android 4.1
* Android 4.2
* Android 4.3
* Android 4.4
* Android 5.0
* Android 5.1
* Android 6.0
* Android 7.0
* Android 7.1
* Android 8.0
* Android 9.0
* Android 10.0
* Android 11.0

## Uso :clipboard:

Puede ver su implementación en RetrofitActivity. 
Adicionalmente se sugiere seguir la siguiente guía y estructura para organizar el contenido del servicio a implementar:

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/structure_retrofit.PNG)

La carpeta `callback` tendra nuestros servicios armados solo para llamar. En esta carpeta destaca la clase **ConfigCallback** y la interface **OnCallbackListener**, donde los únicos parámetros a configurar dependiendo de su necesidad son los que se encuentran dentro de ConfigCallback(dentro del cuadro rojo). 

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/configcallback_parameters.png)

Cada clase que se cree en la carpeta `callback`, debe extender de la clase **ConfigCallback**, donde el primer atributo representa la clase a usar en el servicio y el segundo es la interfaz relacionado a ese servicio

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/user_example_retrofit.png)

La carpeta `codes` esta orientada a filtrar los mensajes personalizados por el tipo de código http, esta se encuentra siendo usada en **ConfigCallback** para filtrar el mensaje correspondiente en cada solicitud que se realice. Aquí solo se modificará el método **getMessagesOfCodesHttp** dentro de la clase **Codes**.

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/codes_retrofit.png)

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/codes_method_retrofit.png)

La carpeta `model` esta orientada a los objetos que necesites para usar los diferentes servicios, por lo general solo tendra atributos, métodos getter y setter.

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/model_example_retrofit.png)

La carpeta `services` contendra las interfaces necesarias para usar retrofit, contiene los endpoint y los servicios a utilizar con sus respectivos parámetros

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/services_example_retrofit.png)

Finalmente la clase ServicesCallback representa la agrupación de todos las clases creadas en la carpeta callback, a excepción de **ConfigCallback** y **OnCallbackListener**.

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/services_all_retrofit.png)

## Consideraciones :warning:

No hay por el momento.

## Expresiones de Gratitud 🎁

* Gracias al sitio https://jsonplaceholder.typicode.com por su REST API para realizar las pruebas.
* Gracias a flaticon: https://www.flaticon.com , donde extraímos los iconos usados en la aplicación: 

## Última revisión :watch:
Lunes, 20 de agosto del 2020
