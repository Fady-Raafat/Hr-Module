package com.futuresoftware.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.futuresoftware.entities.Applicant;
import com.futuresoftware.entities.Authority;
import com.futuresoftware.entities.AvailableJob;
import com.futuresoftware.entities.User;
import com.futuresoftware.service.ApplicantService;
import com.futuresoftware.service.UserService;

@Controller
public class GlobalController {

	@Autowired
	AvailableJob availableJobClone;

	@Autowired
	Applicant applicantClone;

	@Autowired
	ApplicantService applicantService;
	@Autowired
	User user;
	@Autowired
	Authority authority;
	@Autowired
	UserService userService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	boolean contIsDateValid = false;

	// Views************************

	@RequestMapping("/")
	public String homePage() {

		return "HomePage";
	}

	@RequestMapping("/admin")
	public String adminPage(ModelMap map) {

		List<Applicant> applicantsList = applicantService.getAllApplicants();

		map.addAttribute("applicantsList", applicantsList);

		return "AdminDashBoard";
	}

	@RequestMapping("/management")
	public String managementPage(ModelMap map) {

		List<Applicant> applicantsList = applicantService.getAllApplicants();

		map.addAttribute("applicantsList", applicantsList);

		return "ManagerDashBoard";
	}

	/// we are here :)

	@RequestMapping("/editApplicant")
	public String showEditApplicant(@RequestParam("id") int id, ModelMap modelMap) {

		Applicant editableApplicant = applicantService.getApplicantById(id);

		System.out.println(editableApplicant.getPassword());

		modelMap.addAttribute("editableApplicant", editableApplicant);

		return "EditApplicant";

	}

	// step 2: save edited values and show list

	@RequestMapping("/saveUpdatedApplicant")
	public String editUser(@ModelAttribute Applicant applicant, ModelMap modelMap) {

		applicantService.updateApplicant(applicant);

		List<Applicant> applicantsList = applicantService.getAllApplicants();

		modelMap.addAttribute("applicantsList", applicantsList);

		return "ManagerDashBoard";

	}

	@RequestMapping("/deleteApplicant")
	public String deleteUser(@RequestParam("id") int id, ModelMap modelMap) {

		applicantService.deleteApplicant(id);
		List<Applicant> applicantsList = applicantService.getAllApplicants();

		modelMap.addAttribute("applicantsList", applicantsList);

		return "ManagerDashBoard";

	}

	@RequestMapping("/applicant")
	public String applicantStatusPage() {

		return "ApplicantStatus";
	}

	@RequestMapping("/access-denied")
	public String exceptionHandlingPage() {

		return "access-denied";
	}

	@RequestMapping("/login")
	public String loginPage() {

		return "Login";
	}

	@GetMapping("/register")
	public String registrationForm() {

		return "Register";
	}

	// Actions***********************

	// ***** save applicant data **********************

	@PostMapping("/saveapplicantdata")
	public String saveapplicantData(ModelMap map, @ModelAttribute Applicant applicant) {

		boolean isValid = validateApplicant(applicant);

		if (isValid) {

			applicantClone = cloneApplicant(applicant);
			return "JobDetails";
		}

		else {

			map.addAttribute("registration_status", "Registration Failed! Please Review Your Inputs.\n "
					+ "User Name already Registered / Invalid Date Format "
					+ "/ Less Than 6 Characters Password Or E-Mail Pattern Is Not Recognized.");

			return "Register";
		}

	}

	// *************** save job details ****************

	@PostMapping("/savejobdata")
	public String saveJobDetails(ModelMap map, @ModelAttribute AvailableJob availableJob) {

		availableJobClone = cloneAvailableJob(availableJob);

		return "Uploads";
	}

	// save uploaded cv *******************************

	@PostMapping("/saveupload")
	public String saveapplicationForm(ModelMap map, @RequestParam("file") MultipartFile file) {

		if(file.getSize() == 0) {
			
		map.addAttribute("message","File Not Found Or Invalid");
		return "Uploads";
			
			
		}else {

		
		try {
			byte[] cv = file.getBytes();

			saveApplicantFullData(applicantClone, availableJobClone, cv);

			return "LastPage";
			
			

		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
		
		
		
		}

	}

//********************bind user with job with cv****************************

	public void saveApplicantFullData(Applicant applicant, AvailableJob availavleJob, byte[] cv) {

		applicant.setCv(cv);

		applicant.setAvailableJob(availavleJob);

		String originalPassword = applicant.getPassword();

		String encodedPassword = bCryptPasswordEncoder.encode(applicant.getPassword());
		applicant.setPassword(encodedPassword);

		applicantService.saveApplicant(applicant);

		Applicant savedApplicant = applicantService.getApplicantByusername(applicant.getUsername());

		user.setId(savedApplicant.getId());
		user.setUserName(savedApplicant.getUsername());
		user.setEnabled(true);
		user.setPassword(originalPassword);

		authority.setRole("ROLE_USER");

		ArrayList<Authority> authorityList = new ArrayList<Authority>();

		authorityList.add(authority);

		user.setAuthorityList(authorityList);

		authority.setUser(user);

		userService.insertUser(user);

	}

//************** validate applicant inputs ****************************	

	private boolean validateApplicant(Applicant applicant) {

		String userName = applicant.getUsername();
		String password = applicant.getPassword();
		String firstName = applicant.getFirstName();
		String lastName = applicant.getLastName();
		String eMail = applicant.geteMail();
		String address = applicant.getAddress();
		Date BDate = applicant.getBirthDate();
		String mobileNo = applicant.getMobileNo();
		String gender = applicant.getGender();

		contIsDateValid = applicant.isDateNotValid(); // true in case of invalid date

		if ((userName.equals("") || password.equals("") || firstName.equals("") || lastName.equals("")
				|| eMail.equals("") || address.equals("") || mobileNo.equals("") || gender == (null)) || BDate == null)

		{

			return false; // BAD DATA

		} else if (contIsDateValid) {

			return false; // date format not valid
		}

		else if ((applicantService.getApplicantByusername(userName))!=null) {

			return false; // username already exists 
		}

		else {

			return true; // VALID
		}

	}

	@Bean
	private Applicant getApplicantInstance() {

		return new Applicant();
	}

	@Bean
	private User getUserInstance() {

		return new User();
	}

	@Bean
	private Authority getAuthorityInstance() {

		return new Authority();
	}

	@Bean
	private AvailableJob getavailableJobInstance() {

		return new AvailableJob();
	}

	private Applicant cloneApplicant(Applicant applicant) {

		applicantClone.setId(applicant.getId());

		applicantClone.setUsername(applicant.getUsername());
		applicantClone.setPassword(applicant.getPassword());
		applicantClone.setFirstName(applicant.getFirstName());
		applicantClone.setLastName(applicant.getLastName());
		applicantClone.seteMail(applicant.geteMail());

		applicantClone.setAddress(applicant.getAddress());

		String bDateStr = new SimpleDateFormat("dd/MM/yyyy").format(applicant.getBirthDate()).toString();

		applicantClone.setBirthDate(bDateStr);

		applicantClone.setMobileNo(applicant.getMobileNo());
		applicantClone.setGender(applicant.getGender());

		applicantClone.setCv(applicant.getCv());

		return applicantClone;
	}

	private AvailableJob cloneAvailableJob(AvailableJob availableJob) {

		availableJobClone.setJobName(availableJob.getJobName());
		availableJobClone.setReqExperienceYears(availableJob.getReqExperienceYears());
		availableJobClone.setDescription(availableJob.getDescription());
		availableJobClone.setAvailJobId(availableJob.getAvailJobId());

		return availableJobClone;
	}

}
