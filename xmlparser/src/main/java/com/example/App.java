package com.example;

import com.example.annot.N1;
import com.example.annot.N2;
import com.example.annot.N3;
import com.example.annot.N4;
import com.example.annot.N5;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@N4
public class App {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // sax
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XmlCompanyFactory xmlCompanyFactory = new XmlCompanyFactory();
        // parse file company.xml
        parser.parse("company.xml", xmlCompanyFactory);
        Company company = xmlCompanyFactory.createCompany();
        System.out.println(company);

        annotationsProcessTask();
    }

    private static void annotationsProcessTask() {
        // list of custom annotated classes
        List<Class> classesColl = Arrays.asList(Company.class, App.class, JuniorEmployee.class,
                MiddleEmployee.class, XmlCompanyFactory.class);
        for (Class cl : classesColl) {
            if (cl.isAnnotationPresent(N1.class) || cl.isAnnotationPresent(N2.class)) { // if class annotated with N1 or N2
                System.out.println("N1 or N2 annotation present on " + cl.getSimpleName());
            } else if (cl.isAnnotationPresent(N3.class)) { // if class annotated with N3 - 50/50
                boolean shouldSkip = new Random().nextBoolean();
                if (!shouldSkip) {
                    System.out.println("N3 annotation present on " + cl.getSimpleName() + ", 50/50 appears");
                }
            } else {
                // if N1, N2, N3 not present
                System.out.println(cl.getSimpleName() + " skipped");
            }
        }
    }


}
