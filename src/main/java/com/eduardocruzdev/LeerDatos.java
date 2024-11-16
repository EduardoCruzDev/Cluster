package com.eduardocruzdev;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeerDatos {

	protected List<double[]> features = new ArrayList<>();
	protected List<String> label = new ArrayList<>();
	protected static int numberOfFeatures;

	public List<double[]> getFeatures() {
		return features;
	}

	public List<String> getLabel() {
		return label;
	}

	void read(String s) throws NumberFormatException, IOException {
		File file = new File(s);

		try (BufferedReader readFile = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = readFile.readLine()) != null) {
				String[] split = line.split(",");
				// Procesar las primeras dos columnas como características (coordenadas)
				double[] feature = new double[2]; // Solo necesitamos 2 características
				numberOfFeatures = 2;
				for (int i = 0; i < 2; i++) {
					feature[i] = Double.parseDouble(split[i]);
				}
				features.add(feature);

				// La última columna es la etiqueta
				String labels = split[2];
				label.add(labels);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
