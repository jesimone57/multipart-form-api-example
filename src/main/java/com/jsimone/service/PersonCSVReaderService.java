package com.jsimone.service;

import com.jsimone.entity.DocumentMetadata;
import com.jsimone.entity.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Service
public class PersonCSVReaderService {

    public void readPersonCSV(MultipartFile file, DocumentMetadata metadata) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));

            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());
            /*
            CSVParser csvParser = CSVParser.parse(file.getInputStream(), Charset.defaultCharset(),
                    CSVFormat.DEFAULT
                            .withFirstRecordAsHeader()
                            .withIgnoreHeaderCase()
                            .withTrim());

             */

            Map<String, Integer> headerMap = csvParser.getHeaderMap();
            System.out.println(headerMap);
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names
                Person person = new Person();
                person.setName(csvRecord.get("Name"));
                person.setAddress(csvRecord.get("address"));
                person.setCity(csvRecord.get("City"));
                person.setState(csvRecord.get("State"));
                person.setZipcode(csvRecord.get("Zipcode"));
                person.setPhoneNumber(csvRecord.get("Phone Number"));
                person.setDateOfBirth(csvRecord.get("Date of Birth"));
                System.out.println(person);
            }
        } catch (IOException ex) {

        }
    }
}

