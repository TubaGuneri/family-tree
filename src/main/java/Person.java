import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Person {
    //    name
//middleName
//lastName
//sex
//age
//mother (Person)
//father (Person)
//siblings (lijst)
//children (lijst)
//pets (lijst)
//Geef de klassen de juiste attributen.
   private final String name;
   private String middelName = "";
   private String lastName;
   private int age;
   private BiologicalGender biologicalGender;
   private Person mother;
   private Person father;
   private List <Person> children= new ArrayList<>();
   private List<Pet> pets;

    public Person(String name, String lastName, int age, BiologicalGender biologicalGender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.biologicalGender = biologicalGender;
    }

    public Person(String name, String middelName, String lastName, int age, BiologicalGender biologicalGender) {
        this.name = name;
        this.middelName = middelName;
        this.lastName = lastName;
        this.age = age;
        this.biologicalGender = biologicalGender;
    }

    public String getName() {
        return name;
    }

    public String getMiddelName() {
        return middelName;
    }

    public void setMiddelName(String middelName) {
        this.middelName = middelName;
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

    public BiologicalGender getBiologicalGender() {
        return biologicalGender;
    }

    public void setBiologicalGender(BiologicalGender biologicalGender) {
        this.biologicalGender = biologicalGender;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return findSiblings();
    }
    public List<Person> findSiblings(){
        var siblings = new HashSet<Person>();
        if (mother != null){
            siblings.addAll(mother.getSiblings());
        }
        if (father!= null){
            siblings.addAll(father.getSiblings());
        }
        siblings.remove(this);
        List <Person> siblingsList = new ArrayList<>(siblings);
        return siblingsList;
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public void setChildren(List<Person> children) {
        this.children = new ArrayList<>();
        if (children == null){
            return;
        }
        this.children = new ArrayList<>();
        for (Person child : children){
            addChild(child);
        }
    }



    public void addParents (Person father, Person mother){
        setMother(mother);
        mother.addChild(this);
        setFather(father);
        father.addChild(this);
    }

    private void addChild(Person child) {
if (!getChildren().contains(child)){
    getChildren().add(child);
}
if(biologicalGender == BiologicalGender.Male){
    child.setFather(this);
}
if(biologicalGender == BiologicalGender.Female){
child.setMother(this);
}
    }
    private void addPet(Person person, Pet pet){
        List <Pet> pets = new ArrayList<>();
        if(person.getPets() != null){
            pets.addAll(person.getPets());
        }
        pets.add(pet);
        person.setPets(pets);
    }
    public List<Person> getGrandChildren(){
        List<Person> grandChildren = new ArrayList<>();
        for (Person children : getChildren()){
            grandChildren.addAll(children.getChildren());
        }
        return grandChildren;
    }
}
