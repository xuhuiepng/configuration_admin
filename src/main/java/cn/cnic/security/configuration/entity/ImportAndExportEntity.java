package cn.cnic.security.configuration.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 中科院研究所列表----->用于导入导出
 * @author wq
 * @email 1013893214@qq.com
 * @date 2020-07-07 16:15
 */
@Data
@TableName("ca_institutions_list")
@Excel("研究所列表")
public class ImportAndExportEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(type= IdType.AUTO)
    @ExcelField(value = "id",maxLength = 6)
    private Integer id;
    /**
     * 研究所名称
     */
    @ExcelField(value = "orgName",maxLength = 60,required = true)
    private String orgName;
    /**
     * 简称
     */
    @ExcelField(value = "abbreviation",maxLength = 20)
    private String abbreviation;
    /**
     *
     */
    @ExcelField(value = "longitude",maxLength = 11)
    private String longitude;
    /**
     *
     */
    @ExcelField(value = "latitude",maxLength = 11)
    private String latitude;
    /**
     *
     */
    @ExcelField(value = "ipScope",maxLength = 1000)
    private String ipScope;



    @ExcelField(value = "createTime",dateFormat = "yyyy/MM/dd HH:mm:ss")
    private Date createTime;

}
