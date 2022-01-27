package com.pgt360.payment.model.repository;

import com.pgt360.payment.model.entity.Domain;
import com.pgt360.payment.model.entity.Flow;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("FlowRepository")
public interface FlowRepository extends CrudRepository<Flow, Long> {
    @Query(value = "select count(f) from Flow f where f.state=?1")
    Long getCountFlowByState(String pState);

    @Query(value = "select f from Flow f where f.state=?1")
    List<Flow> getFlowsPageableByState(String pState, Pageable pPageable);

    @Query(value = "select f from Flow f where f.state=?1")
    List<Flow> getFlowsByState(String pState);

    @Query(value = "select f from Flow f where f.id = ?1 and f.state=?2")
    Optional<Flow> getFlowByIdAndState(long pFlowId, String pState);

    @Query(value = "select f from Flow f where f.id = ?1")
    Optional<Flow> getFlowById(long pFlowId);
}
