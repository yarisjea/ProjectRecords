package com.azurian.recordsws.repository;

import com.azurian.recordsws.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yarismel Correa
 **/

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
