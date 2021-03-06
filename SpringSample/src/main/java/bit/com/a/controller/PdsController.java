package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

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
import bit.com.a.dto.PdsDto;
import bit.com.a.service.PdsService;
import bit.com.a.util.PdsUtil;

@RestController
public class PdsController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	PdsService service;
	
	@RequestMapping(value = "/pdslist", method = RequestMethod.POST)
	public List<PdsDto> pdslist(){
		
		List<PdsDto> list = service.getPdsList();
		
		return list;
	}
	
	@RequestMapping(value = "/pdswrite", method = RequestMethod.POST)
	public String fileUpload(PdsDto dto, @RequestParam("uploadFile")MultipartFile uploadfile, HttpServletRequest req) {
		System.out.println("FileController fileUpload() dto = " + dto.toString());
		System.out.println("uploadfile = " + uploadfile);
		// 경로	src/main/webapp/upload 폴더를 생성할 것!!
		String uploadPath = req.getServletContext().getRealPath("/upload");	
		
		// 폴더인 경우
	//	String uploadPath = "d:\\tmp";
		
		String filename = uploadfile.getOriginalFilename();
		String newfilename = PdsUtil.getNewFileName(filename);
		
		System.out.println("filename = " + filename);
		System.out.println("newfilename = " + newfilename);
		dto.setFilename(filename);
		dto.setNewFilename(newfilename);
		
		System.out.println("dto = " + dto.toString());
		
		String filepath = uploadPath + File.separator + newfilename;	// File.separator == '/'
		
		int count = service.uploadPds(dto);
		System.out.println("count = " + count);
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
	
	@RequestMapping(value = "/pdsdetail", method = RequestMethod.POST)
	public PdsDto pdsdetail(int seq) {
		System.out.println("pdsdetail seq = " + seq);
		
		PdsDto dto = service.getPds(seq);
		System.out.println(dto.toString());
		
		return dto;
	}
	
	@RequestMapping(value = "/pdsupdate", method = RequestMethod.POST)
	public String pdsupdate(PdsDto dto, @RequestParam("uploadFile")MultipartFile uploadfile, HttpServletRequest req) {
		System.out.println("FileController fileUpload() dto = " + dto.toString());
		System.out.println("uploadfile = " + uploadfile);
		// 경로	src/main/webapp/upload 폴더를 생성할 것!!
		String uploadPath = req.getServletContext().getRealPath("/upload");	
		
		// 폴더인 경우
	//	String uploadPath = "d:\\tmp";
		
		String filename = uploadfile.getOriginalFilename();
		String newfilename = PdsUtil.getNewFileName(filename);
		
		System.out.println("filename = " + filename);
		System.out.println("newfilename = " + newfilename);
		dto.setFilename(filename);
		dto.setNewFilename(newfilename);
		
		System.out.println("dto = " + dto.toString());
		
		String filepath = uploadPath + File.separator + newfilename;	// File.separator == '/'
		
		int count = service.uploadPds(dto);
		System.out.println("count = " + count);
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
	public ResponseEntity<InputStreamResource> dwonload(String fileName, String newFilename, HttpServletRequest req) throws Exception{
		System.out.println("FileController fileDownload() fileName");
		
		// 경로	src/main/webapp/upload 폴더를 생성할 것!!
		String uploadPath = req.getServletContext().getRealPath("/upload");
		
		// 폴더인 경우
	//	String uploadPath = "d:\\tmp";
		
		MediaType mediaType = MediaTypeUtiles.getMediaTypeForFileNmae(this.servletContext, fileName);
		System.out.println("fileName:" + fileName);
		System.out.println("newfileName:" + newFilename);
		System.out.println("mediaType:" + mediaType);
		
		File file = new File(uploadPath + File.separator + newFilename);
		InputStreamResource is = new InputStreamResource(new FileInputStream(file));
		
				// 다운로드 창
		return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)		// 원본파일 이름으로 바꾸고 싶은 경우 이 행의 코드를 바꿔주면된다.
	            .contentType(mediaType)
	            .contentLength(file.length())
	            .body(is);
	}
}



















