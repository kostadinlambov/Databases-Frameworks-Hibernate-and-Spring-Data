package ingrediant.chemical;

import ingrediant.Ingredient;


interface ChemicalIngredient extends Ingredient {
     String getChemicalFormula();
     String setChemicalFormula(String ChemicalFormula);
}
