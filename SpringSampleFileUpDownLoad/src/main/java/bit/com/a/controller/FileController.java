package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.MediaTypeUtiles;

@RestController
public class FileController {
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("uploadFile")MultipartFile uploadfile, HttpServletRequest req) {
		System.out.println("FileController fileUpload()");
		
		// 경로	src/main/webapp/upload 폴더를 생성할 것!!
		String uploadPath = req.getServletContext().getRealPath("/upload");
		
		// 폴더인 경우
	//	String uploadPath = "d:\\tmp";
		
		String filename = uploadfile.getOriginalFilename();
		String filepath = uploadPath + File.separator + filename;	// File.separator == '/'
		
		System.out.println("filepath = " + filepath);
		
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadfile.getBytes());
			
			os.close();	// 중요!!
		} catch (Exception e) {
			e.printStackTrace();
			
			return "file upload fail";
		}
		
		return "file upload success";
	}
	
	@RequestMapping(value = "/fileDownload")
	public ResponseEntity<InputStreamResource> dwonload(String fileName, HttpServletRequest req) throws Exception{
		System.out.println("FileController fileDownload()");
		
		// 경로	src/main/webapp/upload 폴더를 생성할 것!!
		String uploadPath = req.getServletContext().getRealPath("/upload");
		
		// 폴더인 경우
	//	String uploadPath = "d:\\tmp";
		
		MediaType mediaType = MediaTypeUtiles.getMediaTypeForFileNmae(this.servletContext, fileName);
		System.out.println("fileName:" + fileName);
		System.out.println("mediaType:" + mediaType);
		
		File file = new File(uploadPath + File.separator + fileName);
		InputStreamResource is = new InputStreamResource(new FileInputStream(file));
		
				// 다운로드 창
		return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())		// 원본파일 이름으로 바꾸고 싶은 경우 이 행의 코드를 바꿔주면된다.
	            .contentType(mediaType)
	            .contentLength(file.length())
	            .body(is);
	}
}



















