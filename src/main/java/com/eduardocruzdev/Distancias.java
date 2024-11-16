package com.eduardocruzdev;

public class Distancias {

    /**
     * Calcula la distancia euclidiana entre dos puntos.
     *
     * @param point1 Array que representa las coordenadas del primer punto.
     * @param point2 Array que representa las coordenadas del segundo punto.
     * @return Distancia euclidiana entre point1 y point2.
     */

    public static double eucledianDistance(double[] point1, double[] point2) {
        double sum = 0.0;
        for (int i = 0; i < point1.length; i++) {
            sum += Math.pow(point1[i] - point2[i], 2);
        }
        return Math.sqrt(sum);
    }

    /**
     * Calcula la distancia de Manhattan entre dos puntos.
     *
     * @param point1 Array que representa las coordenadas del primer punto.
     * @param point2 Array que representa las coordenadas del segundo punto.
     * @return Distancia de Manhattan entre point1 y point2.
     */

    public static double manhattanDistance(double[] point1, double[] point2) {
        double sum = 0.0;
        for (int i = 0; i < point1.length; i++) {
            sum += Math.abs(point1[i] - point2[i]);
        }
        return sum;
    }

    /**
     * Calcula la distancia de Haversine entre dos puntos geográficos.
     * (Usado para coordenadas geográficas como latitud y longitud).
     *
     * @param point1 Array que contiene [latitud, longitud] del primer punto en grados.
     * @param point2 Array que contiene [latitud, longitud] del segundo punto en grados.
     * @return Distancia en kilómetros entre los dos puntos.
     */

    public static double haversineDistance(double[] point1, double[] point2) {
        final int EARTH_RADIUS = 6371; // Radio de la Tierra en kilómetros
        double lat1 = Math.toRadians(point1[0]);
        double lon1 = Math.toRadians(point1[1]);
        double lat2 = Math.toRadians(point2[0]);
        double lon2 = Math.toRadians(point2[1]);

        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        double a = Math.pow(Math.sin(deltaLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.pow(Math.sin(deltaLon / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }

    /**
     * Contructor Vacio
     */
    public Distancias() {

    }
}
