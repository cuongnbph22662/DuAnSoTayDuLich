    package cuongnbph22662.poly.duansotaydulich.activity;

    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    import com.google.android.material.textfield.TextInputEditText;

    import cuongnbph22662.poly.duansotaydulich.R;

public class DoiMatKhauActivity extends AppCompatActivity {

    TextInputEditText edPassOld,edPass,edRePass;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mk);
        edPassOld = findViewById(R.id.ed_MKCu);
        edPass = findViewById(R.id.ed_MKMoi);
        edRePass = findViewById(R.id.ed_XacNhanMKMoi);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("USER_FILE",MODE_PRIVATE);
                String user = preferences.getString("taiKhoan","");

//                if (validate()>0){
//                    NguoiDung nguoiDung = nguoiDungDAO.getID(user);
//                    nguoiDung.setMatKhau(edPass.getText().toString());
//                    if (nguoiDungDAO.update(nguoiDung)>0){
//                        Toast.makeText(getApplicationContext(),"Thay đôie mật khẩu thành công",Toast.LENGTH_SHORT).show();
//                        edPassOld.setText("");
//                        edPass.setText("");
//                        edRePass.setText("");
//                    }
//                    else{
//                        Toast.makeText(getApplicationContext(),"Thay đôie mật khẩu không thành công",Toast.LENGTH_SHORT).show();
//                    }
//                }
            }
        });

    }
    public int validate(){
        int check = 1;
        if (edPassOld.getText().length()==0||edPass.getText().length()==0||edRePass.getText().length()==0){
            Toast.makeText(getApplicationContext(),"Bạn phải điền đủ thông tin",Toast.LENGTH_SHORT).show();
            check = -1;
        }
        else{
            SharedPreferences preferences = getSharedPreferences("USER_FILE",MODE_PRIVATE);
            String passOld = preferences.getString("matKhau","");
            String pass = edPass.getText().toString();
            String repass = edRePass.getText().toString();
            if (!passOld.equals(edPassOld.getText().toString())){
                Toast.makeText(getApplicationContext(),"Mật khẩu cũ sai",Toast.LENGTH_SHORT).show();
                check = -1;
            }
            if (!pass.equals(repass)){
                Toast.makeText(getApplicationContext(),"Mật khẩu không trùng khớp",Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }
}