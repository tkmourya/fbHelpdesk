package com.FBHelpdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FBHelpdesk.entity.User;
import com.FBHelpdesk.repository.UserRepository;

public interface UserServices {
	String addUsers(User user);// add user in database
	String addSuccess();
	boolean checkEmail(String email); //check email already exist in database or not
	String addExists(); // print exist or not on web page(Register)
	String loginExists();//print exist or not on web page(Login)
	boolean validate(String email, String password); // validation (login)
	boolean adminValidate(String email, String password);
	String getAdminEmail(String email);

}
@Service
class UserServicesImplementation implements UserServices{
	@Autowired
	UserRepository UserRepo;
	

	@Override
	public String addUsers(User user) {
		try {
            UserRepo.save(user);
            return "Added successfully";
        } catch (Exception e) {
            return "Error occurred while Registration";
        }
	}

	@Override
	public String addSuccess() {
		return " Application Success !";
	}

	@Override
	public boolean checkEmail(String email) {
		return UserRepo.existsByEmail(email);
	}

	@Override
	public String addExists() {
		return "Already Exists !";
	}

	@Override
	public String loginExists() {
		return "Incorrect credentials, try again !";
	}

	@Override
	public boolean validate(String email, String password) {
		if(UserRepo.existsByEmail(email)) {
			User u=UserRepo.getByEmail(email);
			String dbpassword=u.getPassword();
			if(password.equals(dbpassword)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public boolean adminValidate(String email, String password) {
		if(UserRepo.existsByEmail(email)) {
			User u=UserRepo.getByEmail(email);
			String dbpassword=u.getPassword();
			if(password.equals(dbpassword)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public String getAdminEmail(String email) {
		User u=UserRepo.getByEmail(email);
		return u.getEmail();
	}
	
}
