package com.lecoded.secureBankSystem.service.suggestions;

import com.lecoded.secureBankSystem.entity.GuestSuggestionEntity;

import java.util.List;

public interface SuggestionsService {
    void getSuggestionRate ();
    List<GuestSuggestionEntity> getCreateStatusSuggestions();
    List<GuestSuggestionEntity> getRemoveStatusSuggestions();
}