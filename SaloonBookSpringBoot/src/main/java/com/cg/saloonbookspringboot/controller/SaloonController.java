package com.cg.saloonbookspringboot.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.saloonbookspringboot.dto.Saloon;
import com.cg.saloonbookspringboot.service.SaloonService;


@RestController
@RequestMapping("/saloon")

/**
 *  * @author hsomagat
 * method name: addSaloon
 * param:- sal (Saloon)
 * returns :- sal1(Saloon)
 *
 */
@CrossOrigin(origins="http://localhost:4200")
public class SaloonController {

	@Autowired
	SaloonService saloonservice;
	public static final Logger logger = Logger.getLogger(SaloonService.class); 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Saloon>  addSaloon(@ModelAttribute Saloon sal){
		Saloon sal1=saloonservice.addSaloon(sal);
		
		return new ResponseEntity<Saloon>(sal1,HttpStatus.OK);
	}
	/**
	 *  * @author hsomagat
	 * method name: searchsaloon
	 * param:- name (Saloon)
	 * returns :- myList(Saloon)
	 *
	 */
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ResponseEntity<List<Saloon>> searchSaloon(@RequestParam("name")String name){
		List<Saloon>myList=saloonservice.searchByName(name);
		if(myList.isEmpty()) {
			return new ResponseEntity("saloon not found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Saloon>>(myList,HttpStatus.OK);
	}
	/*@RequestMapping(value="/assign",method=RequestMethod.POST)
	public ResponseEntity<List<Saloon>> assignCustomer(@RequestParam("name")String name,@ModelAttribute Customer customer){
		Customer custone=new Customer();
		 custone.setName(name);  
		 custone.setId(id);
		 custone.setEmail(emailid);
		 custone.setMobileNumber(mobileNumber);
		 custone.setId(id);
		 List<Customer> custList=new ArrayList<>();
		 
	 
		 Saloon sal=new Saloon();
		 sal.setId(sal.getId());
		 sal.setName(sal.getName());
		 sal.setPhoneNumber(sal.getPhoneNumber());
		 sal.setAddress(sal.getAddress()); 
		 sal.setCustomerList(custList);
		 saloonservice.assignCustomer(name, customer);
		//List<Customer>myList=saloonservice.assignCustomer(name, customer);
		if(custList.isEmpty()) {
			return new ResponseEntity("saloon not found",HttpStatus.NOT_FOUND);
		}
		//return new ResponseEntity<List<Saloon>>(custList,HttpStatus.OK);
		return new ResponseEntity("ok",HttpStatus.OK);
	}*/
}
