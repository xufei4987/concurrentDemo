package com.youxu.concurrent.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NioDemo {
	
	public static void nioCopyFile(String src, String dest) throws IOException{
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		FileChannel readChannel = fis.getChannel();
		FileChannel writeChannel = fos.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(true) {
			buffer.clear();
			int len = readChannel.read(buffer);
			if(-1 == len) {
				//读取完毕
				break;
			}
			//读写转换时需要执行这个方法
			buffer.flip();
			//写入文件
			writeChannel.write(buffer);
			
		}
		readChannel.close();
		writeChannel.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
