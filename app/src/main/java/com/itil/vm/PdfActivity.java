package com.itil.vm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PdfActivity extends AppCompatActivity {
    private Button btnPDFGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        btnPDFGenerator = findViewById(R.id.btnPDFGenerator);

        btnPDFGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generatePDF();
            }
        });
    }

    private void generatePDF()
    {
        // TODO Auto-generated method stub
        String filename = "sample_bill";
        String fileContent = "This is sample text inside pdf";
        PDFUtility pdfUtility = new PDFUtility();
        if (pdfUtility.write(filename, fileContent)) {
            Toast.makeText(getApplicationContext(),
                    filename + ".pdf created", Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(getApplicationContext(), "I/O error",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
