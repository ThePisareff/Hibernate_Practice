package com.pisareff.demo.demoEntity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "embedded_key")
public class EntityEmbeddedId {

    @EmbeddedId
    private EmbeddedIdentifier embeddedIdentifier;
    private String info;
}
