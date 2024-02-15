package com.lecoded.secureBankSystem.service.suggestions;

import com.lecoded.secureBankSystem.entity.GuestSuggestionEntity;
import com.lecoded.secureBankSystem.ob.suggestion.CreateSuggestionsStatus;
import com.lecoded.secureBankSystem.repository.GuestSuggestionRepository;
import com.lecoded.secureBankSystem.util.enums.SuggestionsStatus;

import java.util.List;
import java.util.stream.Collectors;

public class GuestSuggestionService implements SuggestionsService {

    private final GuestSuggestionRepository suggestionRepository ;

    public GuestSuggestionService(GuestSuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }




    public List<GuestSuggestionEntity> findAllDataSuggestions() {
        List<GuestSuggestionEntity> allSuggestions = suggestionRepository.findAll();
        return allSuggestions.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> printAndProcessSuggestion(String suggestionText) {
        return suggestionRepository.findAll();

    }
    public List<GuestSuggestionEntity> findAllCreatedSuggestions(){
        return suggestionRepository.findBySuggestionsStatus(SuggestionsStatus.CREATE);
    }
    public List<GuestSuggestionEntity> findAllRemovedSuggestions(){
        return suggestionRepository.findBySuggestionsStatus(SuggestionsStatus.REMOVE);
    }

    public void processSuggestion(CreateSuggestionsStatus suggestionTex) {
        ProcessSuggestion processSuggestion = suggest -> {
            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
            suggestionEntity.setSuggestionText(suggestionEntity.getSuggestionText());
            suggestionRepository.save(suggestionEntity);
        };
    }

    @Override
    public void getSuggestionRate() {


    }

    @Override
    public List<GuestSuggestionEntity> getCreateStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionsStatus().equals(SuggestionsStatus.CREATE))
                .collect(Collectors.toList());

    }

    @Override
    public List<GuestSuggestionEntity> getRemoveStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionsStatus().equals(SuggestionsStatus.REMOVE))
                .collect(Collectors.toList());

    }
}
