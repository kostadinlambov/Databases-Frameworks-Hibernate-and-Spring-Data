package p05_Border_Control;

public class Citizen implements Identifiable{
    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public void checkId(String id) {
        if(this.id.endsWith(id)){
            System.out.println(this.id);
        }
    }
}
