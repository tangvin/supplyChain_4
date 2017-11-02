package cn.com.edzleft.util.qiniu;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

public class ImageUpload
{
	String ACCESS_KEY = "UDx1l6muXHFXgQ3lOaQz3eTzHfqbEt0KpOmLxQJB";
	  
	  String SECRET_KEY = "DN7d8UAUxANE7Fg58oN9jDN1ZpIrbv5cE-6aUj85";
	  //要上传的空间
	  String bucketname = "aoe-img-01";
	  //上传到七牛后保存的文件名
	  String key = new Date().getTime()+".png";
	  //上传文件的路径
	  Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	  ///////////////////////指定上传的Zone的信息//////////////////
	  //第一种方式: 指定具体的要上传的zone
	  //注：该具体指定的方式和以下自动识别的方式选择其一即可
	  //要上传的空间(bucket)的存储区域为华东时
	  // Zone z = Zone.zone0();
	  //要上传的空间(bucket)的存储区域为华北时
	  // Zone z = Zone.zone1();
	  //要上传的空间(bucket)的存储区域为华南时
	  // Zone z = Zone.zone2();

	  //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
	  Zone z = Zone.autoZone();
	  Configuration c = new Configuration(z);

	  //创建上传对象
	  UploadManager uploadManager = new UploadManager(c);

	    public String getUpToken() {        
	        return auth.uploadToken(bucketname, null, 3600, new StringMap().put("insertOnly", 1));
	    }    
	    public String upload(String file64) throws Exception {
	       /* String file = "D://2.jpg";//图片路径
	        FileInputStream fis = null;        
	        int l = (int) (new File(file).length());        
	        byte[] src = new byte[l];
	        fis = new FileInputStream(new File(file));
	        fis.read(src);
	        String file64 = Base64.encodeToString(src, 0);*/
	    	String key = new Date().getTime()+".png";
	        String url = "http://upload-z1.qiniu.com/putb64/" + -1+"/key/"+ UrlSafeBase64.encodeToString(key);
	        RequestBody rb = RequestBody.create(null, file64);
	        Request request = new Request.Builder().
	                url(url).
	                addHeader("Content-Type", "application/octet-stream")
	                .addHeader("Authorization", "UpToken " + getUpToken())
	                .post(rb).build();
	        System.out.println(request.headers());
	 
	        OkHttpClient client = new OkHttpClient();
	        okhttp3.Response response = client.newCall(request).execute();
	        System.out.println(response);
	        return key;
	    }   
	    
	    public String uploadBlob(String file) throws Exception {
		        //String file = "D://2.jpg";//图片路径
		        FileInputStream fis = null;        
		        int l = (int) (new File(file).length());        
		        byte[] src = new byte[l];
		        fis = new FileInputStream(new File(file));
		        fis.read(src);
		        String file64 = Base64.encodeToString(src, 0);
		    	String key = new Date().getTime()+".png";
		        String url = "http://upload-z1.qiniu.com/putb64/" + -1+"/key/"+ UrlSafeBase64.encodeToString(key);
		        RequestBody rb = RequestBody.create(null, file64);
		        Request request = new Request.Builder().
		                url(url).
		                addHeader("Content-Type", "application/octet-stream")
		                .addHeader("Authorization", "UpToken " + getUpToken())
		                .post(rb).build();
		        System.out.println(request.headers());
		 
		        OkHttpClient client = new OkHttpClient();
		        okhttp3.Response response = client.newCall(request).execute();
		        System.out.println(response);
		        return key;
		    }  
	 

	

	public void download(){
	     //调用privateDownloadUrl方法生成下载链接,第二个参数可以设置Token的过期时间
		Auth auth=Auth.create(ACCESS_KEY, SECRET_KEY);
		String URL = "http://aoe-image.zxrkj.com/1477636563071.png";
	     String downloadRUL = auth.privateDownloadUrl(URL,3600);
	     System.out.println(downloadRUL);
	   }
	
	public static void main(String[] args)
	{
		String s="data:image/jpeg;base64,/9j/4AAQSkZJR";
		int a = s.indexOf(",");
		String d = s.substring(a+1);
		System.out.println(d);
	}
	
	public void infomation(){
		/*CloseableHttpClient client = HttpUtils.createSSLInsecureClient();
		HttpPost post = new HttpPost(getTokenuRL);
		HttpEntity entity = new StringEntity(json);
		post.setEntity(entity);
		post.setHeader("Content-type", "application/json");
		HttpResponse resp  = client.execute(post);*/
	}
}
