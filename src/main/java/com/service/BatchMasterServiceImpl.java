package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BatchMasterRepository;
import com.dao.CourseMasterRepository;
import com.dao.UserMasterRepository;
import com.dto.BatchMasterDTO;
import com.model.BatchMaster;
import com.model.CourseMaster;
import com.model.UserMaster;

@Service
public class BatchMasterServiceImpl implements BatchMasterService {

	@Autowired
	BatchMasterRepository batchMasterRepo;

	@Autowired
	private UserMasterRepository userMasterRepo;

	@Autowired
	private CourseMasterRepository courseMasterRepo;

//	@Override
//	public BatchMaster addBatchMaster(BatchMaster batch) {
//		
//		UserMaster trainer = userMasterRepo.findById(batch.getTrainer().getUid())
//				.orElseThrow(() -> new RuntimeException("Trainer not found"));
//		CourseMaster course = courseMasterRepo.findById(batch.getCourse().getId())
//				.orElseThrow(() -> new RuntimeException("Course not found"));
//
//		batch.setTrainer(trainer);
//		batch.setCourse(course);
//
//		return batchMasterRepo.save(batch);
//	}
	
	@Override
	public BatchMaster addBatchMaster(BatchMasterDTO batchDTO) {
	    UserMaster trainer = userMasterRepo.findById(batchDTO.getTrainerId())
	            .orElseThrow(() -> new RuntimeException("Trainer not found"));
	    CourseMaster course = courseMasterRepo.findById(batchDTO.getCourseId())
	            .orElseThrow(() -> new RuntimeException("Course not found"));

	    BatchMaster batch = new BatchMaster();
	    batch.setBname(batchDTO.getBname());
	    batch.setSdate(batchDTO.getSdate());
	    batch.setEdate(batchDTO.getEdate());
	    batch.setTrainer(trainer);
	    batch.setCourse(course);

	    return batchMasterRepo.save(batch);
	    
	
	}

	@Override
	public List<BatchMaster> getBatchMaster() {
		return batchMasterRepo.findAll();
	}

	@Override
	public Boolean deleteBatch(int B_id) {
		batchMasterRepo.deleteById(B_id);
		return true;
	}

//	@Override
//	public BatchMaster updateBatch(BatchMaster batch, int B_id) {
//		BatchMaster existingBatch = batchMasterRepo.findById(B_id)
//				.orElseThrow(() -> new RuntimeException("Batch not found"));
//
//		UserMaster trainer = userMasterRepo.findById(batch.getTrainer().getUid())
//				.orElseThrow(() -> new RuntimeException("Trainer not found"));
//		CourseMaster course = courseMasterRepo.findById(batch.getCourse().getId())
//				.orElseThrow(() -> new RuntimeException("Course not found"));
//		
//
//		if (existingBatch != null) {
//			existingBatch.setBname(batch.getBname());
//			existingBatch.setCourse(batch.getCourse());
//			existingBatch.setSdate(batch.getSdate());
//			existingBatch.setEdate(batch.getEdate());
//			existingBatch.setTrainer(batch.getTrainer());
//
//		} else {
//			System.out.println("Batch Master Record is null");
//		}
//
//		return batchMasterRepo.save(existingBatch);
//	}
	
	@Override
	public BatchMaster updateBatch(BatchMasterDTO batchDTO, int B_id) {
	    BatchMaster existingBatch = batchMasterRepo.findById(B_id)
	            .orElseThrow(() -> new RuntimeException("Batch not found"));

	    UserMaster trainer = userMasterRepo.findById(batchDTO.getTrainerId())
	            .orElseThrow(() -> new RuntimeException("Trainer not found"));
	    CourseMaster course = courseMasterRepo.findById(batchDTO.getCourseId())
	            .orElseThrow(() -> new RuntimeException("Course not found"));

	    existingBatch.setBname(batchDTO.getBname());
	    existingBatch.setSdate(batchDTO.getSdate());
	    existingBatch.setEdate(batchDTO.getEdate());
	    existingBatch.setTrainer(trainer);
	    existingBatch.setCourse(course);

	    return batchMasterRepo.save(existingBatch);
	}

	public List<UserMaster> getAllTrainers() {
        return userMasterRepo.findAll();
    }

    public List<CourseMaster> getAllCourses() {
        return courseMasterRepo.findAll();
    }

}
