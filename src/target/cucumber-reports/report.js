$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/CompraEquipo.feature");
formatter.feature({
  "line": 1,
  "name": "Comprar articulo en la plataforma de compras",
  "description": "",
  "id": "comprar-articulo-en-la-plataforma-de-compras",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Comprar articulos",
  "description": "",
  "id": "comprar-articulo-en-la-plataforma-de-compras;comprar-articulos",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "que Juan ingresa a la platorma de compras",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "busque un articulo para comprar \u003cArticulo\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "llene el formulario y termine la compra",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "la compra sera exitosa",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "comprar-articulo-en-la-plataforma-de-compras;comprar-articulos;",
  "rows": [
    {
      "cells": [
        "Articulo"
      ],
      "line": 9,
      "id": "comprar-articulo-en-la-plataforma-de-compras;comprar-articulos;;1"
    },
    {
      "cells": [
        "Dell i7 8gb"
      ],
      "line": 10,
      "id": "comprar-articulo-en-la-plataforma-de-compras;comprar-articulos;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 10,
  "name": "Comprar articulos",
  "description": "",
  "id": "comprar-articulo-en-la-plataforma-de-compras;comprar-articulos;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "que Juan ingresa a la platorma de compras",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "busque un articulo para comprar Dell i7 8gb",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "llene el formulario y termine la compra",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "la compra sera exitosa",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Juan",
      "offset": 4
    }
  ],
  "location": "StepCompra.queIngresaALaPlatormaDeCompras(String)"
});
formatter.result({
  "duration": 9320657700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dell i7 8gb",
      "offset": 32
    }
  ],
  "location": "StepCompra.busqueUnArticuloParaComprar(String)"
});
formatter.result({
  "duration": 5992395000,
  "status": "passed"
});
formatter.match({
  "location": "StepCompra.lleneElFormularioYTermineLaCompra()"
});
formatter.result({
  "duration": 1999379300,
  "status": "passed"
});
formatter.match({
  "location": "StepCompra.laCompraSeraExitosa()"
});
formatter.result({
  "duration": 87100,
  "status": "passed"
});
});