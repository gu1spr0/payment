package com.pgt360.payment.model.repository;

import com.pgt360.payment.model.entity.Domain;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("DomainRepository")
public interface DomainRepository extends CrudRepository<Domain, Long> {
    @Query(value = "select count(d) from Domain d where d.state=?1")
    Long getCountDomainsByState(String pState);

    @Query(value = "select d from Domain d where d.state=?1")
    List<Domain> getDomainsPageableByState(String pState, Pageable pPageable);

    @Query(value = "select d from Domain d where d.state=?1")
    List<Domain> getDomainsByState(String pState);

    @Query(value = "select d from Domain d where d.id = ?1 and d.state=?2")
    Optional<Domain> getDomainByIdAndState(long pDomainId, String pState);

    @Query(value = "select d from Domain d where d.id = ?1")
    Optional<Domain> getDomainById(long pDomainId);

    @Query(value = "select d from Domain d where d.domainCode like ?1")
    Optional<Domain> getDomainByCodeDomain(String pCodeDomain);
}
