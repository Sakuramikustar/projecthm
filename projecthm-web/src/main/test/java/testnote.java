import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import javax.swing.text.html.FormSubmitEvent;
  //  "LTAI4FwitaA15TLshhm6Dtn7","pu97bGJ6FtxPHFF21Nz0mLfDxH20tP");
public class testnote {
    public static void main(String[] args){
        DefaultProfile profile = DefaultProfile.getProfile("default","LTAI4FwitaA15TLshhm6Dtn7","pu97bGJ6FtxPHFF21Nz0mLfDxH20tP");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        // 手机号码 号码之间以英文逗号（,）分隔。上限为1000个手机号码
        request.putQueryParameter("PhoneNumbers", "18526039395");
        // 签名
        request.putQueryParameter("SignName", "PHM");
        // 消息模板SMS_174272564
        request.putQueryParameter("TemplateCode", "SMS_174272564");
        // 消息参数
        request.putQueryParameter("TemplateParam", "{ \"code\":\"20070831\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
