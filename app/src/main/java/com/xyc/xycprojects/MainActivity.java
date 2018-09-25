package com.xyc.xycprojects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lzy.okgo.model.HttpParams;
import com.xyc.httplibrary.listener.OnHttpRequestListener;
import com.xyc.httplibrary.manager.HttpManager;
import com.xyc.httplibrary.utils.GsonUtils;
import com.xyc.xycprojects.base.BaseActivity;
import com.xyc.xycprojects.base.BaseFragment;
import com.xyc.xycprojects.fragments.FragmentEvent;
import com.xyc.xycprojects.fragments.MainFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tvTab1)
    TextView tvTab1;
    @BindView(R.id.tvTab2)
    TextView tvTab2;
    @BindView(R.id.tvTab3)
    TextView tvTab3;

    @BindView(R.id.llFragment)
    TextView llFragment;

    private List<BaseFragment>  fragments = new ArrayList<>();

    @Override
    protected int getCenterView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initHeader() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  initFragment();
    }

   /* private void initFragment() {
        List<Long> datas = new ArrayList<>();
        for(int i=0;i<3;i++){
            datas.add((long)(i+1));
        }
        EventBus.getDefault().post(new FragmentEvent(datas));
    }
*/
    /*@Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetFrgmentCountEvent(FragmentEvent event) {
        List<Long> usersList = event.getUsersList();
        if (usersList == null) {
            return;
        }
        for (int i = 0; i < usersList.size(); i++) {
            if (findFragment(BaseFragment.class) == null) {
                Bundle bundle = new Bundle();
                bundle.putLong("userId",usersList.get(i));
                MainFragment mainFragment = new MainFragment();
                mainFragment.setArguments(bundle);
                fragments.add(mainFragment);
                loadRootFragment(R.id.llFragment,mainFragment);
            }
        }
    }*/

/*    @OnClick({R.id.tvTab1, R.id.tvTab2, R.id.tvTab3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvTab1:
                showHideFragment(fragments.get(0));
                break;
            case R.id.tvTab2:
                showHideFragment(fragments.get(1));

                break;
            case R.id.tvTab3:
                showHideFragment(fragments.get(2));

                break;
        }
    }*/
}
