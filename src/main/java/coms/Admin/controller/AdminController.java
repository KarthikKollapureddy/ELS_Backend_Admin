package coms.Admin.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coms.Admin.Service.AdminService;
import coms.Admin.bean.Grades;
import coms.Admin.bean.Subjects;
import coms.Admin.exception.GradeAlreadyExists;
import coms.Admin.exception.GradeNotFound;
import coms.Admin.exception.SubjectAlreadyExists;
import coms.Admin.exception.SubjectNotFound;

@RestController
@RequestMapping("/elearning/api/admin")
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired AdminService adminService;
	
	@PostMapping("/addGrades")
	public Grades addGrad(@RequestBody Grades grad) throws GradeAlreadyExists{
		
		return adminService.insertGrade(grad);
		
	}
	
	@GetMapping("/getGrades")
	public List<Grades> getGrade() throws Exception{
		
		return adminService.grades();
		
	}
	
	@PatchMapping("/editGrad/{gradId}")
	public Grades editGrade(@RequestBody String gradName,@PathVariable Integer gradId) throws GradeNotFound{
		
		return adminService.updateGrad(gradName, gradId);
		
	}
	
	@DeleteMapping("/deleteGrad/{gradId}")
	public String deleteGrade(@PathVariable Integer gradId) throws GradeNotFound{
		adminService.deleteGrade(gradId);
		return "Grade with Id "+gradId+" deleted";
	
		
		
		
	}
	
	@GetMapping("/getInfo")
	public ResponseEntity<Map<String,Integer>> getInformation(){
		return adminService.fetchInfo();
	}
	
	@PostMapping("/addSubject")
	public Subjects insertSubject(@RequestBody Subjects subject) throws SubjectAlreadyExists{
		return adminService.insertSubjects(subject);
		
	}
	
	@GetMapping("/getSubjects")
	public List<Subjects> getAllSubjects() throws SubjectNotFound{
		return (adminService.subjects());
	}
	
	@PatchMapping("/editSub/{subId}")
	public Subjects updateSubjectName(@PathVariable int subId,@RequestBody String subName) throws SubjectNotFound{
		return adminService.updateSubjects(subId, subName);
		
	}
	
	@DeleteMapping("/deleteSub/{subId}")
	public String deleteSubName(@PathVariable int subId) throws SubjectNotFound{
		adminService.deleteSub(subId);
		return "Subject with Id "+subId+" deleted";
	}
	
	@GetMapping("/getGrade/{id}")
	public Grades getGradeInfo(@PathVariable int id) {
		return adminService.getGrade(id);
	}

	@GetMapping("/getSubject/{id}")
	public Subjects getSubjectInfo(@PathVariable Integer id) {
		return adminService.getSubject(id);
	}

	

}
