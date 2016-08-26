package global.tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;  
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import freemarker.template.Configuration;  
import freemarker.template.Template;  
import freemarker.template.TemplateException;  

public class WordCreate {
	private Configuration configuration = null;
	
	private String tempPath = "/media";
	private String downloadPath = "/wordDownload/";
	
	@SuppressWarnings("deprecation")
	public String getTempPath() {
		return ServletActionContext.getRequest().getRealPath(tempPath);
	}

	public void setTempPath(String value) {
		this.tempPath = value;
	}
	
	@SuppressWarnings("deprecation")
	public String getDownloadPath() {
		return ServletActionContext.getRequest().getRealPath(downloadPath);
	}

	public void setDownloadPath(String value) {
		this.downloadPath = value;
	}
    
    @SuppressWarnings("deprecation")
	public WordCreate() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
    }
    
    public void createWord(Map<String,Object> dataMap) throws IOException {
    	String result = "faild";
    	PrintWriter outWriter = ServletActionContext.getResponse().getWriter();
        //getData(dataMap);
        configuration.setDirectoryForTemplateLoading(new File(getTempPath()));
        Template t = null;
        try {
            t = configuration.getTemplate("new.ftl"); //模板
        } catch (IOException e) {
            e.printStackTrace();
        }
        File outFile = new File(getDownloadPath() + Math.random()*10000 + ".doc");
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
           
        try {
            t.process(dataMap, out);
            result = "success";
        } catch (TemplateException e) {
        	result = "faild";
            e.printStackTrace();
        } catch (IOException e) {
        	result = "faild";
            e.printStackTrace();
        }
        
        // 返回ajax处理文件下载
        if (result.equals("success")) {
        	outWriter.write(outFile.getName());
		}
		else {
			outWriter.write("faild");
		}
    }
}
