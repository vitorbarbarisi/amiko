package amiko.api.to;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class KostojRequestTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateAfter;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateBefore;
    private List<String> descriptions;
    private List<String> hashtags;

    public Date getDateAfter() {
        return dateAfter;
    }

    public void setDateAfter(Date dateAfter) {
        this.dateAfter = dateAfter;
    }

    public Date getDateBefore() {
        return dateBefore;
    }

    public void setDateBefore(Date dateBefore) {
        this.dateBefore = dateBefore;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> description) {
        this.descriptions = description;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }
}
