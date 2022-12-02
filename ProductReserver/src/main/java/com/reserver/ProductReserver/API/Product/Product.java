package com.reserver.ProductReserver.API.Product;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String discription;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false, name = "guideline")
    private String guideLines;
    @Column(name = "start_reservation")
    private LocalDate startReservation;
    @Column(name = "end_reservation")
    private LocalDate endReservation;
    @Column
    private Integer rating;
    @Column(name = "buy_date")
    private LocalDate buyDate = LocalDate.now();

    public Product() {

    }

    public Product(Integer id, String name, String discription, Integer quantity, String guideLines, Integer rating, LocalDate buyDate) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.quantity = quantity;
        this.guideLines = guideLines;
        this.rating = rating;
        this.buyDate = buyDate;
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

    public String getGuideLines() {
        return guideLines;
    }

    public void setGuideLines(String guideLines) {
        this.guideLines = guideLines;
    }

    public LocalDate getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(LocalDate startReservation) {
        this.startReservation = startReservation;
    }

    public LocalDate getEndReservation() { return endReservation; }

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
