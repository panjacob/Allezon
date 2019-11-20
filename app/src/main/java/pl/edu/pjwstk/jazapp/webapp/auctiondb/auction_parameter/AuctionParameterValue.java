package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter.ParameterEntity;

import javax.persistence.*;

@Entity
@Table(name = "auction_parameter")
public class AuctionParameterValue {

    @EmbeddedId
    @JoinColumn(columnDefinition = "parameter_id")
    private AuctionParameterId auctionParameterId;

    @OneToOne
    @JoinColumn(columnDefinition = "auction_id")
    private AuctionEntity auctionEntity;

    @ManyToOne
    @JoinColumn(columnDefinition = "parameter_id")
    private ParameterEntity parameterEntity;

    private String value;

    public AuctionParameterValue(AuctionEntity auctionEntity, ParameterEntity parameterEntity, String value) {
        this.auctionEntity = auctionEntity;
        this.parameterEntity = parameterEntity;
        this.value = value;
    }

    public AuctionParameterValue() {

    }

    public AuctionParameterId getAuctionParameterId() {
        return auctionParameterId;
    }

    public void setAuctionParameterId(AuctionParameterId auctionParameterId) {
        this.auctionParameterId = auctionParameterId;
    }

    public AuctionEntity getAuctionEntity() {
        return auctionEntity;
    }

    public void setAuctionEntity(AuctionEntity auctionEntity) {
        this.auctionEntity = auctionEntity;
    }

    public ParameterEntity getParameterEntity() {
        return parameterEntity;
    }

    public void setParameterEntity(ParameterEntity parameterEntity) {
        this.parameterEntity = parameterEntity;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
