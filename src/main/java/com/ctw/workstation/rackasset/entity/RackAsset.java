package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "T_RACK_ASSET")
public class RackAsset {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackAssetIdGenerator")
    @SequenceGenerator(name = "rackAssetIdGenerator", sequenceName = "SEQ_RACK_ASSET_ID", allocationSize = 1)
    private long id;

    @Column(name = "RACK_ID", nullable = false)
    private long rackId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "RACK_ID", updatable = false, insertable = false, nullable = false)
    private Rack rack;

    @Column(name = "ASSET_TAG", length = 10, nullable = false)
    private String assetTag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public long getRackId() {
        return rackId;
    }

    public void setRackId(long rackId) {
        this.rackId = rackId;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }
}
