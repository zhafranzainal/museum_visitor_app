package com.example.museumvisitorapp;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ContactDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact_dialog, container, false);

        ImageView iconCall = view.findViewById(R.id.icon_call);
        ImageView iconEmail = view.findViewById(R.id.icon_email);
        ImageView iconFacebook = view.findViewById(R.id.icon_facebook);

        iconCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initiatePhoneCall();
            }
        });

        iconEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });

        iconFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFacebookPage();
            }
        });

        return view;

    }

    @Override
    public void onStart() {

        super.onStart();

        if (getDialog() != null) {
            int width = getResources().getDimensionPixelSize(R.dimen.dialog_width);
            int height = getResources().getDimensionPixelSize(R.dimen.dialog_height);
            getDialog().getWindow().setLayout(width, height);
        }

    }

    private void initiatePhoneCall() {
        String phoneNumber = "+60 09-541 2378";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    private void sendEmail() {
        String emailAddress = "pr.muziumsungailembing@gmail.com";
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", emailAddress, null));
        startActivity(Intent.createChooser(intent, "Choose an Email client"));
    }

    private void openFacebookPage() {

        String facebookPageId = "sungailembingmuseum";

        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + facebookPageId));
            startActivity(intent);
        } catch (Exception e) {
            // If Facebook app is not installed, open the page in a web browser
            String facebookUrl = "https://www.facebook.com/" + facebookPageId;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));
            startActivity(intent);
        }

    }

}
