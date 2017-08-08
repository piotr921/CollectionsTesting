package pl.learning.collectionstesting;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static pl.learning.collectionstesting.Gender.MAN;
import static pl.learning.collectionstesting.Gender.WOMAN;

public class SetTest {

    @Test
    public void ageComparatorTest() {
        // Given
        Comparator<Person> personAgeComparator = Comparator.comparingInt(Person::getAge);
        Set<Person> people = new TreeSet<>(personAgeComparator);

        // When
        people.add(new Person("A", "AAA", 60, MAN));
        people.add(new Person("Z", "ZZZ", 12, WOMAN));
        people.add(new Person("Q", "QQQ", 33, WOMAN));

        // Then
        people.forEach(person -> System.out.println(person.getFirstName()));
    }

    @Test
    public void nameComparatorTest() {
        // Given
        Comparator<Person> personAgeComparator = Comparator.comparing(Person::getLastName).thenComparing(Person::getGender);
        Set<Person> people = new TreeSet<>(personAgeComparator);

        // When
        Person person1 = new Person("D", "AAA", 60, MAN);
        people.add(person1);
        Person person2 = new Person("D", "AAA", 60, MAN);
        people.add(person2);
        people.add(new Person("Z", "ZZZ", 12, WOMAN));
        people.add(new Person("Q", "QQQ", 33, WOMAN));
        people.add(new Person("D", "AAA", 33, WOMAN));

        System.out.println("Equals test;");
        System.out.println(person1.equals(person2));

        // Then
        people.forEach(person -> System.out.println(person.getLastName() + " " + person.getFirstName()));
    }
}
