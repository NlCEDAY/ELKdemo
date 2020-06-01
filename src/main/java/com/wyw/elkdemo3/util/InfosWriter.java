package com.wyw.elkdemo3.util;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @ClassName:InfosWriter
 * @Author WYW
 * @Date28/05/202020:52
 * @Description: TODO
 * @Version V1.0
 **/
public class InfosWriter {
	/**
	 * @author WYW
	 * @date 28/05/2020 20:46
	 * @param
	 * @return void
	 * @description 写进磁盘
	 */
	public void writeLog(String threadName){
		// 将信息清理成json格式字符串
		String msg = InfosCleaner.getCleanerInstance().makeActionLog();
		String path = threadName.equalsIgnoreCase("action") ? "d:/opt/action/user.log" : "d:/opt/system/sys.log";

		// 写进磁盘
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(path,"rw");
			long size = raf.length();
			raf.seek(size);
			raf.writeBytes(msg + "\r\n");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
