package cn.ph.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class NoteUtill  extends HttpServlet{
//    非servlet类连接session
    ServletRequestAttributes servletReqAttr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = servletReqAttr.getRequest();
    HttpSession session = request.getSession();


    private static String code;
    private static String ttime;

    public static void main(String[] args) {

    }

    public static String getPhone(String mobile){
        DefaultProfile profile = DefaultProfile.getProfile("default", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        code = vcode();
        ttime = vtime();

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("QuerySendDetails");
        request.putQueryParameter("RegionId", "default");
        // 手机号码 号码之间以英文逗号（,）分隔。上限为1000个手机号码
        request.putQueryParameter("PhoneNumber", mobile);
        // 签名
        request.putQueryParameter("SignName", "PHM");
        // 消息模板SMS_174272564
        request.putQueryParameter("TemplateCode", "SMS_174272564");
        // 消息参数
        request.putQueryParameter("TemplateParam", "{ \"code\":\""+code+"\"}");

        request.putQueryParameter("SendDate", ttime);
        request.putQueryParameter("PageSize", "1");
        request.putQueryParameter("CurrentPage", "1");



        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "true";
    }
//    生成六位随机码
    public static String vcode(){
        String vcode = "";
        for (int i=0;i<6;i++){
            vcode = vcode + (int)(Math.random()*9);
        }
        return vcode;
    }
//    日期
    public static String vtime(){
        Date now = new Date();
        String vtime="";
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        vtime = dataFormat.format(now);
        return vtime;
    }
}
