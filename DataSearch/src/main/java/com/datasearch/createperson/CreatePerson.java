package com.datasearch.createperson;

import com.datasearch.common.IDNumberData;
import com.datasearch.common.IDNumberParser;
import com.datasearch.request.RequestPerson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* Class to create the Person.
* @author Srikanth Rp
*/
public class CreatePerson 
{
	public void createPerson(RequestPerson person) throws NullPointerException, IllegalArgumentException, FileNotFoundException, IOException
	{
		if(person == null)
		{
			throw new NullPointerException("Person is null");
		}
		
		if(org.apache.commons.lang3.StringUtils.isBlank(person.getFirstName()))
		{
			throw new IllegalArgumentException("First name may be null or empty or blank");
		}
		
		if(org.apache.commons.lang3.StringUtils.isBlank(person.getLastName()))
		{
			throw new IllegalArgumentException("First name may be null or empty or blank");
		}

		String idNumber = person.getIdNumber().toString();
		String phoneNumber = person.getMobileNumber().toString();
		IDNumberParser idNumberParser = new IDNumberParser();
		IDNumberData idNumberData;
		
		try {
			idNumberData = idNumberParser.parse(idNumber);
		} 
		catch (Exception e) 
		{
			throw new IllegalArgumentException("ID passed is not valid African");
		}
		
		final String userInformationFilePath = "clientInformation.csv";
		final List<String> idNumbers = new ArrayList<>();
		final List<String> phoneNumbers = new ArrayList<>();
		
		try (final CSVReader personCSVReader = new CSVReader(new FileReader(userInformationFilePath)))
        {
            List<String[]> personInformation = personCSVReader.readAll();
            
            for(int i=0; i<personInformation.size(); i++)
            {
            	String[] str = personInformation.get(i);
            	idNumbers.add(str[2]);
            	phoneNumbers.add(str[3]);
            }
        }
		
		if(idNumbers.contains(idNumber))
		{
			throw new IllegalArgumentException("Id Number is duplicate");
		}
		
		if(phoneNumbers.contains(phoneNumber))
		{
			throw new IllegalArgumentException("Mobile Number is duplicate");
		}
		
		try (final CSVWriter userInformationWriter = new CSVWriter(new FileWriter(userInformationFilePath, true)))
        {
			final String[] nextLine = {person.getFirstName(), person.getLastName(), idNumber, phoneNumber, person.getPhysicalAddress()};
            userInformationWriter.writeNext(nextLine);
        }
        catch (final IOException e)
        {
            throw new RuntimeException("Error while trying to create a file to write user information", e);
        }
	}
}
