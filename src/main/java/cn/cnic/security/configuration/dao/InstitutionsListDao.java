package cn.cnic.security.configuration.dao;

import cn.cnic.security.configuration.entity.InstitutionsListEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 中科院研究所列表
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
@Mapper
@Repository
public interface InstitutionsListDao extends BaseMapper<InstitutionsListEntity> {
    @Select("SELECT ca.org_name, ca.abbreviation,ca.longitude, ca.latitude, ca.ip_scope, cc.suffix, ca.create_time FROM ca_institutions_list ca LEFT JOIN comparing_chart cc ON ca.`org_name`=cc.`fullName` WHERE ca.id>13 And suffix IS NULL")
    IPage<InstitutionsListEntity> queryNullSuffix(IPage<InstitutionsListEntity> page);

}
