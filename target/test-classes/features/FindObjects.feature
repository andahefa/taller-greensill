  #encoding: iso-8859-1
  Feature: Busqueda de zapatos adidas

    Scenario Outline: Busqueda de zapatos adidas por precio ascendente
      Given Estoy en la pagina de amazon
      When Ingrese el articulo <article>
      And Seleccione la marca adidas
      And Seleccione el estado Nuevo
      And Ordene los precios de forma <orden>
      And Tome los 5 primeros artículos
      And Ordene los productos de forma descendente y los imprima
      When Los productos deben estar ordenados de forma descendente

      Examples:
        | article | orden      |
        | zapatos | ascendente |