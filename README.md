Counting Sort en Java
==========================

Este proyecto implementa el algoritmo de ordenamiento Counting Sort en Java. Counting Sort es un algoritmo de ordenamiento que funciona contando el número de ocurrencias de cada valor único en el array y luego reconstruyendo el array ordenado.

¿Qué es Counting Sort?
Counting Sort es un algoritmo de ordenamiento que se utiliza para ordenar arrays de enteros no negativos. Su complejidad temporal es O(n + k), donde n es el número de elementos y k es el rango de los valores en el array.

Cómo funciona el código
Paso a paso del algoritmo


1. Encontrar el valor máximo:

Utiliza Java Stream para encontrar el valor máximo en el array.
int maxVal = Arrays.stream(arr).max().getAsInt();

2. Crear el array de conteo:

Crea un array count de tamaño maxVal + 1 para almacenar las ocurrencias de cada valor.
int[] count = new int[maxVal + 1];

3.Contar las ocurrencias:

Itera sobre el array original y aumenta el conteo correspondiente en el array count.
for (int num : arr) {
    count[num]++;
}

4. Calcular el conteo acumulado:

Transforma el array count en un array de conteos acumulados.
for (int i = 1; i < count.length; i++) {
    count[i] += count[i - 1];
}

5. Colocar los elementos en el array de salida:

Crea un nuevo array output y coloca los elementos del array original en él según su posición en el conteo acumulado.
int[] output = new int[arr.length];
for (int i = arr.length - 1; i >= 0; i--) {
    output[count[arr[i]] - 1] = arr[i];
    count[arr[i]]--;
}

6. Copiar el array de salida al array original:

Utiliza System.arraycopy para copiar el contenido del array output al array original.
System.arraycopy(output, 0, arr, 0, arr.length);

==========================

Ejemplo de uso
El archivo main incluye un ejemplo de uso del algoritmo con un array ``.

public static void main(String[] args) {
    int[] arr = {4, 2, 2, 8, 3, 3, 1};
    System.out.println("Array original: " + Arrays.toString(arr));
    countingSort(arr);
    System.out.println("Array ordenado: " + Arrays.toString(arr));
}

Ventajas y limitaciones
Ventajas:

Eficiente para arrays con un rango limitado de valores.

Tiene una complejidad temporal de O(n + k).

Limitaciones:

No es adecuado para arrays con valores negativos o muy grandes.

Requiere espacio adicional para el array de conteo.

Contribuciones
¡Estamos abiertos a contribuciones! Si tienes ideas para mejorar este proyecto o encontrarás errores, por favor, crea un issue o pull request.
