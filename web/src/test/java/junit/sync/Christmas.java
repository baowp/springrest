/**
 * Project: springrest.web
 * 
 * File Created at Dec 24, 2012
 * $Id$
 * 
 * Copyright 1999-2100 Alibaba.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package junit.sync;

/**
 * Christmas
 * 
 * @author baowp
 */
public class Christmas {

    public synchronized void execute() {
        System.out.println("Christmas");
    }
}
