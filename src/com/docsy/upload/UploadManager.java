package com.docsy.upload;

import java.io.InputStream;

import com.docsy.upload.service.IUploadService;

public class UploadManager implements IUploadServiceManager, IUploadManager{
	
	private IUploadService mService;
	@Override
	public boolean uploadFile(InputStream fileStream) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void register(IUploadService service) {
		
		if(mService!=null){
			mService=service;
		}
		
	}
	
	

}
