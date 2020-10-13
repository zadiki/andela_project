package com.zitafutemain.andeleproject.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.zitafutemain.andeleproject.observer.LearnersInterface;
import com.zitafutemain.andeleproject.observer.SkillsInterface;
import com.zitafutemain.andeleproject.repository.LeadersRepository;

public class LeadersViewModel extends AndroidViewModel {
    private LeadersRepository leadersRepository;
    public LeadersViewModel(@NonNull Application application) {
        super(application);
        leadersRepository=new LeadersRepository(application);
    }
    public void fetchLearnersAsyc(LearnersInterface learnersInterface){
        leadersRepository.fetchLearners(learnersInterface);
    }
    public void fetchSkillsAsyc(SkillsInterface skillsInterface){
        leadersRepository.fetchSkills(skillsInterface);
    }
}
