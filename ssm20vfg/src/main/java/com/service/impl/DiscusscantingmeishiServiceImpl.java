package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusscantingmeishiDao;
import com.entity.DiscusscantingmeishiEntity;
import com.service.DiscusscantingmeishiService;
import com.entity.vo.DiscusscantingmeishiVO;
import com.entity.view.DiscusscantingmeishiView;

@Service("discusscantingmeishiService")
public class DiscusscantingmeishiServiceImpl extends ServiceImpl<DiscusscantingmeishiDao, DiscusscantingmeishiEntity> implements DiscusscantingmeishiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusscantingmeishiEntity> page = this.selectPage(
                new Query<DiscusscantingmeishiEntity>(params).getPage(),
                new EntityWrapper<DiscusscantingmeishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusscantingmeishiEntity> wrapper) {
		  Page<DiscusscantingmeishiView> page =new Query<DiscusscantingmeishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusscantingmeishiVO> selectListVO(Wrapper<DiscusscantingmeishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusscantingmeishiVO selectVO(Wrapper<DiscusscantingmeishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusscantingmeishiView> selectListView(Wrapper<DiscusscantingmeishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusscantingmeishiView selectView(Wrapper<DiscusscantingmeishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
