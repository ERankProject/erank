package com.erank.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.erank.dto.SystemClientDto;
import com.erank.model.SystemClients;
import com.erank.model.SystemDomain;
import com.erank.repo.SystemClientRepositary;
import com.erank.repo.SystemDomainRepositary;


@Service
public class SystemClientService {

	
	@Autowired
	private SystemClientRepositary clientRepo;
	
	/*@Autowired
	private TokenProvider tokenProvider;*/
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SystemDomainRepositary domainRepo;
	
	
	public List<SystemClients> getServicesQuestions(){
		return clientRepo.findAll();
	}
	
	public Optional<SystemClients> getQuestionsById(Long system_client_id) {
		return clientRepo.findById(system_client_id);
	}
	
	public SystemClients addClient(SystemClientDto clientDto) {
		
		SystemDomain systemDomain = domainRepo.findById(clientDto.getSystem_domain_id()).get();
		systemDomain.setSystem_domain_id(systemDomain.getSystem_domain_id());
		
		SystemClients systemClient = new SystemClients();
		systemClient.setSystemDomain(systemDomain);
		systemClient.setCompany_name(clientDto.getCompany_name());
		systemClient.setRegistered_id(clientDto.getRegistered_id());
		systemClient.setClient_name(clientDto.getClient_name());
		systemClient.setCategory(clientDto.getCategory());
		systemClient.setPhNum(clientDto.getPhNum());
		systemClient.setEmail(clientDto.getEmail());
		systemClient.setStreet(clientDto.getStreet());
		systemClient.setCity(clientDto.getCity());
		systemClient.setState(clientDto.getState());
		systemClient.setPincode(clientDto.getPincode());
		systemClient.setPassword(passwordEncoder.encode(clientDto.getPassword()));
		systemClient.setCreated_date(LocalDateTime.now());
		return clientRepo.save(systemClient);
	}
	
	public SystemClients updateClient(Long systemClientId,SystemClientDto clientDto) {
		
		SystemDomain systemDomain = domainRepo.findById(clientDto.getSystem_domain_id()).get();
		systemDomain.setSystem_domain_id(systemDomain.getSystem_domain_id());
		
		
		SystemClients systemClient = clientRepo.findById(systemClientId).orElse(null);
		systemClient.setSystemDomain(systemDomain);
		systemClient.setCompany_name(clientDto.getCompany_name());
		systemClient.setRegistered_id(clientDto.getRegistered_id());
		systemClient.setClient_name(clientDto.getClient_name());
		systemClient.setCategory(clientDto.getCategory());
		systemClient.setPhNum(clientDto.getPhNum());
		systemClient.setEmail(clientDto.getEmail());
		systemClient.setStreet(clientDto.getStreet());
		systemClient.setCity(clientDto.getCity());
		systemClient.setState(clientDto.getState());
		systemClient.setPincode(clientDto.getPincode());
	    systemClient.setModified_date(LocalDateTime.now());
		
		return clientRepo.save(systemClient);
		
	}
	
	public SystemClients getByEmailId(SystemClientDto clientDto) {
		
		String client = clientRepo.findByEmail(clientDto.getEmail()).getPassword();
		System.out.println(client);
		boolean isPasswordMatch = passwordEncoder.matches(clientDto.getPassword(), client);
		if(isPasswordMatch == true) {
			//SystemClients authentication = clientRepo.findByEmail(clientDto.getEmail());
			//String token = tokenProvider.createTokenId(authentication);
			//System.out.println(token);
			return clientRepo.findByEmail(clientDto.getEmail());
		}else 
		  return null;
	}
	
	
}
