package com.tomiprasetyo.pemesanantravel.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tomiprasetyo.pemesanantravel.R;
import com.tomiprasetyo.pemesanantravel.adapter.AlertDialogManager;
import com.tomiprasetyo.pemesanantravel.session.SessionManager;

public class MainActivity extends AppCompatActivity {

    AlertDialogManager alert = new AlertDialogManager();
    SessionManager session;
    Button btnLogout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        btnLogout = findViewById(R.id.out);
        btnLogout.setOnClickListener(arg0 -> {
            AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Anda yakin ingin keluar ?")
                    .setPositiveButton("Ya", (dialog1, which) -> {
                        finish();
                        session.logoutUser();
                    })
                    .setNegativeButton("Tidak", null)
                    .create();
            dialog.show();
        });
    }

    public void profileMenu(View v) {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }

    public void historyMenu(View v) {
        Intent i = new Intent(this, HistoryActivity.class);
        startActivity(i);
    }

    public void bookKereta(View v) {
        Intent i = new Intent(this, BookKeretaActivity.class);
        startActivity(i);
    }

    public void bookHotel(View v) {
        Toast.makeText(getApplicationContext(), "Mohon maaf, sistem sedang dalam pengembangan.", Toast.LENGTH_LONG).show();
    }
}