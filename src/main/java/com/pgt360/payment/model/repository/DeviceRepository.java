package com.pgt360.payment.model.repository;

import com.pgt360.payment.model.entity.Device;
import com.pgt360.payment.model.entity.Domain;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("DeviceRepository")
public interface DeviceRepository extends CrudRepository<Device, Long> {
    @Query(value = "select count(d) from Device d where d.state=?1")
    Long getCountDeviceByState(String pState);

    @Query(value = "select d from Device d where d.state=?1")
    List<Device> getDevicesPageableByState(String pState, Pageable pPageable);

    @Query(value = "select d from Device d where d.state=?1")
    List<Device> getDevicesByState(String pState);

    @Query(value = "select d from Device d where d.id = ?1 and d.state=?2")
    Optional<Device> getDeviceByIdAndState(long pDeviceId, String pState);

    @Query(value = "select d from Device d where d.id = ?1")
    Optional<Device> getDeviceById(long pDeviceId);

}
