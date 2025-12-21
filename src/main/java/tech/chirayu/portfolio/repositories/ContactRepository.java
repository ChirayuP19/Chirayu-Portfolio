package tech.chirayu.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.chirayu.portfolio.entity.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

	boolean existsByEmail(String email);
}
