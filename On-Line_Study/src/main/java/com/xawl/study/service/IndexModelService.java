package com.xawl.study.service;

import java.util.List;

import com.xawl.study.model.IndexModel;

public interface IndexModelService {

	// �����ҳ����
	public String addIndexModel(IndexModel index);

	// ����������ҳ����
	public List<IndexModel> findAllIndex();

	// �������õ���ҳ����
	public IndexModel findUseModel();

	// ����id����ҳ����
	public IndexModel findIndexModelById(int id);

	// ɾ����ҳ����
	public String deleteIndexModelById(int id);

	// �ر��Ѿ����õķ���
	public boolean closeUseIndex();

	// ��id�޸���ҳ����
	public String updateIndexModelById(int id, IndexModel indexModel);

	// ��id��ͼƬλ���޸���ҳ����
	public String updateImage(int indexId, String location, String relativePath);
}
