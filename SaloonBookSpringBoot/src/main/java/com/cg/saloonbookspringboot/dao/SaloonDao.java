
/*@Author hsomagat
*Project name:SaloonBookApplication
*  This is saloondao interface where put methods
*/
package com.cg.saloonbookspringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.saloonbookspringboot.dto.Saloon;
 



public interface SaloonDao extends JpaRepository<Saloon, Integer>{
	/**
	 *  * @author hsomagat
	 * method name: searchsaloonbyname
	 * returns :- List(Saloon)
	 *
	 */
	public  List<Saloon>findByName(String name) ;
}
