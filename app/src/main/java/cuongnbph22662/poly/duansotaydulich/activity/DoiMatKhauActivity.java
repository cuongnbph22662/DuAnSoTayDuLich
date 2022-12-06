    package cuongnbph22662.poly.duansotaydulich.activity;

    import android.content.Intent;
    import android.graphics.drawable.ColorDrawable;
    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.TextView;

    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;

    import com.google.android.material.textfield.TextInputEditText;

    import cuongnbph22662.poly.duansotaydulich.R;
    import cuongnbph22662.poly.duansotaydulich.dao.NguoiDungDAO;
    import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;
    import cuongnbph22662.poly.duansotaydulich.model.NguoiDung;
    public class DoiMatKhauActivity extends AppCompatActivity{
        TextInputEditText edPassOld,edPass,edRePass;
        Button btnSave;
        ImageView trove;
        NguoiDungDAO nguoiDungDAO;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_doi_mk);
            anhXa();
            nguoiDungDAO = new NguoiDungDAO(getApplicationContext());
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user = DataLocalManager.getUser();
                    NguoiDung nguoiDung = nguoiDungDAO.getID(user);
                    nguoiDung.setMatKhau(edPass.getText().toString());
                    if (validate()>0){
                        if (nguoiDungDAO.update(nguoiDung)>0){
                            dialog("Thay đổi mật khẩu thành công");
                            edPassOld.setText("");
                            edPass.setText("");
                            edRePass.setText("");
                        } else{
                            dialog("Thay đổi mật khẩu không thành công");
                        }
                    }
                }
            });
            trove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(DoiMatKhauActivity.this, MainActivity.class));
                }
            });

        }

        private void anhXa() {
            trove = findViewById(R.id.img_troveDMK);
            edPassOld = findViewById(R.id.ed_MKCu);
            edPass = findViewById(R.id.ed_MKMoi);
            nguoiDungDAO = new NguoiDungDAO(getApplicationContext());
            edRePass = findViewById(R.id.ed_XacNhanMKMoi);
            btnSave = findViewById(R.id.btnSave);
        }

        public int validate(){
            int check = 1;
            if (edPassOld.getText().length()==0||edPass.getText().length()==0||edRePass.getText().length()==0){
                dialog("Bạn phải điền đủ thông tin");
                check = -1;
            }
            else {
                String passOld = DataLocalManager.getMatKhau();
                String pass = edPass.getText().toString();
                String repass = edRePass.getText().toString();
                if (!passOld.equals(edPassOld.getText().toString())) {
                    dialog("Mật khẩu cũ sai");
                    check = -1;
                }
                if (!pass.equals(repass)) {
                    dialog("Mật khẩu không trùng khớp");
                    check = -1;
                }
            }
            return check;
        }

        public void dialog(String thongbao) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_thongbao, null);
            builder.setView(view);
            AlertDialog alertDialog = builder.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            alertDialog.show();
            TextView tvThongbao = view.findViewById(R.id.tvMess);
            // dialog
            Button btnThongBao = view.findViewById(R.id.btnThongBao);
            tvThongbao.setText(thongbao);

            btnThongBao.setOnClickListener(view1 -> {
                alertDialog.dismiss();
            });
        }

}