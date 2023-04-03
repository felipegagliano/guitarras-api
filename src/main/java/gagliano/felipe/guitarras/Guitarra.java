package gagliano.felipe.guitarras;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guitarras")
public class Guitarra {

    @Id
    private String id;
    private String title;
    private String image;
    private String ranking;

    public Guitarra(){}

    public Guitarra(String title, String image, String ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public Guitarra(String id, String title, String image, String ranking) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getRanking() {
        return ranking;
    }
}
