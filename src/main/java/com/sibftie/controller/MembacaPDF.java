package com.sibftie.controller;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.StringUtils;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.sibftie.model.Dokumen;
import com.sibftie.service.DokumenService;
import com.sibftie.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by solo on 04/06/2017.
 */
public class MembacaPDF
{

    public void readPdf()
    {
        PdfReader reader;

        try {
            int count =0;

            reader = new PdfReader("static\\file\\user\\12s14008\\dokumen\\jquery_tutorial.pdf");
            String word = "should have";

            for(int i = 1; i<= reader.getNumberOfPages(); i++)
            {
                String textFromPage = PdfTextExtractor.getTextFromPage(reader, i);
                textFromPage = textFromPage.toLowerCase();
//                count +=Collections.frequency(Arrays.asList(textFromPage.split(" ")), word.toLowerCase());
                Pattern pattern = Pattern.compile(word);
                Pattern pattern1 = Pattern.compile(word);
                Matcher matcher = pattern.matcher(textFromPage);
                while (matcher.find())
                    count+=1;
            }
            System.out.println("The word \"" + word + "\" is mentioned " + count + " times.");
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void countString()
    {
        String string = "the colored port should be black or white or brown or";
        String word = "or";
        int count = Collections.frequency(Arrays.asList(string.split(" ")), word);
        System.out.println("The word \"" + word + "\" is mentioned " + count + " times.");
    }
}
