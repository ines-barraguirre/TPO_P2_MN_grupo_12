package org.example.adt;

public class StaticStack implements Stack {

    private final int MAX;

    private final int[] array;
    private int count = 0;

    public StaticStack(int maxSize) {
        this.MAX = maxSize;
        this.array = new int[MAX];
    }

    @Override
    public int getTop() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope una pila vacia");
        }
        return array[this.count - 1];
    }

    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope una pila vacia");
        }
        count--;
    }

    @Override
    public void add(int value) {
        if(this.count == MAX) {
            throw new RuntimeException("La pila esta llena");
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

}
