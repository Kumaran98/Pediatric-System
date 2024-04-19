package com.sgic.ppms.services;
import com.sgic.ppms.dto.DietAndAllergyHistoryDto;
public interface DietAndAllergyHistoryService {
    DietAndAllergyHistoryDto getDietAndAllergyHistoryByChildID(String childId);
}
