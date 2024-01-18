package com.devkgm.app.board.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devkgm.app.board.BoardDAO;
import com.devkgm.app.board.BoardPager;


@Repository
public class ProductDAO implements BoardDAO<ProductDTO> {
    @Autowired
    private SqlSession sqlSession;
    private String namespace = "com.devkgm.app.board.product.ProductDAO.";

    @Override
    public List<ProductDTO> getList(BoardPager boardPager) throws Exception {
        return sqlSession.selectList(namespace + "getList", boardPager);
    }

    @Override
    public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
        return sqlSession.selectOne(namespace + "getDetail", productDTO);
    }

    @Override
    public int add(ProductDTO productDTO) throws Exception {
        return sqlSession.insert(namespace + "add", productDTO);
    }

    @Override
    public int update(ProductDTO productDTO) throws Exception {
        System.out.println(productDTO.getContent());
        return sqlSession.update(namespace + "update", productDTO);
    }

    @Override
    public int delete(ProductDTO productDTO) throws Exception {
        return sqlSession.delete(namespace + "delete", productDTO);
    }

    @Override
    public Long getTotalPage(BoardPager boardPager) throws Exception {
        return sqlSession.selectOne(namespace + "getTotalPage", boardPager);
    }

    public int addAvatar(ProductFileDTO productFileDTO) throws Exception {
        return sqlSession.insert(namespace + "addAvatar", productFileDTO);
    }

    public int addThumbnail(ProductFileDTO productFileDTO) throws Exception {
        return sqlSession.insert(namespace + "addThumbnail", productFileDTO);
    }

    public int deleteFile(ProductFileDTO productFileDTO) throws Exception {
        return sqlSession.delete(namespace + "deleteFile", productFileDTO);
    }

    public int deleteThumbnail(ProductFileDTO productFileDTO) throws Exception {
        return sqlSession.delete(namespace + "deleteThumbnail", productFileDTO);
    }

    public List<ProductFileDTO> getTotalImage(ProductDTO productDTO) throws Exception {
        return sqlSession.selectList(namespace + "getTotalImage", productDTO);
    }


}
