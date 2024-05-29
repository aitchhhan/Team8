package Team8.cafe_kiosk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class OrderItem {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private String cup;
    private String temperature;
    private String size;
    private int quantity;
    private int price;

    public OrderItem(Order order, Item item, String cup, String temperature, String size, int quantity, int price) {
        this.order = order;
        this.item = item;
        this.cup = cup;
        this.temperature = temperature;
        this.size = size;
        this.quantity = quantity;
        this.price = price*quantity;
    }
}
