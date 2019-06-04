
/*@Author hsomagat
*Project name:SaloonBookApplication
*  This is saloonserviceimpl class which implements bussiness logic
*/

package com.cg.saloonbookspringboot.service;


 
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;

import com.cg.saloonbookspringboot.controller.SaloonController;
import com.cg.saloonbookspringboot.dao.SaloonDao;
import com.cg.saloonbookspringboot.dto.Customer;
import com.cg.saloonbookspringboot.dto.Saloon;



@Service

public class SaloonServiceImpl implements SaloonService {
	//SaloonDaoImpl sal=new SaloonDaoImpl();
	@Autowired
SaloonDao saldao;
	/**
	 *  * @author hsomagat
	 * method name: addsaloon
	 * returns :- sal(Saloon)
	 *
	 */
public Saloon addSaloon(Saloon sal) {
	 
		if(SaloonController.logger.isDebugEnabled()){
			SaloonController.logger.debug("addSaloon addSaloon(Saloon) is executed!");
			SaloonController.logger.debug(" add saloon");
			} 
	 

	return saldao.save(sal);
	
	
}
/**
 *  * @author hsomagat
 * method name: search saloonbyname
 * returns :- name(Saloon)
 * 
 */
public List<Saloon> searchByName(String name)  {
	if(SaloonController.logger.isDebugEnabled()){
		SaloonController.logger.debug("searchSaloonService searchSaloon(Saloon) is executed!");
		SaloonController.logger.debug("search the saloon by name");
		} 
 
		return saldao.findByName(name);
}
/**
 *  * @author hsomagat
 * method name: assign customer to saloon
 * returns :- List(Saloon)
 *
 */
public Saloon assignCustomer(String name, Customer customer) {
	if(SaloonController.logger.isDebugEnabled()){
		SaloonController.logger.debug("assignCustomer assignCustomer(Customer) is executed!");
		SaloonController.logger.debug(" assign customer to saloon");
		} 
	List<Saloon> saloon=saldao.findByName(name);
	for (Saloon saloon2 : saloon) {
		if(saloon2.getName().equals(name)) {
			
		List<Customer> customerList=saloon2.getCustomerList();
		customerList.add(customer);
		saloon2.setCustomerList(customerList);
		return saloon2;
		
		} 
		
	}
	/*if(saloon.isEmpty())
		throw new SaloonNotFoundException("saloon not found exception");
	
	return null;
	*/
	return null;
	
	
}
/*@Override
public Customer addCustomer(Customer cus) {
	// TODO Auto-generated method stub
	return saldao.save(cus);
}*/


}
