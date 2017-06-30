/**
 * Created by acer on 2017/6/30.
 */

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.InvocationContext;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;
import junit.framework.Assert;
import junit.framework.TestCase;
import yang.servlet.Servlet;

public class HttpUnitTest extends TestCase {
    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testHelloWorld() {

        try {

            // 创建Servlet的运行环境

            ServletRunner sr = new ServletRunner();

            // 向环境中注册Servlet

            sr.registerServlet("Servlet", Servlet.class.getName());

            // 创建访问Servlet的客户端

            ServletUnitClient sc = sr.newClient();

            // 发送请求

            WebRequest request = new GetMethodWebRequest("http://localhost/Servlet");

            InvocationContext ic = sc.newInvocation(request);

            Servlet is = (Servlet) ic.getServlet();

            // 获得模拟服务器的信息

            WebResponse response = sc.getResponse(request);

            // 断言

            Assert.assertTrue(response.getText().equals("hello world"));

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
