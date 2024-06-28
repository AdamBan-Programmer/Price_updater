package org.example.Items;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="observed")
public class ObservedItem {
    @Id
    @Column(name = "observed_id")
    private int id;

    @Column(name = "name")
    private String name;


    public ObservedItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObservedItem() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}