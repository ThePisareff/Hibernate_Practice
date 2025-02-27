package com.pisareff.demo.demoEntity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Embeddable
public class EmbeddedIdentifier implements Serializable {

    @Serial
    private static final long serialVersionUID = -3727003019130914978L;

    private String firstName;
    private String lastName;

}
