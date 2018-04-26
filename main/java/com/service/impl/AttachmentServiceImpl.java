package com.service.impl;

import com.dao.AttachmentMapper;
import com.pojo.Attachment;
import com.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CHLaih on 2018/4/24.
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public void insert(Attachment a) {
        attachmentMapper.insert(a);
    }
}
