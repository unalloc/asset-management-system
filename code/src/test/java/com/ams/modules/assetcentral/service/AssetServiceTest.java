package com.ams.modules.assetcentral.service;

import com.ams.exception.ResourceNotFoundException;
import com.ams.exception.ValidationException;
import com.ams.modules.assetcentral.dto.CreateAssetRequest;
import com.ams.modules.assetcentral.dto.UpdateAssetRequest;
import com.ams.modules.assetcentral.entity.Asset;
import com.ams.modules.assetcentral.repository.AssetRepository;
import com.ams.modules.assetcentral.service.impl.AssetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssetServiceTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private AssetServiceImpl assetService;

    private Asset testAsset;
    private CreateAssetRequest createRequest;

    @BeforeEach
    void setUp() {
        testAsset = new Asset();
        testAsset.setId(1L);
        testAsset.setAssetNumber("AST-001");
        testAsset.setName("Test Asset");
        testAsset.setDescription("Test Description");
        testAsset.setSerialNumber("SN12345");
        testAsset.setAssetType("EQUIPMENT");
        testAsset.setCategory("Machinery");
        testAsset.setManufacturer("TestCorp");
        testAsset.setModel("Model-X");
        testAsset.setPurchaseCost(new BigDecimal("10000.00"));
        testAsset.setBookValue(new BigDecimal("8000.00"));
        testAsset.setStatus("ACTIVE");
        testAsset.setLocation("Building A");

        createRequest = new CreateAssetRequest();
        createRequest.setAssetNumber("AST-001");
        createRequest.setName("Test Asset");
        createRequest.setDescription("Test Description");
        createRequest.setSerialNumber("SN12345");
        createRequest.setAssetType("EQUIPMENT");
        createRequest.setCategory("Machinery");
        createRequest.setManufacturer("TestCorp");
        createRequest.setModel("Model-X");
        createRequest.setPurchaseCost(new BigDecimal("10000.00"));
        createRequest.setBookValue(new BigDecimal("8000.00"));
        createRequest.setStatus("ACTIVE");
        createRequest.setLocation("Building A");
    }

    @Test
    void create_ShouldCreateAsset_WhenAssetNumberDoesNotExist() {
        when(assetRepository.existsByAssetNumber(createRequest.getAssetNumber())).thenReturn(false);
        when(assetRepository.save(any(Asset.class))).thenReturn(testAsset);

        Asset result = assetService.create(createRequest);

        assertNotNull(result);
        assertEquals("AST-001", result.getAssetNumber());
        verify(assetRepository).save(any(Asset.class));
    }

    @Test
    void create_ShouldThrowException_WhenAssetNumberExists() {
        when(assetRepository.existsByAssetNumber(createRequest.getAssetNumber())).thenReturn(true);

        assertThrows(ValidationException.class, () -> assetService.create(createRequest));
        verify(assetRepository, never()).save(any(Asset.class));
    }

    @Test
    void findById_ShouldReturnAsset_WhenExists() {
        when(assetRepository.findById(1L)).thenReturn(Optional.of(testAsset));

        Optional<Asset> result = assetService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("AST-001", result.get().getAssetNumber());
    }

    @Test
    void findById_ShouldReturnEmpty_WhenNotExists() {
        when(assetRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<Asset> result = assetService.findById(999L);

        assertFalse(result.isPresent());
    }

    @Test
    void update_ShouldUpdateAsset_WhenExists() {
        UpdateAssetRequest updateRequest = new UpdateAssetRequest();
        updateRequest.setName("Updated Asset Name");
        updateRequest.setLocation("Building B");

        when(assetRepository.findById(1L)).thenReturn(Optional.of(testAsset));
        when(assetRepository.save(any(Asset.class))).thenReturn(testAsset);

        Asset result = assetService.update(1L, updateRequest);

        assertNotNull(result);
        verify(assetRepository).save(any(Asset.class));
    }

    @Test
    void findAll_ShouldReturnAllAssets() {
        Asset asset2 = new Asset();
        asset2.setId(2L);
        asset2.setAssetNumber("AST-002");
        asset2.setName("Test Asset 2");

        when(assetRepository.findAll()).thenReturn(Arrays.asList(testAsset, asset2));

        List<Asset> result = assetService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void search_ShouldReturnMatchingAssets() {
        Asset asset2 = new Asset();
        asset2.setId(2L);
        asset2.setAssetNumber("AST-002");
        asset2.setName("Different Asset");
        asset2.setLocation("Building B");

        when(assetRepository.findAll()).thenReturn(Arrays.asList(testAsset, asset2));

        List<Asset> result = assetService.search("Test");

        assertEquals(1, result.size());
        assertEquals("Test Asset", result.get(0).getName());
    }

    @Test
    void delete_ShouldDeleteAsset_WhenExists() {
        doNothing().when(assetRepository).deleteById(1L);

        assetService.delete(1L);

        verify(assetRepository).deleteById(1L);
    }
}
