package com.example.gadsleaderboard.util;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.ui.Submissions.SubmissionViewModel;

public class DialogUtil {

    public static String confrimValue;
    private static boolean result;


    public static boolean showConfirmationDialog(final Context context, final String firstname,
                                              final String lastName, final String email, final String link){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        result = false;

        // set the custom layout
        final View customLayout = LayoutInflater.from(context)
                .inflate(R.layout.confirm_dialog, null);

        final SubmissionViewModel submissionViewModel = new ViewModelProvider((ViewModelStoreOwner) context)
                .get(SubmissionViewModel.class);

        Button button = customLayout.findViewById(R.id.confirm_button);
        ImageView imageView = customLayout.findViewById(R.id.cancel_action);
        builder.setView(customLayout);

        // create and show the alert dialog
        final AlertDialog dialog = builder.create();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submissionViewModel.saveGitHubLink(firstname, lastName, email, link);
                result = true;
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();

        return result;
    }

    public static void showFailureDialog(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        // set the custom layout
        final View customLayout = LayoutInflater.from(context)
                .inflate(R.layout.failure_dialog, null);

        builder.setView(customLayout);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public static void showSuccessDialog(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        // set the custom layout
        final View customLayout = LayoutInflater.from(context)
                .inflate(R.layout.success_dialog, null);

        builder.setView(customLayout);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
