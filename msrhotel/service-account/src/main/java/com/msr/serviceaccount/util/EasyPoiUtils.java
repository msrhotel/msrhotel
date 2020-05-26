//package com.msr.serviceaccount.util;
//
//import cn.afterturn.easypoi.excel.ExcelExportUtil;
//import cn.afterturn.easypoi.excel.ExcelImportUtil;
//import cn.afterturn.easypoi.excel.entity.ExportParams;
//import cn.afterturn.easypoi.excel.entity.ImportParams;
//import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
//import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
//import lombok.SneakyThrows;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//public class EasyPoiUtils {
//
//    /**
//     *  导出excel
//     * @param pojoClass
//     * @param dataSet
//     * @param path
//     * @param filename
//     * @throws IOException
//     */
//    public static void exportExcel(Class<?> pojoClass, Collection<?> dataSet, String path, String filename) throws IOException {
//
//        File savefile = new File(path);
//        if (!savefile.exists()) {
//            savefile.mkdirs();
//        }
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), pojoClass, dataSet);
//        FileOutputStream fos = new FileOutputStream(path+filename);
//        workbook.write(fos);
//        fos.close();
//    }
//
//    /**
//     * 根据Map创建对应的Excel(一个excel 创建多个sheet)
//     * @param list list 多个Map key title 对应表格Title key entity 对应表格对应实体 key data
//     *      *             Collection 数据
//     * @param path 路径
//     * @param filename&emsp;文件名
//     * @throws IOException
//     */
//    public static void  exportExcel(List<Map<String, Object>> list, String path, String filename) throws IOException {
//        File savefile = new File(path);
//        if (!savefile.exists()) {
//            savefile.mkdirs();
//        }
//        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
//
//        FileOutputStream fos = new FileOutputStream(path+filename);
//        workbook.write(fos);
//        fos.close();
//    }
//
//
//    /**
//     * 导入excel
//     * @param <T>
//     * @param file
//     * @param pojoClass
//     * @param params
//     * @return
//     */
//    @SneakyThrows
//    public static <T> List<T> importExcel(MultipartFile file, Class<?> pojoClass, ImportParams params){
//        long start = new Date().getTime();
//        List<T> list = ExcelImportUtil.importExcel((InputStream) file, ConsumeExcelEntity.class, params);
//        return list;
//    }
//}
//
