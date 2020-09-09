package cn.cnic.security.configuration.controller;

import cn.cnic.security.common.utils.IPUtils;
import cn.cnic.security.common.utils.MapUtils;
import cn.cnic.security.configuration.entity.ImportAndExportEntity;
import cn.cnic.security.configuration.service.ImportAndExportService;
import com.google.common.collect.Lists;
import com.wuwenze.poi.ExcelKit;
import com.wuwenze.poi.handler.ExcelReadHandler;
import com.wuwenze.poi.pojo.ExcelErrorField;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author wq
 * @email 1013893214@qq.com
 * @date 2020-07-07 22:28
 */
@RestController
@RequestMapping("configuration")
public class ImportAndExportController {
    private static Logger log = LoggerFactory.getLogger(ImportAndExportController.class);
    @Autowired
    private ImportAndExportService importAndExportService;

    //导入
    //@RequestParam MultipartFile file
    @PostMapping(value = "/uploadXlsx")
    public ResponseEntity<?> uploadXlsx(@RequestParam MultipartFile file)
            throws IOException {
        if(file.isEmpty()){
            System.out.println("文件不存在，重新上传");
        }
        long beginMillis = System.currentTimeMillis();
        List<ImportAndExportEntity> successList = Lists.newArrayList();
        List<Map<String, Object>> errorList = Lists.newArrayList();

        ExcelKit.$Import(ImportAndExportEntity.class)
                .readXlsx(file.getInputStream(), new ExcelReadHandler<ImportAndExportEntity>() {

                    @Override
                    public void onSuccess(int sheetIndex, int rowIndex, ImportAndExportEntity entity) {
                        successList.add(entity); // 单行读取成功，加入入库队列。
                    }

                    @Override
                    public void onError(int sheetIndex, int rowIndex,
                                        List<ExcelErrorField> errorFields) {
                        // 读取数据失败，记录了当前行所有失败的数据
                        errorList.add(MapUtils.newHashMap(//
                                "sheetIndex", sheetIndex,//
                                "rowIndex", rowIndex,//
                                "errorFields", errorFields//
                        ));
                    }
                });

        //执行successList的入库操作。
        for (int i = 0; i < successList.size(); i++) {
            //System.out.println(successList.get(i));
            int count = importAndExportService.addInstitution(successList.get(i));
            //System.out.println("成功导入"+count+"条");
        }

        return ResponseEntity.ok(MapUtils.newHashMap(
                "data", successList,
                "haveError", !CollectionUtils.isEmpty(errorList),
                "error", errorList,
                "timeConsuming", (System.currentTimeMillis() - beginMillis) / 1000L
        ));
    }

    //导出
    @GetMapping(value = "/downXlsx")
    public void downXlsx(HttpServletResponse response) {
        long beginMillis = System.currentTimeMillis();
        List<ImportAndExportEntity> importAndExportEntityList = importAndExportService.queryInstitutionsList();
        ExcelKit.$Export(ImportAndExportEntity.class, response).downXlsx(importAndExportEntityList, false);
        log.info("#ExcelKit.$Export success, size={},timeConsuming={}s",//
                importAndExportEntityList.size(), (System.currentTimeMillis() - beginMillis) / 1000L);
    }


    // 生成导入参考的模板（含3条示例数据）
    @GetMapping(value = "/downTemplate")
    public void downTemplate(HttpServletResponse response) {
        List<ImportAndExportEntity> importAndExportEntityList = importAndExportService.queryInstitutionsList3();
        ExcelKit.$Export(ImportAndExportEntity.class, response)
                .downXlsx(importAndExportEntityList, true);
    }
}
