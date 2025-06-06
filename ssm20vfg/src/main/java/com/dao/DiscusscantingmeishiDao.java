package com.dao;

import com.entity.DiscusscantingmeishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusscantingmeishiVO;
import com.entity.view.DiscusscantingmeishiView;


/**
 * 餐厅美食评论表
 * 
 * @author 
 * @email 
 * @date 2022-05-19 16:00:26
 */
public interface DiscusscantingmeishiDao extends BaseMapper<DiscusscantingmeishiEntity> {
	
	List<DiscusscantingmeishiVO> selectListVO(@Param("ew") Wrapper<DiscusscantingmeishiEntity> wrapper);
	
	DiscusscantingmeishiVO selectVO(@Param("ew") Wrapper<DiscusscantingmeishiEntity> wrapper);
	
	List<DiscusscantingmeishiView> selectListView(@Param("ew") Wrapper<DiscusscantingmeishiEntity> wrapper);

	List<DiscusscantingmeishiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusscantingmeishiEntity> wrapper);
	
	DiscusscantingmeishiView selectView(@Param("ew") Wrapper<DiscusscantingmeishiEntity> wrapper);
	

}
