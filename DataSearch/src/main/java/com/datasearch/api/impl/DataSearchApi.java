package com.datasearch.api.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datasearch.createperson.CreatePerson;
import com.datasearch.request.RequestPerson;
import com.datasearch.searchByFirstName.SearchPerson;

@RestController
public class DataSearchApi {
	@RequestMapping(value = "/createPerson", method = RequestMethod.POST)
	public ResponseEntity<String> createPerson(@RequestBody RequestPerson person)
	{
		CreatePerson createPerson = new CreatePerson();

		try {
			createPerson.createPerson(person);
		} catch (NullPointerException | IllegalArgumentException | IOException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>("Successfully inserted the data", HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchPersonByFirstName", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<String[]>> searchPersonOnFirstName(@RequestParam(value = "searchPersonOnFirstName") String searchString)
	{
		SearchPerson searchPerson = new SearchPerson();
		List<String[]> resultList = null;
		try {
			resultList = searchPerson.searchByFirstName(searchString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String[]> emptyList = new ArrayList<>();
		String[] e = {"No data Exist"};
		emptyList.add(e);
		if(resultList.isEmpty())
		{
			return new ResponseEntity<>(emptyList, HttpStatus.OK);
		}

		return new ResponseEntity<>(resultList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchPersonByID", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<String[]>> searchPersonOnID(@RequestParam(value = "searchPersonOnID") String searchString)
	{
		SearchPerson searchPerson = new SearchPerson();
		List<String[]> resultList = null;
		try {
			resultList = searchPerson.searchByID(searchString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String[]> emptyList = new ArrayList<>();
		String[] e = {"No data Exist"};
		emptyList.add(e);
		if(resultList.isEmpty())
		{
			return new ResponseEntity<>(emptyList, HttpStatus.OK);
		}

		return new ResponseEntity<>(resultList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchPersonByPhone", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<String[]>> searchPersonOnPhoneNumber(@RequestParam(value = "searchPersonOnPhoneNumber") String searchString)
	{
		SearchPerson searchPerson = new SearchPerson();
		List<String[]> resultList = null;
		try {
			resultList = searchPerson.searchByPhoneNumber(searchString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String[]> emptyList = new ArrayList<>();
		String[] e = {"No data Exist"};
		emptyList.add(e);
		if(resultList.isEmpty())
		{
			return new ResponseEntity<>(emptyList, HttpStatus.OK);
		}

		return new ResponseEntity<>(resultList, HttpStatus.OK);
	}
}
