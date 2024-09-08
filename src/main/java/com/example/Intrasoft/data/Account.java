package com.example.Intrasoft.data;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.List;
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private Double balance;
    @Column(name = "beneficiary_id")
    private Long beneficiary_id;
    @ManyToOne
    @JoinColumn(name = "beneficiaryid", referencedColumnName = "id")
    private Beneficiary beneficiary;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

}
