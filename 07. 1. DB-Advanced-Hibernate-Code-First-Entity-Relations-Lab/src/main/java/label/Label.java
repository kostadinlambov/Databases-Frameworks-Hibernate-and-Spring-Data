package label;

import shampoo.BasicShampoo;

public interface Label {
    int getId();

    void setId(int id);

    String getTitle();

    void setTitle(String title);

    String getSubTitle();

    void setSubTitle(String subTitle);

    BasicShampoo getShampoo();

    void setShampoo(BasicShampoo shampoo);
}
