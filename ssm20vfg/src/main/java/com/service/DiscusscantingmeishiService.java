package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusscantingmeishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusscantingmeishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusscantingmeishiView;


/**
 * 餐厅美食评论表
 *
 * @author 
 * @email 
 * @date 2022-05-19 16:00:26
 */
public interface DiscusscantingmeishiService extends IService<DiscusscantingmeishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusscantingmeishiVO> selectListVO(Wrapper<DiscusscantingmeishiEntity> wrapper);
   	
   	DiscusscantingmeishiVO selectVO(@Param("ew") Wrapper<DiscusscantingmeishiEntity> wrapper);
   	
   	List<DiscusscantingmeishiView> selectListView(Wrapper<DiscusscantingmeishiEntity> wrapper);
   	
   	DiscusscantingmeishiView selectView(@Param("ew") Wrapper<DiscusscantingmeishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusscantingmeishiEntity> wrapper);
   	

}

