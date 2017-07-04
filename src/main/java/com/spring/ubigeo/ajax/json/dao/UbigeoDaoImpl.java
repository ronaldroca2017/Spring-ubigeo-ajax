package com.spring.ubigeo.ajax.json.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.ubigeo.ajax.json.entity.Departamento;
import com.spring.ubigeo.ajax.json.entity.Distrito;
import com.spring.ubigeo.ajax.json.entity.Provincia;
import com.spring.ubigeo.ajax.json.jdbc.AccesoDB;

@Repository
public class UbigeoDaoImpl implements IUbigeoDao {

	
	
	 	Connection cn;
	    PreparedStatement ps;
	    ResultSet rs;
	    String sql;

	@Override
	public List<Departamento> findAllDepartament() throws Exception {
		  List<Departamento> lstDep = null;
	      try {
	            cn = AccesoDB.getConnection();
	            sql = "SELECT * FROM departamentos";
	            ps = cn.prepareStatement(sql);  
	            rs = ps.executeQuery();
	            lstDep = new ArrayList<>();
	            while(rs.next()){
	            	
	            	Departamento d = new Departamento();
	            	d.setIdDep(rs.getInt("iddepartamento"));
	            	d.setNomDep(rs.getString("departamento"));                   
	            	lstDep.add(d);             
	              
	            }
	            rs.close();
	            ps.close();
	        } catch (Exception e) {
	            throw e;
	        }finally{
	            cn.close();
	        }
	      return lstDep;
	}

	@Override
	public List<Provincia> findAllProvince(int dep) throws Exception {
		 List<Provincia> lstProv = null;
	      try {
	            cn = AccesoDB.getConnection();
	            sql = "SELECT * FROM provincias where iddepartamento = " + dep;
	            ps = cn.prepareStatement(sql);  
	            rs = ps.executeQuery();
	            lstProv = new ArrayList<>();
	            while(rs.next()){
	            	
	            	Provincia prov = new Provincia();
	            	prov.setIdProv(rs.getInt("idprovincia"));
	            	prov.setNomProv(rs.getString("provincia"));                   
	            	lstProv.add(prov);
	                            
	            }
	            rs.close();
	            ps.close();
	        } catch (Exception e) {
	            throw e;
	        }finally{
	            cn.close();
	        }
	      return lstProv;
	}

	@Override
	public List<Distrito> findAllDistrict(int prov) throws Exception {
		 List<Distrito> lstDist = null;
	      try {
	            cn = AccesoDB.getConnection();
	            sql = "SELECT * FROM distritos where idprovincia = " + prov;
	            ps = cn.prepareStatement(sql);  
	            rs = ps.executeQuery();
	            lstDist = new ArrayList<>();
	            while(rs.next()){
	            	
	            	Distrito dist = new Distrito();
	            	dist.setIdDist(rs.getInt("iddistrito"));
	            	dist.setNomDist(rs.getString("distrito"));                   
	            	lstDist.add(dist);
	               
	              
	            }
	            rs.close();
	            ps.close();
	        } catch (Exception e) {
	            throw e;
	        }finally{
	            cn.close();
	        }
	      return lstDist;
	}

}
