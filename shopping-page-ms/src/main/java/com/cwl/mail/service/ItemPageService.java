package com.cwl.mail.service;

public interface ItemPageService {
    public boolean genItemHTML(Long goodsId);

    public boolean deleteItemHTML(Long[] goodsIds);
}
