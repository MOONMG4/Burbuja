package src;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que implementa el algoritmo de ordenamiento de la Burbuja (Bubble Sort)
 * para ordenar una lista dinámica de números enteros.
 * 
 * @author Hernández Exiga Jesús Manuel
 * @fecha 05/11/26
 */
public class OrdenBurbuja {

    /**
     * Método principal que ejecuta el programa.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        
        // Scanner para leer los datos que el usuario ingresa por teclado.
        Scanner teclado = new Scanner(System.in);
        
        /* 
         * DECLARACIÓN DE LA LISTA:
         * Usamos ArrayList<Integer> porque el problema pide una "lista de N elementos". 
         * A diferencia de los arreglos (int[]), el ArrayList crece dinámicamente 
         * conforme le agregamos elementos, sin necesidad de definir su tamaño inicial.
         */
        ArrayList<Integer> tarjetas = new ArrayList<>();
        
        int n, auxiliar;
        
        // --- CONTADORES DE LA FASE 3 ---
        // Variables para llevar el registro estadístico de lo que hace el algoritmo.
        int totalPasadas = 0;
        int totalComparaciones = 0;
        int totalIntercambios = 0;
        
        System.out.print("Ingrese la cantidad de tarjetas (N): ");
        n = teclado.nextInt(); 
        
        /* 
         * LLENADO DE LA LISTA:
         * El ciclo va desde 0 hasta n-1 (índices de Java). 
         * Mostramos (i + 1) para que al usuario le aparezca "Tarjeta 1, 2, 3..."
         * .add(valor) agrega el elemento al final de la lista.
         */
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el valor de la tarjeta " + (i + 1) + ": ");
            int valor = teclado.nextInt();
            tarjetas.add(valor); 
        }
        
        System.out.println("\n--- INICIANDO ORDENAMIENTO ---");
        
        /* 
         * CICLO EXTERNO (PASADAS):
         * Se ejecuta hasta size() - 1. ¿Por qué -1? Porque en la última pasada, 
         * el elemento más grande ya habrá quedado en su lugar definitivo por descarte.
         */
        for (int i = 0; i < tarjetas.size() - 1; i++) {
            
            totalPasadas++; 
            int comparacionesEnEstaPasada = 0;
            int intercambiosEnEstaPasada = 0;
            
            /* 
             * CICLO INTERNO (COMPARACIONES):
             * Compara pares adyacentes. Restamos 'i' porque en cada pasada, 
             * los elementos más grandes ya "burbujearon" al final, por lo que 
             * no es necesario volver a evaluarlos.
             */
            for (int j = 0; j < tarjetas.size() - 1 - i; j++) {
                
                totalComparaciones++;
                comparacionesEnEstaPasada++;
                
                /* 
                 * COMPARACIÓN Y ACCESO:
                 * .get(indice) obtiene el valor en esa posición. 
                 * Si el actual es mayor que el siguiente, están desordenados.
                 */
                if (tarjetas.get(j) > tarjetas.get(j + 1)) {
                    
                    /* 
                     * INTERCAMBIO (SWAP) usando variable auxiliar:
                     * 1. Guardamos el primer valor en 'auxiliar'.
                     * 2. .set(indice, valor) reemplaza el primero con el segundo.
                     * 3. Colocamos el valor guardado en la segunda posición.
                     * Esto evita perder datos por sobrescritura.
                     */
                    auxiliar = tarjetas.get(j); 
                    tarjetas.set(j, tarjetas.get(j + 1)); 
                    tarjetas.set(j + 1, auxiliar);        
                    
                    totalIntercambios++;
                    intercambiosEnEstaPasada++;
                }
            }
            
            /* 
             * PUNTO 2 DE LA FASE 3: 
             * Se imprime cómo va quedando la lista después de cada pasada para
             * que el alumno compare con su registro manual (Fase 1).
             */
            System.out.println("Pasada " + totalPasadas + ": " + tarjetas.toString() + 
                               " | Comparaciones: " + comparacionesEnEstaPasada + 
                               " | Intercambios: " + intercambiosEnEstaPasada);
        }
        
        /* 
         * PUNTO 3 DE LA FASE 3: 
         * Impresión de los totales estadísticos al finalizar el algoritmo.
         */
        System.out.println("\n--- RESUMEN FINAL ---");
        System.out.println("Total de pasadas: " + totalPasadas);
        System.out.println("Total de comparaciones: " + totalComparaciones);
        System.out.println("Total de intercambios: " + totalIntercambios);
        
        System.out.print("Lista final ordenada: ");
        for (int i = 0; i < tarjetas.size(); i++) {
            System.out.print(tarjetas.get(i) + " ");
        }
        System.out.println(); 
        
        // Cierre del Scanner para liberar recursos del sistema.
        teclado.close();
    }
}