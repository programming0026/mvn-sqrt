package com.juniverse.math;

/**
 * Raíz cuadrada con el método de Newton-Raphson (método babilónico).
 *
 * @author Java Universe
 */
public class NewtonSqrt implements SqrtStrategy {

    // Tolerancia relativa para la convergencia
    private static final double TOLERANCE = 1e-10;

    // Número máximo de iteraciones
    private static final int MAX_ITERATIONS = 100;

    /**
     * Calcula la raíz cuadrada usando el método de Newton
     *
     * @param n número del cual calcular la raíz cuadrada
     * @param precision precisión deseada (por defecto 1e-10)
     * @param maxIterations máximo número de iteraciones (por defecto 100)
     * @return raíz cuadrada aproximada de n
     */
    private static double sqrtNewton(double n, double precision, int maxIterations) {
        if (n < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo");
        }

        if (n == 0) {
            return 0;
        }

        // Aproximación inicial: 2^(exponente/2), del orden de magnitud correcto para cualquier n
        // (partir de n/2 necesita cientos de iteraciones con números enormes).
        double x = Math.scalb(1.0, Math.getExponent(n) / 2);

        for (int i = 0; i < maxIterations; i++) {
            // Aplicar la fórmula de Newton: x_{k+1} = (x_k + n/x_k) / 2
            double newX = (x + n / x) / 2.0;

            // Verificar si hemos alcanzado la precisión deseada
            if (Math.abs(newX - x) <= precision * newX) { // tolerancia relativa: sirve para números muy pequeños y muy grandes
                return newX;
            }

            x = newX;
        }

        return x;
    }

    /**
     * Raíz cuadrada con tolerancia 1e-10 y máximo 100 iteraciones.
     * @param n número no negativo
     * @return raíz cuadrada aproximada
     * @throws IllegalArgumentException si {@code n} es negativo
     */
    @Override
    public double sqrt(double n) {
        return sqrtNewton(n, TOLERANCE, MAX_ITERATIONS);
    }

}
