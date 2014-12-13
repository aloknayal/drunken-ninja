package com.docsy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class DocServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//Collection<Part> parts=req.getParts();
		StringBuilder value=new StringBuilder("");


		InputStream i=req.getInputStream();
		BufferedReader reader= new BufferedReader(new InputStreamReader(i));
		char[] buffer = new char[2048];
		for (int length = 0; (length = reader.read(buffer)) > 0;) {
			value.append(buffer, 0, length);
		}



		/*DocTags tag= new DocTags();
		tag.setState(tagsOn);
		DocTagManager.register("a", tag);*/
		File f=new File("/test5.html");
		FileOutputStream fos= new FileOutputStream(f);
		BufferedOutputStream bos= new BufferedOutputStream(fos);
		bos.write(value.toString().getBytes());
		bos.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DocTags dt=DocTagManager.getTag("a");
		PrintWriter writer=resp.getWriter();
		writer.write(dt.getStateJSon());
		writer.flush();
	}


}
