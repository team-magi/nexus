package com.magi.nft.service;

import java.util.List;

import com.magi.nft.domain.NftList;

/**
 * nft藏品列Service接口
 *
 * @author nexus
 * @date 2021-09-09
 */
public interface INftListService {
    /**
     * 查询nft藏品列
     *
     * @param id nft藏品列主键
     *
     * @return nft藏品列
     */
    public NftList selectNftListById(Integer id);

    /**
     * 查询nft藏品列列表
     *
     * @param nftList nft藏品列
     *
     * @return nft藏品列集合
     */
    public List<NftList> selectNftListList(NftList nftList);

    /**
     * 新增nft藏品列
     *
     * @param nftList nft藏品列
     *
     * @return 结果
     */
    public int insertNftList(NftList nftList);

    /**
     * 修改nft藏品列
     *
     * @param nftList nft藏品列
     *
     * @return 结果
     */
    public int updateNftList(NftList nftList);

    /**
     * 批量删除nft藏品列
     *
     * @param ids 需要删除的nft藏品列主键集合
     *
     * @return 结果
     */
    public int deleteNftListByIds(String ids);

    /**
     * 删除nft藏品列信息
     *
     * @param id nft藏品列主键
     *
     * @return 结果
     */
    public int deleteNftListById(Integer id);

}
