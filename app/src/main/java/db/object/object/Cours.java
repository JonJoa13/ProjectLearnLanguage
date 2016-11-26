package db.object.object;

/**
 * Created by TheoP on 15.11.2016.
 */

public class Cours {
    private int id;
    private String titre;
    private int level;

    public Cours(){};

    public Cours(String titre, int level){
        this.titre = titre;
        this.level = level;
    }

    public Cours(int id, String titre, int level){
        this.id = id;
        this.titre = titre;
        this.level = level;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
