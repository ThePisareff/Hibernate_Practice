package com.pisareff.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Embeddable // Объявляем что данный класс встраиваемый компонент
public class PersonalInfo {
    //    @Convert(converter = BirthdayConverter.class) // Обозначаем конвертер для пользовательского типа (1 способ). Лучше писать иначе IDEA орёт
    //@Column(name = "birth_date") // Маппим поле на колонку в таблице вручную -> перенёс в другой механизм embeddable
    private Birthday birthDate;
    private String firstName;
    private String lastName;

}
