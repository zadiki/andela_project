package com.zitafutemain.andeleproject.observer;

import com.zitafutemain.andeleproject.models.LearningResponse;

import java.util.List;

public interface LearnersInterface {
    void fetchLeanersSuccess(List<LearningResponse> learningResponseList);
    void fetchLearnersFailure();
}
