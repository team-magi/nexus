package com.magi.nft.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.magi.common.annotation.Excel;
import com.magi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * nft藏品列对象 nft_list
 *
 * @author nexus
 * @date 2021-09-09
 */
public class NftList extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date updatedAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date deletedAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String url;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long views;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long favorites;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String details;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long sysUserId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sysUserAuthorityId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long currentPrice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String nftType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String tokenAddress;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long tokenId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String author;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getViews() {
        return views;
    }

    public void setFavorites(Long favorites) {
        this.favorites = favorites;
    }

    public Long getFavorites() {
        return favorites;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserAuthorityId(String sysUserAuthorityId) {
        this.sysUserAuthorityId = sysUserAuthorityId;
    }

    public String getSysUserAuthorityId() {
        return sysUserAuthorityId;
    }

    public void setCurrentPrice(Long currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Long getCurrentPrice() {
        return currentPrice;
    }

    public void setNftType(String nftType) {
        this.nftType = nftType;
    }

    public String getNftType() {
        return nftType;
    }

    public void setTokenAddress(String tokenAddress) {
        this.tokenAddress = tokenAddress;
    }

    public String getTokenAddress() {
        return tokenAddress;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createdAt", getCreatedAt())
                .append("updatedAt", getUpdatedAt())
                .append("deletedAt", getDeletedAt())
                .append("name", getName())
                .append("url", getUrl())
                .append("views", getViews())
                .append("favorites", getFavorites())
                .append("details", getDetails())
                .append("sysUserId", getSysUserId())
                .append("sysUserAuthorityId", getSysUserAuthorityId())
                .append("currentPrice", getCurrentPrice())
                .append("nftType", getNftType())
                .append("tokenAddress", getTokenAddress())
                .append("tokenId", getTokenId())
                .append("author", getAuthor())
                .toString();
    }

}
