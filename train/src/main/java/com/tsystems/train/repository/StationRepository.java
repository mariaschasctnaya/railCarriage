package com.tsystems.train.repository;

import com.tsystems.train.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StationRepository extends JpaRepository <Station, String> {

    Station findByName(String name);
    List<Station> findByNameIsLike(String name);
}
