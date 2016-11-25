package db.object.object;

/**
 * Created by TheoP on 18.11.2016.
 */

public class Choice {
    private int id;
    private String choice_1;
    private String choice_2;
    private String choice_3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getChoice_1() {
        return choice_1;
    }

    public void setChoice_1(String choice_1) {
        this.choice_1 = choice_1;
    }

    public String getChoice_2() {
        return choice_2;
    }

    public void setChoice_2(String choice_2) {
        this.choice_2 = choice_2;
    }

    public String getChoice_3() {
        return choice_3;
    }

    public void setChoice_3(String choice_3) {
        this.choice_3 = choice_3;
    }
}
