package com.pisareff.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

//Lombok annotations
@Data // @Getter+@Setter+@RequiredArgsConstructor+@ToString+@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
//JPA annotation
@Entity // Объявляем класс как сущность
@Table(name = "users", schema = "public") // Маппим на таблицу БД
public class User {

    @Id // Объявляем как первичный ключ
    private String username;
    private String firstName;
    private String lastName;
    @Column(name = "birth_date") // Маппим поле на колонку в таблице вручную
    private LocalDate birthDate;
    private Integer age;
    @Enumerated(EnumType.STRING) // Обозначаем что это поле Enum и ставим представление в виде строки
    private Role role;
}
