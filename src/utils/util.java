package utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author gudonghu
 */
public class util {
	
	/**
	 * 32MD5����
	 * @param str �������ַ���
	 * @return 32λMD5�����ַ���
	 * @throws NoSuchAlgorithmException
	 */
	public static String UseMD5(String str) throws NoSuchAlgorithmException  {
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		BigInteger bigInteger=new BigInteger(1, md.digest());
		return bigInteger.toString(16);
	}
	
	/**
	 * ��ȡϵͳ��ǰ����ʱ��
	 * @return ϵͳ��ǰ����ʱ��
	 */
	public static String getNowTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		return df.format(System.currentTimeMillis()); 
	}
	
	/**
	 * ��ȡ��ǰѧ��
	 * @return ϵͳ��ǰѧ��
	 */
	public static String getNowCurricula(){
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		if(month<=8){
			return (year-1)+"-"+year+"ѧ�� ��ѧ��";
		}
		return year+"-"+(year+1)+"ѧ�� ��ѧ��";		
	}
	
	/**
	* ���ڽ��쳣����e�еĴ�����Ϣ����Ϊһ��String��
	���������ַ���
	* �������������־�ļ�����ȥ
	* @param e �쳣����
	* @return �쳣�����е��쳣��Ϣ�ַ���
	*/
	public static String getExceptionMsg(Throwable e){
		//���쳣�����е��쳣��¼ת��Ϊ��¼����
		StackTraceElement[] s = e.getStackTrace();
		StringBuffer sb = new StringBuffer();//��������ȡ���쳣��Ϣ������Ϊһ���ַ���
		for(int i=0;i<s.length;i++){
			sb.append("\r\n");
			sb.append(s[i]);
		}
		return sb.toString();
	}
	
	public static Object convertNull(Object obj){
		if(obj==null)
			return "";
		return obj;
	}
	/**
	 * �ļ��ϴ�����
	 * @param servlet Servlet����
	 * @param request request����
	 * @param dirname �ϴ�Ŀ���ļ���
	 * @param fileName �ϴ����ļ���
	 * @throws Exception �쳣
	 */
	public static String fileupload(HttpServlet servlet,
			HttpServletRequest request, String dirname, String fileName)
			throws Exception {
		 // �����ϴ�����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
        factory.setSizeThreshold(1024 * 1024 * 3);        
        // ������ʱ�洢Ŀ¼
        factory.setRepository(new File(System.getProperty("java.io.tmpdir"))); 
        ServletFileUpload upload = new ServletFileUpload(factory);         
        // ��������ļ��ϴ�ֵ
        upload.setFileSizeMax(1024 * 1024 * 40);         
        // �����������ֵ (�����ļ��ͱ�����)
        upload.setSizeMax(1024 * 1024 * 50);        
        // ���Ĵ���
        upload.setHeaderEncoding("UTF-8"); 

        
        String uploadPath = servlet.getServletContext().getRealPath("/")  + dirname;
       
        System.out.println(uploadPath);
        // ���Ŀ¼�������򴴽�
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        } 
      
        // ���������������ȡ�ļ�����
        @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // ����������
            for (FileItem item : formItems) {
                // �����ڱ��е��ֶ�
                if (!item.isFormField()) {
                	System.out.println(item.getFieldName());
                	String fName = new File(item.getName()).getName();
                	System.out.println(fName);
                	String type=fName.substring(fName.indexOf("."), fName.length());
                	System.out.println(type);
                	if(fileName.equals("")){
                		//fileName = new File(item.getName()).getName();
						fileName=item.getFieldName()+type;
                	}else{
                		fileName=fileName+type;
                	}
                    String filePath = uploadPath + File.separator + fileName;
                    System.out.println(filePath);
                    File storeFile = new File(filePath);
                    // �ڿ���̨����ļ����ϴ�·��
                    System.out.println(filePath);
                    // �����ļ���Ӳ��
                    if(storeFile.exists()){
                    	storeFile.delete();
                    }
                    item.write(storeFile);                        
                }
            }
        }
        return fileName;
   
	}
	//����
	public static void main(String[] args) {
		System.out.println(getNowTime());
	}

}
