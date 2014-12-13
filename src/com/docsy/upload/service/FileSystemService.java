package com.docsy.upload.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.docsy.upload.IUploadParams;
import com.docsy.upload.UploadParamsFS;

public class FileSystemService implements IUploadService{
	
	
	File mUploadHome=null;
	
	public FileSystemService(String aUploadHome) throws Exception{
		boolean initialized=setUploadDirectoryHome(aUploadHome);
		if(!initialized){
			throw new Exception("Could not initialize Upload Directory "+aUploadHome);
		}
	}
	@SuppressWarnings("finally")
	@Override
	public boolean uploadDocument(IUploadParams params) {
		
		
		if(!(params instanceof UploadParamsFS)){
			return false;
		}
		UploadParamsFS fsParams=(UploadParamsFS)params;
		boolean success=false;
		BufferedOutputStream bos=null;
		
		try {
			StringBuilder value=new StringBuilder("");
			BufferedReader bFileReader=null;
			try{
				InputStreamReader fileReader=new InputStreamReader(fsParams.getFileStream());
				bFileReader= new BufferedReader(fileReader);
				char[] buffer = new char[2048];
				for (int length = 0; (length = bFileReader.read(buffer)) > 0;) {
					value.append(buffer, 0, length);
				}
			}finally{
				if(bFileReader!=null){
					bFileReader.close();
				}
			}
			
			File destinationDirectory=new File(mUploadHome,fsParams.getSourceHash());
			if(!destinationDirectory.exists()){
				destinationDirectory.mkdirs();
			}
			File typeDir= new File(destinationDirectory,fsParams.getUploadType().getFolderName());
			if(!typeDir.exists()){
				typeDir.mkdirs();
			}
			FileOutputStream fos= new FileOutputStream(new File(typeDir,UploadParamsFS.getHash(fsParams.getFileName())));
			bos= new BufferedOutputStream(fos);
			bos.write(value.toString().getBytes());
			success=true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bos!=null){
				try{
					bos.close();
				}catch(IOException e){
					
				}
			}
		return success;
	}
	
	
	}
	
	private boolean setUploadDirectoryHome(String aUploadHome) {
		File uploadHome = new File(aUploadHome);
		boolean success=true;
		if(!uploadHome.exists()){
			success=uploadHome.mkdirs();
		}
		mUploadHome=uploadHome;
		return success;
	}
	
	
	

}
