package label;

import shampoo.BasicShampoo;

import javax.persistence.*;


@Entity
@Table(name = "labels")
public class BasicLabel implements Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    private String title;

    @Basic
    private String subTitle;

    public BasicLabel(String label) {
        this.title = label;
    }

    @OneToOne(mappedBy = "label", targetEntity = BasicShampoo.class, cascade = CascadeType.ALL)
    private BasicShampoo shampoo;

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public String getSubTitle() {
        return null;
    }

    @Override
    public void setSubTitle(String subTitle) {

    }

    @Override
    public BasicShampoo getShampoo() {
        return null;
    }

    @Override
    public void setShampoo(BasicShampoo shampoo) {

    }
}
