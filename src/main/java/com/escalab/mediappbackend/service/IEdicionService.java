package com.escalab.mediappbackend.service;

import java.util.List;

import com.escalab.mediappbackend.dto.EdicionDTO;
import com.escalab.mediappbackend.model.EdicionModel;

public interface IEdicionService extends ICRUD<EdicionModel>{
	
	public List<EdicionDTO> findEdicion();
	
	
	
}
