package com.ams.modules.assetcentral.repository;

import com.ams.common.BaseRepository;
import com.ams.modules.assetcentral.entity.Asset;
import java.util.Optional;

public interface AssetRepository extends BaseRepository<Asset> {

    Optional<Asset> findByAssetNumber(String assetNumber);

    boolean existsByAssetNumber(String assetNumber);
}
