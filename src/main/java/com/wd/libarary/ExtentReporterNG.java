package com.wd.libarary;

import com.relevantcodes.extentreports.*;
import org.testng.*;
import org.testng.IReporter;
import org.testng.xml.XmlSuite;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ike on 16/8/31.
 */
public class ExtentReporterNG implements IReporter {

    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        extent = new ExtentReports("logs/ExtentReport.html", //生成报告文件名
                true  // true为覆盖已经生成的报告，false 在已有的报告上面生成，不会覆盖旧的结果
                , DisplayOrder.NEWEST_FIRST // 最新运行的用例结果在第一个
                , NetworkMode.OFFLINE //online  报告的一些样式文件需从网络下载，生成的报告文件小   offline  样式及js文件不会从网络下载，生成在文件中
        );
        extent.assignProject("H5");
        extent.x("127.0.0.1", 27017);
        extent.addSystemInfo("Host Name", "localhost");
        extent.addSystemInfo("Environment", "online");
//        extent.startReporter(ReporterType.DB, "logs/"); //生成本地的DB数据文件,会生成一个Sqllite的数据库db文件

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }

        extent.flush();
        extent.close();
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());

                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group); // 添加分类

                if (result.getThrowable() != null) {
//                    test.log(status, test.addScreenCapture("logs/imgs/"+result.getMethod().getMethodName()+".png"));
                    // 这里需要添加一个base64位的图片的前缀标识.否则网页不识别是base64位图片
                    test.log(status, test.addBase64ScreenShot("data:image/jpg;base64," + getImageToBase64Str("logs/imgs/" + result.getMethod().getMethodName() + ".png")));
                    test.log(status, result.getThrowable().getMessage());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
//                String message = "Test " + status.toString().toLowerCase() + "ed";
//                result.getMethod().getMethodName();
//                if (result.getThrowable() != null)
//                    message = result.getThrowable().getMessage();
//                test.log(status, message);

                extent.endTest(test);
            }
        }
    }

    // 图片转化成base64位字符串
    public static String getImageToBase64Str(String path) {
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
