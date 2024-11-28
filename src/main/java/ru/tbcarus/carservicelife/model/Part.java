package ru.tbcarus.carservicelife.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "parts")
public class Part extends AbstractBaseEntity {
    private String name;

    @Min(value = 5000, message = "Интервал замены не может быть менее 5000 км")
    @Column(name = "interval_dist", columnDefinition = "integer default 10000")
    private Integer intervalDist;
    private Integer prolongation; // продление ресурса детали по пробегу (только по пробегу)

    @Min(value = 1, message = "Инетрвал замены не может быть менее 1 года")
    @Column(name = "interval_date", columnDefinition = "integer default 25")
    private Integer intervalDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "part_id")
    private List<Replacement> replacements;

    @ManyToOne
    @JoinColumn(name = "carSystem_id")
    CarSystem carSystem;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
