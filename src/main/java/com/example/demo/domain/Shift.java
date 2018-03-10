package com.example.demo.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "users")
@EqualsAndHashCode(of = {"startedDate", "finishedDate"})
@Builder

@Entity
@Table(name = "shift")
public class Shift {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Getter @Setter
    @Column(name = "started", nullable = false)
    private LocalDateTime startedDate;
    @Getter @Setter
    @Column(name = "finished", nullable = false)
    private LocalDateTime finishedDate;
    @Getter @Builder.Default
    @ManyToMany(mappedBy = "shifts")
    private List<User> users = new ArrayList<>();
}
