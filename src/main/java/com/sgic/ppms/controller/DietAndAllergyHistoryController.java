package com.sgic.ppms.controller;

import com.sgic.ppms.dto.DietAndAllergyHistoryDto;
import com.sgic.ppms.services.DietAndAllergyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.ppms.enums.RestApiResponseStatus;
import com.sgic.ppms.util.EndpointBundle;
import com.sgic.ppms.util.ResponseWrapper;
import com.sgic.ppms.util.ValidationMessages;

@RestController
@RequestMapping(value = EndpointBundle.DIET_ALLERGY_HISTORY)
public class DietAndAllergyHistoryController {
    @Autowired
    DietAndAllergyHistoryService dietAndAllergyHistoryService;

    @GetMapping(value = EndpointBundle.GET_BY_CHILD_ID)
    public ResponseEntity<ResponseWrapper<DietAndAllergyHistoryDto>> getDietANDAllergyHistoryByChildId(
            @PathVariable("childId") String childId) {
        DietAndAllergyHistoryDto dietAndAllergyHistoryDto = dietAndAllergyHistoryService.getDietAndAllergyHistoryByChildID(childId);
        return ResponseEntity.ok(new ResponseWrapper<>(RestApiResponseStatus.FOUND.getCode(), ValidationMessages.FOUND, dietAndAllergyHistoryDto));
    }
}
