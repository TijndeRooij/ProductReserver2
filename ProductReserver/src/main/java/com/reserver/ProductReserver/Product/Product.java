package com.reserver.ProductReserver.Product;

import java.time.LocalDate;

public class Product {
    private Integer id;
    private String name;
    private String discription;
    private Integer quantity;
    private String gideLines;
    private LocalDate startReservation;
    private LocalDate endReservation;
    private Integer rating;
    private LocalDate buyDate = LocalDate.now();

    public Product(Integer id ,String name, String discription, Integer quantity, String gideLines, Integer rating) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.quantity = quantity;
        this.gideLines = gideLines;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getGideLines() {
        return gideLines;
    }

    public void setGideLines(String gideLines) {
        this.gideLines = gideLines;
    }

    public LocalDate getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(LocalDate startReservation) {
        this.startReservation = startReservation;
    }

    public LocalDate getEndReservation() {
        return endReservation;
    }

    public void setEndReservation(LocalDate endReservation) {
        this.endReservation = endReservation;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocalDate getBuyDate() {
        return buyDate;
    }

//    public void ReserveProduct(LocalDate startReservation, LocalDate endReservation){
//        this.startReservation = startReservation;
//        this.endReservation = endReservation;
//    }
//
//    public Boolean isReserved(){
//        if (startReservation == LocalDate.now()){
//            return true;
//        }
//        if (endReservation == LocalDate.now()){
//            return false;
//        }
//        return false;
//    }
}
