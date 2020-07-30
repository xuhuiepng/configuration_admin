package cn.cnic.security.configuration.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.Query;

import cn.cnic.security.configuration.dao.InstitutionsListDao;
import cn.cnic.security.configuration.entity.InstitutionsListEntity;
import cn.cnic.security.configuration.service.InstitutionsListService;


@Service("institutionsListService")
public class InstitutionsListServiceImpl extends ServiceImpl<InstitutionsListDao, InstitutionsListEntity> implements InstitutionsListService {

    @Autowired
    private InstitutionsListDao institutionsListDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<InstitutionsListEntity> queryWrapper = new QueryWrapper<InstitutionsListEntity>();
        if(params.containsKey("orgName")) {
            queryWrapper.like("org_name", params.get("orgName").toString());
        }
        if(params.containsKey("abbreviation")) {
            queryWrapper.like("abbreviation", params.get("abbreviation").toString());
        }
        if(params.containsKey("ipScope")) {
            queryWrapper.like("ip_scope", params.get("ipScope").toString());
        }
        if(params.containsKey("NoSuffix")) {
            return queryNullSuffix(params);
        }
        queryWrapper.gt("id",13);
        IPage<InstitutionsListEntity> page = this.page(
                new Query<InstitutionsListEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    //aa
    @Override
    public PageUtils queryNullSuffix(Map<String, Object> params) {
        IPage<InstitutionsListEntity> info= this.institutionsListDao.queryNullSuffix(new Query<InstitutionsListEntity>().getPage(params));
        return new PageUtils(info);
    }

}