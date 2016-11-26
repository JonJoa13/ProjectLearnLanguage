package db.object.object;

/**
 * Created by TheoP on 18.11.2016.
 */

public class Choice {
    private int id;
    private String description;
    private int idExercice;
    private String choice1;
    private String choice2;
    private String choice3;

    public Choice(){};

    public Choice(String description, String choice1, String choice2, String choice3)
    {
        this.description = description;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
    }

    public Choice(int id, String description, String choice1, String choice2, String choice3)
    {
        this.description = description;
        this.id = id;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdExercice() {
        return idExercice;
    }

    public void setIdExercice(int idExercice) {
        this.idExercice = idExercice;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }
}
