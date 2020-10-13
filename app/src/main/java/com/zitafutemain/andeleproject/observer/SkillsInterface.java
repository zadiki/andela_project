package com.zitafutemain.andeleproject.observer;

import com.zitafutemain.andeleproject.models.IqskillResponse;
import com.zitafutemain.andeleproject.models.LearningResponse;

import java.util.List;

public interface SkillsInterface {
    void fetchIqLeadersSuccess(List<IqskillResponse> iqskillResponseList);
    void fetchSkillFailure();

}
