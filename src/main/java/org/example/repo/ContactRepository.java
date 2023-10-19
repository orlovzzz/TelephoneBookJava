package org.example.repo;

import org.example.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByNameContaining(String partialName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Contact c WHERE c.id = :id")
    void deleteContactById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Contact c SET c.name = :name WHERE c.id = :id")
    void updateNameById(@Param("id") Long id, @Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Contact c SET c.number = :number WHERE c.id = :id")
    void updateNumberById(@Param("id") Long id, @Param("number") String number);
}