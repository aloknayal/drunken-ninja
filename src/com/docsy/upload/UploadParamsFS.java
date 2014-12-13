package com.docsy.upload;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



import com.docsy.upload.service.IUploadService.Type;

public class UploadParamsFS implements IUploadParams{
	
	private InputStream fileStream;
	
	private String fileName;
	
	private Type uploadType;
	
	private String sourceHash;
	
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
		
	}
	
	public static String getHash(String ip){
		
		String hash=ip;
		try {
			MessageDigest digest= MessageDigest.getInstance("MD5");
			byte[] bytes=digest.digest(ip.getBytes());
			hash= new String(bytes);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash;
	}
	
	public String getSourceHash() {
		return sourceHash;
	}
	
	public void setSourceHash(String source) {
		this.sourceHash = source;
	}
	
	public InputStream getFileStream() {
		return fileStream;
	}
	
	public void setFileStream(InputStream fileStream) {
		this.fileStream = fileStream;
	}
	
	public Type getUploadType() {
		return uploadType;
	}
	
	public void setUploadType(Type uploadType) {
		this.uploadType = uploadType;
	}

}
