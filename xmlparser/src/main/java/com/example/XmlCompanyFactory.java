package com.example;

import com.example.annot.N5;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@N5
public class XmlCompanyFactory extends DefaultHandler {

    private Company company = new Company();

    /**
     * Start processing xml element (like <company>, <employee>)
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("employee")) {
            String name = attributes.getValue("name");
            int age = Integer.parseInt(attributes.getValue("age"));
            company.getEmployeeList().add(new Employee(name, age));
        } else if (qName.equals("company")) {
            int id = Integer.parseInt(attributes.getValue("id"));
            String name = attributes.getValue("name");
            company.setId(id);
            company.setName(name);
        }
    }

    /**
     * create company from parsed xml
     * @return
     */
    public Company createCompany() {
        Company c = new Company(company.getId(), company.getName(), company.getEmployeeList());
        company = new Company();
        return c;
    }
}
