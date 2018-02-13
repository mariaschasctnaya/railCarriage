package com.tsystems.train.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class RouteEntry {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    @ManyToOne(optional = false)
    private Station station;
    @ManyToOne(cascade = CascadeType.ALL)
    private Schedule schedule;
    @ManyToOne(cascade=CascadeType.ALL)
    private Route route;
}
