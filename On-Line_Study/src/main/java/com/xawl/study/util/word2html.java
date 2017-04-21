package com.xawl.study.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;

public class word2html {

	public static void tran(String inp, String oup, String root) {

		String end = inp.substring(inp.lastIndexOf(".") + 1, inp.length())
				.toLowerCase();
		if ("doc".toLowerCase().equals(end)) {
			try {
				docToHtml(inp, oup, root);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("docx".toLowerCase().equals(end)) {
			try {
				docxToHtml(inp, oup, root);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("xls".toLowerCase().equals(end.toLowerCase())) {
			try {
				xlsToHtml(inp, oup);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			throw new RuntimeException("格式错误");
		}

	}

	// doc转换为html
	static void docToHtml(String sourceFileName, String targetFileName,
			String root) throws Exception {
		final String imagePathStr = root + "\\image\\";
		HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(
				sourceFileName));
		Document document = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().newDocument();
		WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
				document);
		// 保存图片，并返回图片的相对路径
		wordToHtmlConverter.setPicturesManager(new PicturesManager() {

			@Override
			public String savePicture(byte[] arg0, PictureType arg1,
					String arg2, float arg3, float arg4) {

				FileOutputStream out;
				try {
					out = new FileOutputStream(imagePathStr + arg2);
					out.write(arg0);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "image/" + arg2;
			}
		});
		wordToHtmlConverter.processDocument(wordDocument);
		Document htmlDocument = wordToHtmlConverter.getDocument();
		DOMSource domSource = new DOMSource(htmlDocument);
		StreamResult streamResult = new StreamResult(new File(targetFileName));

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer serializer = tf.newTransformer();
		serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		serializer.setOutputProperty(OutputKeys.METHOD, "html");
		serializer.transform(domSource, streamResult);
	}

	// docx转换为html
	public static void docxToHtml(String sourceFileName, String targetFileName,
			String root) throws Exception {

		String imagePathStr = root + "\\image\\";
		OutputStreamWriter outputStreamWriter = null;
		try {
			XWPFDocument document = new XWPFDocument(new FileInputStream(
					sourceFileName));
			XHTMLOptions options = XHTMLOptions.create();
			// 存放图片的文件夹
			options.setExtractor(new FileImageExtractor(new File(imagePathStr)));
			// html中图片的路径
			options.URIResolver(new BasicURIResolver("image"));
			outputStreamWriter = new OutputStreamWriter(new FileOutputStream(
					targetFileName), "utf-8");
			XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter
					.getInstance();
			xhtmlConverter.convert(document, outputStreamWriter, options);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStreamWriter != null) {
				outputStreamWriter.close();
			}
		}
	}

	public static void xlsToHtml(String sourceFileName, String targetFileName) {

		try {
			Document doc = ExcelToHtmlConverter
					.process(new File(sourceFileName));
			DOMSource domSource = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File(
					targetFileName));
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer serializer = tf.newTransformer();
			serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty(OutputKeys.METHOD, "html");
			serializer.transform(domSource, streamResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
