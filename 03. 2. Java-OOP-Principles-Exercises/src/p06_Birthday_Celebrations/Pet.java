package p06_Birthday_Celebrations;

public class Pet implements Birthday{
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.setName(name);
        this.setBirthdate(birthdate);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public void checkYear(String year) {
        if(this.birthdate.endsWith(year)){
            System.out.println(this.birthdate);
        }
    }
}
