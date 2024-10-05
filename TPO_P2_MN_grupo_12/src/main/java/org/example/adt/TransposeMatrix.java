package org.example.adt;
import java.util.LinkedList;
import java.util.Queue;

public class TransposeMatrix {

    // Metodo para calcular la transpuesta de una QueueOfStacks
    public static Queue<Stack> transpose(Queue<Stack> queueOfStacks) {
        if (queueOfStacks.isEmpty()) {
            throw new RuntimeException("La cola de pilas está vacía");
        }

        Queue<Stack> transposedQueue = new LinkedList<>();
        int maxSize = 0;

        // Calculamos el tamaño máximo de las pilas en la cola original
        for (Stack stack : queueOfStacks) {
            Stack tempStack = new StaticStack(100); // Suponemos un tamaño máximo arbitrario
            int currentSize = 0;

            // Pasamos los elementos de la pila original a la pila temporal y contamos
            while (!stack.isEmpty()) {
                int topElement = stack.getTop();
                stack.remove(); // Remove the element from the original stack
                tempStack.add(topElement); // Add it to the temporary stack
                currentSize++;
            }

            // Devolvemos los elementos a la pila original
            while (!tempStack.isEmpty()) {
                int topElement = tempStack.getTop();
                tempStack.remove();
                stack.add(topElement);
            }

            // Actualizamos el tamaño máximo
            if (currentSize > maxSize) {
                maxSize = currentSize;
            }
        }

        // Creamos nuevas pilas para la transpuesta
        for (int i = 0; i < maxSize; i++) {
            transposedQueue.add(new StaticStack(queueOfStacks.size()));
        }

        // Extraemos los elementos de las pilas y los colocamos en la nueva cola transpuesta
        while (!queueOfStacks.isEmpty()) {
            Stack currentStack = queueOfStacks.remove();
            int stackIndex = 0;

            while (!currentStack.isEmpty()) {
                int topElement = currentStack.getTop();
                currentStack.remove();

                // Añadimos el elemento a la pila correspondiente en la cola transpuesta
                ((LinkedList<Stack>) transposedQueue).get(stackIndex).add(topElement);
                stackIndex++;
            }
        }

        return transposedQueue;

    }
    public static void main(String[] args) {
        // Ejemplo: dependiendo si quiere que ingresemos una variable por teclado, o traerla como archivo
        Queue<Stack> queueOfStacks = new LinkedList<>();

        // Suponiendo que ya tienes una cola de pilas preexistente llamada `queueOfStacks`, podrías llamarlo así:
        // Queue<Stack> transposedQueue = transpose(queueOfStacks);
        // Mostrar las pilas transpuestas (ejemplo de cómo puedes imprimir los resultados):
        // for (Stack stack : transposedQueue) {
        //     while (!stack.isEmpty()) {
        //         System.out.println(stack.getTop());
        //         stack.remove();
        //     }
        //     System.out.println("----");
        // }
    }
}


}