package com.example.gadsleaderboard.ui.Submissions;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gadsleaderboard.models.FormEntry;
import com.example.gadsleaderboard.repository.SubmissionRepository;

public class SubmissionViewModel extends AndroidViewModel {
    SubmissionRepository mSubmissionRepository;
    MutableLiveData<FormEntry> mFormEntryMutableLiveData;

    public SubmissionViewModel(@NonNull Application application) {
        super(application);
        mSubmissionRepository = new SubmissionRepository(application);

    }

    public MutableLiveData<FormEntry> saveGitHubLink(String firstName, String lastName,
                                  String email, String link){

        mFormEntryMutableLiveData = mSubmissionRepository.saveGitHubLink(firstName, lastName, email, link);

        return mFormEntryMutableLiveData;
    }
}
