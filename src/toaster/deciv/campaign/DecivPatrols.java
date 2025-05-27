package toaster.deciv.campaign;

import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;
import com.fs.starfarer.api.impl.campaign.ids.Industries;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;


public class DecivPatrols extends BaseIndustry {

    public void apply() {
        super.apply(true);
    }

    @Override
    protected void buildingFinished() {
        super.buildingFinished();
        market.removeCondition(Conditions.DECIVILIZED_SUBPOP);
        market.removeIndustry("deciv_patrols", null, false);
    }

    @Override
    public void unapply() {
        super.unapply();
    }

    @Override
    public boolean showWhenUnavailable() {
        return market.hasCondition("decivilized_subpop");
    }

    public boolean isAvailableToBuild() {
        return (
                market.hasCondition("decivilized_subpop") &&
                (
                        market.hasFunctionalIndustry(Industries.GROUNDDEFENSES) ||
                        market.hasFunctionalIndustry(Industries.HEAVYBATTERIES)
                )
        );
    }

    public String getUnavailableReason() {
        return "Requires Ground Defences or Heavy Batteries.";
    }

    @Override
    public boolean canImprove() {
        return false;
    }

}




