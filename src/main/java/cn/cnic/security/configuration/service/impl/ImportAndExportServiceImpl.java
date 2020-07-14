package cn.cnic.security.configuration.service.impl;

import cn.cnic.security.configuration.dao.ImportAndExportDao;
import cn.cnic.security.configuration.entity.ImportAndExportEntity;
import cn.cnic.security.configuration.service.ImportAndExportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wq
 * @email 1013893214@qq.com
 * @date 2020-07-07 22:02
 */
@Service("ImportAndExportService")
public class ImportAndExportServiceImpl extends ServiceImpl<ImportAndExportDao, ImportAndExportEntity> implements ImportAndExportService {
    @Autowired
    private ImportAndExportDao importAndExportDao;

    @Override
    public List<ImportAndExportEntity> queryInstitutionsList3() {
        List<ImportAndExportEntity> importAndExportEntityList = importAndExportDao.queryInstitutionsList3();
        return importAndExportEntityList;
    }

    @Override
    public List<ImportAndExportEntity> queryInstitutionsList() {
        List<ImportAndExportEntity> importAndExportEntityList = importAndExportDao.queryInstitutionsList();
        return importAndExportEntityList;
    }

    @Override
    public int addInstitution(ImportAndExportEntity importAndExportEntity) {
        int count = importAndExportDao.addInstitution(importAndExportEntity);
        return count;
    }
}
