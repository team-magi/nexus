package com.magi.nft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magi.nft.domain.NftList;
import com.magi.nft.service.INftListService;
import com.magi.common.core.text.Convert;
import com.magi.nft.mapper.NftListMapper;

/**
 * nft藏品列Service业务层处理
 *
 * @author nexus
 * @date 2021-09-09
 */
@Service
public class NftListServiceImpl implements INftListService {
    @Autowired
    private NftListMapper nftListMapper;

    /**
     * 查询nft藏品列
     *
     * @param id nft藏品列主键
     *
     * @return nft藏品列
     */
    @Override
    public NftList selectNftListById(Integer id) {
        return nftListMapper.selectNftListById(id);
    }

    /**
     * 查询nft藏品列列表
     *
     * @param nftList nft藏品列
     *
     * @return nft藏品列
     */
    @Override
    public List<NftList> selectNftListList(NftList nftList) {
        return nftListMapper.selectNftListList(nftList);
    }

    /**
     * 新增nft藏品列
     *
     * @param nftList nft藏品列
     *
     * @return 结果
     */
    @Override
    public int insertNftList(NftList nftList) {
        return nftListMapper.insertNftList(nftList);
    }

    /**
     * 修改nft藏品列
     *
     * @param nftList nft藏品列
     *
     * @return 结果
     */
    @Override
    public int updateNftList(NftList nftList) {
        return nftListMapper.updateNftList(nftList);
    }

    /**
     * 批量删除nft藏品列
     *
     * @param ids 需要删除的nft藏品列主键
     *
     * @return 结果
     */
    @Override
    public int deleteNftListByIds(String ids) {
        return nftListMapper.deleteNftListByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除nft藏品列信息
     *
     * @param id nft藏品列主键
     *
     * @return 结果
     */
    @Override
    public int deleteNftListById(Integer id) {
        return nftListMapper.deleteNftListById(id);
    }

}
