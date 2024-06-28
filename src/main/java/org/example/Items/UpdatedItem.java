package org.example.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="results")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatedItem {

    @Id
    @Column(name = "result_id")
    private int id;

    @JsonProperty("lowest_price")
    @Column(name = "price")
    private String price;

    @Column(name = "log_date")
    private String logDate;

    @Column(name = "observed_id")
    private int observedId;

    public UpdatedItem(int id, String price, String logDate,int observedId)
    {
        this.id = id;
        this.price = price;
        this.logDate = logDate;
        this.observedId = observedId;
    }

    public UpdatedItem() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLogDate() {
        return this.logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public int getObservedId() {
        return this.observedId;
    }

    public void setObservedId(int observedId) {
        this.observedId = observedId;
    }
}
