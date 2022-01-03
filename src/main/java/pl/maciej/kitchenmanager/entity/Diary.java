package pl.maciej.kitchenmanager.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    private String purpose;

    @Lob
    private String breakfast;
    private int breakfastQuantity;

    @Lob
    private String dinner;
    private int dinnerQuantity;

    @Lob
    private String tea;
    private int teaQuantity;

    @OneToMany
    private List<Expenditure> expenditureList;

    private LocalDate date = LocalDate.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public int getBreakfastQuantity() {
        return breakfastQuantity;
    }

    public void setBreakfastQuantity(int breakfastQuantity) {
        this.breakfastQuantity = breakfastQuantity;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public int getDinnerQuantity() {
        return dinnerQuantity;
    }

    public void setDinnerQuantity(int dinnerQuantity) {
        this.dinnerQuantity = dinnerQuantity;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public int getTeaQuantity() {
        return teaQuantity;
    }

    public void setTeaQuantity(int teaQuantity) {
        this.teaQuantity = teaQuantity;
    }

    public List<Expenditure> getExpenditureList() {
        return expenditureList;
    }

    public void setExpenditureList(List<Expenditure> expenditureList) {
        this.expenditureList = expenditureList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
