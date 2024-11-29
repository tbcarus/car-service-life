package ru.tbcarus.carservicelife.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "replacements")
public class Replacement extends AbstractBaseEntity {
    private Integer mileage;
    private String name;
    private String partName; // название/производитель/параметры детали
    private String reason;
    private String description;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;

    @OneToOne
    @JoinColumn(name = "prev_replacement_id")
    private Replacement previousReplacement;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDate creationDate;
}
