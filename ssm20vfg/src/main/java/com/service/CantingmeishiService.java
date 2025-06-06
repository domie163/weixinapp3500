package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CantingmeishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CantingmeishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CantingmeishiView;


/**
 * 餐厅美食
 *
 * @author 
 * @email 
 * @date 2022-05-19 16:00:26
 */
public interface CantingmeishiService extends IService<CantingmeishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CantingmeishiVO> selectListVO(Wrapper<CantingmeishiEntity> wrapper);
   	
   	CantingmeishiVO selectVO(@Param("ew") Wrapper<CantingmeishiEntity> wrapper);
   	
   	List<CantingmeishiView> selectListView(Wrapper<CantingmeishiEntity> wrapper);
   	
   	CantingmeishiView selectView(@Param("ew") Wrapper<CantingmeishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CantingmeishiEntity> wrapper);
   	

}

