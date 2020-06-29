package com.harik.cs.cloudstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketSourceOption;
import com.google.cloud.storage.StorageClass;

@RestController
public class GCSOperations {
	
	@Autowired
	public Storage storage;
	
	/**
	 * 
	 */
	@RequestMapping(path  = {"/createBucket"}, method = {RequestMethod.GET})
	public void createBukcet() {
		String bucketName = "hakruharku";	
		
		  Bucket bucket = storage.create(BucketInfo.newBuilder(bucketName)
		  // See here for possible values: http://g.co/cloud/storage/docs/storage-classes
		  .setStorageClass(StorageClass.COLDLINE) // Possible values:
		  //http://g.co/cloud/storage/docs/bucket-locations#location-mr
		  .setLocation("asia") .build());
		  
		  System.out.println(bucket.getName() + "was created");
		  
		 
		
		long bucketMetageneration = 42;
		 boolean deleted = storage.delete(bucketName,
		     BucketSourceOption.metagenerationNotMatch(bucketMetageneration));	

		 if (deleted) {
		   // the bucket was deleted
			 System.out.println(bucketName+" was deleted successfully");
		 } else {
		   // the bucket was not found
			 System.out.println(bucketName+" was not found");
		 }
		 }
	}


