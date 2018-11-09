package com.marketplace.kelompok2.kue.ui.register;

import com.marketplace.kelompok2.kue.base.BaseView;
import com.marketplace.kelompok2.kue.model.Pembeli;

public interface RegisterView extends BaseView{
    void showError();
    void actionRegisterSuccess(Pembeli pembeli);
    void actionRegisterFailed();
}
