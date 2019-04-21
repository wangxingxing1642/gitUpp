package com.example.a196177.xingmu.activity;


import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.a196177.xingmu.R;
import com.example.a196177.xingmu.base.BaseActivity;
import com.example.a196177.xingmu.base.BasePresenter;
import com.example.a196177.xingmu.base.Constants;
import com.example.a196177.xingmu.util.DateUtil;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;

public class CalenderActivity extends BaseActivity {

    @BindView(R.id.view_calender)
    MaterialCalendarView mCalender;
    @BindView(R.id.tool_bar)
    Toolbar mToolbar;

    CalendarDay mDate;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_calender;
    }

    @Override
    protected void initView() {
        setToolBar(mToolbar, "选择日期");
        mCalender.state().edit()
                .setFirstDayOfWeek(Calendar.WEDNESDAY)
                .setMinimumDate(CalendarDay.from(2018, 5, 20))
                .setMaximumDate(CalendarDay.from(DateUtil.getCurrentYear(), DateUtil.getCurrentMonth(), DateUtil.getCurrentDay()))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();
        mCalender.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                mDate = date;
            }
        });
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private static final String TAG = "CalenderActivity";
    @OnClick(R.id.tv_calender_enter)
    void chooseDate() {
        if (mDate != null) {
            String date = new SimpleDateFormat("yyyyMMdd").format(mDate.getDate());
            Log.e(TAG, "chooseDate: "+ date);
            Intent intent = new Intent();
            intent.putExtra(Constants.DATA,date);
            setResult(RESULT_OK,intent);
        }
        finish();
    }
}
