# Raíz cuadrada: comparación de algoritmos

Implementa seis formas de calcular la raíz cuadrada, las compara en precisión y velocidad y explica con detalle los trucos de bits de la famosa constante de Quake III.

## Características

- `Math.sqrt()`, Newton-Raphson, aproximación por bits (IEEE 754), Quake III, búsqueda binaria + Newton y raíz n-ésima.
- Patrón Strategy: todos implementan `SqrtStrategy`.
- Benchmark de un millón de operaciones.
- Explicaciones didácticas paso a paso por consola.

## Requisitos

- JDK 21 y Maven 3.9 o superior.

## Compilar y ejecutar

```bash
mvn compile exec:java
```

## Notas

- Con fines educativos: en Java moderno `Math.sqrt()` es más rápido y más preciso que cualquier alternativa.

## JAR ejecutable (fat jar)

```bash
mvn clean package
java -jar target/mvn-sqrt-1.0-SNAPSHOT-launcher.jar
```

El archivo `-launcher.jar` incluye todas las dependencias.

## Licencia

Código de ejemplo de uso libre con fines educativos.
