package com.ams.modules.assetcentral.repository;

import com.ams.common.BaseRepository;
import com.ams.modules.assetcentral.entity.WorkOrder;
import java.util.List;
import java.util.Optional;

public interface WorkOrderRepository extends BaseRepository<WorkOrder> {

    Optional<WorkOrder> findByWorkOrderNumber(String workOrderNumber);

    boolean existsByWorkOrderNumber(String workOrderNumber);

    List<WorkOrder> findByAssetId(Long assetId);

    List<WorkOrder> findByStatus(String status);
}
