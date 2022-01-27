package com.pgt360.payment.model.repository;

import com.pgt360.payment.model.entity.DomainValue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("DomainValueRepository")
public interface DomainValueRepository extends CrudRepository<DomainValue, Long> {
    @Query(value = "select count(d) from DomainValue d where d.domain.id=?1 AND d.state=?2")
    Long getCountDomainsValuesByIdAndState(Long pDomainId, String pState);

    @Query(value = "select d from DomainValue d where d.domain.id=?1 AND d.state=?2")
    List<DomainValue> getDomainsValuesPageableByIdAndState(Long pDomainId, String pState, Pageable pPageable);

    @Query(value = "select d from DomainValue d where d.id = ?1")
    Optional<DomainValue> getDomainValueById(long pDomainValueId);

    @Query(value = "select d from DomainValue d where d.domain.id = ?1")
    List<DomainValue> getDomainValueByDomainId(long pDomainId);

    @Query(value = "select d from DomainValue d where d.domain.domainCode = ?1 and d.state = ?2")
    List<DomainValue> getDomainValueByDomainCodeAndState(String pDomainCode, String pState);

    @Query(value = "select d from DomainValue d where d.domain.domainCode = ?1 and d.charValueExtra=?2 and d.state = ?3")
    List<DomainValue> getDomainValueByDomainCodeAndCharValueExtraAndState(String pDomainCode, String pCharValueExtra, String pState);

    @Query(value = "select distinct d from DomainValue  d where d.domain.id = ?1 and d.codeValue = ?2")
    Optional<DomainValue> getDomainValueByDomainIdAndCodeValue(long pDomainId, String pCodeValue);

    @Query(value = "select d from DomainValue d where d.domain.domainCode=?1 and d.codeValue=?2 and d.state=?3")
    Optional<DomainValue> getDomainValueByDomainCodeAndCodeValue(String pDomainCode, String pCodeValue, String pState);

    @Query(value = "select d from DomainValue d where d.domain.domainCode=?1 and d.charValue=?2 and d.state=?3")
    Optional<DomainValue> getDomainValueByDomainCodeAndCharValue(String pDomainCode, String pCodeValue, String pState);

    @Query(value = "select d from DomainValue d where d.domain.domainCode = ?1 and d.charValue=?2 and d.state = ?3")
    List<DomainValue> getDomainValueByDomainCodeAndCharValueAndState(String pDomainCode, String pCharValue, String pState);

    @Query(value = "select d from DomainValue d where d.domain.domainType=?1 and d.state = ?2")
    Optional<List<DomainValue>> getDomainValueByDomainAndState(String pTypeDomain, String pState);

    @Query(value = "select count(d) from DomainValue d where d.domain.domainCode=?1 and d.state=?2")
    Long getCountDomainsValuesByCodeValue(String pDomainCode, String pState);

    @Query(value = "select d from DomainValue d where d.id in ?1 order by d.charValue")
    List<DomainValue> getDomainValuesByIds(Long[] pDomainValueIds);

    @Query(value = "select d from DomainValue d where d.domain.domainCode=?1 and d.codeValue in ?2 and d.state=?3 order by d.charValue")
    List<DomainValue> getDomainValuesByDomainAndCodeValues(String pDomainCode, String[] pCodeValues, String pState);
}
