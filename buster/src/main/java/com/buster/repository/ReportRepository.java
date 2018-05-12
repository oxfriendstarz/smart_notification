package com.buster.repository;

import com.buster.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ramon on 5/12/2018.
 */
@Transactional
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByUsername(String username);
}