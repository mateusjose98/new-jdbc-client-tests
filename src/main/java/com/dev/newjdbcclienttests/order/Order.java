package com.dev.newjdbcclienttests.order;

import com.dev.newjdbcclienttests.order.enums.PaymentMethod;
import com.dev.newjdbcclienttests.order.items.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private Integer id;
    private LocalDateTime issuanceDate;
    private PaymentMethod paymentMethod;
    private Set<Item> items = new HashSet<>();

    public void addItem(Item i) {
        this.items.add(i);
    }
}
