package com.docsy.upload.service;

import com.docsy.upload.IUploadParams;

public interface IUploadService {
	public enum Type{
		SOURCE("source"),TEMPLATE("template"),HTML("html"),TARGET("target");
		private String folderName;
		
		private Type(String folderName) {
			this.folderName=folderName;
		}
		public String getFolderName() {
			return folderName;
		}
	}
	public boolean uploadDocument(IUploadParams params) ;

}
