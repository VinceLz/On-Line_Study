package com.xawl.study.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;

import com.xawl.study.model.Question;

public class ExamUtil {

	public static List<Question> getAllExam(InputStream i) {

		try {
			HWPFDocument doc;
			doc = new HWPFDocument(i);
			String doc1 = doc.getDocumentText().trim();
			List<Question> list = new ArrayList();
			int start = 0;
			while (start < doc1.length()) {
				Question q = new Question();
				int indexOf = doc1.indexOf("#", start);
				int indexOf2 = doc1.indexOf("#", indexOf + 1);
				String timu = doc1.substring(indexOf + 1, indexOf2);
				q.setSubject(timu);
				// A
				int indexOf3 = doc1.indexOf("$", indexOf2 + 1);
				int indexOf4 = doc1.indexOf("$", indexOf3 + 1);
				String A = doc1.substring(indexOf3 + 1, indexOf4);
				q.setOptionA(A);

				// B
				int indexOf5 = doc1.indexOf("$", indexOf4 + 1);
				int indexOf6 = doc1.indexOf("$", indexOf5 + 1);
				String B = doc1.substring(indexOf5 + 1, indexOf6);
				q.setOptionB(B);

				// C
				int indexOf7 = doc1.indexOf("$", indexOf6 + 1);
				int indexOf8 = doc1.indexOf("$", indexOf7 + 1);
				String C = doc1.substring(indexOf7 + 1, indexOf8);
				q.setOptionC(C);

				// D
				int indexOf9 = doc1.indexOf("$", indexOf8 + 1);
				int indexOf10 = doc1.indexOf("$", indexOf9 + 1);
				String D = doc1.substring(indexOf9 + 1, indexOf10);
				q.setOptionD(D);

				// ´ð°¸
				int indexOf11 = doc1.indexOf("@", indexOf10 + 1);
				int indexOf12 = doc1.indexOf("@", indexOf11 + 1);
				String E = doc1.substring(indexOf11 + 1, indexOf12);
				q.setAnswer(E);
				start = indexOf12 + 1;
				System.out.println(doc1.length());
				System.out.println(start);
				list.add(q);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
