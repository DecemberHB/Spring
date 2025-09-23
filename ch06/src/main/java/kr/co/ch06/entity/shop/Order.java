package kr.co.ch06.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SHOP_Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderer") //FK KEY 명
    private Customer customer;

    private int orderPrice;
    private int orderStatus;

    @CreationTimestamp
    private LocalDateTime orderDate;
}
