<h1>Calculadora de PickUpPoints Optimos segun Ubicaciones de Nuestros Clientes</h1>
<p>El programa utiliza el metodo K-Media para calcular clusters</p>
<p>El programa recibe los siguientes datos:</p>
<ul>
	<li> Cantidad de Clusters </li>
	<li> Distancia metrica </li>
	<li> Numero de Iteraciones ( Se recomienda entre 50 y 300 ) </li>
</ul>


<h2>Clases</h2>
<h3>LeerDatos</h3>

<p>La clase LeerDatos es una herramienta diseñada para leer y procesar datos desde un archivo, separándolos en características numéricas y etiquetas textuales. Se enfoca en extraer información estructurada de un archivo CSV (valores separados por comas) para ser utilizada en aplicaciones que requieran análisis de datos. Aquí está el resumen de lo que hace la clase:

Estructura de Datos:

Almacena características numéricas (features) como una lista de arreglos de tipo double[]. Cada arreglo representa un conjunto de coordenadas (dos valores numéricos).
Almacena las etiquetas (label) como una lista de cadenas (List<String>), que representan la categoría o nombre asociado a cada conjunto de características.
Método Principal:

El método read(String s) recibe la ruta de un archivo como entrada y:
Lee línea por línea el contenido del archivo.
Divide cada línea en partes utilizando la coma como delimitador.
Extrae las dos primeras columnas como las características numéricas.
Extrae la última columna como la etiqueta correspondiente.
Gestión de Errores:

Maneja excepciones comunes como FileNotFoundException si el archivo no existe, y NumberFormatException si los datos numéricos no están en el formato correcto.

Propósito:

Es útil en proyectos que requieran clasificación, predicción, o análisis estadístico, como el procesamiento de datos de entrada para algoritmos de aprendizaje automático.
En resumen, la clase LeerDatos actúa como un lector de archivos que organiza datos en características y etiquetas, facilitando su uso en aplicaciones de análisis y modelado.</p>

<p>Lee un archivo txt con la siguiente estructura: 
  
  <br> -12.112532,-77.0465684,Kion-Chinese
	<br> -12.0667769,-77.0575594,Tentaciones-Express </p>

 <h3>Distancias</h3>
<p>La clase Distancias proporciona un método estático para calcular la distancia euclidiana entre dos puntos en un espacio multidimensional. El método eucledianDistance toma dos arreglos de números (point1 y point2) que representan las coordenadas de los puntos, calcula la suma de las diferencias al cuadrado entre cada par de coordenadas correspondientes y devuelve la raíz cuadrada de esa suma, que es la distancia entre los dos puntos.

Propósito en una presentación:

"Esta clase permite calcular la distancia euclidiana entre dos puntos en un espacio n-dimensional, siendo útil en aplicaciones como análisis de datos, algoritmos de clustering, y otras áreas que requieran medir proximidades o similitudes entre puntos."</p>

 <h3>K-Medias</h3>
<p>La clase K_Medias implementa un algoritmo de agrupamiento basado en K-Means. Este método clasifica datos geográficos (latitud, longitud y nombre) en grupos o clústeres mediante iteraciones y cálculos de centroides. A continuación, se describen los aspectos principales:

Lectura de Datos:

Permite cargar un archivo de texto con datos estructurados en el formato: Latitud, Longitud, Nombre desde una ruta especificada por el usuario.
Configuración del Algoritmo:

El usuario elige:
El número de clústeres (k).
El número máximo de iteraciones.
El tipo de métrica de distancia (Euclidiana o Manhattan).
Inicialización:

Los centroides iniciales se seleccionan aleatoriamente de los datos cargados.
Proceso de Agrupamiento (K-Means):

Los datos se asignan a clústeres en función de la distancia más corta a los centroides.
Los centroides se recalculan iterativamente como el promedio de los puntos asignados a cada clúster.
El proceso se repite hasta completar el número máximo de iteraciones.
Resultados:

Al final, se muestran:
Los clústeres calculados con sus datos asignados.
Las coordenadas finales de los centroides.
El error total (WCSS - Within-Cluster Sum of Squares).
Detalles del proceso como la métrica de distancia, iteraciones y cantidad de clústeres.
Reutilización:

El programa permite ejecutar el proceso nuevamente con diferentes configuraciones.
Funcionalidades Adicionales:
Cálculo de Distancias:
Se soportan dos tipos de distancias: Euclidiana , definida en la clase Distancias.
Cálculo de Centroides:
Proporciona un método para calcular el centroide promedio de un grupo de puntos.
Esta clase es ideal para aplicaciones donde se necesite agrupar datos geoespaciales o clasificar puntos según su proximidad en un espacio bidimensional.</p>


