package org.example.project_1.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "groups")
public class Group extends BaseEntity {

    private String name;

    @Builder
    public Group(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
