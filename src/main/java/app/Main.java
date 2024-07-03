package app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void printList(List<Person> people){
        AtomicInteger count = new AtomicInteger(1);
        people.forEach(Person ->
                System.out.println(count.getAndIncrement() +
                        ") " + Person.getName()));
    }

    public static List<Person> whoIsOverTwentyFive(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() > 25)
                .collect(Collectors.toList());
    }

    public static List<Person> toUpperCase(List<Person> people) {
        return people.stream()
                .map(person -> {
                    Person p = new Person(person.getName().toUpperCase(), person.getAge(), person.getGender());
                    return p;
                })
                .collect(Collectors.toList());
    }

    public static List<Person> reverseAlphabetSort(List<Person> people){
        return people.stream()
                .sorted((p1, p2) -> p2.getName().compareTo(p1.getName()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Nazar", 18, "male"));
        people.add(new Person("Tom", 46,"male"));
        people.add(new Person("Flora", 22,"female"));
        people.add(new Person("Adrian", 29, "male"));
        people.add(new Person("Kevin", 48,"male"));
        people.add(new Person("Leah", 32,"female"));
        people.add(new Person("Andrew", 16,"male"));

        System.out.println("People, older than 25 years old:");
        List<Person> filteredPeople = whoIsOverTwentyFive(people);
        printList(filteredPeople);
        System.out.println();

        System.out.println("Their names in uppercase:");
        List<Person> upperCasePersons = toUpperCase(filteredPeople);
        printList(upperCasePersons);
        System.out.println();

        System.out.println("Their names reverse sorted and new List looks like:");
        List<Person> reserveSortedPersons = reverseAlphabetSort(upperCasePersons);
        printList(reserveSortedPersons);
        System.out.println();



    }
}
