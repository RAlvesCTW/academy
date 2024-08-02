package com.ctw.workstation.rackasset.control;

import com.ctw.workstation.rack.control.RackRepository;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rackasset.entity.RackAsset;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class RackAssetService {

    @Inject
    RackAssetRepository rackAssetRepository;

    public void addRackAsset(RackAsset rackAsset) {
        rackAssetRepository.persist(rackAsset);
    }

    public List<RackAsset> getRackAssets() {
        return rackAssetRepository.listAll();
    }

    public RackAsset getRackAssetById(long id) {
        return rackAssetRepository.findById(id);
    }

    public RackAsset updateRackAsset(long id, RackAsset updatedRackAsset) {
        RackAsset rackAsset = rackAssetRepository.findById(id);
        if (rackAsset == null) return null;
        rackAsset.setRackId(updatedRackAsset.getRackId());
        rackAsset.setAssetTag(updatedRackAsset.getAssetTag());
        rackAssetRepository.persist(rackAsset);
        return rackAsset;
    }

    public boolean deleteRack(long id) {
        return rackAssetRepository.deleteById(id);
    }
}
