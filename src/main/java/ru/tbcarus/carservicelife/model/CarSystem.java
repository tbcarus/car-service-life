package ru.tbcarus.carservicelife.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "car_systems")
public class CarSystem extends AbstractBaseEntity {

    @Size(min = 1, max = 100, message = "Название системы должно быть от 1 до 100 символов")
    private String name;

}

