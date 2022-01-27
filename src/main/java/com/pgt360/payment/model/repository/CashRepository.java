package com.pgt360.payment.model.repository;

import com.pgt360.payment.model.entity.Cash;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("CashRepository")
public interface CashRepository extends CrudRepository<Cash, Long>{
    @Query(value = "select count(c) from Cash c where c.state=?1")
    Long getCountCashByState(String pState);

    @Query(value = "select c from Cash c where c.state=?1")
    List<Cash> getCashPageableByState(String pState, Pageable pPageable);

    @Query(value = "select c from Cash c where c.state=?1")
    List<Cash> getCashByState(String pState);

    @Query(value = "select c from Cash c where c.id = ?1 and c.state=?2")
    Optional<Cash> getCashByIdAndState(long pCashId, String pState);

    @Query(value = "select c from Cash c where c.id = ?1")
    Optional<Cash> getCashById(long pCashId);
}
