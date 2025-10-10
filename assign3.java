package Assignment;
class Person {
	 String name;
	 int age;
	 Person(String name, int age) {
	     this.name = name;
	     this.age = age;
	 }
	 public String toString() {
	     return "Person{name='" + name + "', age=" + age + "}";
	 }
	}
	class PersonBuilder<T extends PersonBuilder<T>> {
	 protected String name;
	 protected int age;
	 public T name(String name) {
	     this.name = name;
	     return (T) this; 
	 }
	 public T age(int age) {
	     this.age = age;
	     return (T) this;
	 }
	 public Person build() {
	     return new Person(name, age);
	 }
	}
	class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
	 private String department;
	 public EmployeeBuilder department(String department) {
	     this.department = department;
	     return this;
	 }
	 @Override
	 public Person build() {
	     return new Person(name + " (" + department + ")", age);
	 }
	}
public class FluentBuilders {
	public static void main(String[] args) {
	     Person p1 = new PersonBuilder<>()
	             .name("John")
	             .age(25)
	             .build();
	     Person p2 = new EmployeeBuilder()
	             .name("Alice")
	             .age(28)
	             .department("IT")
	             .build();
	     System.out.println(p1);
	     System.out.println(p2);
	}
}
