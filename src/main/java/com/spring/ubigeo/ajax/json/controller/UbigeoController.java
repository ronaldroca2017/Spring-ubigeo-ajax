package com.spring.ubigeo.ajax.json.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.ubigeo.ajax.json.dao.IUbigeoDao;
import com.spring.ubigeo.ajax.json.entity.Departamento;
import com.spring.ubigeo.ajax.json.entity.Distrito;
import com.spring.ubigeo.ajax.json.entity.Provincia;

@Controller
public class UbigeoController {

	@Autowired
	IUbigeoDao dao;

	@RequestMapping("/inicio")
	public ModelAndView inicio() throws Exception {
		System.out.println("CONTROLLER OK!");
		return new ModelAndView("ubigeo");
	}

	@RequestMapping(value = "/Departamento", headers = "Accept=*/*", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public List<Departamento> findAllDepartaments() throws Exception {
		List<Departamento> lstDep = dao.findAllDepartament();
		return lstDep;
	}

	@RequestMapping(value = "/Provincia/{idDep}", headers = "Accept=*/*", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public List<Provincia> findAllProvincies(@PathVariable("idDep") int idDep) throws Exception {
		List<Provincia> lstProv = dao.findAllProvince(idDep);
		return lstProv;
	}

	@RequestMapping(value = "/Distrito/{idProv}", headers = "Accept=*/*", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public List<Distrito> findAllDistritos(@PathVariable("idProv") int idProv) throws Exception {
		List<Distrito> lstDist = dao.findAllDistrict(idProv);
		return lstDist;
	}
	
/*	@RequestMapping(value = "/Provincia.htm", method = RequestMethod.POST )
	@ResponseBody
	public  List<Provincia> findAllProvincies(@RequestParam("idDep") String idDep) throws Exception {
		System.out.println("ENTRO A METODO findAllProvincies -> Id Departamento seleccionado" + idDep);
		List<Provincia> lstProv;
		lstProv = dao.findAllProvince(Integer.parseInt(idDep));
		return lstProv;
	}
*/
	
}
