package com.datasearch.searchByFirstName;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;

/**
* Class to Search based on the input.
* @author Srikanth Rp
*/
public class SearchPerson 
{
	/**
	* Method will help to search the person based on the First Name.
	*/
	public List<String[]> searchByFirstName(String searchByFirstName) throws FileNotFoundException, IOException
	{
		final String userInformationFilePath = "clientInformation.csv";
		List<String[]> searchList = new ArrayList<>();
		
		try (final CSVReader personCSVReader = new CSVReader(new FileReader(userInformationFilePath)))
        {
            List<String[]> personInformation = personCSVReader.readAll();
            
            searchList = personInformation.stream().filter(n -> n[0].equals(searchByFirstName)).collect(Collectors.toList());
        }
            
        if(searchList.isEmpty())
        {
        	return Collections.emptyList();
        }
        
		return searchList;
	}
	
	/**
	* Method will help to search the person based on the ID Number.
	*/
	public List<String[]> searchByID(String searchByID) throws FileNotFoundException, IOException
	{
		final String userInformationFilePath = "clientInformation.csv";
		List<String[]> searchList = new ArrayList<>();
		
		try (final CSVReader personCSVReader = new CSVReader(new FileReader(userInformationFilePath)))
        {
            List<String[]> personInformation = personCSVReader.readAll();
            
            searchList = personInformation.stream().filter(n -> n[2].equals(searchByID)).collect(Collectors.toList());
        }
            
        if(searchList.isEmpty())
        {
        	return Collections.emptyList();
        }
        
		return searchList;
	}
	
	/**
	* Method will help to search the person based on the Phone Number.
	*/
	public List<String[]> searchByPhoneNumber(String searchByPhoneNumber) throws FileNotFoundException, IOException
	{
		final String userInformationFilePath = "clientInformation.csv";
		List<String[]> searchList = new ArrayList<>();
		
		try (final CSVReader personCSVReader = new CSVReader(new FileReader(userInformationFilePath)))
        {
            List<String[]> personInformation = personCSVReader.readAll();
            
            searchList = personInformation.stream().filter(n -> n[3].equals(searchByPhoneNumber)).collect(Collectors.toList());
        }
            
        if(searchList.isEmpty())
        {
        	return Collections.emptyList();
        }
        
		return searchList;
	}

}
