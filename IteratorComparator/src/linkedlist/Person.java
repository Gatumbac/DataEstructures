package linkedlist;

import java.util.Objects;

/**
 *
 * Profesora: Adriana Collaguazo Jaramillo
 */

public class Person implements Comparable<Person>{
    private String name;
    private String lastName;
    private int age;
    
    public Person(String name, String lastName, int age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    
    @Override
    public String toString(){
        return "Person(" + "name=" + name + ", lastName=" + lastName + ",age=" + age + ')';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.lastName, other.lastName);
    }


    @Override
    public int compareTo(Person o) {
        if (this.age == o.age && this.name.equals(o.name) && this.lastName.equals(o.lastName)) {
            return 0;
        } else {
            int nameComparison = this.name.compareTo(o.name);
            if (nameComparison != 0) {
                return nameComparison;
            }
            int lastNameComparison = this.lastName.compareTo(o.lastName);
            if (lastNameComparison != 0) {
                return lastNameComparison;
            }
            return Integer.compare(this.age, o.age);
        }
    } 
}
