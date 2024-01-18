package com.devkgm.app.board;

public class BoardPager {
    private Long totalPage;
    private Long page = 1l;
    private Long perPage = 10l;
    private Long startPage;
    private Long lastPage;

    private Long perBlock = 10l;
    private Long curBlock;
    private Long startBlock;
    private Long lastBlock;
    private Long totalBock;

    private String kind = "title";
    private String search = "";


    public Long getTotalBock() {
        return totalBock;
    }

    public void setTotalBock(Long totalBock) {
        this.totalBock = totalBock;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public boolean isStart() {
        return this.curBlock == 1;
    }

    public boolean isLast() {
        return this.curBlock == this.totalBock / this.perBlock + 1;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
        this.lastPage = this.page * this.perPage;
        this.startPage = this.lastPage - this.perPage + 1;

        this.totalBock = this.totalPage / this.perPage + (this.totalPage % this.perPage > 0 ? 1 : 0);
        this.curBlock = this.page / this.perPage + (this.page % this.perPage > 0 ? 1 : 0);
        this.startBlock = this.page / this.perBlock * (this.page % this.perBlock > 0 ? this.perBlock : 0) + 1;
        this.lastBlock = this.startBlock + (this.totalBock - this.startBlock < 10 ? this.totalBock - this.startBlock : this.perBlock - 1);
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "BoardPager [totalPage=" + totalPage + ", page=" + page + ", perPage=" + perPage + ", startPage="
                + startPage + ", lastPage=" + lastPage + ", perBlock=" + perBlock + ", curBlock=" + curBlock
                + ", startBlock=" + startBlock + ", lastBlock=" + lastBlock + ", totalBock=" + totalBock + "]";
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;

    }

    public Long getPerPage() {
        return perPage;
    }

    public void setPerPage(Long perPage) {
        this.perPage = perPage;
    }

    public Long getStartPage() {
        return startPage;
    }

    public void setStartPage(Long startPage) {
        this.startPage = startPage;
    }

    public Long getLastPage() {
        return lastPage;
    }

    public void setLastPage(Long lastPage) {
        this.lastPage = lastPage;
    }

    public Long getPerBlock() {
        return perBlock;
    }

    public void setPerBlock(Long perBlock) {
        this.perBlock = perBlock;
    }

    public Long getCurBlock() {
        return curBlock;
    }

    public void setCurBlock(Long curBlock) {
        this.curBlock = curBlock;
    }

    public Long getStartBlock() {
        return startBlock;
    }

    public void setStartBlock(Long startBlock) {
        this.startBlock = startBlock;
    }

    public Long getLastBlock() {
        return lastBlock;
    }

    public void setLastBlock(Long lastBlock) {
        this.lastBlock = lastBlock;
    }


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
