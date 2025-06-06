package com.entity.view;

import com.entity.DiscusscantingmeishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 餐厅美食评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-19 16:00:26
 */
@TableName("discusscantingmeishi")
public class DiscusscantingmeishiView  extends DiscusscantingmeishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusscantingmeishiView(){
	}
 
 	public DiscusscantingmeishiView(DiscusscantingmeishiEntity discusscantingmeishiEntity){
 	try {
			BeanUtils.copyProperties(this, discusscantingmeishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
