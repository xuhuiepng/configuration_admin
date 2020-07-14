package cn.cnic.security.configuration.dao;

import cn.cnic.security.configuration.entity.ImportAndExportEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wq
 * @email 1013893214@qq.com
 * @date 2020-07-07 22:04
 */
@Mapper
@Repository
public interface ImportAndExportDao extends BaseMapper<ImportAndExportEntity> {
    /**
     * 查询前三条数据，用于作导入参考模板
     * @return
     */
    List<ImportAndExportEntity> queryInstitutionsList3();

    /**
     * 查询所有，用于导出
     * @return
     */
    List<ImportAndExportEntity> queryInstitutionsList();


    /**
     * 添加研究所
     * @return
     * @param importAndExportEntity
     */
    int addInstitution(ImportAndExportEntity  importAndExportEntity);
}
