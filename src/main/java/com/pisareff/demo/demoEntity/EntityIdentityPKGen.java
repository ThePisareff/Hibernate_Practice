package com.pisareff.demo.demoEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "identity_pk_strategy")
public class EntityIdentityPKGen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Объявляем о том, что поле генерируемое, решение принимает СУБД
    private Long id;

    private String info;

}
