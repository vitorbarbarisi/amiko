package amiko.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Kosto implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kostoId;

    @NotNull
    private Double price;
    @NotNull
    private String description;
    @NotNull
    private Double quantity = 1.;
    @NotNull
    private String weight = "0";
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    protected Kosto() {
    }

    public Kosto(Double price, String description, Double quantity, String weight, Date date) {
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.weight = weight;
        this.date = date;
    }

    public long getKostoId() {
        return kostoId;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getWeight() {
        return weight;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Kosto{" +
                "kosto_id=" + kostoId +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", weight='" + weight + '\'' +
                ", date=" + date +
                '}';
    }

}
