# CommonUtilities

Compendio de diversas utilidades que se usan comúnmente en el desarrollo de proyectos, esta desarrollado bajo interfaces para ser usado en patrones de diseño como fábrica abstracta y además incluye ejemplos de uso.

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/pp4.jpg)

## Estructura :hammer_and_wrench:

El paquete utilidades esta clasificado en **3 grupos**:

1. pl  | Solo uso de código java ó kotlin
2. so  | Código que involucra clases ó paquetes android.
3. lib | Código que involucra librerías de terceros o propias.

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/pp1.png)

Y cada grupo tienen sus tipos de utilidades orientados a una función.Por ejemplo en el grupo `so` podemos algunos tipos como:

![alt text](https://github.com/vanskarner/CommunUtilidades/blob/master/info/pp2.png)

## Uso :clipboard:

Para usar basta con cumplir con los **Pre-Requisitos** declarados en cada tipo de utilidad que se pretende usar y luego copiar el paquete que necesite a su proyecto.
Cada tipo de utilidad tiene su implementación en una actividad, donde se muestra como usarlo.

1. Ir a [pl](https://github.com/vanskarner/CommunUtilidades/blob/master/info/README_PL.md)
2. Ir a [so](https://github.com/vanskarner/CommunUtilidades/blob/master/info/README_SO.md)
3. Ir a [lib](https://github.com/vanskarner/CommunUtilidades/blob/master/info/README_LIB.md)

## Consideraciones :warning:
* Si utilizas varias dependencias en tu proyecto, puedes tener errores relacionados al multiDex. Para solucionarlo agrega el siguiente código a tu `build.grade(Module)` de tu proyecto:

```gradle
android {		
    defaultConfig {        
        multiDexEnabled true        
    }		
}

dependencies {  
  implementation 'androidx.multidex:multidex:2.0.1'  
}
```
---
:keyboard: con :heart: por [Vanskarner](https://github.com/vanskarner)  :grin:
