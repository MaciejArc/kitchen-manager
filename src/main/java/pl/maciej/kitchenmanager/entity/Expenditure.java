package pl.maciej.kitchenmanager.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne
    private Product product;

    private int diaryNumber;

    private double quantity;

    private double value;

    private LocalDate pickUpDate = LocalDate.now();

    private String purpose;

    public int getDiaryNumber() {
        return diaryNumber;
    }

    public void setDiaryNumber(int diaryNumber) {
        this.diaryNumber = diaryNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }



    public Expenditure() {
    }
    public Expenditure(Product product) {
        this.product = product;
    }
}
