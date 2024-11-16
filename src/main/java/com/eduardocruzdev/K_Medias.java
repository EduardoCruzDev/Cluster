package com.eduardocruzdev;

import java.io.IOException;
import java.util.*;

public class K_Medias extends LeerDatos {

	/**
	 * Ruta por defecto C:\Cluster\src\main\resources\hola.txt
	 * Formato: No necesita encabezados
	 *-12.112532,-77.0465684,Kion-Chinese
	 * -12.0667769,-77.0575594,Tentaciones-Express
	 */

	public static void main(String[] args) throws IOException {
		LeerDatos r1 = new LeerDatos();
		r1.features.clear();
		Scanner sc = new Scanner(System.in);
		System.out.println(
		"""
		Alerta: La estructura del archivo a cargar debe ser la siguiente : Latitud,Longitud,Nombre-con-guiones
		Ingresa la ruta del Archivo:
		""");

		String file = sc.next();
		r1.read(file); // Cargar datos

		int ex = 1;
		do {
			System.out.println("Ingrea el numero de clusters");
			int k = sc.nextInt();
			System.out.println("Ingresa la cantidad maxima de iteraciones");
			int max_iterations = sc.nextInt();
			System.out.println("Ingresa la distancia Metrica 1 or 2: \n1. Euclidean\n2. Manhattan");
			int distance = sc.nextInt();

			Map<Integer, double[]> centroids = new HashMap<>();
			double[] x1;
			int r = 0;
			for (int i = 0; i < k; i++) {
				x1 = r1.features.get(r++);
				centroids.put(i, x1);
			}

			Map<double[], Integer> clusters = kmeans(r1.features, distance, centroids, k);

			for (int i = 0; i < max_iterations; i++) {
				for (int j = 0; j < k; j++) {
					List<double[]> list = new ArrayList<>();
					for (double[] key : clusters.keySet()) {
						if (clusters.get(key) == j) {
							list.add(key);
						}
					}
					double[] db = centroidCalculator(list, numberOfFeatures);
					centroids.put(j, db);
				}
				clusters.clear();
				clusters = kmeans(r1.features, distance, centroids, k);
			}

			System.out.println("\nCalculo Final de Clusters");
			System.out.println("Latitud\tLongitud\tCluster");
			for (double[] key : clusters.keySet()) {
				for (int i = 0; i < key.length; i++) {
					System.out.print(key[i] + "\t");
				}
				System.out.print(clusters.get(key) + "\n");
			}

			double wcss = 0;

			for (int i = 0; i < k; i++) {
				double sse = 0;
				for (double[] key : clusters.keySet()) {
					if (clusters.get(key) == i) {
						sse += Math.pow(Distancias.eucledianDistance(key, centroids.get(i)), 2);
					}
				}
				wcss += sse;
			}

			System.out.println("\nCalculo Final de Centroides:");
			for (int i = 0; i < k; i++) {
				double[] centroid = centroids.get(i);
				System.out.print("Cluster " + i + ": [");
				for (int j = 0; j < centroid.length; j++) {
					System.out.print(centroid[j]);
					if (j < centroid.length - 1) {
						System.out.print(", ");
					}
				}
				System.out.println("]");
			}

			String dis = distance == 1 ? "Euclidean" : "Manhattan";
			System.out.println("\nDistancia Metrica: " + dis);
			System.out.println("Iteraciones: " + max_iterations);
			System.out.println("Numero de Clusters: " + k);
			System.out.println("WCSS: " + wcss);
			System.out.println("Presiona 1 si deseas continuar de lo contrario 0 para salir.");
			ex = sc.nextInt();
		} while (ex == 1);
	}
	public static Map<double[], Integer> kmeans(List<double[]> features, int distance, Map<Integer, double[]> centroids, int k) {
		// Mapa que almacenará cada punto de datos junto con el índice del clúster asignado
		Map<double[], Integer> clusters = new HashMap<>();

		// Iterar sobre los puntos de características (features)
		for (double[] x : features) {
			double minimum = Double.MAX_VALUE;  // Inicializar la mínima distancia con un valor muy grande
			int k1 = -1;  // Variable para almacenar el índice del clúster más cercano
			double dist = 0.0;  // Variable para almacenar la distancia calculada

			// Comparar el punto x con cada uno de los centroides
			for (int j = 0; j < k; j++) {
				// Calcular la distancia dependiendo del tipo especificado
				if (distance == 1) {
					dist = Distancias.eucledianDistance(centroids.get(j), x);  // Distancia Euclidiana
				} else if (distance == 2) {
					dist = Distancias.manhattanDistance(centroids.get(j), x);  // Distancia Manhattan
				}

				// Si la distancia calculada es menor que la distancia mínima, actualizar el clúster
				if (dist < minimum) {
					minimum = dist;
					k1 = j;  // Asignar el índice del clúster más cercano
				}
			}

			// Asignar el punto x al clúster más cercano
			clusters.put(x, k1);
		}

		// Devolver el mapa con los puntos y sus respectivos clústeres
		return clusters;
	}

	public static double[] centroidCalculator(List<double[]> a, int numberOfFeatures) {
		// Inicializar un arreglo para almacenar el centroide de cada dimensión
		double[] centroids = new double[numberOfFeatures];

		// Iterar sobre cada dimensión (característica)
		for (int i = 0; i < numberOfFeatures; i++) {
			double sum = 0.0;
			int count = 0;

			// Sumar los valores de la característica i de cada punto
			for (double[] x : a) {
				sum += x[i];
				count++;
			}

			// Calcular el valor promedio (centroide) de la característica i
			centroids[i] = sum / count;
		}

		// Devolver el centroide calculado
		return centroids;
	}
	public K_Medias() {
		// Constructor vacío
	}

}
