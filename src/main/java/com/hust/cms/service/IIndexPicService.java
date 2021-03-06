package com.hust.cms.service;

import com.hust.cms.model.IndexPic;
import com.hust.cms.model.Pager;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface IIndexPicService {
    public void add(IndexPic indexPic);

    public void update(IndexPic indexPic);

    public void delete(int id);

    public void updateStatus(int id);

    public IndexPic load(int id);

    /**
     * 根据数量来获取首页图片信息
     *
     * @param num
     * @return
     */
    public List<IndexPic> listIndexPicByNum(int num);

    public Pager<IndexPic> findIndexPic();

    public List<String> listAllIndexPicName();

    public void cleanNoUseIndexPic(List<String> pics) throws IOException;

    public Map<String, Integer> getMinAdnMaxPos();

    public void updatePos(int id, int oldPos, int newPos);
}
