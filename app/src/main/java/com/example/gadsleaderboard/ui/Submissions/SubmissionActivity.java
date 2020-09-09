package com.example.gadsleaderboard.ui.Submissions;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.models.FormEntry;
import com.example.gadsleaderboard.util.DialogUtil;

public class SubmissionActivity extends AppCompatActivity {

    private SubmissionViewModel submissionViewModel;
    private String mResult;
    private TextView mFirstName;
    private TextView mLastName;
    private TextView mEmail;
    private TextView mLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        submissionViewModel =  ViewModelProviders.of(this).get(SubmissionViewModel.class);

        mFirstName = findViewById(R.id.et_first_name);
        mLastName = findViewById(R.id.et_last_name);
        mEmail = findViewById(R.id.et_email);
        mLink = findViewById(R.id.et_project_link);
        Button button = findViewById(R.id.submit);
        ImageView back = findViewById(R.id.back);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = mFirstName.getText().toString();
                String lastname = mLastName.getText().toString();
                String emailAddr = mEmail.getText().toString();
                String projectLink = mLink.getText().toString();

                saveLink(firstname, lastname, emailAddr, projectLink);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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

                if(result.equals("ok")){

                    DialogUtil.showSuccessDialog(SubmissionActivity.this);
                    clearTextViews();
                }
                else
                    DialogUtil.showFailureDialog(SubmissionActivity.this);
            }
        });
    }

    private void clearTextViews() {
        mEmail.setText("");
        mFirstName.setText("");
        mLastName.setText("");
        mLink.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }


}