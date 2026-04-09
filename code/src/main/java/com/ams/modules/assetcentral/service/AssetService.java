package com.ams.modules.assetcentral.service;

import com.ams.common.BaseService;
import com.ams.modules.assetcentral.dto.CreateAssetRequest;
import com.ams.modules.assetcentral.dto.UpdateAssetRequest;
import com.ams.modules.assetcentral.entity.Asset;
import java.util.List;

public interface AssetService extends BaseService<Asset> {

    Asset create(CreateAssetRequest request);

    Asset update(Long id, UpdateAssetRequest request);

    Asset findByAssetNumber(String assetNumber);

    List<Asset> findByStatus(String status);

    List<Asset> search(String keyword);
}
