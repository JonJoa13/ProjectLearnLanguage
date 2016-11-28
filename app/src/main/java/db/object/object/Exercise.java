package db.object.object;

/**
 * Created by TheoP on 15.11.2016.
 */

public class Exercise {
    private int id;
    private String titre;
    private String type;
    private int idCours;
    private String donnee;
    private String solution;

    public Exercise(){}

    public Exercise(String titre, String type, String donnee, String solution){
        this.titre = titre;
        this.type = type;
        this.donnee = donnee;
        this.solution = solution;
    }

    public Exercise(int id, String titre, String type, String donnee, String solution){
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.donnee = donnee;
        this.solution = solution;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getDonnee() {
        return donnee;
    }

    public void setDonnee(String donnee) {
        this.donnee = donnee;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

}
