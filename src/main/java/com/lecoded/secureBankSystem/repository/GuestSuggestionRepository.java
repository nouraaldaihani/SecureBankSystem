package com.lecoded.secureBankSystem.repository;

import com.lecoded.secureBankSystem.entity.GuestSuggestionEntity;
import com.lecoded.secureBankSystem.util.enums.SuggestionsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity,Long> {
    List<GuestSuggestionEntity> findBySuggestionsStatus(SuggestionsStatus status);


}