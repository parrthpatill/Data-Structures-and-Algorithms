class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
    public static void main(String[] args){
        Dog tommy = new Dog();
        tommy.sound();
        tommy.bark();
    }
}
