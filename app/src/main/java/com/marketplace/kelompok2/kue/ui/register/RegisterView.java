package com.marketplace.kelompok2.kue.ui.register;

import com.marketplace.kelompok2.kue.base.BaseView;

public interface RegisterView extends BaseView{
    void showError();
    void actionRegisterSuccess(Integer id);
    void actionRegisterFailed();
}
