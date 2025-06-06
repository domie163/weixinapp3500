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


import com.dao.CantingmeishiDao;
import com.entity.CantingmeishiEntity;
import com.service.CantingmeishiService;
import com.entity.vo.CantingmeishiVO;
import com.entity.view.CantingmeishiView;

@Service("cantingmeishiService")
public class CantingmeishiServiceImpl extends ServiceImpl<CantingmeishiDao, CantingmeishiEntity> implements CantingmeishiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CantingmeishiEntity> page = this.selectPage(
                new Query<CantingmeishiEntity>(params).getPage(),
                new EntityWrapper<CantingmeishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CantingmeishiEntity> wrapper) {
		  Page<CantingmeishiView> page =new Query<CantingmeishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CantingmeishiVO> selectListVO(Wrapper<CantingmeishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CantingmeishiVO selectVO(Wrapper<CantingmeishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CantingmeishiView> selectListView(Wrapper<CantingmeishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CantingmeishiView selectView(Wrapper<CantingmeishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
