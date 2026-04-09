package com.ams.modules.assetcentral.controller;

import com.ams.common.dto.ApiResponse;
import com.ams.modules.assetcentral.dto.AssetDto;
import com.ams.modules.assetcentral.dto.CreateAssetRequest;
import com.ams.modules.assetcentral.dto.UpdateAssetRequest;
import com.ams.modules.assetcentral.entity.Asset;
import com.ams.modules.assetcentral.service.AssetService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AssetDto>>> getAllAssets() {
        List<AssetDto> assets = assetService.findAll().stream()
                .map(AssetDto::toDto)
                .toList();
        return ResponseEntity.ok(ApiResponse.success(assets));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AssetDto>> getAssetById(@PathVariable Long id) {
        Asset asset = assetService.findById(id)
                .orElseThrow(() -> new com.ams.exception.ResourceNotFoundException("Asset", id));
        return ResponseEntity.ok(ApiResponse.success(AssetDto.toDto(asset)));
    }

    @GetMapping("/number/{assetNumber}")
    public ResponseEntity<ApiResponse<AssetDto>> getAssetByNumber(@PathVariable String assetNumber) {
        Asset asset = assetService.findByAssetNumber(assetNumber);
        return ResponseEntity.ok(ApiResponse.success(AssetDto.toDto(asset)));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse<List<AssetDto>>> getAssetsByStatus(@PathVariable String status) {
        List<AssetDto> assets = assetService.findByStatus(status).stream()
                .map(AssetDto::toDto)
                .toList();
        return ResponseEntity.ok(ApiResponse.success(assets));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<AssetDto>>> searchAssets(@RequestParam String keyword) {
        List<AssetDto> assets = assetService.search(keyword).stream()
                .map(AssetDto::toDto)
                .toList();
        return ResponseEntity.ok(ApiResponse.success(assets));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AssetDto>> createAsset(@Valid @RequestBody CreateAssetRequest request) {
        Asset asset = assetService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Asset created successfully", AssetDto.toDto(asset)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AssetDto>> updateAsset(
            @PathVariable Long id,
            @Valid @RequestBody UpdateAssetRequest request) {
        Asset asset = assetService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success("Asset updated successfully", AssetDto.toDto(asset)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAsset(@PathVariable Long id) {
        assetService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Asset deleted successfully", null));
    }
}
