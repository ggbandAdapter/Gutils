package com.rx.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * ToastUtil
 * @author ggband
 */


public class ToastUtil {
    private Toast mToast;
    private static ToastUtil mToastUtils;

    private ToastUtil(Context context) {
        mToast = Toast.makeText(context.getApplicationContext(), null, Toast.LENGTH_SHORT);
    }

    public static synchronized ToastUtil getInstanc(Context context) {
        if (null == mToastUtils) {
            mToastUtils = new ToastUtil(context);
        }
        return mToastUtils;
    }

    /**
     * 显示toast
     *
     * @param toastMsg
     */
    public void showToast(int toastMsg) {
        mToast.setText(toastMsg);
        mToast.show();
    }

    /**
     * 显示toast
     *
     * @param toastMsg
     */
    public void showToast(String toastMsg) {
        mToast.setText(toastMsg);
        mToast.show();
    }

    /**
     * 取消toast，在activity的destory方法中调用
     */
    public void destory() {
        if (null != mToast) {
            mToast.cancel();
            mToast = null;
        }
        mToastUtils = null;
    }
}

