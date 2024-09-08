package com.example.Intrasoft.data;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "account_id")  // Specify the foreign key column
    private Account account;

    @Column(name = "type")  // Add the type field here
    private String type;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;  // Use @Column for basic fields

    @Column(name = "amount")
    private Double amount;
}
