package com.sooft.test.repository;

import com.sooft.test.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepositoryImpl extends CompanyRepository, JpaRepository<Company, Long> {

    Optional<Company> findById(Long id);

    List<Company> findAllByIdIn(List<Long> companyIds);

}
