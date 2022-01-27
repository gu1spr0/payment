package com.pgt360.payment.model.repository;

import com.pgt360.payment.model.entity.Commerce;
import com.pgt360.payment.model.entity.Domain;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("CommerceRepository")
public interface CommerceRepository extends CrudRepository<Commerce, Long> {
    @Query(value = "select count(c) from Commerce c where c.state=?1")
    Long getCountCommerceByState(String pState);

    @Query(value = "select c from Commerce c where c.state=?1")
    List<Commerce> getCommercePageableByState(String pState, Pageable pPageable);

    @Query(value = "select c from Commerce c where c.state=?1")
    List<Commerce> getCommerceByState(String pState);

    @Query(value = "select c from Commerce c where c.id = ?1 and c.state=?2")
    Optional<Commerce> getCommerceByIdAndState(long pCommerceId, String pState);

    @Query(value = "select c from Commerce c where c.id = ?1")
    Optional<Commerce> getCommerceById(long pCommerceId);
}
