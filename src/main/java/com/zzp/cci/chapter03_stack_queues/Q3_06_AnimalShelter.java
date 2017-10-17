package com.zzp.cci.chapter03_stack_queues;


import java.util.LinkedList;
import java.util.Queue;

abstract class Animal {
    public int order;
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public boolean idOlderThan(Animal animal) {
        return this.order < animal.order;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

public class Q3_06_AnimalShelter {
    Queue<Dog> dogs = new LinkedList<>();
    Queue<Cat> cats = new LinkedList<>();

    private int order;

    public void enqueue(Animal animal) {
        animal.order = order++;
        if (animal instanceof Dog) dogs.add((Dog) animal);
        else if (animal instanceof Cat) cats.add((Cat) animal);
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
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    public static void main(String[] args) {
        Q3_06_AnimalShelter animalShelter = new Q3_06_AnimalShelter();
        animalShelter.enqueue(new Dog("George"));
        animalShelter.enqueue(new Dog("Tom"));
        animalShelter.enqueue(new Cat("Sandy"));
        animalShelter.enqueue(new Dog("Jim"));
        animalShelter.enqueue(new Cat("Joe"));
        animalShelter.enqueue(new Dog("Peter"));

        System.out.println(animalShelter.dequeueCats().name);
        System.out.println(animalShelter.dequeueDogs().name);
        System.out.println(animalShelter.dequeueAny().name);
    }
}