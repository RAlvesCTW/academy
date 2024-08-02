package com.ctw.workstation.rack.control;

import com.ctw.workstation.rack.entity.Rack;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class RackService {

    @Inject
    RackRepository rackRepository;

    public void addRack(Rack rack) {
        rack.setCreatedAt(LocalDateTime.now());
        rack.setModifiedAt(LocalDateTime.now());
        rackRepository.persist(rack);
    }

    public List<Rack> getRacks() {
        return rackRepository.listAll();
    }

    public Rack getRackById(long id) {
        return rackRepository.findById(id);
    }

    public Rack updateRack(long id, Rack updatedRack) {
        Rack rack = rackRepository.findById(id);
        if (rack == null) return null;
        rack.setSerialNumber(updatedRack.getSerialNumber());
        rack.setTeamId(updatedRack.getTeamId());
        rack.setStatus(updatedRack.getStatus());
        rack.setDefaultLocation(updatedRack.getDefaultLocation());
        rack.setModifiedAt(LocalDateTime.now());
        rackRepository.persist(rack);
        return rack;
    }

    public boolean deleteRack(long id) {
        return rackRepository.deleteById(id);
    }
}
