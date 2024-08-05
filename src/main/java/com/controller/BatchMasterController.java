package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BatchMasterDTO;
import com.model.BatchMaster;
import com.model.CourseMaster;
import com.model.Success;
import com.model.UserMaster;
import com.service.BatchMasterServiceImpl;

@RestController
@RequestMapping("/BatchMaster")
@CrossOrigin("*")
public class BatchMasterController {
	
	@Autowired
	BatchMasterServiceImpl batchMasterService;

//	@PostMapping("/addBatch")
//	public BatchMaster addBatchMaster(@RequestBody BatchMaster batch) {
//		
//		return batchMasterService.addBatchMaster(batch);
//	}
	
	@PostMapping("/addBatch")
	public BatchMaster addBatchMaster(@RequestBody BatchMasterDTO batchDTO) {
	    return batchMasterService.addBatchMaster(batchDTO);
	}
	
	
	@GetMapping("/getBatch")
	List<BatchMaster> getBatchMaster(){
		return batchMasterService.getBatchMaster();
	}
	
	@DeleteMapping("/deleteBatch/{B_id}")
	public ResponseEntity<Success> deleteBatch(@PathVariable int B_id) {
		boolean isdeleted= batchMasterService.deleteBatch(B_id);
		  if (isdeleted) {
			  Success success=new Success("Deleted Successfully");
			return new ResponseEntity<Success>(HttpStatus.ACCEPTED);
		}
		  else {
			  Success failure=new Success("Unable to delete");
			  return new ResponseEntity<Success>(HttpStatus.BAD_REQUEST);
		  }
				
	}
	
//	@PutMapping("updateBatch/{id}")
//	public BatchMaster updateBatch( @RequestBody BatchMaster batch,@PathVariable int B_id) {
//		//TODO: process PUT request	
//		return batchMasterService.updateBatch(batch, B_id);
//	}
	@PutMapping("/updateBatch/{B_id}")
	public BatchMaster updateBatch(@RequestBody BatchMasterDTO batchDTO, @PathVariable int B_id) {
	    return batchMasterService.updateBatch(batchDTO, B_id);
	}
	
	@GetMapping("/getTrainers")
    public List<UserMaster> getAllTrainers() {        return batchMasterService.getAllTrainers();
    }

    @GetMapping("/getCourses")
    public List<CourseMaster> getAllCourses() {
        return batchMasterService.getAllCourses();
    }
	
	

	
	
}
