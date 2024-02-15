package com.lecoded.secureBankSystem.service.suggestions;

import com.lecoded.secureBankSystem.ob.suggestion.CreateSuggestionsStatus;

public interface ProcessSuggestion {
    void processSuggestion(CreateSuggestionsStatus suggestionTex);
}