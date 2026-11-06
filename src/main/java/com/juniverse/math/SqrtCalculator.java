package com.juniverse.math;

/**
 * Fachada que elige el algoritmo de raíz cuadrada.
 *
 * @author Java Universe
 */
public final class SqrtCalculator {

    private static final java.util.Map<Algorithms, SqrtStrategy> strategies
            = new java.util.HashMap<>();

    /** Algoritmos disponibles. */
    public enum Algorithms {
        MATH, NEWTON, QUAKE, OPTIMIZED, SEARCH, ROOT
    }

    /** Clase de utilidades: no se instancia. */
    private SqrtCalculator() {

    }

    static {

        SqrtCalculator.strategies.put(Algorithms.MATH, new MathSqrt());
        SqrtCalculator.strategies.put(Algorithms.NEWTON, new NewtonSqrt());
        SqrtCalculator.strategies.put(Algorithms.QUAKE, new QuakeSqrt());
        SqrtCalculator.strategies.put(Algorithms.OPTIMIZED, new OptimizedSqrt());
        SqrtCalculator.strategies.put(Algorithms.SEARCH, new SearchSqrt());
        SqrtCalculator.strategies.put(Algorithms.ROOT, new RootCalculator());
    }

    /**
     * Calcula la raíz cuadrada con el algoritmo elegido.
     * @param algorithm algoritmo a usar
     * @param x número no negativo
     * @return raíz cuadrada
     */
    public static double sqrt(Algorithms algorithm, double x) {
        return SqrtCalculator.strategies.get(algorithm).sqrt(x);
    }
}
