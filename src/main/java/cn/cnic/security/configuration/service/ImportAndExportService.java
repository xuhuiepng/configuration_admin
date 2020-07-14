package cn.cnic.security.configuration.service;

import cn.cnic.security.configuration.entity.ImportAndExportEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wq
 * @email 1013893214@qq.com
 * @date 2020-07-07 22:00
 */
public interface ImportAndExportService extends IService<ImportAndExportEntity> {

    /**
     * 查询前三条数据，用于作导入参考的模板
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
     * @param importAndExportEntity
     * @return
     */
    int addInstitution(ImportAndExportEntity importAndExportEntity);
}
