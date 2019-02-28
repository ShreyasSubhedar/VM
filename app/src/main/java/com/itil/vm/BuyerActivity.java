package com.itil.vm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BuyerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FirebaseDatabase database;
    DatabaseReference myRef;
    private RadioGroup slocation;
    private RadioGroup sreq;
    private EditText sName;
    private EditText sEmail;
    private EditText srequirement;
    private EditText sDeptName;
    private EditText sPostal;
    private EditText saccType;
    private EditText sMacno;
    private EditText sinvPeriod;
    private EditText srefAccountNo;
    private EditText sVendorInvoiceN;
    private EditText sVendorInvoiceDate;
    private EditText sVendorInvAmtWoT;
    private EditText sVendorInvAmtWT;
    private EditText scustName;
    private EditText sPoNo;
    private EditText sPoEndDate;
    private EditText sPoAmmount;
    private EditText sinvNO;
    private EditText swoTaxAmt;
    private EditText sinvAmt;
    private EditText sDISC;
    private EditText sPmtReq;
    private EditText sPmtRel;
    private EditText sVpmtdue;
    private EditText svPayReqSend;
    private EditText sPmtRefNo;
    private EditText sRemark;
    private EditText sWBSElement;
    private EditText scustomerPoDes;
    private EditText sSite;
    private Button submit;
    String reqest,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        slocation=findViewById(R.id.slocation);
        sreq=findViewById(R.id.sRequest);
        sName=findViewById(R.id.sName);
        sEmail=findViewById(R.id.sEmail);
        srequirement=findViewById(R.id.sRequiremrnt);
        sDeptName=findViewById(R.id.sdept);
        sPostal=findViewById(R.id.saddress);
        saccType=findViewById(R.id.sAccoumt);
        sMacno=findViewById(R.id.sMaccount);
        sinvPeriod=findViewById(R.id.sinvPer);
        srefAccountNo=findViewById(R.id.saccNo);
        sVendorInvoiceN=findViewById(R.id.sVendorAcc);
        sVendorInvoiceDate=findViewById(R.id.svinvDate);
        sVendorInvAmtWoT=findViewById(R.id.sinvamtTax);
        sVendorInvAmtWT=findViewById(R.id.sinvwtax);
        scustName=findViewById(R.id.scustName);
        sPoNo=findViewById(R.id.spono);
        sPoEndDate=findViewById(R.id.spoEnd);
        sPoAmmount=findViewById(R.id.sPoAmt);
        sinvNO=findViewById(R.id.sinvNo);
        swoTaxAmt=findViewById(R.id.sinvwoAmount);
        sinvAmt=findViewById(R.id.sinvAmount);
        sDISC=findViewById(R.id.sDisc);
        sPmtReq=findViewById(R.id.sCustpmt);
        sPmtRel=findViewById(R.id.sPmtRel);
        sVpmtdue=findViewById(R.id.spmtDue);
        svPayReqSend=findViewById(R.id.sVPayReq);
        sPmtRefNo=findViewById(R.id.vPayRef);
        sRemark=findViewById(R.id.sremark);
        sWBSElement=findViewById(R.id.sWbsElem);
        scustomerPoDes=findViewById(R.id.sCustPoDes);
        sSite=findViewById(R.id.site);
        submit=findViewById(R.id.button2);
        database = FirebaseDatabase.getInstance();

submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        dataentry();
    }
});


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


            }


     public void dataentry(){
         if (slocation.getCheckedRadioButtonId() == R.id.rCredit)
         {
             reqest="network";
         }
         if (slocation.getCheckedRadioButtonId() == R.id.rDebit)
         {
             reqest="software";
         }
         if (slocation.getCheckedRadioButtonId() == R.id.rhardware)
         {
             reqest="hardware";
         }
         if (slocation.getCheckedRadioButtonId() == R.id.rOther)
         {
             reqest="other";
         }
         if (sreq.getCheckedRadioButtonId() == R.id.rOffice)
         {
             location="Office";
         }
         if (sreq.getCheckedRadioButtonId() == R.id.rHome)
         {
             location="Home";
         }

         myRef=database.getReference("serviceRequest").child(sName.getText().toString());
         ServiceRequest obj=new ServiceRequest(sName.getText().toString(),sEmail.getText().toString(),reqest,srequirement.getText().toString(),location,sDeptName.getText().toString(),sPostal.getText().toString(),saccType.getText().toString(),sMacno.getText().toString(),sinvPeriod.getText().toString(),srefAccountNo.getText().toString(),sVendorInvoiceN.getText().toString(),sVendorInvoiceDate.getText().toString(),sVendorInvAmtWoT.getText().toString(),sVendorInvAmtWT.getText().toString(),scustName.getText().toString(),sPoNo.getText().toString(),sPoEndDate.getText().toString(),sPoAmmount.getText().toString(),sinvNO.getText().toString(),swoTaxAmt.getText().toString(),sinvAmt.getText().toString(),sDISC.getText().toString(),sPmtReq.getText().toString(),sPmtRel.getText().toString(),sVpmtdue.getText().toString(),svPayReqSend.getText().toString(),sPmtRefNo.getText().toString(),sRemark.getText().toString(),sWBSElement.getText().toString(),scustomerPoDes.getText().toString(),sSite.getText().toString());
         myRef.setValue(obj);

     }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.buyer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
