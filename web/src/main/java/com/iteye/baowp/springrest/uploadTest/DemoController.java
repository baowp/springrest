package com.iteye.baowp.springrest.uploadTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@Controller
@RequestMapping("/fileUploadDemo")
public class DemoController {
	@Autowired
	private DemoService service;
	
	/**
	 * 文件保持路径
	 */
	private static String ASVE_PATH = "E:/upload/";
	
	public DemoController() {
		System.out.println("fileUploadDemo init...");
	}
	
	@RequestMapping(value = "/page")
	public String showUploadPage() {
		return "upload/list";
	}
	
	/**                                                          
	* 描述 : <事先就知道确切的上传文件数目>. <br>
	*<p>                                                 
	                                                                                                                                                                                                      
	* @param file1
	* @param file2
	* @param model
	* @return
	* @throws IOException                                                                                    			   
	*/
	@RequestMapping(value = "/uploadFile")
	public String handleImport(
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			Model model) throws IOException {
		List<FileModel> list = new ArrayList<FileModel>();
		if (file1 != null&&StringUtils.hasText(file1.getOriginalFilename())) {
			System.out.println(file1.getOriginalFilename());

			FileModel fileModel1 = new FileModel();
			fileModel1.setName(file1.getOriginalFilename());
			fileModel1.setSize(file1.getSize());
			String path = service.saveFileToServer(file1, ASVE_PATH);
			fileModel1.setPath(path);
			list.add(fileModel1);
		}
		if (file2 != null&&StringUtils.hasText(file2.getOriginalFilename())) {
			System.out.println(file2.getOriginalFilename());

			FileModel fileModel2 = new FileModel();
			fileModel2.setName(file2.getOriginalFilename());
			fileModel2.setSize(file2.getSize());
			String path = service.saveFileToServer(file1, ASVE_PATH);
			fileModel2.setPath(path);
			list.add(fileModel2);

		}
		model.addAttribute("list", list);
		return "upload/list";

	}

	/**                                                          
	* 描述 : <事先就并不知道确切的上传文件数目，比如FancyUpload这样的多附件上传组件>. <br>
	*<p>                                                 
	                                                                                                                                                                                                      
	* @param model
	* @param multipartRequest
	* @return
	* @throws IOException                                                                                    			   
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/uploadMulti")
	public String handleImport(Model model,
			DefaultMultipartHttpServletRequest multipartRequest) throws IOException {

		List<FileModel> list = new ArrayList<FileModel>();
		if (multipartRequest != null) {
			Iterator iterator = multipartRequest.getFileNames();

			while (iterator.hasNext()) {
				MultipartFile multifile =
				multipartRequest.getFile((String) iterator.next());
		
				if (StringUtils.hasText(multifile.getOriginalFilename())) {
					System.out.println(multifile.getOriginalFilename());
					FileModel fileModel = new FileModel();
					fileModel.setName(multifile.getOriginalFilename());
					fileModel.setSize(multifile.getSize());
					String path = service.saveFileToServer(multifile, ASVE_PATH);
					fileModel.setPath(path);
					list.add(fileModel);
				}

			}
		}

		model.addAttribute("list", list);
		return "upload/list";
	}
	
}
