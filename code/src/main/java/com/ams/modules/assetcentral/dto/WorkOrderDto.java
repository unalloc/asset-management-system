package com.ams.modules.assetcentral.dto;

import com.ams.modules.assetcentral.entity.WorkOrder;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WorkOrderDto {

    private Long id;
    private String workOrderNumber;
    private Long assetId;
    private String assetName;
    private String description;
    private String workOrderType;
    private String priority;
    private String status;
    private String assignedTechnician;
    private LocalDateTime scheduledStartDate;
    private LocalDateTime scheduledEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;
    private BigDecimal estimatedHours;
    private BigDecimal actualHours;
    private BigDecimal laborCost;
    private BigDecimal partsCost;
    private BigDecimal totalCost;
    private String workOrderSource;
    private String failureCode;
    private String rootCause;
    private String resolutionNotes;
    private BigDecimal assetDowntimeHours;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;

    public static WorkOrderDto toDto(WorkOrder workOrder) {
        WorkOrderDto dto = new WorkOrderDto();
        dto.setId(workOrder.getId());
        dto.setWorkOrderNumber(workOrder.getWorkOrderNumber());
        dto.setAssetId(workOrder.getAssetId());
        dto.setDescription(workOrder.getDescription());
        dto.setWorkOrderType(workOrder.getWorkOrderType());
        dto.setPriority(workOrder.getPriority());
        dto.setStatus(workOrder.getStatus());
        dto.setAssignedTechnician(workOrder.getAssignedTechnician());
        dto.setScheduledStartDate(workOrder.getScheduledStartDate());
        dto.setScheduledEndDate(workOrder.getScheduledEndDate());
        dto.setActualStartDate(workOrder.getActualStartDate());
        dto.setActualEndDate(workOrder.getActualEndDate());
        dto.setEstimatedHours(workOrder.getEstimatedHours());
        dto.setActualHours(workOrder.getActualHours());
        dto.setLaborCost(workOrder.getLaborCost());
        dto.setPartsCost(workOrder.getPartsCost());
        dto.setTotalCost(workOrder.getTotalCost());
        dto.setWorkOrderSource(workOrder.getWorkOrderSource());
        dto.setFailureCode(workOrder.getFailureCode());
        dto.setRootCause(workOrder.getRootCause());
        dto.setResolutionNotes(workOrder.getResolutionNotes());
        dto.setAssetDowntimeHours(workOrder.getAssetDowntimeHours());
        dto.setCreatedAt(workOrder.getCreatedAt());
        dto.setUpdatedAt(workOrder.getUpdatedAt());
        dto.setCreatedBy(workOrder.getCreatedBy());
        dto.setUpdatedBy(workOrder.getUpdatedBy());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(String workOrderType) {
        this.workOrderType = workOrderType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTechnician() {
        return assignedTechnician;
    }

    public void setAssignedTechnician(String assignedTechnician) {
        this.assignedTechnician = assignedTechnician;
    }

    public LocalDateTime getScheduledStartDate() {
        return scheduledStartDate;
    }

    public void setScheduledStartDate(LocalDateTime scheduledStartDate) {
        this.scheduledStartDate = scheduledStartDate;
    }

    public LocalDateTime getScheduledEndDate() {
        return scheduledEndDate;
    }

    public void setScheduledEndDate(LocalDateTime scheduledEndDate) {
        this.scheduledEndDate = scheduledEndDate;
    }

    public LocalDateTime getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(LocalDateTime actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public LocalDateTime getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(LocalDateTime actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public BigDecimal getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(BigDecimal estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public BigDecimal getActualHours() {
        return actualHours;
    }

    public void setActualHours(BigDecimal actualHours) {
        this.actualHours = actualHours;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(BigDecimal partsCost) {
        this.partsCost = partsCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getWorkOrderSource() {
        return workOrderSource;
    }

    public void setWorkOrderSource(String workOrderSource) {
        this.workOrderSource = workOrderSource;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getRootCause() {
        return rootCause;
    }

    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }

    public String getResolutionNotes() {
        return resolutionNotes;
    }

    public void setResolutionNotes(String resolutionNotes) {
        this.resolutionNotes = resolutionNotes;
    }

    public BigDecimal getAssetDowntimeHours() {
        return assetDowntimeHours;
    }

    public void setAssetDowntimeHours(BigDecimal assetDowntimeHours) {
        this.assetDowntimeHours = assetDowntimeHours;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
