package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UseComparatorInterface {
    public static void main(String[] args) {
        Person person = new Person("1", 5);
        Person person2 = new Person("2", 4);
        Person person3 = new Person("3", 12);
        Person person4 = new Person("Ali", 1);
        Person person5 = new Person("Veli", 1);
        Person person6 = new Person("3", 0);
        Person person7 = new Person("3", 7);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person7);

        personList.stream().forEach(System.out::println);
    /*
            Person{name='1', age=5}
            Person{name='2', age=4}
            Person{name='3', age=12}
            Person{name='Ali', age=1}
            Person{name='Veli', age=1}
            Person{name='3', age=0}
            Person{name='3', age=7}
    */
        System.out.println("\n");
        personList.sort(new PersonComparator());
        personList.stream().forEach(System.out::println);
    /*
            Person{name='3', age=0}
            Person{name='Ali', age=1}
            Person{name='Veli', age=1}
            Person{name='2', age=4}
            Person{name='1', age=5}
            Person{name='3', age=7}
            Person{name='3', age=12}
     */

    }


}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * Comparator interface provides compare ability for all types of objects.
 * retun 0 if params equals
 * return 1 if first param bigger than second param
 * return -1 if second param bigger than first param
 */
class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (Integer.compare(o1.getAge(), o2.getAge()) == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
