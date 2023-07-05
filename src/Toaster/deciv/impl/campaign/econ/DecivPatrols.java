package Toaster.deciv.impl.campaign.econ;

import java.awt.Color;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SubmarketPlugin;
import com.fs.starfarer.api.campaign.econ.CommoditySpecAPI;
import com.fs.starfarer.api.combat.MutableStat;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;
import com.fs.starfarer.api.impl.campaign.ids.Commodities;
import com.fs.starfarer.api.impl.campaign.ids.Industries;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.impl.campaign.intel.events.ht.HyperspaceTopographyEventIntel;
import com.fs.starfarer.api.impl.campaign.intel.events.ht.HyperspaceTopographyEventIntel.Stage;
import com.fs.starfarer.api.impl.campaign.submarkets.LocalResourcesSubmarketPlugin;
import com.fs.starfarer.api.ui.TooltipMakerAPI;
import com.fs.starfarer.api.util.Misc;
import com.fs.starfarer.api.util.Pair;



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




