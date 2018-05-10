package ingrediant.chemical;

import ingrediant.Basic.BasicIngredient;

import java.math.BigDecimal;

public abstract class BasicChemicalIngredient extends BasicIngredient implements ChemicalIngredient {

    public String chemicalFormula;

    public BasicChemicalIngredient() {
    }

    public BasicChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name,price);
        this.chemicalFormula = chemicalFormula;
    }

    @Override
    public String getChemicalFormula() {
        return null;
    }

    @Override
    public String setChemicalFormula(String ChemicalFormula) {
        return null;
    }
}
