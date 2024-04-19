package com.sgic.ppms.services;

import com.sgic.ppms.dto.DietAndAllergyHistoryDto;
import com.sgic.ppms.entities.*;
import com.sgic.ppms.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DietAndAllergyHistoryServiceimpl implements DietAndAllergyHistoryService{

    @Autowired
    public DietAllergyRepository dietAllergyRepository;

    @Autowired
    public ChildEnvAllergyRepository childEnvAllergyRepository;

    @Autowired
    public ChildFoodAllergyRepository childFoodAllergyRepository;

    @Autowired
    public DietRepository dietRepository;

    @Autowired
    public AllergyDetailRepository allergyDetailRepository;

    @Autowired
    public DrugAllergyRepository drugAllergyRepository;

    @Transactional(readOnly = true)
    public DietAndAllergyHistoryDto getDietAndAllergyHistoryByChildID(String childId) {
        DietAndAllergyHistoryDto dietAndAllergyHistoryDto = new DietAndAllergyHistoryDto();
        if (dietAllergyRepository.existsByChildDetailChildId(childId)) {
            dietAndAllergyHistoryDto.setDietAllergy(dietAllergyRepository.findByChildDetailChildId(childId));
        }
        if (allergyDetailRepository.existsByChildDetailChildId(childId)) {
            AllergyDetail allergyDetail = allergyDetailRepository.findByChildDetailChildId(childId);
            dietAndAllergyHistoryDto.setAllergyDetail(allergyDetail);
            dietAndAllergyHistoryDto.setChildFoodAllergyList(childFoodAllergyRepository.findByAllergyDetailId(allergyDetail.getId()));
            dietAndAllergyHistoryDto.setDrugAllergyList(drugAllergyRepository.findByAllergyDetail_Id(allergyDetail.getId()));
            dietAndAllergyHistoryDto.setChildEnvironmentalAllergyList(childEnvAllergyRepository.findByAllergyDetailId(allergyDetail.getId()));
        }
        dietAndAllergyHistoryDto.setDietDetailsList(dietRepository.findByChildDetailId(childId));

        return dietAndAllergyHistoryDto;

    }
}

