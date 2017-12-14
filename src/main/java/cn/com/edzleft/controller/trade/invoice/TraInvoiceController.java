package cn.com.edzleft.controller.trade.invoice;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Attachment;
import cn.com.edzleft.entity.InvoiceRecord;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.trade.invoice.TraAttService;
import cn.com.edzleft.service.trade.invoice.TraInvoiceService;
import cn.com.edzleft.util.FtpUtil;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/traInvoice")
public class TraInvoiceController {
	@Autowired
	private TraInvoiceService traInvoiceService;
	
    
	@Autowired
	private TraAttService traAttService;
	
	@RequestMapping(value = "/invoiceList",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson invoiceList(HttpSession session,Integer pageNumber,Integer pageSize,String invoiceNumber,String checkTaker) {
		DataGridJson dgj = new DataGridJson();
		PageUtil<InvoiceRecord> userPage = new PageUtil<>();
		HashMap<String, Object> whereMaps = new HashMap<>();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		Account sessionAccount=sessionInfo.getAdmin();
		Integer userId=sessionAccount.getInformationId();
		whereMaps.put("userId", userId);
		whereMaps.put("invoiceNumber",invoiceNumber);
		whereMaps.put("checkTaker",checkTaker);
		/*System.out.println("================");
		System.out.println(drawer);
		System.out.println("================");*/
		userPage.setCpage(pageNumber);
		userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        
        userPage = traInvoiceService.getInvoiceRecordEntityListByConditions(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
		return dgj;
	}
	
	@RequestMapping("/edit")
	public String edit(Map<String, Object> map,Integer id) {
		InvoiceRecord invoiceRecord = traInvoiceService.getById(id);
		map.put("invoiceRecord", invoiceRecord);
		return "/trade/invoice/edit";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Map update(InvoiceRecord invoiceRecord,@RequestParam("uploadFile") MultipartFile uploadFile,HttpSession session,RedirectAttributes attr){
		//Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		Map resultMap = new HashMap<>();  
		Attachment attachment = new Attachment();
		String newName="";
		String imagePath="";
		boolean result =true;
        try {  
        	if (!uploadFile.isEmpty()) {
        		 // 生成一个文件名  
                // 获取旧的名字  
                String oldName = uploadFile.getOriginalFilename();  
              //获取文件名后缀.的位置
    			int nodePosition = oldName.lastIndexOf(".");
    			
               newName = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() + oldName.substring(nodePosition);
                //新名字  
               // newName = newName + oldName.substring(oldName.lastIndexOf("."));  
                //上传的路径  
              //  Date date = new Date();
                imagePath = "/ukey";
                //端口号  
                int port = Integer.parseInt("21");  
               // System.out.println(FTP_BASEPATH);  
                //调用方法，上传文件  
                result = FtpUtil.uploadFile("47.104.103.141", port,  
                        "gylftpuser", "gylftppwd", "/home/gylftpuser", imagePath,  
                        newName, uploadFile.getInputStream());  
			}
           
            //判断是否上传成功  
            if (!result) {  
                resultMap.put("error", 1);  
                resultMap.put("message", "上传失败");  
                return resultMap;  
            }  
            resultMap.put("error", 0);  
            resultMap.put("url", "47.104.103.141" + imagePath + newName); 
            attachment.setAttachmentName(newName);
            attachment.setAttachmentId(invoiceRecord.getInvoiceFileAttachment());
            traAttService.updateImg(attachment);
            traInvoiceService.update(invoiceRecord);
            return resultMap;  
  
        } catch (IOException e) {  
            resultMap.put("error", 1);  
            resultMap.put("message", "上传发生异常");  
            return resultMap;  
        }  
		
		
		/*Map resultMap = new HashMap<>();  
		Attachment attachment = new Attachment();
		String newName="";
		String imagePath="";
		boolean result =true;
        try {  
        	if (!uploadFile.isEmpty()) {
        		 // 生成一个文件名  
                // 获取旧的名字  
                String oldName = uploadFile.getOriginalFilename();  
              //获取文件名后缀.的位置
    			int nodePosition = oldName.lastIndexOf(".");
    			
               newName = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() + oldName.substring(nodePosition);
                //新名字  
               // newName = newName + oldName.substring(oldName.lastIndexOf("."));  
                //上传的路径  
               // Date date = new Date();
                imagePath = "/ukey";
                //端口号  
                int port = Integer.parseInt("21");  
                //System.out.println(FTP_BASEPATH);  
                //调用方法，上传文件  
                result = FtpUtil.uploadFile("47.104.103.141", port,  
                		"gylftpuser", "gylftppwd", "/home/gylftpuser/uploadfile", imagePath,  
                        newName, uploadFile.getInputStream());  
			}
           
            //判断是否上传成功  
            if (!result) {  
                resultMap.put("error", 1);  
                resultMap.put("message", "上传失败");  
                return resultMap;  
            }  
            resultMap.put("error", 0);  
            resultMap.put("url", "http://47.104.103.141/uploadfile" + imagePath + newName); 
            attachment.setAttachmentName(newName);
            attachment.setAttachmentId(invoiceRecord.getInvoiceFileAttachment());
            attachment.setAttachmentUrl((String)resultMap.get("url"));
            if (result) {
            	traAttService.updateImg(attachment);
			}
            
            traInvoiceService.update(invoiceRecord);
            return resultMap;  
  
        } catch (IOException e) {  
            resultMap.put("error", 1);  
            resultMap.put("message", "上传发生异常");  
            return resultMap;  
        }  */
		
		
		
		
		
		
		
		
		
		
		
		/*Attachment attachment = new Attachment();
		//Integer invoiceNo=invoiceRecord.getInvoiceNo();
		//获取图片上传的路径
		String path = session.getServletContext().getRealPath("/download");
		String newFileName = "";
		String returnPath = "";
		try {//循环遍历
			for (int i = 0; i < photos.length; i++) {
				//判断当前对象是否为空
				if(!photos[i].isEmpty()){
					//获取原文件名
					String originalFileName = photos[i].getOriginalFilename();
					//获取文件名后缀.的位置
					int nodePosition = originalFileName.lastIndexOf(".");
					if(nodePosition > 0){
						//设置图片新的名称
						newFileName = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() + originalFileName.substring(nodePosition);
						System.out.println("=============");
						System.out.println(newFileName);
						System.out.println(path);
						System.out.println("=============");
						attachment.setAttachmentUrl("/supplyChain/download/" + newFileName);
						}
					
					File file = new File(path, newFileName);
					photos[i].transferTo(file);
					//System.out.println();
					attachment.setAttachmentName(newFileName);
					//attachment.setAttachmentUrl(newFileName);
					attachment.setAttachmentId(invoiceRecord.getInvoiceFileAttachment());
					int r1=traAttService.updateImg(attachment);
					}	
				}
			
			traInvoiceService.update(invoiceRecord);
		//	attr.addAttribute("id", invoiceRecord.getId());
			returnPath = "redirect:/tradeMain/tradeMain.action";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnPath;*/
	}
}
