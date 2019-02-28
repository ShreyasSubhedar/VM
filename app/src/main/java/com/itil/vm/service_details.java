package com.itil.vm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class service_details extends AppCompatActivity {
//    ListView listViewUsers;
    Intent intent;
    String UserName;
//    List<ServiceRequest> users;
    FirebaseDatabase database;
    DatabaseReference ref;
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);
        intent = getIntent();

//        users =new ArrayList<>();
//        listViewUsers=findViewById(R.id.list_viue_detail);
        UserName = intent.getStringExtra(AdminActivity.USER_NAME);

        a=findViewById(R.id.enter_Name);
        b=findViewById(R.id.enter_Email);
        c=findViewById(R.id.Radio_Button);
        d=findViewById(R.id.Radio_Button_2);
        e=findViewById(R.id.Department_Name);
        f=findViewById(R.id.Postal_address);
        g=findViewById(R.id.Acc_Type);
        h=findViewById(R.id.Invoice_Period);
        i=findViewById(R.id.Ref_OR_Account_NO_);
        j=findViewById(R.id.Vender_Invoice_No);
        k=findViewById(R.id.Vender_Invoice_Date);
        l=findViewById(R.id.Vender_Invoice_AMT);
        m=findViewById(R.id.Vender_Invoice_AMT2);
        n=findViewById(R.id.Cust_Name);
        o=findViewById(R.id.PO_NO);
        p=findViewById(R.id.PO_End_Date);
        q=findViewById(R.id.PO_Amount);
        r=findViewById(R.id.Invoice_No);
        s=findViewById(R.id.Enter_Email);
        t=findViewById(R.id.Without_Tax_Amount);
        u=findViewById(R.id.Invoice_Amount);
        v=findViewById(R.id.DISC);
        w=findViewById(R.id.Cust_PMT_RECD);
        x=findViewById(R.id.Vendor_PMT_Release);
        y=findViewById(R.id.V_Payment_Due_Date);
        z=findViewById(R.id.V_PAY_REQ_Send);
        A=findViewById(R.id.V_Payment_refrence_No);
        B=findViewById(R.id.REMARK);
        C=findViewById(R.id.WBS_Element);
        D=findViewById(R.id.Customer_PO_Description);
        E=findViewById(R.id.Site);
        F=findViewById(R.id.Master_Acc_No_);
        G=findViewById(R.id.Enter_Name);

    }

    @Override
    protected void onStart() {
        super.onStart();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("serviceRequest").child(UserName);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                users.clear();
                    //getting artist
                    ServiceRequest loc = dataSnapshot.getValue(ServiceRequest.class);
                    //adding artist to the list

                a.setText(loc.getsName());
                b.setText(loc.getsEmail());
                c.setText(loc.getsreq());
                d.setText(loc.getsDeptName());
                e.setText(loc.getSaccType());
                f.setText(loc.getsMacno());
                g.setText(loc.getSinvPeriod());
                h.setText(loc.getSrefAccountNo());
                i.setText(loc.getsVendorInvoiceN());
                j.setText(loc.getsVendorInvoiceDate());
                k.setText(loc.getsVendorInvAmtWoT());
                l.setText(loc.getsVendorInvAmtWT());
                m.setText(loc.getScustName());
                n.setText(loc.getsPoNo());
                o.setText(loc.getsPoEndDate());
                p.setText(loc.getsPoAmmount());
                q.setText(loc.getSinvNO());
                r.setText(loc.getSwoTaxAmt());
                s.setText(loc.getSinvAmt());
                t.setText(loc.getsDISC());
                u.setText(loc.getsPmtReq());
                v.setText(loc.getsPmtRel());
                w.setText(loc.getsVpmtdue());
                x.setText(loc.getSvPayReqSend());
                y.setText(loc.getsPmtRefNo());
                z.setText(loc.getsRemark());
                A.setText(loc.getsWBSElement());
                B.setText(loc.getScustomerPoDes());
                C.setText(loc.getsSite());            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
