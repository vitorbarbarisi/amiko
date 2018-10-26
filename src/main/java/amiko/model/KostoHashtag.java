package amiko.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class KostoHashtag {
    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kostoHashtagId;

    @NotNull
    private Long kostoId;

    @NotNull
    private Long hashtagId;

    @ManyToOne
    @JoinColumn(name="hashtagId", insertable=false, updatable=false)
    private Hashtag hashtag;

    @ManyToOne
    @JoinColumn(name="kostoId", insertable=false, updatable=false)
    private Kosto kosto;

    public KostoHashtag() {

    }

    public KostoHashtag(Long kostoId, Long hashtagId) {
        this.kostoId = kostoId;
        this.hashtagId = hashtagId;
    }

}
