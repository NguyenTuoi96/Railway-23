package com.vti.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.dto.UserDTO;
import com.vti.entity.Device;
import com.vti.entity.User;
import com.vti.entity.UserDevice;
import com.vti.repository.IDeviceRepository;
import com.vti.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;
	
	@Autowired
	private IDeviceRepository repositoryDevice;

	public UserDTO getUserByEmailPassword(String email, String password) {
		UserDTO dto = new UserDTO();
		User user = repository.getUserByEmailPassword(email, password);
		if(repository.getUserByEmailPassword(email, password) == null) {
			dto.setMess("login thất bại");
			dto.setUser(user);
		}else {
			dto.setMess("login thành công");
			dto.setUser(user);
		}
		return dto;
	}

	public void createUser(User User) {
		repository.createUser(User);
	}
	
	public List<String> getListDevicesForUserName(String userFullname, String monthYear) {
		List<String> rs = new ArrayList<>();
		List<User> userList = repository.getUsersByName(userFullname);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        for(User user : userList) {
        	int cnt = 0;
        	for(UserDevice userDevice : user.getUserDeviceList()) {
				int userId = userDevice.getId().getUserId();
				String month = dateFormat.format(userDevice.getBorrowDate());				
				if(userId == user.getUserId() && monthYear.equals(month)) {
					if(cnt == 0) {
						rs.add(user.getEmail() + ":");
					}
					Device device = repositoryDevice.getDeviceByID(userDevice.getId().getDeviceId());
					rs.add(device.getDeviceName());
		        	cnt++;
				}
			}
        }
        
		return rs;
	}
}
