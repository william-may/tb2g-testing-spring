package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {

  @Mock
  PetRepository petRepository;

  @Mock
  VetRepository vetRepository;

  @Mock
  OwnerRepository ownerRepository;

  @Mock
  VisitRepository visitRepository;

  @InjectMocks
  ClinicServiceImpl clinicService;

  @Test
  void findPetTypes() {

    // GIVEN
    List<PetType> petTypeList = new ArrayList<>();
    given(petRepository.findPetTypes()).willReturn(petTypeList);

    // WHEN
    Collection<PetType> returnedPetType = clinicService.findPetTypes();

    //THEN
    then(petRepository).should().findPetTypes();
    assertThat(returnedPetType).isNotNull();
  }
}