package com.zitafutemain.andeleproject.network;

import com.zitafutemain.andeleproject.models.IqskillResponse;
import com.zitafutemain.andeleproject.models.LearningResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeadersApiCall {
    @GET("api/hours")
    Call<List<LearningResponse>> getLearners();

    @GET("api/skilliq")
    Call<List<IqskillResponse>> getIqLeaders();
}
