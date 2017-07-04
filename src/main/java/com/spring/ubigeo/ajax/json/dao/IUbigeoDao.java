package com.spring.ubigeo.ajax.json.dao;

import java.util.List;

import com.spring.ubigeo.ajax.json.entity.Departamento;
import com.spring.ubigeo.ajax.json.entity.Distrito;
import com.spring.ubigeo.ajax.json.entity.Provincia;



public interface IUbigeoDao {

	List<Departamento> findAllDepartament() throws Exception;
	List<Provincia> findAllProvince(int dep)throws Exception;
	List<Distrito> findAllDistrict(int prov)throws Exception;
	
}
