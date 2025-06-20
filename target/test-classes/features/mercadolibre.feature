@Busqueda
Feature: Búsqueda de productos en MercadoLibre

  Scenario: Buscar PlayStation 5 y mostrar primeros 5 resultados
    Given el usuario ingresa al sitio de MercadoLibre
    And selecciona el país México
    When busca el producto "PlayStation 5"
    And filtra por condición "Nuevo"
    And filtra por ubicación "CDMX"
    And ordena por "mayor a menor precio"
    Then imprime en pantalla los nombres y precios de los primeros 5 productos