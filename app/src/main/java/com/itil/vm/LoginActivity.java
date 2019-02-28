package com.itil.vm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText email;
    private EditText pass;
    private Spinner usrtypee;
    private String type;
    private String admin = "Admin";
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progres;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        btn = findViewById(R.id.btnlogin);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.passwd);
        usrtypee = findViewById(R.id.usrtypeSpinner);

        progres = new ProgressDialog(this);
        btn.setOnClickListener(this);

    }

    public void myfun() {
        Toast.makeText(LoginActivity.this, type, Toast.LENGTH_SHORT).show();
        if (type.equals("Admin")) {
            finish();
            startActivity(new Intent(getApplicationContext(), AdminActivity.class));
        } else if (type.equals("Buyer")) {
            finish();
            startActivity(new Intent(getApplicationContext(), BuyerActivity.class));
        } else if (type.equals("Vendor")) {
            finish();
            startActivity(new Intent(getApplicationContext(), VendorActivity.class));
        } else if (type.equals("Select User Type")) {
            Toast.makeText(LoginActivity.this, "Please Select User Type", Toast.LENGTH_SHORT).show();

        }

    }

    private void userLogin() {
        type = usrtypee.getSelectedItem().toString();
        String emailid = email.getText().toString().trim();
        String password = pass.getText().toString().trim();


        //checking if email and passwords are empty
        if (TextUtils.isEmpty(emailid)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog
        progres.setMessage("loggig in...");
        progres.show();

        //logging in the user
        firebaseAuth.signInWithEmailAndPassword(emailid, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progres.dismiss();
                        if (task.isSuccessful()) {
                            myfun();
                        } else {
                            Toast.makeText(LoginActivity.this, "Check Email ID or Password!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if (view == btn) {
            userLogin();
        }

    }
}
