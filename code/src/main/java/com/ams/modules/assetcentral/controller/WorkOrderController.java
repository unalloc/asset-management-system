package com.ams.modules.assetcentral.controller;

import com.ams.common.dto.ApiResponse;
import com.ams.modules.assetcentral.dto.WorkOrderDto;
import com.ams.modules.assetcentral.dto.CreateWorkOrderRequest;
import com.ams.modules.assetcentral.dto.UpdateWorkOrderRequest;
import com.ams.modules.assetcentral.entity.WorkOrder;
import com.ams.modules.assetcentral.service.WorkOrderService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/work-orders")
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<WorkOrderDto>>> getAllWorkOrders() {
        List<WorkOrderDto> workOrders = workOrderService.findAll().stream()
                .map(WorkOrderDto::toDto)
                .toList();
        return ResponseEntity.ok(ApiResponse.success(workOrders));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<WorkOrderDto>> getWorkOrderById(@PathVariable Long id) {
        WorkOrder workOrder = workOrderService.findById(id)
                .orElseThrow(() -> new com.ams.exception.ResourceNotFoundException("WorkOrder", id));
        return ResponseEntity.ok(ApiResponse.success(WorkOrderDto.toDto(workOrder)));
    }

    @GetMapping("/number/{workOrderNumber}")
    public ResponseEntity<ApiResponse<WorkOrderDto>> getWorkOrderByNumber(@PathVariable String workOrderNumber) {
        WorkOrder workOrder = workOrderService.findByWorkOrderNumber(workOrderNumber);
        return ResponseEntity.ok(ApiResponse.success(WorkOrderDto.toDto(workOrder)));
    }

    @GetMapping("/asset/{assetId}")
    public ResponseEntity<ApiResponse<List<WorkOrderDto>>> getWorkOrdersByAsset(@PathVariable Long assetId) {
        List<WorkOrderDto> workOrders = workOrderService.findByAssetId(assetId).stream()
                .map(WorkOrderDto::toDto)
                .toList();
        return ResponseEntity.ok(ApiResponse.success(workOrders));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse<List<WorkOrderDto>>> getWorkOrdersByStatus(@PathVariable String status) {
        List<WorkOrderDto> workOrders = workOrderService.findByStatus(status).stream()
                .map(WorkOrderDto::toDto)
                .toList();
        return ResponseEntity.ok(ApiResponse.success(workOrders));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<WorkOrderDto>> createWorkOrder(@Valid @RequestBody CreateWorkOrderRequest request) {
        WorkOrder workOrder = workOrderService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Work order created successfully", WorkOrderDto.toDto(workOrder)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<WorkOrderDto>> updateWorkOrder(
            @PathVariable Long id,
            @Valid @RequestBody UpdateWorkOrderRequest request) {
        WorkOrder workOrder = workOrderService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success("Work order updated successfully", WorkOrderDto.toDto(workOrder)));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<WorkOrderDto>> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        WorkOrder workOrder = workOrderService.updateStatus(id, status);
        return ResponseEntity.ok(ApiResponse.success("Work order status updated successfully", WorkOrderDto.toDto(workOrder)));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<ApiResponse<WorkOrderDto>> completeWorkOrder(@PathVariable Long id) {
        WorkOrder workOrder = workOrderService.complete(id);
        return ResponseEntity.ok(ApiResponse.success("Work order completed successfully", WorkOrderDto.toDto(workOrder)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteWorkOrder(@PathVariable Long id) {
        workOrderService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Work order deleted successfully", null));
    }
}
