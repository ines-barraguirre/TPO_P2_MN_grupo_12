package org.example.adt;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class TraceMatrix {

    public static int calculateTrace(Queue<Stack> queueOfStacks) {
        int traza = 0;
        int stackIndex = 0;
        while (!queueOfStacks.isEmpty()) {
            Stack currentStack = queueOfStacks.poll();
            int elementsToRemove = stackIndex;
            for (int i = 0; i < elementsToRemove; i++) {
                currentStack.remove();  // Remover elementos hasta llegar a la diagonal
            }
            if (!currentStack.isEmpty()) {
                traza += currentStack.getTop();
                currentStack.remove();
            }
            stackIndex++;
        }
        return traza;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el tamaño de la matriz (n para una matriz n x n):");
        int n = scanner.nextInt();

        Queue<Stack> queueOfStacks = new LinkedList<>();

        System.out.println("Introduce los elementos de la matriz:");
        for (int i = 0; i < n; i++) {
            Stack stack = new StaticStack(n);
            System.out.println("Introduce los elementos de la fila " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                stack.add(value);
            }
            queueOfStacks.add(stack);
        }

        int trazaResultado = calculateTrace(queueOfStacks);
        System.out.println("La traza de la matriz es: " + trazaResultado);
    }
}