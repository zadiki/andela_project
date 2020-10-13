package com.zitafutemain.andeleproject.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zitafutemain.andeleproject.Adapter.LearnersFragmentAdapter;
import com.zitafutemain.andeleproject.R;
import com.zitafutemain.andeleproject.models.LearningResponse;
import com.zitafutemain.andeleproject.observer.LearnersInterface;
import com.zitafutemain.andeleproject.viewModels.LeadersViewModel;

import java.util.List;
import java.util.Objects;

public class LearnersFragment extends Fragment implements LearnersInterface {
    public static final String ARG_OBJECT = "object";
    private LearnersFragmentAdapter learnersFragmentAdapter;
    ContentLoadingProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.leaders_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_leaders);
        progressBar = view.findViewById(R.id.progressBarCyclic);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        learnersFragmentAdapter = new LearnersFragmentAdapter();
        recyclerView.setAdapter(learnersFragmentAdapter);
        LeadersViewModel leadersViewModel = new LeadersViewModel(Objects.requireNonNull(getActivity()).getApplication());
        leadersViewModel.fetchLearnersAsyc(this);
    }

    @Override
    public void fetchLeanersSuccess(List<LearningResponse> learningResponseList) {
        learnersFragmentAdapter.submitList(learningResponseList);
        progressBar.hide();
    }

    @Override
    public void fetchLearnersFailure() {
        progressBar.hide();
        Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
    }
}
