package Ex3;

import java.util.LinkedList;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan11,2017
 * Problem: Animal Shelter-> An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out"
 * 		    basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can
 * 			select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). 
 * 		    They cannot select which specific animal they would like. Create the data structures to maintain this system and
 *          implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. 
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/
class Animal{
	private int order;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Animal(String type){
		 this.name = type;
	}
	public void setOrder(int order){
		this.order = order;
	}
	public int getOrder(){
		return this.order;
	}
	public boolean isOlder(Animal a){
	    return this.order < a.getOrder();
	}
}

class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
}

class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}

public class AnimalShelter {
	private LinkedList<Dog> dogs ;
	private LinkedList<Cat> cats ;
	private int order =0;
	
	public AnimalShelter(){
		this.dogs = new LinkedList<Dog>();
		this.cats = new LinkedList<Cat>();
	}
	
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		
		if(a instanceof Dog)
			dogs.addLast((Dog) a);
		else
			cats.addLast((Cat) a);
	}
	
	public Animal dequeueAny(){
		if(dogs.isEmpty() && cats.isEmpty())
			return null;
		if(dogs.isEmpty())
			return cats.removeFirst();
		else if(cats.isEmpty())
			return dogs.removeFirst();
		else{
			Cat oldestCat = cats.peek();
			Dog oldestDog = dogs.peek();
			if(oldestCat.isOlder(oldestDog))
				return cats.removeFirst();
			else
				return dogs.removeFirst();
		}
	}
	
	public Animal dequeueDog(){
		if(dogs.isEmpty())
			return null;
		return dogs.removeFirst();
	}
	
	public Animal dequeueCat(){
		if(cats.isEmpty())
			return null;
		return cats.removeFirst();
	}
	
	  public Animal peek() {
		    if (dogs.size() == 0 && cats.size() == 0)
		      return null;
		    if (dogs.size() == 0)
		      return cats.peek();
		    if (cats.size() == 0)
		      return dogs.peek();

		    Cat oldestCat = cats.peek();
		    Dog oldestDog = dogs.peek();
		    if (oldestCat.isOlder(oldestDog))
		      return oldestCat;
		    else
		      return oldestDog;
		  }
	
	public static void main(String[] args) {
		AnimalShelter ash = new AnimalShelter();
		Dog d1 = new Dog("Tommy");
		Dog d2 = new Dog("Dolly");
		Dog d3 = new Dog("Guston");
		Dog d4 = new Dog("Molly");
		
		Cat c1 = new Cat("Kitty");
		Cat c2 = new Cat("Mitty");
		Cat c3 = new Cat("Bitty");
		Cat c4 = new Cat("Sully");
		
		//ash.dequeueAny();
		ash.enqueue(d1);
		ash.enqueue(c1);
		ash.enqueue(c2);
		ash.enqueue(d2);
		ash.enqueue(d3);
		ash.enqueue(d4);
		ash.enqueue(c3);
		ash.enqueue(c4);
		
		Animal a1 = ash.dequeueAny();
		System.out.println(a1.getName());
		a1 = ash.dequeueAny();
		System.out.println(a1.getName());
		a1 = ash.dequeueDog();
		System.out.println(a1.getName());
		a1 = ash.dequeueCat();
		System.out.println(a1.getName());
	}

}
