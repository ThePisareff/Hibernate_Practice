package com.pisareff;

import com.pisareff.entity.Birthday;
import com.pisareff.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static java.util.stream.Collectors.*;

class HibernateRunnerTest {

    // Примерная иллюстрация формирования SQL запроса под капотом Hibernate
    @Test
    void checkReflectionApi() {
        User user = User.builder()
                .username("pisareff@gmail.com")
                .firstName("Alexander")
                .lastName("Pisareff")
                .birthDate(new Birthday(LocalDate.of(1997, 1, 21)))
                .build();

        String sql = """
                INSERT
                INTO
                %s
                (%s)
                VALUES
                (%s)
                """;

        String tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
                .map(annotation -> annotation.schema() + "." + annotation.name())
                .orElse(user.getClass().getName());

        Field[] declaredFields = user.getClass().getDeclaredFields();

        String columnNames = Arrays.stream(declaredFields)
                .map(field -> Optional.ofNullable(field.getAnnotation(Column.class))
                        .map(Column::name)
                        .orElse(field.getName()))
                .collect(joining(" ,"));

        String columnValues = Arrays.stream(declaredFields)
                .map(field -> "?")
                .collect(joining(", "));

        System.out.println(sql.formatted(tableName, columnNames, columnValues));

//        //ПРИМЕРНОЕ построение запроса
//        Connection connection = null;
//        PreparedStatement prepareStatement = connection.prepareStatement(sql);
//        int indexOfField = 1;
//        for (Field declaredField : declaredFields){
//            declaredField.setAccessible(true);
//            prepareStatement.setObject(indexOfField, declaredField.get(user));
//            indexOfField++;
//        }

    }

}