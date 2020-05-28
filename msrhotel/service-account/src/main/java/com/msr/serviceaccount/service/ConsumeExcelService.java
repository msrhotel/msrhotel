package com.msr.serviceaccount.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */

public interface ConsumeExcelService extends IService<ConsumeExcelEntity> {
    List<ConsumeExcelEntity> getConsumes(String customerId);
//    void importConsumeData(List<ConsumeExcelEntity> consumeList);
//    void importConsumeData(MultipartFile file, ConsumeExcelService consumeExcelService);

}
