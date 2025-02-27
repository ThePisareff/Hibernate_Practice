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
@Table(name = "sequence_pk_strategy")
public class EntitySequencePKGen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_gen") // Объявляем о том, что поле генерируемое, указываем генератор
    @SequenceGenerator(name = "sequence_gen", sequenceName = "sequence_pk_strategy_id_seq", allocationSize = 1) // Обозначаем генератор последовательностей из БД
    private Long id;

    private String info;
}
