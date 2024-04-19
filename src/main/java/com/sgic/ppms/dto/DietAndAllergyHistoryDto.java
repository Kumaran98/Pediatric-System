package com.sgic.ppms.dto;

import com.sgic.ppms.entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DietAndAllergyHistoryDto {
    DietAllergy dietAllergy;
    List<DietDetails> dietDetailsList;
    AllergyDetail allergyDetail;
    List<ChildEnvironmentalAllergy> childEnvironmentalAllergyList;
    List<ChildFoodAllergy> childFoodAllergyList;
    List<DrugAllergy> drugAllergyList;

}
