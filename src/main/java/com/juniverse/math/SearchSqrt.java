package com.juniverse.math;

/**
 * Raíz cuadrada que parte de la raíz entera (búsqueda binaria) y se refina con Newton-Raphson.
 *
 * @author Java Universe
 */
public class SearchSqrt implements SqrtStrategy{

    /**
     * Método para números enteros que retorna resultado exacto cuando es
     * posible
     *
     * @param x
     * @return
     */
    private static int sqrtIntegerFloor(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo");
        }

        if (x <= 1) {
            return x;
        }

        // Usar búsqueda binaria para enteros
        int left = 1;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    /**
     * Método optimizado para números enteros que retorna el resultado decimal
     * correcto Usa una aproximación inicial inteligente seguida de
     * Newton-Raphson
     *
     * @param x
     * @return
     */
    @Override
    public double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo");
        }
        if (x == 0) {
            return 0;
        }

        // Aproximación inicial: la parte entera de la raíz si x cabe en un int;
        // fuera de ese rango (x < 1 o x demasiado grande) el cast a int no sirve.
        double guess;
        if (x >= 1 && x <= Integer.MAX_VALUE) {
            guess = sqrtIntegerFloor((int) x);
            // Si es un cuadrado perfecto, devolver el resultado exacto
            if (guess * guess == x) {
                return guess;
            }
        } else {
            guess = Math.scalb(1.0, Math.getExponent(x) / 2);
        }

        // Refinar con Newton-Raphson hasta converger
        for (int i = 0; i < 200; i++) {
            double next = (guess + x / guess) / 2.0;
            if (Math.abs(next - guess) <= 1e-15 * next) {
                return next;
            }
            guess = next;
        }
        return guess;
    }
}
