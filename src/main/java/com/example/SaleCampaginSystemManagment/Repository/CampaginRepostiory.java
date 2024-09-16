package com.example.SaleCampaginSystemManagment.Repository;

import com.example.SaleCampaginSystemManagment.model.Campagin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaginRepostiory extends JpaRepository<Campagin,Integer> {
}
