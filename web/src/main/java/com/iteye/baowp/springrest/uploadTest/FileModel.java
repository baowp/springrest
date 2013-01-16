/*
* COPYRIGHT Beijing NetQin-Tech Co.,Ltd.                                   *
****************************************************************************
* Դ�ļ���: FileModel.java 														       
* ����: �������ļ����ܣ�													   
* �汾:	@version 1.0	                                                                   
* ��������: 2010-3-3							    						   
* ˵��: ������ʹ���ļ�����ʱ����Լ������                                       
* �޸���ʷ: (��Ҫ��ʷ�䶯ԭ��˵��)		
* YYYY-MM-DD |    Author      |	 Change Description		      
* 2010-3-3   |  hanqunfeng    |  Created 
*/
package com.iteye.baowp.springrest.uploadTest;

import java.io.Serializable;

public class FileModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7964950152782381235L;
	private String name;
	private long size;
	private String path;
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}
	
	
}
