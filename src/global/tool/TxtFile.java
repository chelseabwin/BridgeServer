package global.tool;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TxtFile {
	private final static Log logger = LogFactory.getLog(TxtFile.class);
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	InputStreamReader reader;

	/**
	 * ���������ļ�
	 * 
	 * @param filePath д���ļ���·��
	 * @param content д����ַ�������
	 * @return
	 */
	public boolean string2File(String content, String filePath) {
		boolean flag = true;
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			bufferedReader = new BufferedReader(new StringReader(content));
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			char buffer[] = new char[1024];
			int len;
			while ((len = bufferedReader.read(buffer)) != -1) {
				bufferedWriter.write(buffer, 0, len);
			}
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
		} catch (IOException e) {
			logger.error(e);
			flag = false;
			return flag;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
		return flag;
	}
	/**
	 * ��ȡ�����ļ�
	 * @param filePath ��ȡ���ļ�·��
	 * @param encoding ��ȡ����ַ������뼯����
	 * @return
	 */
	public String file2String(String filePath, String encoding) {
		StringWriter writer = new StringWriter();
		File file = new File(filePath);
		try {
			if (encoding == null || "".equals(encoding.trim())) {
				reader = new InputStreamReader(new FileInputStream(file));
			} else {
				reader = new InputStreamReader(new FileInputStream(file), encoding);
			}
			// ��������д�������
			char[] buffer = new char[1024];
			int n = 0;
			while (-1 != (n = reader.read(buffer))) {
				writer.write(buffer, 0, n);
			}
		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					logger.error(e);
				}
		}
		// ����ת�����
		return writer.toString();		
	}

	public static void main(String[] args) {
		new TxtFile().string2File("�����ļ�д�����ģ�TEST STRING TO FILE", "F:/c.txt");
		System.out.println(new TxtFile().file2String("F:/c.txt", null));
		System.out.println(new TxtFile().file2String("F:/c.txt", "GBK"));
	}
}