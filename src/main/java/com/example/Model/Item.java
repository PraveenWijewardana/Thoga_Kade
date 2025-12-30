package com.example.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Item {
    private String itemCode;
    private String dsc;
    private String category;
    private int qtyOnHand;
    private Double unitPrice;
}
