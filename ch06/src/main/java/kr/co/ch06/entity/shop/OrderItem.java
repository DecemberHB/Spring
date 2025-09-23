package kr.co.ch06.entity.shop;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SHOP_ORDER_ITEM")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderId")
    private Order order; // 한건의 주문에 아이템이 여러개

    private int count; // 주문 수량

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="productId")
    private  Product product; // 외래키
}
