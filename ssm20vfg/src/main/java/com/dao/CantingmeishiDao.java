package com.dao;

import com.entity.CantingmeishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CantingmeishiVO;
import com.entity.view.CantingmeishiView;


/**
 * 餐厅美食
 * 
 * @author 
 * @email 
 * @date 2022-05-19 16:00:26
 */
public interface CantingmeishiDao extends BaseMapper<CantingmeishiEntity> {
	
	List<CantingmeishiVO> selectListVO(@Param("ew") Wrapper<CantingmeishiEntity> wrapper);
	
	CantingmeishiVO selectVO(@Param("ew") Wrapper<CantingmeishiEntity> wrapper);
	
	List<CantingmeishiView> selectListView(@Param("ew") Wrapper<CantingmeishiEntity> wrapper);

	List<CantingmeishiView> selectListView(Pagination page,@Param("ew") Wrapper<CantingmeishiEntity> wrapper);
	
	CantingmeishiView selectView(@Param("ew") Wrapper<CantingmeishiEntity> wrapper);
	

}
