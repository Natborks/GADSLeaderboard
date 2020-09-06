package com.example.gadsleaderboard.ui.Submissions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.models.FormEntry;
import com.example.gadsleaderboard.ui.LearningLeaders.LearningViewModel;
import com.example.gadsleaderboard.ui.SkillLeaders.SkillViewModel;
import com.example.gadsleaderboard.util.DialogUtil;

public class SubmissionActivity extends AppCompatActivity {

    private SubmissionViewModel submissionViewModel;
    private String mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        submissionViewModel =  ViewModelProviders.of(this).get(SubmissionViewModel.class);

        final TextView firstName = findViewById(R.id.et_first_name);
        final TextView lastName = findViewById(R.id.et_last_name);
        final TextView email = findViewById(R.id.et_email);
        final TextView link = findViewById(R.id.et_project_link);
        Button button = findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = firstName.getText().toString();
                String lastname = lastName.getText().toString();
                String emailAddr = email.getText().toString();
                String projectLink = link.getText().toString();

                saveLink(firstname, lastname, emailAddr, projectLink);
            }
        });
        
    }

    private void saveLink(String firstName, String lastName,
                          String emailAddr, String projectLink) {


        submissionViewModel.saveGitHubLink(firstName, lastName, emailAddr, projectLink)
        .observe(this, new Observer<FormEntry>() {
            @Override
            public void onChanged(FormEntry formEntry) {
                String result = formEntry.getString();

                if(result.equals("ok"))
                    DialogUtil.showSuccessDialog(SubmissionActivity.this);
                else
                    DialogUtil.showFailureDialog(SubmissionActivity.this);
            }
        });





    }


}