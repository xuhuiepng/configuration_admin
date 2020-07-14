package cn.cnic.security.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Map工具类
 * @author wq
 * @email 1013893214@qq.com
 * @date 2020-07-08 15:31
 */
public class MapUtils {
    /**
     * 一次添加多个键值对
     * @param parms
     * @return
     */
    public static Map newHashMap(Object... parms){
        Map map = new HashMap<>();
        Object key = null;
        Object value = null;
        for (int i = 0; i < parms.length; i++) {
            if(i%2==0){
                key = parms[i];
            }else {
                value = parms[i];
            }
            map.put(key, value);
        }
        return map;
    }
}
