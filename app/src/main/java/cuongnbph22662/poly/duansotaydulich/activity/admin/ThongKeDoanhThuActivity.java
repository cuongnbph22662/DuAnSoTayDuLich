package cuongnbph22662.poly.duansotaydulich.activity.admin;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.ChuyenDiDAO;

public class ThongKeDoanhThuActivity extends AppCompatActivity {
    Button btnDoanhThu;
    ImageView imgTuNgay, imgDenNgay;
    TextView tvDoanhThu, tvTuNgay, tvDenNgay;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    int mYear, mMonth, mDay;
    ChuyenDiDAO chuyenDiDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_doanh_thu);
        anhXa();
        imgTuNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog date = new DatePickerDialog(ThongKeDoanhThuActivity.this, 0, mDateTuNgay, mYear, mMonth, mDay);
                date.show();
            }
        });
        imgDenNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog date = new DatePickerDialog(ThongKeDoanhThuActivity.this, 0, mDateDenNgay, mYear, mMonth, mDay);
                date.show();
            }
        });

        btnDoanhThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tuNgay = tvTuNgay.getText().toString();
                String denNgay = tvDenNgay.getText().toString();
                chuyenDiDAO = new ChuyenDiDAO(getApplicationContext());
                int doanhThu = chuyenDiDAO.getDoanhThu(tuNgay, denNgay);
                tvDoanhThu.setText(""+doanhThu);
            }
        });
    }

    DatePickerDialog.OnDateSetListener mDateTuNgay = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int nam, int thang, int ngay) {
            mYear = nam;
            mMonth = thang;
            mDay = ngay;
            GregorianCalendar c = new GregorianCalendar(mYear, mMonth, mDay);
            tvTuNgay.setText(sdf.format(c.getTime()));
        }
    };

    DatePickerDialog.OnDateSetListener mDateDenNgay = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int nam, int thang, int ngay) {
            mYear = nam;
            mMonth = thang;
            mDay = ngay;
            GregorianCalendar c = new GregorianCalendar(mYear, mMonth, mDay);
            tvDenNgay.setText(sdf.format(c.getTime()));
        }
    };

    private void anhXa() {
        btnDoanhThu = findViewById(R.id.btn_TinhDoanhThu);
        imgDenNgay = findViewById(R.id.img_DenNgay);
        imgTuNgay = findViewById(R.id.img_TuNgay);
        tvDoanhThu = findViewById(R.id.tv_TongDoanhThu);
        tvTuNgay = findViewById(R.id.tv_TuNgay);
        tvDenNgay = findViewById(R.id.tv_DenNgay);
    }
}