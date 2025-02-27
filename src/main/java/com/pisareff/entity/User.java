package com.pisareff.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//Lombok annotations
@Data // @Getter+@Setter+@RequiredArgsConstructor+@ToString+@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
//JPA annotation
@Entity // Объявляем класс как сущность
@Table(name = "users", schema = "public") // Маппим на таблицу БД
public class User {

    @Id  // Вариант для BIGSERIAL полей с авто генерацией ключа на стороне СУБД
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Объявляем о том, что поле генерируемое
    private Long id;

    @Column(unique = true) // В данном случае используем как мета информацию для программиста
    private String username;

    @Embedded // Необязательная аннотация. Обозначает что тип embeddable (встраиваемый)
    @AttributeOverride(name = "birthDate", column = @Column(name = "birth_date")) // Ручной маппинг поля, альтернативный вариант для embedded компонента
    private PersonalInfo personalInfo;

    @Enumerated(EnumType.STRING) // Обозначаем что это поле Enum и ставим представление в виде строки
    private Role role;
}
