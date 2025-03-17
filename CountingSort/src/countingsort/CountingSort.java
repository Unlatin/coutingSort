package countingsort;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr) {
        // Paso 1: Encontrar el valor máximo en el array
        int maxVal = Arrays.stream(arr).max().getAsInt();

        // Paso 2: Crear el array de conteo
        int[] count = new int[maxVal + 1];

        // Paso 3: Contar las ocurrencias de cada elemento
        for (int num : arr) {
            count[num]++;
        }

        // Paso 4: Calcular el conteo acumulado
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Paso 5: Colocar los elementos en el array de salida
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copiar el array de salida al array original
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Array original: " + Arrays.toString(arr));
        countingSort(arr);
        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }
}
