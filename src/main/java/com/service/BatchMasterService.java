package com.service;

import java.util.List;

import com.dto.BatchMasterDTO;
import com.model.BatchMaster;
import com.model.CourseMaster;
import com.model.UserMaster;


public interface BatchMasterService {

//	BatchMaster addBatchMaster(BatchMaster batch);
	BatchMaster addBatchMaster(BatchMasterDTO batchDTO);
	
	List<BatchMaster> getBatchMaster();
	
    Boolean deleteBatch(int B_id);
	
//    BatchMaster updateBatch(BatchMaster batch,int B_id);
    BatchMaster updateBatch(BatchMasterDTO batchDTO, int B_id);
    
    List<UserMaster> getAllTrainers();
    
    List<CourseMaster> getAllCourses();
    


}
