package com.iteye.baowp.springrest.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;


@Controller
@RequestMapping("/fileUpload")
public class FileUploadControll extends BaseController {
	/** 附件集合 **/
	protected List tempAttachments = new ArrayList();
	private List<File> filedata;
	private List<String> filedataFileName;
	public String uploadType;
	private static final int BUFFER_SIZE = 16 * 1024;
	protected String title;
	/** 上传文件域对象 **/
	protected List<MultipartFile> upload;
	// 上传文件类型
	protected List<String> uploadContentType;
	protected String uploadFilePath;
	/** 上传文件名 **/
	protected List<String> uploadFileName;
	/** 生成的文件名 **/
	protected List<String> newFileNameList;
	/** 保存文件的目录路径 **/
	protected String savePath = "E://upload";// 缺省值
	// 模块名
	protected String module = "picture"; // 缺省值
	protected int maximumSize = 10;// 缺省值
	protected int minimumSize = 5;
	/** 文件扩展名约束 **/
	protected Set<String> extensionSet;
	/** 文件格式不对或大小不对的回馈信息 **/
	protected List<String> feedback;
	// 保存附件的相对路径（文件夹）
	protected String relativeFolder;
	protected String relativeFileFolder;
	protected String newFilename;
	protected String newFilenames = "";

	/**
	 * 文件保持路径
	 */
	private static String ASVE_PATH = "E:/upload/";

	@RequestMapping(value = "/page")
	public String showUploadPage() {
		return "upload/list";
	}

	/**
	 * 描述 : 事先就并不知道确切的上传文件数目
	 */
	@RequestMapping(value = "/uploadMulti")
	public String handleImport(
			DefaultMultipartHttpServletRequest multipartRequest)
			throws IOException {
		if (multipartRequest != null) {
			upload = new ArrayList<MultipartFile>(); // 初始化
			uploadFileName = new ArrayList<String>();
			Iterator iterator = multipartRequest.getFileNames();
			while (iterator.hasNext()) {
				MultipartFile multifile = multipartRequest
						.getFile((String) iterator.next());
				if (StringUtils.hasText(multifile.getOriginalFilename())) {
					System.out.println(multifile.getOriginalFilename());
					upload.add(multifile);
					uploadFileName.add(multifile.getOriginalFilename());// 文件名
				}
			}
			this.setAllowedExtension("txt,jpg"); // 上传文件限制
			this.doUpload(); // 上传
		}
		return "upload/list";
	}

	/**
	 * 自己封装的一个把源文件对象复制成目标文件对象
	 * 
	 * @param multifile
	 *            [源文件]
	 * @param dst
	 */
	protected void copy(MultipartFile multifile, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(multifile.getInputStream(),
					BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst),
					BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			// log.info(e.getMessage());
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected boolean checkUploadFile() {
		feedback = new ArrayList<String>(upload.size());
		for (int i = 0; i < upload.size(); i++) {
			if (upload.get(i) == null) {
				feedback.add("");
				continue;
			}
			String[] str = uploadFileName.get(i).split("\\.");
			String extension = str.length == 1 ? "" : str[str.length - 1];
			if (extensionSet != null
					&& !extensionSet.contains(extension.toLowerCase())) {
				feedback.add("上传文件格式不对");
				return false;
			}
			if (upload.get(i).getSize() <= minimumSize) {
				feedback.add("上传文件应大于" + minimumSize + "字节");
				return false;
			}
			if (upload.get(i).getSize() > maximumSize) {
				feedback.add("上传文件不得超出" + maximumSize + "字节");
				return false;
			}
			feedback.add("");
		}
		return true;
	}

	protected boolean checkUploadFile(Set extensionSet) {
		feedback = new ArrayList<String>(upload.size());
		for (int i = 0; i < upload.size(); i++) {
			if (upload.get(i) == null) {
				feedback.add("");
				continue;
			}
			String[] str = uploadFileName.get(i).split("\\.");
			String extension = str.length == 1 ? "" : str[str.length - 1];
			if (extensionSet != null
					&& !extensionSet.contains(extension.toLowerCase())) {
				feedback.add("上传文件格式不对");
				return false;
			}
			if (upload.get(i).getSize() <= minimumSize) {
				feedback.add("上传文件应大于" + minimumSize + "字节");
				return false;
			}
			if (upload.get(i).getSize() > maximumSize) {
				feedback.add("上传文件不得超出" + maximumSize + "字节");
				return false;
			}
			feedback.add("");
		}
		return true;
	}

	/**
	 * 上传文件
	 * 
	 * @return
	 */
	public String doUpload() {
		if (upload == null)
			return "upload/list";
		if (!checkUploadFile())
			return "upload/list";
		String name = "zhaoyubetter";

		// String dstDir = servletContext.getRealPath(relativeFolder);
		String dstDir = savePath + relativeFileFolder;
		File dirFile = new File(dstDir);
		if (!dirFile.exists())
			dirFile.mkdirs();

		for (int i = 0; i < upload.size(); i++) {
			if (upload.get(i) == null)
				continue;
			newFilename = setFilename(this.getUploadFileName().get(i));
			String dstPath = savePath + newFilename;
			File dstFile = new File(dstPath);
			copy(this.upload.get(i), dstFile);
			uploadFilePath = relativeFolder + "/" + newFilename;
		}

		return "uplad/list";
	}

	public String setFilename(String filename) {
		String[] str = filename.split("\\.");
		filename = new Date().getTime() + "." + str[str.length - 1];
		return setFilename(filename, str[str.length - 1]);
	}

	public String setFilename(String filename, String ext) {
		filename = new Date().getTime() + "." + ext;
		return filename;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<MultipartFile> getUpload() {
		return upload;
	}

	public void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}

	public List<MultipartFile> getFile() {
		return upload;
	}

	public void setFile(List<MultipartFile> upload) {
		this.upload = upload;
	}

	public List<String> getFileFileName() {
		return uploadFileName;
	}

	public void setFileFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public List<String> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<String> feedback) {
		this.feedback = feedback;
	}

	public int getMaximumSize() {
		return maximumSize;
	}

	public void setMaximumSize(int maximumSize) {
		this.maximumSize = maximumSize;
	}

	public int getminimumSize() {
		return minimumSize;
	}

	public void setminimumSize(int minimumSize) {
		this.minimumSize = minimumSize;
	}

	public Set<String> getExtensionSet() {
		return extensionSet;
	}

	public void setAllowedExtension(String allowedExtension) {
		extensionSet = new HashSet<String>();
		for (String s : allowedExtension.replaceAll("\\s", "").split(","))
			extensionSet.add(s.toLowerCase());
	}

	public String getUploadFilePath() {
		return uploadFilePath;
	}

	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	public List<String> getNewFileNameList() {
		return newFileNameList;
	}

	public void setNewFileNameList(List<String> newFileNameList) {
		this.newFileNameList = newFileNameList;
	}

	public List<String> getFiledataFileName() {
		return filedataFileName;
	}

	public void setFiledataFileName(List<String> filedataFileName) {
		this.filedataFileName = filedataFileName;
	}

	public List<File> getFiledata() {
		return filedata;
	}

	public void setFiledata(List<File> filedata) {
		this.filedata = filedata;
	}
}
