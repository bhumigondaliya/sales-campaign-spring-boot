package com.example.SaleCampaginSystemManagment.Repository;

import com.example.SaleCampaginSystemManagment.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {
}
