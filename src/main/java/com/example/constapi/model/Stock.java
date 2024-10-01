package com.example.constapi.model;

import jakarta.persistence.*;


@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item_name;
    private int item_quantity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return item_name;
    }

    public void setItemName(String name) {
        this.item_name = name;
    }

    public int getItemQuantity() {
        return item_quantity;
    }

    public void setItemQuantity(int quantity) {
        this.item_quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
