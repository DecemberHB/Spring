package kr.co.ch06.dto;

import lombok.Data;

@Data
public class ProductAggDTO {
    private int priceSum;
    private int priceMax;
    private int priceMin;
    private double priceAvg;

}
