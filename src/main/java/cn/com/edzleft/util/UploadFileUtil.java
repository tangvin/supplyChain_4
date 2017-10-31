package cn.com.edzleft.util;

import com.qiniu.cdn.CdnManager;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import javax.servlet.http.HttpServlet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 上传文件 包含用户头像。 朋友圈图片，视频
* <p>Title: UploadController<／p>
* <p>Description: <／p>
* @author MR.Chen
* @date 2016年11月28日
 */
public class UploadFileUtil extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 //上传文件的保存路径  
	 static String ACCESS_KEY = "2zX9TnQBo9kTEfMoi2SA-nNyObgdSN_QB-Ur-PKC";
	 static String SECRET_KEY = "W5UL2-FZDzpVbTlU6I7VukhdZwSh5e_nTm0xvzbG";
	 //要上传的空间
	 static String bucketname = "travel-image";
	 //上传文件的路径
	 static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	 static String qiniu_path="http://onk010wf6.bkt.clouddn.com/";

    /**
     * 上传图片
     * @param filePath
     * @param keyName 文件名称。覆盖上传使用
     * @return
     * @throws IOException
     */
    public static String upload(String filePath,String keyName,boolean isOverride) throws IOException {
        try {
        	Zone z = Zone.autoZone();
            Configuration c = new Configuration(z);
            //创建上传对象
            UploadManager uploadManager = new UploadManager(c);
            //上传到七牛后保存的文件名
      	    String key = new Date().getTime()+".png";
      	    if(StringUtils.isNotBlank(keyName)&&isOverride){
      	    	//覆盖上传
      	    	String token=auth.uploadToken(bucketname,keyName);
      	    	Response res = uploadManager.put(filePath, keyName,token);
      	    	System.out.println(res.bodyString());
      	    	//---刷新缓存 begin----
      	    	CdnManager cdnManager = new CdnManager(auth);
	    	    //单次方法调用刷新的目录不可以超过10个，另外刷新目录权限需要联系技术支持开通
	    	    Response resonse= cdnManager.refreshUrls(new String[]{qiniu_path+keyName});//待刷新的目录列表，目录必须以 / 结尾
	    	    System.out.println("刷新图片返回码："+resonse.bodyString());
	    	    //---刷新缓存 end ---
      	    }else{
      	    	//简单上传
      	    	String token=auth.uploadToken(bucketname);
      	    	Response res = uploadManager.put(filePath, key, token);
      	    	System.out.println(res.bodyString());
      	    }
            return qiniu_path+key;
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
        return null;
    }
    /**
     * 上传base64格式图片
     * 用户头像
     * @param base64
     * @param path
     * @return
     */
    public static boolean base64ToImage(String base64, String path) {
    	// 对字节数组字符串进行Base64解码并生成图片
        if (base64 == null){ // 图像数据为空
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(base64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(path);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
 /*       String base="YmFja2dyb3VuZC1pbWFnZTogdXJsKCJkYXRhOmltYWdlL3BuZztiYXNlNjQsLzlqLzRBQVFTa1pKUmdBQkFRQUFTQUJJQUFELzJ3QkRBQU1DQWdNQ0FnTURBd01FQXdNRUJRZ0ZCUVFFQlFvSEJ3WUlEQW9NREFzS0N3c05EaElRRFE0UkRnc0xFQllRRVJNVUZSVVZEQThYR0JZVUdCSVVGUlQvMndCREFRTUVCQVVFQlFrRkJRa1VEUXNORkJRVUZCUVVGQlFVRkJRVUZCUVVGQlFVRkJRVUZCUVVGQlFVRkJRVUZCUVVGQlFVRkJRVUZCUVVGQlFVRkJRVUZCVC93QUFSQ0FDRUFJUURBUkVBQWhFQkF4RUIvOFFBSFFBQUFRTUZBUUFBQUFBQUFBQUFBQUFBQWdFRENBQUVCZ2NKQmYvRUFFRVFBQUVDQlFNQ0JBTUVCZ2dIQVFBQUFBRUNBd0FFQlFZUkJ4SWhDREVUSWtGUllYR0JDUlF5b1JValFsS1JzUllZSkROaWN1SHdGeVZ6Z3BMQjBmSC94QUFiQVFBQ0F3RUJBUUFBQUFBQUFBQUFBQUFBQVFJREJBVUdCLy9FQUM4UkFBSUNBZ0lCQXdNQkJ3VUFBQUFBQUFBQkFoRURFZ1FoTVFVaVFSTlJZUlFHSTNHaHNkSHdRa09CNGZILzJnQU1Bd0VBQWhFREVRQS9BSlh0MGhwS1FQQVFjREhLUnpIaVZDajBEa0cxVGtNS3kyMGhDL2NKR1lhZzE0RGEvSVhnT2VtMzZvVC9BUElkU0RZTnRzdG5KU241N1JEU2FGdFk0ZkNLaWZCVHU5d0lmWDJDMzl4RExwV2M3Y0V4R3JIc3loSXQ1d1VBbjNNR2d0eWwwNXRlQ1cwa2o0UXZwcGdwc1FVOUNjL3EwNFBmeWlHb1VHektUSk5CUnl5akgrVVExRU5oVnliV1A3cEgvaUliaUZqUmFEWndFaElIb0JpSVZRN0xaeGp4T1NrRWVtUkNvZDBJMUtJQndFSlQ4aENVUTJZcTJXVWdrTnBKK1VPa0ZzWlVsc25IaHBTZmdCRVF0Z3Fsem55bzQrQUVHbzdNbERmOFkycEdleWxOakhNRkFObEpCOS9sQ29ZSVI4TXdVQTZpV0JHY2NROUJXT3BhR2ZoRXRVS3h4TGFTUWNRYW9MRjhNWjdkNGVvV1VVQUR0a1FhaFlKYkI1eGlGcU93VkpBeWNRcUF0bkdnczhESTk0aTFZeGhUR0ZSSFVkZ0thUDV3OVFzUXkwTFVMS0VpbnVSOUlORUZsR1hHZU1ZK01QUkRzOUhPSXVLN0ZISjdRVUF1MEgvNURvUVd6dERvQXR1SUFGSXdPTXcyZ0Y5TzhLZ0ZQMWgwQVlUMnlybjJoZ1Z0eU1lcGdvQkNrQk1EUURidUNPUDRDSXNZeVVBZzhSR2gyTmxvUVVBbXpqbk1PZ0VVbkF3SVZBQmo0NGdBdVVweUFjdzBJY0NBazV6bUpWUXJITUU1K01NQ2duTUFHSTZzNm1VZlJ5d0t2ZDlkY1VpblU1c0tVaEI4emkxS0NVSVQ4VktVQjlmaEZrSU9ja2tRbEpSVnN5dHQxRHFFclNyY2hRQ2txSFlnOWpGWk1vcTJ3bUJyM1hyVG1wNnVhYlZDMWFYY0Qxc09UcmpSZW41WkpMdmhJV0ZxUWtoUTJsVzBEUFBCUEJ6aUxNY2xDV3pWa0p4Y2xTT2FXaGYyak9vdWxjeEwwdTYzRGZGdnRFTkZFNnZiT3NvSEhrZnhsWHljM1p4aktlOGRUSnhvVDdqMHpGRE5LUFQ3T3NsR3E3TmVvMGhVNVFyKzZ6ckNKbG9yU1VxMkxTRkp5UFE0UGFPUzAwNk9ndXk4T2NESFAxaUlBNDRQcjd3aGdaNytzQUNESjVKekFBbU13NkFRb0pCNStrS2dCOEkrL3dDVUFEcUQ1UnpBbUI0R29kOVV6VEd5cXZkTllFd3FtVXhueG5reWpKZGRVTWdBSlNPNUpJSG9CbkpJR1RGa1l1VHBFSk5SVnMwOXBEMTE2VzZ6MzZMUm9zMVVaT3B2YmhKdVZPV0RMVTRVODdXeUZFN2lBU0FvSkp3ZlhpTDU4ZWNGc3l1T1dNblNKRDRIdkdjdUltOVhFcWpWeldUU3ZTQjVaVFJYSFhMbnVFbFJTZ1NVdUZCS1Zuc0VxSWRUazlpVW1OZUgyUmxrL3dDRVo4bnVrb216ZFA4QXF2MHoxTDFLZnNPMXF1dXFWV1dZY2REckV1b1Nxa3RsSVVHM095dStRUjVTQWNIdG1tZUdjWTd5Snh5UmIxUm05MGFvMmJaTldrYVpjRjAwZWlWR2VQOEFacFdmblcyWEhmaUVxSU9NOFo3WjRpcFFsSldrVGNrdW15M3NQVWVTditzM2ZMVXpZOUsyOVZCU0ZUTGJnV2wxNE1OT3VZeDIybDNZZmlrdzVRY0VtL2tGTGF6aWZVN0tYY0hVRk4yakxvVzJ1ZHVkZExiUXJoU1N1YUxZQno2ak1kMVNxRzM0T1pWeW82Q2RRdlV0V1dyb2N0cXlhby9ScUxTUjkwY2NsUUVMZGRRU2xXMVl5UWdZQUdNWndUN1I1dHlaOVk5SjlIeFJ3ckx5WTNKOXEvaGZ3KzVyKzBlcUxVYTBwbHRmOUlINnZMaFFLNWFxL3dCb1NzZTI1WG5IMFVJVnM2dWYwZmhaMVdtcis2Ni82SjhhYTMxSzZrV1JTYmtsVy9CYm5tdHkyU3JjV25BU2xhTSt1RkFqUHJ3WXNYM1Btbkw0MHVKbmxnbDhHU2tldlllc014Z0ZQSU9lMEZDQ0FHTWdmbEFBbkI3OHd3RjhnNzk0UURTQ1Rqc1lpaHNwMWxxYVlkWWZiUzZ5NGtvVzJzQlNWSkl3UVFlNFB0RWhFRkpIN05tZHNucUR0cTc3UXVhVlp0T1FxN05UWEl6aGNUTnNJUTZsWlpiVWxKQ3dRQ25LaWs0NzU5ZWorcFVvT01sMlpQb1ZKTlBvbnB1T2VJd0dzNDFkV0dzMDdjblUvcUVHYXRNUzl2VEUwM1Fwd1NhdVhaT1dVbEsyd1J5VWxhRkwyZzRKeG1PemloV05mYzV1U1Z6WnVPWjF2MDdyL1hQbzdjdW5FMHROS2VsSmFoempLSlJjdjRhMStMTHR0Rktrak9FT05ESXlBRWpCNDRwMG1zTWxJczJpOGljVFB2dFRkSDVPZnNhaTZpU01rbE5VcDAybVJxTXcwZ0JUa3U0bkRhbG4xQ0ZwU2tmOVV4VnhKOXVCUFBIcll0ZnNuYjdsSHJVdld5MXVKVFVHSjFGWGFiVWVYRzNHMHRMSS93QXBhUm4vQURpSHpJOXFRY2Q5TkVkTE9wNGMrMFkrN25hNXQxQW1sQTlobE00NG9INkVmbEd1dHNOZmd6M1dTL3laWmVsdXoxcFhiVjZQVWtGdWRrNWxiVGdQT1RuaFh4QkdDUG5Ibm1xZEgzM2o1b2NqREhMRHcwZVF3dzVOUHRzc3RxZGVjVUVJYlFrbFNsSGdBQWR6Q05EYWlyZmc2ZDZIMmFyU2ZSV2owK3JvUzNOU2NzNU56dTBiaWhTbEtkVW40bElPMy90anZZc01ZWTF1dXo0bDZueW56dWZPZUo5TnBMK244eUVGN2RVVjkzSmRrM1U2YlhaeWlTQmRKbGFmTE9BSWFSK3lGWUFDejdrZ3h4SlN0MnVqNmh4dlJ1Smh3ckhrZ3BQNWIrZjdFcGVsaldHczZzV2pVZjA4RVBWR21Qb2FWTm9iQ0EraFNjZ2tEamNNSE9BQmpIRU9MczhaNjF3TVhCelIrajRrdkgyTjFrbEkvd0RVU1BQQ0ZmeU1BaE54OUJDR05veVFQUVJGREl4ZGFNNzFBMCtYcDd1a0xhM0tHSmNxcUJwclRUcytIUW8vaFNzRlJUdHgvZGdxem1OMkJZdjl6eVpjdS84QXBOZDlCdlZWZjk5WDlQYWM2akYrYm5HSk54K1VuSm1SVzNOb2NiV2tMYmVLUUFBQVQ1bGdISUFKSlVCRnVmRENLM2dReFpKTjZ5SjJyV2xsdFMxSGFsSXlUR0UxbkNQU3lpeXVxblVOYlZQbjJ2R3A5YnVKbjcwMnRSRzVoYjRVNENRUVI1Q3JrR085TjZ3Ylh3amxSVzBrV09weWFKWm10VndmMEduM3YwSFRLdzRxa3prdThyZWhEYnVVS2JjNzhFZVZlYzhBNWdqYmd0dklwVXBlMDdmM05hVkIxaDB6bXFKVTJ6T1VHdlNBUXJDOHE4TmFRcEMwcU9mTUR0VUR6eUFZNGFiaEsxNVIxR2xLTk1qWDBuZEE5WDZkOWFKKzdabTY1V3JVVVNMc3BLTU1OTGJmZDNyU2Yxb1BsQUFTRHdvNVY3WTU2MFd1UkMyakE3eFM2SWxTeTBVMzdUTlptaVhnclVCWUdEamxjeWRnK2hVbitFWFNmc2JvcVM5MUhVYlVIUWF4OVU2ZzNQWEJSUk1UemFRa1RiTHkybHJUKzZvcEkzQWVtYzQ5SXhySGp5dHVTTzN4dlZPWndJYVlKMHZ0U1lsbWFBV0RwN090emxDdHVXbDU5SG1ST1RDbHpEaUQyeWxUaWxiVDhzUkpZb1JkWTEzOS9JdVI2cnpPWEd1UmtiWDJYWDlEUDVpWGFtcGR5WGVRSEduRUZDMEtIQ2trWUkvZ1kweHBMUTQ5eVQzUkRLdWRBVlVldU9hVlNybGtXS0d0MHFaRXkydFQ3YUNmd2tBWVZqdG5JejhJNXN1Qzc2ZlI5R3hmdGJqV0pmVnh0eithcWlRK21XbWR2NkRhY1RFbUpzS1lsL0VuS2hVNWpEWldvRHpMUGZha0pTQUJrNEE5VGttNVljY2NUWG1yUEtjem5aL1UrV3BWNXBKZVRYbHI5WVZpWFRjYk5JQ0tsVFZ6RHdaWW1weGhJYVdvbkNjbEt5VTVPT1NNYzg0amxiSTd1YjBEbDRjYnlkT3UyaysvNkc4Q01ENXd6emdPM1B4K2NBQXBiSjQ5SWlrREhXeVU4R0pDWkd2cSs2bUo3U3g2aVdIWTdEVS9xWmM2a3kwa0ZEUDNGdDFYaHBlSXhncUt4aElQSGxLandNSFpoeGJKeWw0UlJrbnI3WStXYnYwcXR5dFdocHRidEV1U3FLcnRiazVKREU3VUZ1S2NNdzZCNWxibGVaV2ZjOCs4VVRrbkp0ZUMyS2FWTTR3OVRtbE1yb1ByZFhiWnBGYWFxTXRMcjhkbGN1VkpjbGtPQXFTeTUvalNrak9DUVFRZUNTQjJzVS9xUVVtam16anBLa2UvbzUwUzZvNjNXeWk0YUpUWlNSb3pxOXJFMVZaZ3NDWXdjRlRZMmtxU1Azc1lPQ0JrZ3hHZWVHTjB4eHhTa3JSMkgwcnRpZXMzVGUwN2RxRXczT1ZDbFVxVmtIMzJjN0hIR21Vb1VVNTV3U24xamtQOTVONi9KMEY3WTkvQm5DQUVKQ1I2Y2NSMklWQ0tpdkp6cFhKdVRPT2QzaFRIMmxyZjczL0VDVE9FL0dhYVAvdUxmRVNIbG5ZZ0o4Sk9Db25JejhQOTlvd2F2R3RXelZ0djJoMGZoR0kxeGZ0U2lVTmQyekNOYTlXcVJvZnBuVzd5clIzUzFPWnkyd2s0Vk1QSzhyYlNmaXBSQXo2REpQQU1XZWV5SGc1MjErOU9wUzFORnBpL0tyZUtyV2R2QzRXNWlsVU50amZVSjUxOElTaHRBVm53R1V0dDVTZ2NxL2FIbUVIeitCblF5NUxGcVY5Nk1UTnNWYWRiUldaNm1JWm1KeHBJRFptUWxKSzhEOWtySElIcG5FWnZwN1luSDduUjRuSy9TY3ZIbmF2Vm9pbnA3MFRYZEwzVkpUbHl2VStUcEVtK2w1ME1QbDF4OEpWbmFrQWNBNHdTY1lCN0dPVStQT01YSitFZlErViswdkZsaWNNQ2JrMTExU1JNdGZZbkJIeWlvOENCeWZYRUlrRWhaSEFoSmlhTlBkVHZVdlJlbTZ4MTFLYURGUXVDWUdLYlJWditHdWFPOUtWcXlBY0pRRlpKeDZZN21OT0hFOHNxK0NySk5RUkRUb1pwRmU2ak9wMjROWUxyQ1pyOUU1ZUN0cERhWnAxSmJaYmJIN3JiWVZnWkpHRWR5Y3h1NURXTEdzY2ZreTRrNXoyWkxmcTA2cXFUMDRXVXRUUzJKNjhKOUJUVEtXVkFrRTVIanVqdUcwbi9BTWlNRDFJeDRjTHl2OEduSmtVRitUalRYSzdQM0xXNTZzVlNhY25xbFBQcm1abVplT1ZPdUtVVktVZm1TWTdhU1NwSE5idnRrdU5PUHRDNzVWWkx0bVZodG1acWJqc2l6UnF0SU10eWhsd2lZYTNOT0liQ1ViQzBsU1FVZ0VkamtISXlTNDhiMlJlczBxbzZ3U3FOenZJeUFNNDk0NTJHS2MrelhrYlVlaTdsMXBVcklUdDNEampHZmVOMkZwdTBxc3paRTBxZmRISkJta08zYjlxQXFYVUR2YXZSVXllRCtHV1VYZjVOUnJjbW9XL0pRa25La1QyNm9PcnFrZE9VemJ0S2JvY3hkdDBWcHdlRFJwRnphNkdOMjByUGxVY2xYbFNuSG1JVnlNR0trdCszL240SnQ2OUVKNnI5b0RyWGVYOUtxaEpYTGFlblNhSmtpaHprc0RPVEJ5b2VFMEhrT2VJNG5iaFdkZ3lSd014UFZScEw1STIzMmE2djNyYXZiWEd0MmM5Y3R0MCt2U3RycFhQZm9hV2JjRXJPelNVa2labUVBa2xLQUFTZ0VKd0Y4Z0tJaXlpRmw5cDMxaHpWL2RSZGozWHJiTnVWYWdVSnhaa21KTmhEVXZUM2wvZ2ZMU1JsWVFvSkpQS3ZJaytiYnRLYXFOUkduYnRuWCtuVk9XclZMWW5xWk1NelVwTXRwZWFmWWNEamJpRkRLVklVT0NDT1l5KzV4YWgwL3QvWXU2VFczWnBUcVU2azNORnBtbVVxblUxbXFWT2RhTDYxVENpbHR0ck8wZHU2aVFmbGo0eG41R2JYMkxzOVA2TDZNdlVWTExPV3NWMTE5ekl0SGRUVTZ0V05MWEFtU1ZUM1ZPTFlkbHlyZUF0SjVLVllHUWNqMDl4NlJ6cnNyNS9EZkJ6dkRkL05tYWxSekFjOHBJT2NreEZDSXQ5YnZTQlUrcEVXL1ZyYnFFckpYRFRFcmxWb3FDMUpsM1pkV1ZqbElVVXFTb1lHQWM3em5zSTM4Zk9zVnFYZ3paY2JuMmpaZlNqb1gvVi8wYXBkc3pUclQ5WGNXcWRxTHJJQVNaaHdEY2tIOW9JQVNnSzlRblBHY0NyTmtXU2V4UEhIU05HbU9xLzdQMTdYaS9KbTlMZHVoRkxyRTIyMDNOU1ZUYlc1THFMYUFoS2tMVGtvOHFVNVR0SXprOFpqUmg1UDA0NnRGV1REdTdUTWMwTit5OG8xczFSdXFhazFobTVpMGN0MGluQmJjcVQ3dU9IQzFqL0NBbjRramlKWk9XMzFCVVJoZ1NmdU56VDNRRm92UDNvaTVFMjQ3SlBKZlJNQ1FrNWxUVW52U1FSK3FIQUJ4K0VZSEo0aW45UmtTcXkzNk1MdWlRczlXWkczNVJ5ZW5wbHVVbFdnVktXNG9BZGljRDNQSGFJNGJVMVE4bGF1ejEvQ1M2bHNnL3F3TWdlM3NZNkR4YlVsNFJrM3EyL0p6NzZCTEhUcVIxQzZzYTF2c0svUjVxczVMMHN1RElMa3c2cHh4UVB1aG9vVDhuakZrMjRSU0l4U2syWUJjWFdpeFlPb0dwczVJV3FpNU5XcHU2cDJRcE5SbldBNDNTNUJvSWw1ZERRSG1VbzdYTW9UdEJLaVNUa2d5K25kVjRJN2ViSXhhWldUVDlaN3dwY2pVNjA4bTZybXVXWGt3MmhLVW9TeTZvcW1aaHc0NFZsU0FoSUhKMyt3QnQ4SXI4azI5YXJ6MEswenFUV2xGdXBwVnVXcFQxQjI5SjZsdGh5Zm4yMm5DVVVwTGdQaXV1T09EOVlTckRhUmdxSElpcU45dGszUkdEcXU2Z3RQZGRISmRkbjZXdDJxNVR3aHBGYVE0bGx4eGtEQ1czR0drK0dCNkFsUkl3QURqaUxGZnlSZGZBV2duVkxxNzB4VUNsVDh0S3pGVTAvcWEzQkxTVldhV1pOMVNGRU9DWGRITGF3UWNoSnh6a3BQQmgwcnRCWkpmK3Uzb3oxSjE2MGFMZU5qVnFuVnFabWtTTGMwM05JTXZMbDFRU056aVZvVXBHNGduS09PU1BYT0hOZ1VvWFhhT3p3ZlZPUndaTllaVXBlZXJKdlc3YmRNdEdpU3RKbzhtM0lVNldCUTB3MW5BNXllVHlTU1NTVHlTWTVQOEMzTm15WjV2SmtkeVpmbm1FVkFKVmo1eEJBT29PY2UwVFFnd2NFQ0dJVXErUGFBQlZLempQYUFDdCtQakRBTmF4c1ZsTzRkOGQ0a25RR05xdUdidmhxNHFEVGhOMHIvQUpjcHR1cnZTYTBGaVlXRnBCQ1ZiZHhUNVY4RVo1NWpwUXY2ZHN3eXJha09hTmFUMGpSalRpaTJmUkUvMlNtc0JDNWtwQVhNdXE4empxaDdxVVNlL0djZGdJbG84c20vSC9ndHRFa2NvT3NpenJpMEQ2bEwzY3BUTGtySlhaNHN4Sno0bDhxVzFNa0ttRU1ySThxdDVXMmRwenRVUjJVUWRrVnJGSW9rN2RtVGFEZloyNnMxaTlwU2VyYnptbkV0VEhaYWJUVXk0RE5aS2ZFSDNjSVA5NGdoSUpKRzFSOVNDSVc4ZmxocXpIOVliUnN2cG42eUpxbVhKYjB6ZE5ndHBscGw2Vm5WRjZabTBMbDBxVTZGcVVrcVg0KzlSNUFPRkpJMm5FTis1ZEM4UHN4anFCNm41TFdTWXB0dlVPMTVXeE5ONUtZUThhTFJtbW1uWmhZeWt1dUZLUWtyQ1NRa1lJR2VTZThRaEJ4dHQyeVVwSjlKZEhYblQ3VFd6Mk5HN2V0TmlpUzA5YWpWT1piYmthbkxJZFM2bmFGYm5FRk9Dc2tsU2lSeW9reEhGN3UzNUpUNjZJN2EyOUNsc3UxMjNhcnBsYmxJdHVwU2MwcVltSFJNT29BVmxDbWxwVGxTUnNLVkhBQTdpTVhLeXlUMGl6MEhvOHVEaWNwODJHM2l2OHNrOVRtbjVXbXl6TXkvOTVtVzJrb2RlMjQ4UllBQlZqMHljbU9hWnB0T1RjVlNIdDQ5ZS96aFdSb2JTczkvNVJGREhFSGowTVNJaGJpTzBNUlNsbmcvU0FZSmZLRkRJN3dXRkRnZDQ3L2xEQ2hGT3FCR2VSN1F3UE51Q3YxT2d5elU3VDZTYXcyMmYxOHMydmErRS92TitpaVBidWM4ZHVkT0ZwUzl4UmtUcm90dExMZ3JsMVRGd1ZTcDA2WXBOUGVtRzB5TW5OQWhhQWxHMVo1QU9DUWsrMmMvT094SFd2YWM5MzhnYXIzVFRiV2Z0NTZ1MGlTcWxIZG5VZ3VUTGFWcmszMCtadDVBVUNPTUU1R0NNY0huRVRJbWVsSGk1VUZia2tjRFBsTVV1R3plM2dzMnBkRVdOWDdBMHUxZjFkb3FkVkxWbUpHdFVvQmlYbW01dy9jNXhvcUtrSmRJQ1NXOXhVUjJ3U1FTQmtSYjhkRlpuQ09qVFJYNzgxTnAwd292anRLU3RBMnJDTWo5NUdkcCtJSU9ZeHFVMnExL21hR29ydXpjTHM2aVdRVzJpTnd3QVU5a2lLSjUxQzFGOWxzY1RsVGZnODVhaVNWRTVKNzVqbXUzMnpZaHBTK09POElZMmVEeVB6aERLQnh6em4yaElRU0hNUklCemVCZ1F5SVNsY2R1SUJqSlNBYzh3aGpyYWdQY0NHSVU0SXpneElRU1Y4akFnR2VmY2xOcWxTcCt5ajFsMml6aVRsTHFHa09vWDhGcFVEeDhpUHJGMk9lajdSVk9PeTZOTjNOcExxRGZGVmxSY0ZjazVxVVk4cUhVcUlDRWs4bExZUVBNZmo4T1kzcms0NHg2c3l2RE52c2tHbXFVNmpVOXBMODAzS3Nzb0NBcDlZVGdBWTdtTG84aUVrVnl4U2l5TEhVWmU5TXZHN0pSdWxPSW1XSkJndEttbXlDbHhST1NFbjFBOS9jbU5DZHF5cHFqY1dqVngxQ3E2YlVoVXc4dFRqYVZzaGF1NmtwVVVwNStBQUgwamtjakxPT1J4aXpmaGhHVUUyak1FK1UvaUpQdEdFMUJLT1Rqc1lBR3lkcDVFUkFRcXo2SCtFQUZLVU52dDg0UXdPTXd4RHFUN0NHRkNxSngyZ0VVRkR0ajZ3V0FXQUIvckRzQXNqMFRBQlFVRDZ3QVBJd1BTSkNCV3IvWWhBYXd1UHAvdDJ2VERreTFNVDBpK3RSVXJhOTRpU1R5VDU4bjg0MlI1YzQ5ZVNpV0NMN1BMa09taWlTc3loeWJxVTVPTkE1TFFDV3dyNWtaUDhJbStaSitFUlhIWHl6YWxOcDByUjVGbVRrMkVTOHN3a0liYVFNQUQvZnJHR1RiZHMxSlVxUmNrWkF3SWlBaCtzQXhsWEErTVFZd1BITVJzUWFzWUdJQmpTaGp1ZUI2UXJBY2JkSHFZYVlVRVZidlhFT3dCSzl2QmdzQlE0TWdBd3JBSXJ6M01Pd0tTckI3OFFXQThIQmpJLzhBMkhzS2lpb0hzZm5CWUNoUTd3V0FpMWdqbUN4akMxaEo1N3d0Z0tTN25rOW9OZ0tXOENQeFlnMkF0M0hkM1l4QnNkRE8vZHp4RWJIUVJmUCtwaUd3NkdWdm4zaUxrU29KdDczNWdVZ29lQ2xGUEhiNHhMWVZBK0lmVTgrOExZS0s4WFBZOGU4R3dVR0ZxUHBFa3hVR2xDL1E4bUgyQUJLa2tBbm1JM1FCZUlVZ3c5Z29FekI5VEMyWVVJWDFkdThHekhRMjQ4UUlXd1VOZmVTQUIzaU93Nks4VW5QdjdRYkNvWlU2c2toT1ByQzJiSlVDRmtEbk9ZVmhSN1V6S05vVGtKOUkwT0tLN1o1OHNoTTR5RkxTQVNTUExGZEprMjZMaGlWUUI2bjV3S0tFMk90dEpVeXRXT1U5b25xaU45akwrR3djSlQyaXBrMFdhWnBRVitGT005c1JGUzdKME96TSt1WFkzcFFnbjJJT1A1eGFtUXF4V0txNHFWTHBiYTNCR2V4eC9PTEV3YStCSmlwdUwya29iSGxCd0IvckVaZGlTTHBoZjNocEsxSkFKOW9UOFdIelJiK0psa3IySjNiaW44NGlNdWx5NkV0SlVCekV0VlZrVXhwTENGZHhFRWlUWUlZUUZnQVlnU1YwRmlLWlFsUkczMGdwQUU0d2dJeUU4NTd3TkJaNWt4TktaZVVoS1U0SHZtQ2dQLy9aIik7";*/
        /*String filePath =System.getProperty("java.io.tmpdir");//+"Travel_Temp_custome";
        File file=new File(filePath);
        file.mkdirs();
        System.out.println(filePath);*/
        //System.out.println(base64ToImage(base, filePath));
        Calendar beginNow = Calendar.getInstance();
        beginNow.setTime(new Date());
        beginNow.add(Calendar.DAY_OF_YEAR,20);//20天后生效
        Date beginTime=beginNow.getTime();//生效时间

        Calendar endNow = Calendar.getInstance();
        endNow.setTime(beginTime);
        endNow.add(Calendar.MONTH, 1);//失效时间为生效时间后一个月
        Date endTime=endNow.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd  HH:mm:ss");
        System.out.println(sdf.format(beginTime));
        System.out.println(sdf.format(endTime));

    }
}
