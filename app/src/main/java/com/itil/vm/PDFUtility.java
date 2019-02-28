package com.itil.vm;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class PDFUtility {


    public Boolean write(String fname, String fcontent) {
        try {
            String fpath = "/sdcard/" + fname + ".pdf";
            File file = new File(fpath);

            if (!file.exists()) {
                file.createNewFile();
            }


            Font bfBold12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);


            Document document = new Document();


            PdfWriter.getInstance(document,
                    new FileOutputStream(file.getAbsoluteFile()));

            document.open();
            Paragraph paragraph = new Paragraph("first Bill format \n\n");

            document.add(paragraph);

            document.add(addTable());

            Paragraph paragraph2 = new Paragraph("Second Bill format \n\n");
            document.add(paragraph2);

            document.add(addTable());

            document.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }


    private PdfPCell setCell(String cellData){
        PdfPCell cell = new PdfPCell(new Phrase(cellData));
        cell.setColspan(1);
        cell.setBorder(Rectangle.BOX);
        return cell;
    }


    private PdfPTable addTable(){
        // Table
        PdfPTable table = new PdfPTable(8);

        // Set column inside tables
        PdfPCell columnSRNo = new PdfPCell(new Phrase("SR NO"));
        PdfPCell columnVendorName = new PdfPCell(new Phrase("Vendor Name"));
        PdfPCell columnItemDesc = new PdfPCell(new Phrase("Item Description"));
        PdfPCell columnAccType = new PdfPCell(new Phrase("Acc Type"));
        PdfPCell columnMasterAccNo = new PdfPCell(new Phrase("Master Acc No."));
        PdfPCell columnRefNo = new PdfPCell(new Phrase("Ref / ACCOUNT NO."));
        PdfPCell columnEmailID = new PdfPCell(new Phrase("Email ID"));
        PdfPCell columnDisplayName = new PdfPCell(new Phrase("Display Name"));


        table.addCell(columnSRNo);
        table.addCell(columnVendorName);
        table.addCell(columnItemDesc);
        table.addCell(columnAccType);
        table.addCell(columnMasterAccNo);
        table.addCell(columnRefNo);
        table.addCell(columnEmailID);
        table.addCell(columnDisplayName);

        // Now adding value for each column currently  Adding 10 rows
        int noOfRows = 10;
        for(int i= 1;i<=noOfRows;i++){

            // Adding value for column SRNO.
            columnSRNo= new PdfPCell(new Phrase(String.valueOf(i)));
            table.addCell(columnSRNo);

            // Adding value for column vendor name.
            columnVendorName= new PdfPCell(new Phrase("Vendor "+String.valueOf(i)));
            table.addCell(columnVendorName);

            // Adding value for column Item Desc.
            columnItemDesc= new PdfPCell(new Phrase("Item Desc "+String.valueOf(i)));
            table.addCell(columnItemDesc);

            // Adding value for column Acc type.
            columnAccType= new PdfPCell(new Phrase("Account Type "+String.valueOf(i)));
            table.addCell(columnAccType);

            // Adding value for column Master acc no.
            columnMasterAccNo= new PdfPCell(new Phrase("Master Account "+String.valueOf(i)));
            table.addCell(columnMasterAccNo);

            // Adding value for column Ref NO.
            columnRefNo= new PdfPCell(new Phrase("Ref No."+String.valueOf(i)));
            table.addCell(columnRefNo);

            // Adding value for column Email ID.
            columnEmailID= new PdfPCell(new Phrase("email"+String.valueOf(i)+"@xyz.com"));
            table.addCell(columnEmailID);

            // Adding value for column Display Name.
            columnDisplayName= new PdfPCell(new Phrase("Display Name "+i));
            table.addCell(columnDisplayName);
        }

       return table;

    }


}
