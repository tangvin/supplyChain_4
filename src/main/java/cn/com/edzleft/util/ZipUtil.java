package cn.com.edzleft.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.FileUtils;

public class ZipUtil {

	public static byte[] urlImage2byte(String destUrl) {
		// 定义byte数组
		byte[] data = null;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		int BUFFER_SIZE = 1024;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;
		try {
			url = new URL(destUrl);
			httpUrl = (HttpURLConnection) url.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());

			while ((size = bis.read(buf)) != -1) {
				output.write(buf, 0, size);
			}
			data = output.toByteArray();
			output.close();
			bis.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}
	
	public static File zipFile(String zipPath,List<String> listPhoto) throws Exception {
		
		File zipFile = null;
		if(listPhoto == null || listPhoto.size() < 1)
			return zipFile;
		String path = zipPath.substring(0,zipPath.lastIndexOf("/"));
		
		// 打成压缩包
		zipFile = new File(zipPath);
		FileOutputStream zipFos = new FileOutputStream(zipFile);
		ArchiveOutputStream archOut = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, zipFos);
		if (archOut instanceof ZipArchiveOutputStream) {
			ZipArchiveOutputStream zos = (ZipArchiveOutputStream) archOut;
			zos = (ZipArchiveOutputStream) archOut;
			for(String picPath : listPhoto){
				String picSuffix = picPath.substring(picPath.lastIndexOf("."),picPath.length());
				String picName = picPath.substring(0, picPath.lastIndexOf("."));
				if (picPath.contains("/")) {
					picName = picPath.substring(picPath.lastIndexOf("/"),picPath.lastIndexOf("."));
				}
				// 调用工具类获取图片
				byte[] data = urlImage2byte(picPath);
				if (data == null) 
					continue;
				
				//创建图片文件
				File imageFile = new File(path + picName + picSuffix);
				// 创建输出流
				FileOutputStream outStream = new FileOutputStream(imageFile);
				// 写入数据
				outStream.write(data);
				// 关闭输出流
				outStream.close();
				
				ZipArchiveEntry zipEntry = new ZipArchiveEntry(imageFile,imageFile.getName());
				zos.putArchiveEntry(zipEntry);
				zos.write(FileUtils.readFileToByteArray(imageFile));
				
				if (imageFile.exists())
					imageFile.delete();
			}
			zos.closeArchiveEntry();
			zos.flush();
			zos.close();
		}

		return zipFile;
	}

}
