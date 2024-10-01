package com.example.constapi.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "item_name", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stock> stockItems = new ArrayList<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Stock> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<Stock> stockItems) {
        this.stockItems = stockItems;
    }

    public void saveStockItems(Stock item) {
        stockItems.add(item);
        item.setUser(this);
    }

    public void removeStockItems(Stock item) {
        stockItems.remove(item);
        item.setUser(null);
    }



}
