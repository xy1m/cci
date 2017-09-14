package com.zzp.cci.stack;


import java.util.LinkedList;

abstract class Animal {
    public int order;
    public String name;

    public boolean idOlderThan(Animal animal) {
        return this.order < animal.order;
    }
}

class Dog extends Animal {

}

class Cat extends Animal {

}

public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();

    private int order;

    public void enqueue(Animal animal) {
        animal.order = order++;
        if (animal instanceof Dog) dogs.addLast((Dog) animal);
        else if (animal instanceof Cat) cats.addLast((Cat) animal);
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) return dequeueCats();
        if (cats.isEmpty()) return dequeueDogs();
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.idOlderThan(cat)) {
            return dog;
        } else {
            return cat;
        }
    }

    public Dog dequeueDogs() {
        return dogs.pop();
    }

    public Cat dequeueCats() {
        return cats.pop();
    }
}