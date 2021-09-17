package com.magi.nft.mapper;

import java.util.List;

import com.magi.nft.domain.NftList;

/**
 * nft藏品列Mapper接口
 *
 * @author nexus
 * @date 2021-09-09
 */
public interface NftListMapper {
    /**
     * 查询nft藏品列
     *
     * @param id nft藏品列主键
     *
     * @return nft藏品列
     */
    NftList selectNftListById(Integer id);

    /**
     * 查询nft藏品列列表
     *
     * @param nftList nft藏品列
     *
     * @return nft藏品列集合
     */
    List<NftList> selectNftListList(NftList nftList);

    /**
     * 新增nft藏品列
     *
     * @param nftList nft藏品列
     *
     * @return 结果
     */
    int insertNftList(NftList nftList);

    /**
     * 修改nft藏品列
     *
     * @param nftList nft藏品列
     *
     * @return 结果
     */
    int updateNftList(NftList nftList);

    /**
     * 删除nft藏品列
     *
     * @param id nft藏品列主键
     *
     * @return 结果
     */
    int deleteNftListById(Integer id);

    /**
     * 批量删除nft藏品列
     *
     * @param ids 需要删除的数据主键集合
     *
     * @return 结果
     */
    int deleteNftListByIds(String[] ids);

}
