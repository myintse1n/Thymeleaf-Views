package com.ms.thymeleaf.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ms.thymeleaf.model.entity.State;
import com.ms.thymeleaf.model.repo.StateRepo;

@Service
@Transactional(readOnly = true)
public class StateService {

	@Autowired
	private StateRepo stateRepo;
	
	public List<State> getAll(){
		return stateRepo.findAll();
	}
	
	public long getCount() {
		return stateRepo.count();
	}

	@Transactional
	public void upload(MultipartFile file) {
		
		try {
			var br = new BufferedReader(new InputStreamReader(file.getInputStream()));
			
			String line = null;
			
			while (null != (line = br.readLine())) {
				var entity = new State(line);
				stateRepo.save(entity);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
