
/*@Author hsomagat
*Project name:SaloonBookApplication
*  This is interface where put functionalities
*/
package com.cg.saloonbookspringboot.service;

import java.util.List;

import com.cg.saloonbookspringboot.dto.Customer;
import com.cg.saloonbookspringboot.dto.Saloon;





public interface SaloonService {
	public  Saloon addSaloon(Saloon sal);
	public  List<Saloon>searchByName(String name);
	public  Saloon assignCustomer(String name, Customer customer)   ;
}
