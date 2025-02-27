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
@Table(name = "table_pk_strategy")
public class EntityTablePKGen {

    @Id
    @GeneratedValue(generator = "table_gen", strategy = GenerationType.TABLE)
    @TableGenerator(name = "table_gen", table = "table_sequence", pkColumnName = "table_name", valueColumnName = "pk_value", allocationSize = 1)
    private Long id;

    private String info;

}
