//package com.msr.serviceaccount.util;
//
//import cn.afterturn.easypoi.excel.ExcelExportUtil;
//import cn.afterturn.easypoi.excel.ExcelImportUtil;
//import cn.afterturn.easypoi.excel.entity.ExportParams;
//import cn.afterturn.easypoi.excel.entity.ImportParams;
//import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
//import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
//import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
//import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.beans.PropertyDescriptor;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.net.URLEncoder;
//import java.util.List;
//import java.util.Map;
//import java.util.NoSuchElementException;
//
//public class ExcelUtils {
//
//    // 得到Workbook对象
//    public static Workbook getWorkBook(MultipartFile file) throws IOException {
//        // 这样写  excel 能兼容03和07
//        InputStream is = file.getInputStream();
//        Workbook hssfWorkbook = null;
//        try {
//            hssfWorkbook = new HSSFWorkbook(is);
//        } catch (Exception ex) {
//            is = file.getInputStream();
//            hssfWorkbook = new XSSFWorkbook(is);
//        }
//        return hssfWorkbook;
//    }
//
//    // 得到错误信息
//    public static void getWrongInfo(StringBuilder sb, List list, int i, Object obj, String name, String msg) throws Exception {
//        Class clazz = obj.getClass();
//        Object str = null;
//        // 得到属性名数组
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field f : fields) {
//            if (f.getName().equals(name)) {
//                // 用来得到属性的get和set方法
//                PropertyDescriptor pd = new PropertyDescriptor(f.getName(), clazz);
//                // 得到get方法
//                Method getMethod = pd.getReadMethod();
//                str = getMethod.invoke(obj);
//            }
//        }
//        if (i == 0)
//            sb.append(msg + str + ";");
//        else if (i == (list.size() - 1))
//            sb.append(str + "</br>");
//        else
//            sb.append(str + ";");
//    }
//
//    // 导出
//    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response) {
//        ExportParams exportParams = new ExportParams(title, sheetName);
//        exportParams.setCreateHeadRows(isCreateHeader);
//        defaultExport(list, pojoClass, fileName, response, exportParams);
//    }
//
//    // 导出
//    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) {
//        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
//    }
//
//    // 导出 （多表）
//    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
//        defaultExport(list, fileName, response);
//    }
//
//    // 默认导出
//    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName,
//                                      HttpServletResponse response, ExportParams exportParams) {
//
//        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
//        // 下载
//        if (workbook != null) ;
//        downLoadExcel(fileName, response, workbook);
//    }
//
//    // 下载
//    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
//        try {
//            response.setCharacterEncoding("UTF-8");
//            response.setHeader("content-Type", "application/vnd.ms-excel");
//            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
//            workbook.write(response.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//            //throw new NormalException(e.getMessage());
//        }
//    }
//
//    // 默认导出（多表）
//    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
//        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
//        if (workbook != null) ;
//        downLoadExcel(fileName, response, workbook);
//    }
//
//    // 导入
//    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
//        if (StringUtils.isBlank(filePath)) {
//            return null;
//        }
//        ImportParams params = new ImportParams();
//        params.setTitleRows(titleRows);
//        params.setHeadRows(headerRows);
//        List<T> list = null;
//        try {
//            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
//        } catch (NoSuchElementException e) {
//            // throw new NormalException("模板不能为空");
//        } catch (Exception e) {
//            e.printStackTrace();
//            // throw new NormalException(e.getMessage());
//        }
//        return list;
//    }
//
//    // 导入
//    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
//        if (file == null) {
//            return null;
//        }
//        ImportParams params = new ImportParams();
//        params.setTitleRows(titleRows);
//        params.setHeadRows(headerRows);
//        List<T> list = null;
//        try {
//            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
//        } catch (NoSuchElementException e) {
//            // throw new NormalException("excel文件不能为空");
//        } catch (Exception e) {
//            // throw new NormalException(e.getMessage());
//            System.out.println(e.getMessage());
//        }
//        return list;
//    }
//
//    // 多表导入
//    public static String importExcel(MultipartFile file) throws IOException {
//        // 根据file得到Workbook,主要是要根据这个对象获取,传过来的excel有几个sheet页
//        Workbook hssfWorkbook = getWorkBook(file);
//        StringBuilder sb = new StringBuilder();
//        try {
//            ImportParams params = new ImportParams();
//            // 循环工作表Sheet
//            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
//                System.out.println("循环工作表");
//                //表头在第几行
//                params.setTitleRows(0);
//                //距离表头中间有几行不要的数据
//                //params.setStartRows(1);
//                //第几个sheet页
//                params.setStartSheetIndex(numSheet);
//                ExcelImportResult<Object> result = null;
//
//                for (int i = 0; i <= numSheet; i++) {
//                    System.out.println("导入数据");
//                    result = ExcelImportUtil.importExcelMore(file.getInputStream(), ConsumeExcelEntity.class, params);
//                    //插入验证合格的数据
//                    //CallServiceUtil.callDataService("", "", new Object[] { result.getList() },
//                    //new Class[] { List.class });
//                }
//            }
//
//            if (sb.length() != 0) {
//                return sb.toString();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "导入失败！请检查导入文档的格式是否正确";
//        }
//        return "导入成功！";
//    }
//
//    // 通过模板导出
//    public static void exportExcel(String filepath, Map<String, Object> map, HttpServletResponse response) throws IOException {
//        TemplateExportParams params = new TemplateExportParams(filepath, true);
//
//        // 创建workBook对象
//        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
//
//        String fileName = "收入报表.xls";
//
//        if (workbook != null) {
//            downLoadExcel(fileName, response, workbook);
//        }
//    }
//
//    // 通过模板多表导出
//    public static void exportMultiSheetExcel(String filepath, Map<Integer, List<Map<String, Object>>> map, HttpServletResponse response) throws IOException {
//        TemplateExportParams params = new TemplateExportParams(filepath, true);
//
//        Workbook workbook = ExcelExportUtil.exportExcelClone(map, params);
//
//        String fileName = "收入报表.xls";
//
//        if (workbook != null) {
//            downLoadExcel(fileName, response, workbook);
//        }
//    }
//}
