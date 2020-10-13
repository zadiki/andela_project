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

import com.zitafutemain.andeleproject.Adapter.IqFragmentAdapter;
import com.zitafutemain.andeleproject.Adapter.LearnersFragmentAdapter;
import com.zitafutemain.andeleproject.R;
import com.zitafutemain.andeleproject.models.IqskillResponse;
import com.zitafutemain.andeleproject.models.LearningResponse;
import com.zitafutemain.andeleproject.observer.SkillsInterface;
import com.zitafutemain.andeleproject.viewModels.LeadersViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IqScoreFragment extends Fragment implements SkillsInterface {
    public static final String ARG_OBJECT = "object";
    private IqFragmentAdapter skillsFragmentAdapter;
    ContentLoadingProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.leaders_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_leaders);
        progressBar = view.findViewById(R.id.progressBarCyclic);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        skillsFragmentAdapter = new IqFragmentAdapter();
        recyclerView.setAdapter(skillsFragmentAdapter);
        LeadersViewModel leadersViewModel = new LeadersViewModel(Objects.requireNonNull(getActivity()).getApplication());
        leadersViewModel.fetchSkillsAsyc(this);
    }

    @Override
    public void fetchIqLeadersSuccess(List<IqskillResponse> iqskillResponseList) {
        skillsFragmentAdapter.submitList(iqskillResponseList);
        progressBar.hide();
    }

    @Override
    public void fetchSkillFailure() {
        progressBar.hide();
        Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
    }
}
