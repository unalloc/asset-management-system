package com.ams.modules.assetcentral.service;

import com.ams.exception.ResourceNotFoundException;
import com.ams.exception.ValidationException;
import com.ams.modules.assetcentral.dto.CreateWorkOrderRequest;
import com.ams.modules.assetcentral.dto.UpdateWorkOrderRequest;
import com.ams.modules.assetcentral.entity.WorkOrder;
import com.ams.modules.assetcentral.repository.WorkOrderRepository;
import com.ams.modules.assetcentral.service.impl.WorkOrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkOrderServiceTest {

    @Mock
    private WorkOrderRepository workOrderRepository;

    @InjectMocks
    private WorkOrderServiceImpl workOrderService;

    private WorkOrder testWorkOrder;
    private CreateWorkOrderRequest createRequest;

    @BeforeEach
    void setUp() {
        testWorkOrder = new WorkOrder();
        testWorkOrder.setId(1L);
        testWorkOrder.setWorkOrderNumber("WO-001");
        testWorkOrder.setAssetId(100L);
        testWorkOrder.setDescription("Test Work Order");
        testWorkOrder.setWorkOrderType("MAINTENANCE");
        testWorkOrder.setPriority("HIGH");
        testWorkOrder.setStatus("PENDING");
        testWorkOrder.setAssignedTechnician("John Doe");
        testWorkOrder.setEstimatedHours(new BigDecimal("8.00"));
        testWorkOrder.setLaborCost(new BigDecimal("200.00"));
        testWorkOrder.setPartsCost(new BigDecimal("150.00"));

        createRequest = new CreateWorkOrderRequest();
        createRequest.setWorkOrderNumber("WO-001");
        createRequest.setAssetId(100L);
        createRequest.setDescription("Test Work Order");
        createRequest.setWorkOrderType("MAINTENANCE");
        createRequest.setPriority("HIGH");
        createRequest.setStatus("PENDING");
        createRequest.setAssignedTechnician("John Doe");
        createRequest.setEstimatedHours(new BigDecimal("8.00"));
        createRequest.setLaborCost(new BigDecimal("200.00"));
        createRequest.setPartsCost(new BigDecimal("150.00"));
    }

    @Test
    void create_ShouldCreateWorkOrder_WhenNumberDoesNotExist() {
        when(workOrderRepository.existsByWorkOrderNumber(createRequest.getWorkOrderNumber())).thenReturn(false);
        when(workOrderRepository.save(any(WorkOrder.class))).thenReturn(testWorkOrder);

        WorkOrder result = workOrderService.create(createRequest);

        assertNotNull(result);
        assertEquals("WO-001", result.getWorkOrderNumber());
        verify(workOrderRepository).save(any(WorkOrder.class));
    }

    @Test
    void create_ShouldThrowException_WhenNumberExists() {
        when(workOrderRepository.existsByWorkOrderNumber(createRequest.getWorkOrderNumber())).thenReturn(true);

        assertThrows(ValidationException.class, () -> workOrderService.create(createRequest));
        verify(workOrderRepository, never()).save(any(WorkOrder.class));
    }

    @Test
    void findById_ShouldReturnWorkOrder_WhenExists() {
        when(workOrderRepository.findById(1L)).thenReturn(Optional.of(testWorkOrder));

        Optional<WorkOrder> result = workOrderService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("WO-001", result.get().getWorkOrderNumber());
    }

    @Test
    void findById_ShouldReturnEmpty_WhenNotExists() {
        when(workOrderRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<WorkOrder> result = workOrderService.findById(999L);

        assertFalse(result.isPresent());
    }

    @Test
    void updateStatus_ShouldUpdateStatus() {
        when(workOrderRepository.findById(1L)).thenReturn(Optional.of(testWorkOrder));
        when(workOrderRepository.save(any(WorkOrder.class))).thenReturn(testWorkOrder);

        WorkOrder result = workOrderService.updateStatus(1L, "IN_PROGRESS");

        assertNotNull(result);
        verify(workOrderRepository).save(any(WorkOrder.class));
    }

    @Test
    void complete_ShouldSetStatusToCompleted() {
        when(workOrderRepository.findById(1L)).thenReturn(Optional.of(testWorkOrder));
        when(workOrderRepository.save(any(WorkOrder.class))).thenReturn(testWorkOrder);

        WorkOrder result = workOrderService.complete(1L);

        assertNotNull(result);
        assertEquals("COMPLETED", result.getStatus());
        assertNotNull(result.getActualEndDate());
    }

    @Test
    void findByAssetId_ShouldReturnWorkOrdersForAsset() {
        WorkOrder wo2 = new WorkOrder();
        wo2.setId(2L);
        wo2.setWorkOrderNumber("WO-002");
        wo2.setAssetId(100L);
        wo2.setDescription("Second Work Order");

        when(workOrderRepository.findByAssetId(100L)).thenReturn(Arrays.asList(testWorkOrder, wo2));

        List<WorkOrder> result = workOrderService.findByAssetId(100L);

        assertEquals(2, result.size());
    }

    @Test
    void findByStatus_ShouldReturnWorkOrdersWithStatus() {
        when(workOrderRepository.findByStatus("PENDING")).thenReturn(Arrays.asList(testWorkOrder));

        List<WorkOrder> result = workOrderService.findByStatus("PENDING");

        assertEquals(1, result.size());
        assertEquals("PENDING", result.get(0).getStatus());
    }
}
