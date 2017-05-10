/*
 * {EasyGank}  Copyright (C) {2015}  {CaMnter}
 *
 * This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; type `show c' for details.
 *
 * The hypothetical commands `show w' and `show c' should show the appropriate
 * parts of the General Public License.  Of course, your program's commands
 * might be different; for a GUI interface, you would use an "about box".
 *
 * You should also get your employer (if you work as a programmer) or school,
 * if any, to sign a "copyright disclaimer" for the program, if necessary.
 * For more information on this, and how to apply and follow the GNU GPL, see
 * <http://www.gnu.org/licenses/>.
 *
 * The GNU General Public License does not permit incorporating your program
 * into proprietary programs.  If your program is a subroutine library, you
 * may consider it more useful to permit linking proprietary applications with
 * the library.  If this is what you want to do, use the GNU Lesser General
 * Public License instead of this License.  But first, please read
 * <http://www.gnu.org/philosophy/why-not-lgpl.html>.
 */

package com.zc.zby.mvpdemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    protected View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (this.view == null) {
            this.view = inflater.inflate(this.getLayoutId(), container, false);
        }
        if (this.view.getParent() != null) {
            ViewGroup parent = (ViewGroup) this.view.getParent();
            parent.removeView(this.view);
        }
        this.initViews(this.view, savedInstanceState);
        this.initToolbar(savedInstanceState);
        this.initListeners();
        this.initData();
        return this.view;
    }


    protected abstract int getLayoutId();

    protected abstract void initViews(View view, Bundle savedInstanceState);

    protected abstract void initToolbar(Bundle savedInstanceState);

    protected abstract void initListeners();

    protected abstract void initData();

    /**
     * 跳转到指定的Activity
     *
     * @param targetActivity 要跳转的目标Activity
     */
    protected final void startActivity(@NonNull Class<?> targetActivity) {
        startActivity(new Intent(getActivity(), targetActivity));
    }

    /**
     * 跳转到指定的Activity
     *
     * @param data           Activity之间传递数据，Intent的Extra key为Constant.EXTRA_NAME.DATA
     * @param targetActivity 要跳转的目标Activity
     */
    protected final void startActivity(@NonNull String name, @NonNull Bundle data, @NonNull Class<?> targetActivity) {
        final Intent intent = new Intent();
        intent.putExtra(name, data);
        intent.setClass(getActivity(), targetActivity);
        startActivity(intent);
    }

}
