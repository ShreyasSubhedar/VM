package com.itil.vm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextemail;
    private EditText edittextpassword;
    private EditText edittextcomanyName;
    private EditText phone_number;
    private EditText edittextCompanyAddress;
    private EditText edittextName;
    private Spinner usrrr;
    private String usrtype;
    private ProgressDialog progressDialog;
    private FirebaseDatabase database;
    private DatabaseReference myDB;
    private Button btnR;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextemail = findViewById(R.id.email);
        edittextpassword = findViewById(R.id.password);
        edittextcomanyName = findViewById(R.id.companyname);
        phone_number = findViewById(R.id.phone);
        edittextCompanyAddress = findViewById(R.id.addrress);
        edittextName = findViewById(R.id.name);
        usrrr = findViewById(R.id.registertype);
        usrtype = usrrr.getSelectedItem().toString();
        progressDialog = new ProgressDialog(this);
        btnR = findViewById(R.id.register);
        btnR.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void dataEntry() {
        usrtype = usrrr.getSelectedItem().toString();

        String emailS = editTextemail.getText().toString().trim();
        String passwordS = edittextpassword.getText().toString().trim();
        String companyName = edittextcomanyName.getText().toString().trim();
        String phoneN = phone_number.getText().toString().trim();
        String companyaaddr = edittextCompanyAddress.getText().toString().trim();
        String name = edittextName.getText().toString().trim();
        String usrtypeS = usrtype.trim();
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        database = FirebaseDatabase.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(emailS, passwordS)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        } else {
                            //display some message here
                            Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
        myDB = database.getReference(usrtypeS);
        registeration obj = new registeration(emailS, passwordS, companyName, phoneN, companyaaddr, name, usrtypeS);
        myDB.child(companyName).setValue(obj);
    }

    @Override
    public void onClick(View view) {
        if (view == btnR) {
            dataEntry();
        }
    }
}
