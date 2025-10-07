package com.inflowia.dsevents.entities;

import jakarta.persistence.*;

import com.inflowia.dsevents.entities.Block;

import java.util.*;

@Entity
@Table(name = "tb_activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(name = "tb_activity_participant",
    joinColumns  = @JoinColumn(name = "activity_id"),
    inverseJoinColumns = @JoinColumn(name = "participant_id"))
    private Set<Participant> participants = new HashSet<>();

    @OneToMany(mappedBy = "activity")
    private List<Block> blocks = new ArrayList<>();

    public Activity () {}

    public Activity(Long id, String name, String description, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;
        return Objects.equals(getId(), activity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
