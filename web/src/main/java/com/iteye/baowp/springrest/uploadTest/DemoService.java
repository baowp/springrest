package com.iteye.baowp.springrest.uploadTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DemoService {

	/**
	 * 描述 : <将文件保存到指定路径>. <br>
	 *<p>
	 * 
	 * @param multifile
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public String saveFileToServer(MultipartFile multifile, String path)
			throws IOException {
		// 创建目录
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		// 读取文件流并保持在指定路径
		InputStream inputStream = multifile.getInputStream();
		OutputStream outputStream = new FileOutputStream(path
				+ multifile.getOriginalFilename());
		byte[] buffer = multifile.getBytes();
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = inputStream.read(buffer)) != -1) {
			bytesum += byteread;
			outputStream.write(buffer, 0, byteread);
			outputStream.flush();
		}
		outputStream.close();
		inputStream.close();

		return path + multifile.getOriginalFilename();
	}
}
