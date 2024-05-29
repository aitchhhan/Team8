package Team8.cafe_kiosk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Order {
    @Id @GeneratedValue
    private Long Id;
    private LocalDateTime orderDateTime;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
    private int totalAmount;
    private String orderNumber; // 주문 번호 추가

    public Order(LocalDateTime orderDateTime, List<OrderItem> orderItems, int totalAmount, String orderNumber) {
        this.orderDateTime = orderDateTime;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.orderNumber = orderNumber;
    }
}
