package com.zitafutemain.andeleproject.repository;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.AsyncTask;

import com.zitafutemain.andeleproject.models.IqskillResponse;
import com.zitafutemain.andeleproject.models.LearningResponse;
import com.zitafutemain.andeleproject.network.BaseNetworkConfig;
import com.zitafutemain.andeleproject.network.LeadersApiCall;
import com.zitafutemain.andeleproject.observer.LearnersInterface;
import com.zitafutemain.andeleproject.observer.SkillsInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeadersRepository {
    private static LeadersApiCall leadersApiCall;
    public LeadersRepository(Application application) {
        leadersApiCall = BaseNetworkConfig.getLeadersApiCall();
    }

    public void fetchSkills(SkillsInterface skillsInterface) {

            Call<List<IqskillResponse>> call = leadersApiCall.getIqLeaders();
            call.enqueue(new Callback<List<IqskillResponse>>() {
                @Override
                public void onResponse(Call<List<IqskillResponse>> call, Response<List<IqskillResponse>> response) {
                    if (response.isSuccessful()) {
                        skillsInterface.fetchIqLeadersSuccess(response.body());
                    } else {
                        skillsInterface.fetchSkillFailure();
                    }
                }

                @Override
                public void onFailure(Call<List<IqskillResponse>> call, Throwable t) {
                    skillsInterface.fetchSkillFailure();
                }
            });
        }


    public void fetchLearners(LearnersInterface learnersInterface) {

        Call<List<LearningResponse>> call = leadersApiCall.getLearners();
        call.enqueue(new Callback<List<LearningResponse>>() {
            @Override
            public void onResponse(Call<List<LearningResponse>> call, Response<List<LearningResponse>> response) {
                if (response.isSuccessful()) {
                    learnersInterface.fetchLeanersSuccess(response.body());
                } else {
                    learnersInterface.fetchLearnersFailure();
                }
            }

            @Override
            public void onFailure(Call<List<LearningResponse>> call, Throwable t) {
                learnersInterface.fetchLearnersFailure();
            }
        });
    }
}
