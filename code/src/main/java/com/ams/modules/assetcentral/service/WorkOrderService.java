package com.ams.modules.assetcentral.service;

import com.ams.common.BaseService;
import com.ams.modules.assetcentral.dto.CreateWorkOrderRequest;
import com.ams.modules.assetcentral.dto.UpdateWorkOrderRequest;
import com.ams.modules.assetcentral.entity.WorkOrder;
import java.util.List;

public interface WorkOrderService extends BaseService<WorkOrder> {

    WorkOrder create(CreateWorkOrderRequest request);

    WorkOrder update(Long id, UpdateWorkOrderRequest request);

    WorkOrder findByWorkOrderNumber(String workOrderNumber);

    List<WorkOrder> findByAssetId(Long assetId);

    List<WorkOrder> findByStatus(String status);

    WorkOrder updateStatus(Long id, String status);

    WorkOrder complete(Long id);
}
