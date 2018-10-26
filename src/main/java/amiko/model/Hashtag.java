package amiko.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Hashtag {
    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long hashtagId;

    @NotNull
    @Column(unique = true)
    private String hashtag;

    public Hashtag() {
    }

    public Hashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public void setHashtagId(long hashtagId) {
        this.hashtagId = hashtagId;
    }

    public long getHashtagId() {
        return hashtagId;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
}


