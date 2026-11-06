package com.juniverse.math;

/**
 * Estrategia para calcular la raíz cuadrada de un número.
 *
 * @author Java Universe
 */
public interface SqrtStrategy {

    /**
     * Calcula la raíz cuadrada.
     * @param x número no negativo
     * @return raíz cuadrada
     */
    double sqrt(double x);
}
