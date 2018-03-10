package com.example.demo.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "shifts")
@EqualsAndHashCode(of = {"name", "password"})
@Builder
@Entity
@Table(name = "user_details")
public class User {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Getter @Setter
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "password", unique = true, nullable = false)
    @Getter @Setter
    private String password;
    @CreationTimestamp
    @Column(name = "created")
    private Date creationDate;
    @Getter @Builder.Default
    @ManyToMany
    List<Shift> shifts = new ArrayList<>();
}
