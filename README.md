# Proyecto para colección de Mitos y Leyendas

Este proyecto contiene la API que permite gestionar colecciones de cartas del juego Mitos y Leyendas. Dentro del servicio, las cartas y ediciones deben ser agregadas, eliminadas, editadas por el adminitrador de servicio. El usuario solo se encarga de crear su grupo de colecciones, crear las colecciones que el desee e ir seleccionando cartas que el crea correspondiente para agregar a su colección escogida. 

## Contenido de la carta

Una carta de Mitos y Leyendas contiene:
*  Coste: Cantidad de oros que cuesta jugar esa carta.
*  Fuerza: Solo las cartas tipo *Aliado* tienen fuerza.
*  Nombre: Nombre de la carta en el borde izquierdo.
*  Habilidad: Cuadro de texto de la parte inferior.
*  Historia: Extracto de texto que contiene un leyenda de la carta.
*  Ilustador: Persona que ilustro la carta.
*  Codigo: Numero de carta que corresponde dentro de la edicion.
*  Edicion: A la edicion que pertenece la carta.
*  Tipo: El tipo se distingue entre Talisman, Aliado, Totem, Arma u Oro.
*  Frecuencia: Se puede dividir en Real, Cortesani, Vasallo o sin Frecuencia.

<p align="center">
  <img align="center" src="https://i.imgur.com/bBmuWo2.jpg" width="330" title="Carta Mitos y Leyendas">
</p>

## Comó clonar el repositorio

Para clonar el repositorio usar:
```
$ git clone https://github.com/soRodriguezz/proyecto-escalab.git
```

Posteriormente importar a Eclipse, Spring Tools Suite, etc.

## Documentación proyecto

Dentro del directorio **documentacion** se encuentra:
* Coleccion de Postman.
* Consultas de la base de datos.
* Modelo de la base de datos.
* Screen de pruebas unitarias.

## Modelo de la base de datos

![Modelo proyecto escalab](https://i.imgur.com/fwAtMm3.png)

## Enlaces importantes

* http://localhost:8080/swagger-ui.html
* http://localhost:8080/oauth/token
* http://localhost:8080/usuarios/**
* http://localhost:8080/colecciones/**
* http://localhost:8080/grupo-coleccion/**
* http://localhost:8080/ediciones/**
