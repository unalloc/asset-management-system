package com.ams.modules.assetcentral.service.impl;

import com.ams.common.BaseRepository;
import com.ams.common.BaseServiceImpl;
import com.ams.exception.ResourceNotFoundException;
import com.ams.exception.ValidationException;
import com.ams.modules.assetcentral.dto.CreateAssetRequest;
import com.ams.modules.assetcentral.dto.UpdateAssetRequest;
import com.ams.modules.assetcentral.entity.Asset;
import com.ams.modules.assetcentral.repository.AssetRepository;
import com.ams.modules.assetcentral.service.AssetService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl extends BaseServiceImpl<Asset> implements AssetService {

    private final AssetRepository assetRepository;

    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    protected BaseRepository<Asset> getRepository() {
        return assetRepository;
    }

    @Override
    public Asset create(CreateAssetRequest request) {
        if (assetRepository.existsByAssetNumber(request.getAssetNumber())) {
            throw new ValidationException("Asset number already exists: " + request.getAssetNumber());
        }

        Asset asset = new Asset();
        asset.setAssetNumber(request.getAssetNumber());
        asset.setName(request.getName());
        asset.setDescription(request.getDescription());
        asset.setSerialNumber(request.getSerialNumber());
        asset.setAssetType(request.getAssetType());
        asset.setCategory(request.getCategory());
        asset.setManufacturer(request.getManufacturer());
        asset.setModel(request.getModel());
        asset.setManufactureDate(request.getManufactureDate());
        asset.setPurchaseDate(request.getPurchaseDate());
        asset.setPurchaseCost(request.getPurchaseCost());
        asset.setBookValue(request.getBookValue());
        asset.setResidualValue(request.getResidualValue());
        asset.setUsefulLifeYears(request.getUsefulLifeYears());
        asset.setDepreciationMethod(request.getDepreciationMethod());
        asset.setStatus(request.getStatus() != null ? request.getStatus() : "ACTIVE");
        asset.setLocation(request.getLocation());
        asset.setCriticality(request.getCriticality());
        asset.setBarcode(request.getBarcode());
        asset.setQrCode(request.getQrCode());
        asset.setRfidTag(request.getRfidTag());
        asset.setWarrantyExpiry(request.getWarrantyExpiry());
        asset.setNotes(request.getNotes());

        return assetRepository.save(asset);
    }

    @Override
    public Asset update(Long id, UpdateAssetRequest request) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset", id));

        if (request.getAssetNumber() != null) {
            if (!request.getAssetNumber().equals(asset.getAssetNumber()) &&
                assetRepository.existsByAssetNumber(request.getAssetNumber())) {
                throw new ValidationException("Asset number already exists: " + request.getAssetNumber());
            }
            asset.setAssetNumber(request.getAssetNumber());
        }

        if (request.getName() != null) {
            asset.setName(request.getName());
        }
        if (request.getDescription() != null) {
            asset.setDescription(request.getDescription());
        }
        if (request.getSerialNumber() != null) {
            asset.setSerialNumber(request.getSerialNumber());
        }
        if (request.getAssetType() != null) {
            asset.setAssetType(request.getAssetType());
        }
        if (request.getCategory() != null) {
            asset.setCategory(request.getCategory());
        }
        if (request.getManufacturer() != null) {
            asset.setManufacturer(request.getManufacturer());
        }
        if (request.getModel() != null) {
            asset.setModel(request.getModel());
        }
        if (request.getManufactureDate() != null) {
            asset.setManufactureDate(request.getManufactureDate());
        }
        if (request.getPurchaseDate() != null) {
            asset.setPurchaseDate(request.getPurchaseDate());
        }
        if (request.getPurchaseCost() != null) {
            asset.setPurchaseCost(request.getPurchaseCost());
        }
        if (request.getBookValue() != null) {
            asset.setBookValue(request.getBookValue());
        }
        if (request.getResidualValue() != null) {
            asset.setResidualValue(request.getResidualValue());
        }
        if (request.getUsefulLifeYears() != null) {
            asset.setUsefulLifeYears(request.getUsefulLifeYears());
        }
        if (request.getDepreciationMethod() != null) {
            asset.setDepreciationMethod(request.getDepreciationMethod());
        }
        if (request.getStatus() != null) {
            asset.setStatus(request.getStatus());
        }
        if (request.getLocation() != null) {
            asset.setLocation(request.getLocation());
        }
        if (request.getCriticality() != null) {
            asset.setCriticality(request.getCriticality());
        }
        if (request.getBarcode() != null) {
            asset.setBarcode(request.getBarcode());
        }
        if (request.getQrCode() != null) {
            asset.setQrCode(request.getQrCode());
        }
        if (request.getRfidTag() != null) {
            asset.setRfidTag(request.getRfidTag());
        }
        if (request.getWarrantyExpiry() != null) {
            asset.setWarrantyExpiry(request.getWarrantyExpiry());
        }
        if (request.getNotes() != null) {
            asset.setNotes(request.getNotes());
        }

        return assetRepository.save(asset);
    }

    @Override
    public Asset findByAssetNumber(String assetNumber) {
        return assetRepository.findByAssetNumber(assetNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with asset number: " + assetNumber));
    }

    @Override
    public List<Asset> findByStatus(String status) {
        return assetRepository.findAll().stream()
                .filter(asset -> status.equalsIgnoreCase(asset.getStatus()))
                .toList();
    }

    @Override
    public List<Asset> search(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return assetRepository.findAll().stream()
                .filter(asset -> 
                    (asset.getName() != null && asset.getName().toLowerCase().contains(lowerKeyword)) ||
                    (asset.getAssetNumber() != null && asset.getAssetNumber().toLowerCase().contains(lowerKeyword)) ||
                    (asset.getSerialNumber() != null && asset.getSerialNumber().toLowerCase().contains(lowerKeyword)) ||
                    (asset.getLocation() != null && asset.getLocation().toLowerCase().contains(lowerKeyword))
                )
                .toList();
    }
}
