package ingrediant.chemical;

import java.math.BigDecimal;

public class AmmoniumChloride extends BasicChemicalIngredient {
    public AmmoniumChloride(String name, BigDecimal price, String chemicalFormula) {
        super("•Ammonium Chloride", BigDecimal.valueOf(0.59), "NH4Cl");
    }
}
