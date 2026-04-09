package com.ams.modules.assetcentral.service.impl;

import com.ams.common.BaseRepository;
import com.ams.common.BaseServiceImpl;
import com.ams.exception.ResourceNotFoundException;
import com.ams.exception.ValidationException;
import com.ams.modules.assetcentral.dto.CreateWorkOrderRequest;
import com.ams.modules.assetcentral.dto.UpdateWorkOrderRequest;
import com.ams.modules.assetcentral.entity.WorkOrder;
import com.ams.modules.assetcentral.repository.WorkOrderRepository;
import com.ams.modules.assetcentral.service.WorkOrderService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WorkOrderServiceImpl extends BaseServiceImpl<WorkOrder> implements WorkOrderService {

    private final WorkOrderRepository workOrderRepository;

    public WorkOrderServiceImpl(WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
    }

    @Override
    protected BaseRepository<WorkOrder> getRepository() {
        return workOrderRepository;
    }

    @Override
    public WorkOrder create(CreateWorkOrderRequest request) {
        if (workOrderRepository.existsByWorkOrderNumber(request.getWorkOrderNumber())) {
            throw new ValidationException("Work order number already exists: " + request.getWorkOrderNumber());
        }

        WorkOrder workOrder = new WorkOrder();
        workOrder.setWorkOrderNumber(request.getWorkOrderNumber());
        workOrder.setAssetId(request.getAssetId());
        workOrder.setDescription(request.getDescription());
        workOrder.setWorkOrderType(request.getWorkOrderType());
        workOrder.setPriority(request.getPriority() != null ? request.getPriority() : "MEDIUM");
        workOrder.setStatus(request.getStatus() != null ? request.getStatus() : "PENDING");
        workOrder.setAssignedTechnician(request.getAssignedTechnician());
        workOrder.setScheduledStartDate(request.getScheduledStartDate());
        workOrder.setScheduledEndDate(request.getScheduledEndDate());
        workOrder.setActualStartDate(request.getActualStartDate());
        workOrder.setActualEndDate(request.getActualEndDate());
        workOrder.setEstimatedHours(request.getEstimatedHours());
        workOrder.setActualHours(request.getActualHours());
        workOrder.setLaborCost(request.getLaborCost());
        workOrder.setPartsCost(request.getPartsCost());
        workOrder.setTotalCost(request.getTotalCost());
        workOrder.setWorkOrderSource(request.getWorkOrderSource());
        workOrder.setFailureCode(request.getFailureCode());
        workOrder.setRootCause(request.getRootCause());
        workOrder.setResolutionNotes(request.getResolutionNotes());
        workOrder.setAssetDowntimeHours(request.getAssetDowntimeHours());

        return workOrderRepository.save(workOrder);
    }

    @Override
    public WorkOrder update(Long id, UpdateWorkOrderRequest request) {
        WorkOrder workOrder = workOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WorkOrder", id));

        if (request.getWorkOrderNumber() != null) {
            if (!request.getWorkOrderNumber().equals(workOrder.getWorkOrderNumber()) &&
                workOrderRepository.existsByWorkOrderNumber(request.getWorkOrderNumber())) {
                throw new ValidationException("Work order number already exists: " + request.getWorkOrderNumber());
            }
            workOrder.setWorkOrderNumber(request.getWorkOrderNumber());
        }

        if (request.getAssetId() != null) {
            workOrder.setAssetId(request.getAssetId());
        }
        if (request.getDescription() != null) {
            workOrder.setDescription(request.getDescription());
        }
        if (request.getWorkOrderType() != null) {
            workOrder.setWorkOrderType(request.getWorkOrderType());
        }
        if (request.getPriority() != null) {
            workOrder.setPriority(request.getPriority());
        }
        if (request.getStatus() != null) {
            workOrder.setStatus(request.getStatus());
        }
        if (request.getAssignedTechnician() != null) {
            workOrder.setAssignedTechnician(request.getAssignedTechnician());
        }
        if (request.getScheduledStartDate() != null) {
            workOrder.setScheduledStartDate(request.getScheduledStartDate());
        }
        if (request.getScheduledEndDate() != null) {
            workOrder.setScheduledEndDate(request.getScheduledEndDate());
        }
        if (request.getActualStartDate() != null) {
            workOrder.setActualStartDate(request.getActualStartDate());
        }
        if (request.getActualEndDate() != null) {
            workOrder.setActualEndDate(request.getActualEndDate());
        }
        if (request.getEstimatedHours() != null) {
            workOrder.setEstimatedHours(request.getEstimatedHours());
        }
        if (request.getActualHours() != null) {
            workOrder.setActualHours(request.getActualHours());
        }
        if (request.getLaborCost() != null) {
            workOrder.setLaborCost(request.getLaborCost());
        }
        if (request.getPartsCost() != null) {
            workOrder.setPartsCost(request.getPartsCost());
        }
        if (request.getTotalCost() != null) {
            workOrder.setTotalCost(request.getTotalCost());
        }
        if (request.getWorkOrderSource() != null) {
            workOrder.setWorkOrderSource(request.getWorkOrderSource());
        }
        if (request.getFailureCode() != null) {
            workOrder.setFailureCode(request.getFailureCode());
        }
        if (request.getRootCause() != null) {
            workOrder.setRootCause(request.getRootCause());
        }
        if (request.getResolutionNotes() != null) {
            workOrder.setResolutionNotes(request.getResolutionNotes());
        }
        if (request.getAssetDowntimeHours() != null) {
            workOrder.setAssetDowntimeHours(request.getAssetDowntimeHours());
        }

        return workOrderRepository.save(workOrder);
    }

    @Override
    public WorkOrder findByWorkOrderNumber(String workOrderNumber) {
        return workOrderRepository.findByWorkOrderNumber(workOrderNumber)
                .orElseThrow(() -> new ResourceNotFoundException("WorkOrder not found with work order number: " + workOrderNumber));
    }

    @Override
    public List<WorkOrder> findByAssetId(Long assetId) {
        return workOrderRepository.findByAssetId(assetId);
    }

    @Override
    public List<WorkOrder> findByStatus(String status) {
        return workOrderRepository.findByStatus(status);
    }

    @Override
    public WorkOrder updateStatus(Long id, String status) {
        WorkOrder workOrder = workOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WorkOrder", id));
        workOrder.setStatus(status);
        return workOrderRepository.save(workOrder);
    }

    @Override
    public WorkOrder complete(Long id) {
        WorkOrder workOrder = workOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WorkOrder", id));
        workOrder.setStatus("COMPLETED");
        workOrder.setActualEndDate(LocalDateTime.now());

        BigDecimal laborCost = workOrder.getLaborCost() != null ? workOrder.getLaborCost() : BigDecimal.ZERO;
        BigDecimal partsCost = workOrder.getPartsCost() != null ? workOrder.getPartsCost() : BigDecimal.ZERO;
        workOrder.setTotalCost(laborCost.add(partsCost));

        return workOrderRepository.save(workOrder);
    }
}
