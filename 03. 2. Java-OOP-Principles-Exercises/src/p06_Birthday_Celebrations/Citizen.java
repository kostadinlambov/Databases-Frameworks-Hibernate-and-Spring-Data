package p06_Birthday_Celebrations;

public class Citizen implements Identifiable, Birthday {
    private String name;
    private int age;
    private String id;
    private String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthdate(birthdate);
    }

    private void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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

    @Override
    public void checkYear(String year) {
        if(this.birthdate.endsWith(year)){
            System.out.println(this.birthdate);
        }
    }
}
