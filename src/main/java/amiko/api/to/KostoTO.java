package amiko.api.to;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KostoTO {

    private Long id;
    private Double price;
    private String description;
    private Double quantity = 1.0;
    private String weight = "0";
    private List<String> hashtags = new ArrayList<>();
    private Date date;

    public KostoTO(Long id, Double price, String description, Double quantity, String weight, Date date) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.weight = weight;
        this.date = date;
    }

    public KostoTO (){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
